package ru.android.hedgehogs.main.videos;

import android.app.Activity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.network.actions.ActionGetUserVideos;
import ru.android.hedgehogs.network.events.get_videos.GetVideosErrorEvent;
import ru.android.hedgehogs.network.events.get_videos.GetVideosSuccessEvent;
import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 06.04.18.
 */

public class VideoPresenter extends BasePresenter<VideoView.View>
        implements VideoView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public VideoPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }

    @Override
    public void getVideos() {
        getView().startAction(new ActionGetUserVideos(mToken));
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetVideosSuccessEvent event) {
        getView().setAdapter(event.getVideoRO());
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetVideosErrorEvent event) {

    }
}
