package ru.android.hedgehogs.notification.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.main.MainActivity;

/**
 * Created by yasina on 20.04.18.
 */
public class MessageReceiver extends FirebaseMessagingService {

    private static final int REQUEST_CODE = 1;
    private static final int NOTIFICATION_ID = 6578;

    public MessageReceiver() {
        super();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Map<String,String> m = remoteMessage.getData();
        String title, message;
        for (Map.Entry<String,String> entry : m.entrySet()) {
            title = entry.getKey();
            message = entry.getValue();
            Log.d("FIREBASE","Key = " + entry.getKey() + ", Value = " + entry.getValue());
            showNotifications(title, message);
        }
    }

    private void showNotifications(String title, String msg) {
        Intent i = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE,
                i, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setContentText(msg)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.play)
                .setSound(alarmSound).setDefaults(Notification.DEFAULT_SOUND)
                .build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, notification);
    }

}
