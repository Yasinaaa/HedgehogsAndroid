package ru.android.hedgehogs.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

/**
 * Created by yasina on 18.04.18.
 */
public class PrefUtils {

    private static final String PREF_AUTH_DATA = "pref_auth_data";

    @Nullable
    public static String getAuthToken(@Nullable final Context context) {
        if (context == null) return null;

        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sp.getString(PREF_AUTH_DATA, "");
    }

    public static void saveAuthToken(@Nullable final Context context, @Nullable String authToken) {
        if (context == null || authToken == null) return;
        SharedPreferences sp =
                PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        sp.edit().remove(PREF_AUTH_DATA).apply();
        sp.edit().putString(PREF_AUTH_DATA, authToken).apply();
    }
}
