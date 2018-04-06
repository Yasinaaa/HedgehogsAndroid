package ru.android.hedgehogs.main.load;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

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
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
