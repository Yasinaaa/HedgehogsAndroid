package ru.android.hedgehogs.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
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

    public static String parseCorrectUri(String path, Activity activity){
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = activity.getContentResolver().query(Uri.parse(path),
                filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        path = cursor.getString(columnIndex);
        cursor.close();
        return path;
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
