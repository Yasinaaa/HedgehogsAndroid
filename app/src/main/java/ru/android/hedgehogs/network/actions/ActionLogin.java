package ru.android.hedgehogs.network.actions;

import android.os.Parcel;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Credentials;
import retrofit2.Response;
import ru.android.hedgehogs.network.events.login.LoginErrorEvent;
import ru.android.hedgehogs.network.events.login.LoginSuccessEvent;
import ru.android.hedgehogs.network.response_object.LoginErrorRO;
import ru.android.hedgehogs.network.response_object.TokenRO;

/**
 * Created by yasina on 06.04.18.
 */

public class ActionLogin extends BaseAction<TokenRO>{

    private String username, password;
    private String grantType = "password";

    public ActionLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ActionLogin(Parcel in){
        this.username = in.readString();
        this.password = in.readString();
        this.grantType = in.readString();
    }

    @Override
    protected Response<TokenRO> makeRequest() throws IOException {
        String authToken = Credentials.basic("testjwtclientid", "secret");
        return getRest().getToken(username, password, grantType, authToken).execute();
    }

    @Override
    protected void onResponseSuccess(Response<TokenRO> response) {
        EventBus.getDefault().post(new LoginSuccessEvent(response.body()));
    }

    @Override
    protected void onHttpError(Response<?> response) {
        try {
            EventBus.getDefault().post(new LoginErrorEvent(response.code(),
                    parseLoginError(response.errorBody().string())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private LoginErrorRO parseLoginError(String text)
            throws IOException {
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<LoginErrorRO>() {
            }.getType();
            return gson.fromJson(text, type);
        }catch (java.lang.IllegalStateException e){
            return null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(grantType);
    }

    public static final Creator<ActionLogin> CREATOR = new Creator<ActionLogin>() {
        @Override
        public ActionLogin createFromParcel(Parcel in) {
            return new ActionLogin(in);
        }

        @Override
        public ActionLogin[] newArray(int size) {
            return new ActionLogin[size];
        }
    };

}
