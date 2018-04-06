package ru.android.hedgehogs.sign;

import android.app.Activity;

import ru.android.hedgehogs.base.BasePresenter;

/**
 * Created by yasina on 06.04.18.
 */

public class SignInPresenter extends BasePresenter<SignInView.View>
        implements SignInView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public SignInPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }
}
