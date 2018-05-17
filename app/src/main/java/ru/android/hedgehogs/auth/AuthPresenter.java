package ru.android.hedgehogs.auth;

import android.app.Activity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import ru.android.hedgehogs.base.BasePresenter;
import ru.android.hedgehogs.network.actions.ActionLogin;
import ru.android.hedgehogs.network.actions.ActionRegistration;
import ru.android.hedgehogs.network.events.login.LoginErrorEvent;
import ru.android.hedgehogs.network.events.login.LoginSuccessEvent;
import ru.android.hedgehogs.network.events.registration.RegistrationErrorEvent;
import ru.android.hedgehogs.network.events.registration.RegistrationSuccessEvent;
import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 06.04.18.
 */

public class AuthPresenter extends BasePresenter<AuthInView.View>
        implements AuthInView.Presenter {

    private Activity mActivity;
    private int mId;
    private String mToken;

    public AuthPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        //mToken = PrefUtils.getAuthToken(mActivity.getBaseContext());
        //mId = PrefUtils.getAuthId(mActivity.getBaseContext());
    }

    @Override
    public void auth(String username, String password) {
        getView().startAction(new ActionRegistration(username, password));
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(RegistrationSuccessEvent event) {
        getView().openNextView();
    }

    @Override
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(RegistrationErrorEvent event) {
        //getView().errorView(event.getLoginErrorRO().getMessage());
    }
}
