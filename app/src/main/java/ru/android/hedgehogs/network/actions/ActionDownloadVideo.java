package ru.android.hedgehogs.network.actions;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.android.hedgehogs.network.events.download_video.DownloadVideoErrorEvent;
import ru.android.hedgehogs.network.events.download_video.DownloadVideoSuccessEvent;
import ru.android.hedgehogs.network.events.send_video.SendVideoErrorEvent;
import ru.android.hedgehogs.network.events.send_video.SendVideoSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */

public class ActionDownloadVideo extends BaseAction<ResponseBody>{

    private final String tokenType = "Bearer ";
    private String token;
    private int deviceId;

    public ActionDownloadVideo(String token, int deviceId) {
        this.token = token;
        this.deviceId = deviceId;
    }

    public ActionDownloadVideo(Parcel in) {
        this.token = in.readString();
        this.deviceId = in.readInt();
    }

    File file;
    @Override
    protected Response<ResponseBody> makeRequest() throws IOException {
        //return getRest().downloadVideo(deviceId,tokenType + token).execute();
        return getRest2().downloadVideo().execute();
    }

    @Override
    protected void onResponseSuccess(Response<ResponseBody> response) {
        EventBus.getDefault().post(new DownloadVideoSuccessEvent(response.body()));
    }

    @Override
    protected void onHttpError(Response<?> response) {
        EventBus.getDefault().post(new DownloadVideoErrorEvent());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
        dest.writeInt(deviceId);
    }

    public static final Parcelable.Creator<ActionDownloadVideo> CREATOR = new Parcelable.Creator<ActionDownloadVideo>() {
        @Override
        public ActionDownloadVideo createFromParcel(Parcel in) {
            return new ActionDownloadVideo(in);
        }

        @Override
        public ActionDownloadVideo[] newArray(int size) {
            return new ActionDownloadVideo[size];
        }
    };
}
