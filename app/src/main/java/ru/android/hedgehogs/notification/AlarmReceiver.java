package ru.android.hedgehogs.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Calendar;

import ru.android.hedgehogs.R;
import ru.android.hedgehogs.main.download.DownloadActivity;

/**
 * Created by yasina on 15.03.18.
 */

public class AlarmReceiver extends BroadcastReceiver {

    public static final String NOTIFICATION_FREQUENCY = "NOTIFICATION_FREQUENCY";
    private int notifFrequency;

    @Override
    public void onReceive(Context context, Intent intent) {

        notifFrequency = intent.getIntExtra(NOTIFICATION_FREQUENCY, 0);

        Intent intentToRepeat = new Intent(context, DownloadActivity.class);
        intentToRepeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(context, NotificationHelper.ALARM_TYPE_RTC, intentToRepeat,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        Notification repeatedNotification = buildLocalNotification(context, pendingIntent).build();
        NotificationHelper.getNotificationManager(context).
                notify(NotificationHelper.ALARM_TYPE_RTC, repeatedNotification);
    }

    public NotificationCompat.Builder buildLocalNotification(Context context, PendingIntent pendingIntent) {

        Log.d("f","ff");
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.drawable.hedgehog)
                        .setContentTitle(context.getString(R.string.notification_text))
                        .setAutoCancel(true)
                        .setSound(alarmSound);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
               builder.setChannelId("11");
        }

        return builder;
    }
}