package ru.android.hedgehogs.sign;

import android.app.Activity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.network.actions.ActionLogin;
import ru.android.hedgehogs.network.events.login.LoginErrorEvent;
import ru.android.hedgehogs.network.events.login.LoginSuccessEvent;
import ru.android.hedgehogs.utils.PrefUtils;

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

    @Override
    public void login(String username, String password) {
        getView().startAction(new ActionLogin(username, password));
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginSuccessEvent event) {
        PrefUtils.saveAuthToken(mActivity.getBaseContext(), event.getTokenRO().getToken());
        getView().openNextView();
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(LoginErrorEvent event) {
        getView().errorView(event.getLoginErrorRO().getMessage());
    }
}
