package ru.android.hedgehogs.auth;


import org.greenrobot.eventbus.Subscribe;

import ru.android.hedgehogs.base.BaseView;
import ru.android.hedgehogs.network.events.login.LoginErrorEvent;
import ru.android.hedgehogs.network.events.login.LoginSuccessEvent;
import ru.android.hedgehogs.network.events.registration.RegistrationErrorEvent;
import ru.android.hedgehogs.network.events.registration.RegistrationSuccessEvent;

/**
 * Created by yasina on 06.04.18.
 */

public interface AuthInView {

    interface View extends BaseView.View {
        void setRegistration();
        void openNextView();
        void errorView(String text);
    }

    interface Presenter extends BaseView.Presenter<AuthInView.View>{
        void auth(String username, String password);
        @Subscribe void onEvent(RegistrationSuccessEvent event);
        @Subscribe void onEvent(RegistrationErrorEvent event);
    }

}
