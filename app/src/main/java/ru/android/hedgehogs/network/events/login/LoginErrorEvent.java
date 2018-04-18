package ru.android.hedgehogs.network.events.login;

import ru.android.hedgehogs.network.events.base.BaseErrorEvent;
import ru.android.hedgehogs.network.response_object.LoginErrorRO;

/**
 * Created by yasina on 06.04.18.
 */

public class LoginErrorEvent extends BaseErrorEvent {

    private LoginErrorRO loginErrorEvent;

    public LoginErrorEvent(int responseCode, LoginErrorRO loginErrorEvent) {
        super(responseCode);
        this.loginErrorEvent = loginErrorEvent;
    }

    public LoginErrorRO getLoginErrorRO() {
        return loginErrorEvent;
    }
}
