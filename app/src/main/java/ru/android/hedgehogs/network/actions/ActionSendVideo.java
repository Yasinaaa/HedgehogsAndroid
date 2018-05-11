package ru.android.hedgehogs.network.actions;

import android.os.Parcel;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import ru.android.hedgehogs.network.events.send_video.SendVideoErrorEvent;
import ru.android.hedgehogs.network.events.send_video.SendVideoSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */

public class ActionSendVideo extends BaseAction<ResponseBody>{

    private final String tokenType = "Bearer ";
    private String token, path;
    MultipartBody.Part filePart;
    String title;
    int quality;
    int originalSize;
    String originalSizeType;
    String deviceId;

    public ActionSendVideo(String token, String path, String title, int quality, int originalSize, String originalSizeType, String deviceId) {
        this.token = token;
        this.path = path;
        this.title = title;
        this.quality = quality;
        this.originalSize = originalSize;
        this.originalSizeType = originalSizeType;
        this.deviceId = deviceId;
    }

    public ActionSendVideo(Parcel in) {
        this.token = in.readString();
        this.path = in.readString();
        this.title = in.readString();
        this.quality = in.readInt();
        this.originalSize = in.readInt();
        this.originalSizeType = in.readString();
        this.deviceId = in.readString();
    }

    File file;
    @Override
    protected Response<ResponseBody> makeRequest() throws IOException {
        RequestBody requestBody = null;
        if (path != null) {
            file = new File(path);
            RequestBody videoBody = RequestBody.create(MediaType.parse("video/*"), file);
            filePart  = MultipartBody.Part.createFormData("video", file.getName(), videoBody);
        }
        return getRest().loadVideo(filePart, title, quality, originalSize, originalSizeType, tokenType + token, deviceId).execute();
    }

    @Override
    protected void onResponseSuccess(Response<ResponseBody> response) {
        EventBus.getDefault().post(new SendVideoSuccessEvent());
    }

    @Override
    protected void onHttpError(Response<?> response) {
        EventBus.getDefault().post(new SendVideoErrorEvent());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
        dest.writeString(path);
        dest.writeString(title);
        dest.writeInt(quality);
        dest.writeInt(originalSize);
        dest.writeString(originalSizeType);
        dest.writeString(deviceId);
    }

    public static final Creator<ActionSendVideo> CREATOR = new Creator<ActionSendVideo>() {
        @Override
        public ActionSendVideo createFromParcel(Parcel in) {
            return new ActionSendVideo(in);
        }

        @Override
        public ActionSendVideo[] newArray(int size) {
            return new ActionSendVideo[size];
        }
    };
}
