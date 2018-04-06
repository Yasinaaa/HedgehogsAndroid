package ru.android.hedgehogs.start;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

/**
 * Created by yasina on 06.04.18.
 */

public class StartPresenter extends BasePresenter<StartView.View>
        implements StartView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public StartPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
