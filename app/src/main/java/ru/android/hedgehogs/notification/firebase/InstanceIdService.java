package ru.android.hedgehogs.notification.firebase;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ru.android.hedgehogs.utils.PrefUtils;

/**
 * Created by yasina on 20.04.18.
 */
public class InstanceIdService extends FirebaseInstanceIdService {
    public InstanceIdService() {
        super();
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("tag", token);
        PrefUtils.saveFirebaseId(getApplicationContext(), token);
        //sends this token to the server
        //sendToServer(token);
    }
}
