package ru.android.hedgehogs.network.events.login;

import ru.android.hedgehogs.network.response_object.TokenRO;

/**
 * Created by yasina on 06.04.18.
 */

public class LoginSuccessEvent {

    private TokenRO tokenRO;

    public LoginSuccessEvent(TokenRO tokenRO) {
        this.tokenRO = tokenRO;
    }

    public TokenRO getTokenRO() {
        return tokenRO;
    }
}
