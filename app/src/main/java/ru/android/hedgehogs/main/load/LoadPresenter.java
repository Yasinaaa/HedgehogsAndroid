package ru.android.hedgehogs.main.load;

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

public class LoadPresenter extends BasePresenter<LoadView.View>
        implements LoadView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public LoadPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
