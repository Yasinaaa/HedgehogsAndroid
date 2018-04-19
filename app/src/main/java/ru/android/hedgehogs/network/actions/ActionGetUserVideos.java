package ru.android.hedgehogs.network.actions;

import android.os.Parcel;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import ru.android.hedgehogs.network.events.get_videos.GetVideosErrorEvent;
import ru.android.hedgehogs.network.events.get_videos.GetVideosSuccessEvent;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 06.04.18.
 */

public class ActionGetUserVideos extends BaseAction<List<VideoRO>>{

    private final String tokenType = "Bearer ";
    private String token;

    public ActionGetUserVideos(String token) {
        this.token = token;
    }

    public ActionGetUserVideos(Parcel in) {
        this.token = in.readString();
    }

    @Override
    protected Response<List<VideoRO>> makeRequest() throws IOException {
        return getRest().getVideo(tokenType + token).execute();
    }

    @Override
    protected void onResponseSuccess(Response<List<VideoRO>> response) {
        EventBus.getDefault().post(new GetVideosSuccessEvent(response.body()));
    }

    @Override
    protected void onHttpError(Response<?> response) {
        try {
            EventBus.getDefault().post(new GetVideosErrorEvent(response.code(),
                    response.errorBody().string()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(token);
    }

    public static final Creator<ActionGetUserVideos> CREATOR = new Creator<ActionGetUserVideos>() {
        @Override
        public ActionGetUserVideos createFromParcel(Parcel in) {
            return new ActionGetUserVideos(in);
        }

        @Override
        public ActionGetUserVideos[] newArray(int size) {
            return new ActionGetUserVideos[size];
        }
    };
}
