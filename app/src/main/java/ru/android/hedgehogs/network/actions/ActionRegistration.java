package ru.android.hedgehogs.network.actions;

import android.os.Parcel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Credentials;
import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.android.hedgehogs.network.events.registration.RegistrationErrorEvent;
import ru.android.hedgehogs.network.events.registration.RegistrationSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */

public class ActionRegistration extends BaseAction<ResponseBody>{

    private String username, password;
    private String grantType = "password";

    public ActionRegistration(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ActionRegistration(Parcel in){
        this.username = in.readString();
        this.password = in.readString();
    }

    @Override
    protected Response<ResponseBody> makeRequest() throws IOException {
        return getRest().enrollment(username, password).execute();
    }

    @Override
    protected void onResponseSuccess(Response<ResponseBody> response) {
        EventBus.getDefault().post(new RegistrationSuccessEvent(response.body()));
    }

    @Override
    protected void onHttpError(Response<?> response) {
        EventBus.getDefault().post(new RegistrationErrorEvent());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(username);
        parcel.writeString(password);
    }

    public static final Creator<ActionRegistration> CREATOR = new Creator<ActionRegistration>() {
        @Override
        public ActionRegistration createFromParcel(Parcel in) {
            return new ActionRegistration(in);
        }

        @Override
        public ActionRegistration[] newArray(int size) {
            return new ActionRegistration[size];
        }
    };

}
