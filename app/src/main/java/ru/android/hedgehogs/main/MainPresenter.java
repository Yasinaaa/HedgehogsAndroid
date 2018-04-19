package ru.android.hedgehogs.main;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 06.04.18.
 */

public class MainPresenter extends BasePresenter<MainView.View>
        implements MainView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public MainPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
