package ru.android.hedgehogs.network;

import java.util.concurrent.TimeUnit;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import ru.android.hedgehogs.network.api.API;
import ru.android.hedgehogs.utils.AndroidUtils;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class SessionRestManager {

    private static volatile SessionRestManager instance;

    private SessionRestManager() {
    }

    public static SessionRestManager getInstance() {
      if (instance == null) {
        synchronized (SessionRestManager.class) {
          if (instance == null) instance = new SessionRestManager();
        }
      }
      return instance;
    }


    private OkHttpClient setupHttpClientWithAuth() {
      OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
      httpClient.addInterceptor(chain -> {
        Request original = chain.request();
        Request request = original.newBuilder()
            //.header("Content-Type", "application/json")
            .method(original.method(), original.body())
            .build();
        return chain.proceed(request);
      });

      httpClient.connectTimeout(1, TimeUnit.MINUTES);
      httpClient.writeTimeout(2, TimeUnit.MINUTES);
      httpClient.readTimeout(1, TimeUnit.MINUTES);

      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      httpClient.addInterceptor(loggingInterceptor);
      return httpClient.build();
    }

    private final Retrofit REST_ADAPTER=
        new Retrofit.Builder().baseUrl(AndroidUtils.getRestEndpoint())
            .client(setupHttpClientWithAuth())
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

    public API getRest(){return REST_ADAPTER.create(API.class);}

    public Retrofit getRestAdapter() {
      return REST_ADAPTER;
    }
}
