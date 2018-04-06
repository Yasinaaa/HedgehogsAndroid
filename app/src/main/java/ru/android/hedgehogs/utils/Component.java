package ru.android.hedgehogs.utils;

import android.content.Context;

import ru.android.hedgehogs.app.AppView;

/**
 * Created by yasina on 06.04.18.
 */

public final class Component {

    private Component() {
        throw new IllegalStateException("No instances!");
    }

    @SuppressWarnings("unchecked")
    public static <T> T getComponent(Context context, Class<T> componentType) {
        return componentType.cast(((AppView<T>) context.getApplicationContext()).getComponent());
    }
}
