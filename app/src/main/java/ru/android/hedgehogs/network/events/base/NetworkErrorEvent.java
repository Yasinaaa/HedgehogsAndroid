package ru.android.hedgehogs.network.events.base;

/**
 * Created by yasina on 18.04.18.
 */
public class NetworkErrorEvent {

    private Object object;
    private int code;
    private String error;

    public NetworkErrorEvent(int code) {
        this.code = code;
    }

    public NetworkErrorEvent(String text) {
        this.error = text;
    }

    public NetworkErrorEvent(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }
}
