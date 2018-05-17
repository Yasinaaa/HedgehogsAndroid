package ru.android.hedgehogs.network.events.registration;

import okhttp3.ResponseBody;

/**
 * Created by yasina on 06.04.18.
 */

public class RegistrationSuccessEvent {

    private ResponseBody responseBody;

    public RegistrationSuccessEvent(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }
}
