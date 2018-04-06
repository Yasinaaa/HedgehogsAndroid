package ru.android.hedgehogs.network.actions;

import android.content.Context;
import android.os.Parcelable;

/**
 * Created by yasina on 06.04.18.
 */

public interface Action extends Parcelable {

    void execute();
    void setContext(Context context);

}

