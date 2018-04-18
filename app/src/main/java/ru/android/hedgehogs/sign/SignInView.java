package ru.android.hedgehogs.sign;


import org.greenrobot.eventbus.Subscribe;

import ru.android.hedgehogs.base.BaseView;
import ru.android.hedgehogs.network.events.login.LoginErrorEvent;
import ru.android.hedgehogs.network.events.login.LoginSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */

public interface SignInView {

    interface View extends BaseView.View {
        void setLogin();
        void setRegistration();
        void openNextView();
        void errorView(String text);
    }

    interface Presenter extends BaseView.Presenter<SignInView.View>{
        void login(String username, String password);
        @Subscribe void onEvent(LoginSuccessEvent event);
        @Subscribe void onEvent(LoginErrorEvent event);
    }

}
