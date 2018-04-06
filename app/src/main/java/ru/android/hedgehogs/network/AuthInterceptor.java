package ru.android.hedgehogs.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import ru.android.hedgehogs.app.App;

public class AuthInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
      Request original = chain.request();
      /*if (PrefUtils.isSignedIn(App.context)) {
        Request request = original.newBuilder()
            //.header("Cookie", AndroidUtils.checkNotNull(PrefUtils.getAuthToken(App.context)))
            //.method(original.method(), original.body())
            .build();
        return chain.proceed(request);
      }*/
      return chain.proceed(chain.request());
    }
}
