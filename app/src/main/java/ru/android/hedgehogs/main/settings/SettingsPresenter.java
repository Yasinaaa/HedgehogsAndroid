package ru.android.hedgehogs.main.settings;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

/**
 * Created by yasina on 06.04.18.
 */

public class SettingsPresenter extends BasePresenter<SettingsView.View>
        implements SettingsView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public SettingsPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
