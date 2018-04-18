package ru.android.hedgehogs.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import ru.android.hedgehogs.R;

/**
 * Created by yasina on 06.04.18.
 */

public class AndroidUtils {

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (null != activity.getCurrentFocus() && null != activity.getCurrentFocus().getWindowToken()) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static String getRestEndpoint() {
        return Resources.URL;
    }

    public static void makeErrorDialog(Activity activity, int text){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity)
                .setTitle(R.string.error)
                .setMessage(text)
                .setCancelable(true);
        alertDialogBuilder.show();
    }

    public static void makeErrorDialog(Activity activity, String text){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity)
                .setTitle(R.string.error)
                .setMessage(text)
                .setCancelable(true);
        alertDialogBuilder.show();
    }

}
