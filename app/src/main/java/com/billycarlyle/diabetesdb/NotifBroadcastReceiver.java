package com.billycarlyle.diabetesdb;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class NotifBroadcastReceiver extends BroadcastReceiver {
    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("NOTIFICATIONS", "Call received to create notification");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "DB_Channel")
                .setSmallIcon(R.drawable.ic_stat_access_alarm)
                .setContentTitle("Update glucose level")
                .setContentText("Please add your current glucose level to the database")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        //intellij wanted me to add this for permissions checks: not sure how it works but I'll figure it out later
        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //send the notification
        notificationManager.notify(0, builder.build());
    }
}
