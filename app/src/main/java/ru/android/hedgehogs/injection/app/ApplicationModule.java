package ru.android.hedgehogs.injection.app;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.strategy.Strategy;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.android.hedgehogs.app.App;
import ru.android.hedgehogs.network.api.API;

/**
 * Created by yasina on 06.04.18.
 */
@Module
@Singleton
public class ApplicationModule {

    private App mApp;

    public ApplicationModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    public API provideApi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Strategy strategy = new AnnotationStrategy();
        Serializer serializer = new Persister(strategy);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2, TimeUnit.MINUTES)
                .build();

        //TODO: change temporary values to real
        Retrofit retrofit =  new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
                .baseUrl("http://192.168.43.138:8080")
                .client(okHttpClient)
                .build();

        return retrofit.create(API.class);
    }
}
