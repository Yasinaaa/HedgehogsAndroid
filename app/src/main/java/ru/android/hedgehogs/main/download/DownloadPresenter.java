package ru.android.hedgehogs.main.download;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

/**
 * Created by yasina on 06.04.18.
 */

public class DownloadPresenter extends BasePresenter<DownloadView.View>
        implements DownloadView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public DownloadPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
