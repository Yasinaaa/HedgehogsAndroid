package ru.android.hedgehogs.main.videos;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

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
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
