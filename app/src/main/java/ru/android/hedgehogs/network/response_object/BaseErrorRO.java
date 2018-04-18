package ru.android.hedgehogs.network.response_object;

/**
 * Created by yasina on 18.04.18.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseErrorRO<T> {

    private T errors;

    public T getErrors() {
        return errors;
    }
}
