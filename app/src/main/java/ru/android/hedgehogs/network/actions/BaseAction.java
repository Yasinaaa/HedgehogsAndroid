package ru.android.hedgehogs.network.actions;

import android.content.Context;
import com.orhanobut.logger.Logger;
import org.greenrobot.eventbus.EventBus;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Response;
import ru.android.hedgehogs.network.SessionRestManager;
import ru.android.hedgehogs.network.api.API;
import ru.android.hedgehogs.network.api.API2;
import ru.android.hedgehogs.network.events.base.NetworkErrorEvent;


public abstract class BaseAction<T> implements Action {

    protected Context context;

    public RequestBody toRequestBody(String value) {
        RequestBody body = null;
        if (value != null)
            body = RequestBody.create(MediaType.parse("text/plain"), value);
        return body;
    }

    @Override
    public void setContext(Context context) {
      this.context = context.getApplicationContext();
    }

    protected API getRest(){
        return SessionRestManager.getInstance().getRest();
    }

    protected API2 getRest2(){
        return SessionRestManager.getInstance().getRest2();
    }

    protected void processError(Response<?> response) {
      /*switch (response.code()){
        case 401:
          EventBus.getDefault().post(new ExpiredTokenEvent());
          break;
        default:
          onHttpError(response);
          //break;
      }*/
      if (response.code() != 200)
          onHttpError(response);
    }

    protected void processNetworkError(String e) {
        EventBus.getDefault().post(new NetworkErrorEvent(e));
    }

    protected abstract Response<T> makeRequest() throws IOException;

    protected abstract void onResponseSuccess(Response<T> response);

   // protected abstract void onBadRequestError(Response<D> response);

    protected abstract void onHttpError(Response<?> response);

    @Override
    public void execute() {
      if (context == null) {
        Logger.e("Context is not set!");
        return;
      }
      Response<T> response;
      try {
        response = makeRequest();
      } catch (IOException e) {
        processNetworkError(e.getMessage());
        return;
      }
      if (response.isSuccessful() || response.code() == 200) {
        onResponseSuccess(response);
      } else {
        processError(response);
      }
    }

    protected Float getFloat(float f){
        return f==0 ? null : f;
    }

    protected Integer getInteger(int i){
        return i==0 ? null: i;
    }

    protected Boolean getBoolean(int b1, boolean b){
        return b1==-1 ? null: b;
    }

}
