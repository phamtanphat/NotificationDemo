package com.example.appalarmclock;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class AlarmReceive extends BroadcastReceiver {
    NotificationManager mNotificationManager;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BBB","Cos");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            String CHANNEL_ID = "my_channel_01";// The id of the channel.
            CharSequence name = "channel";// The user-visible name of the channel.
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            String channelId = "Your_channel_id";

            builder.setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("Time"))
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setContentTitle("Bao thuc")
                    .setChannelId("my_channel_01")
                    .setContentText("Da toi gio hen")
                    .setAutoCancel(true);

            mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.createNotificationChannel(mChannel);
        }else{
            builder.setSmallIcon(android.R.drawable.sym_def_app_icon)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("Time"))
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setContentTitle("Bao thuc")
                    .setContentText("Da toi gio hen")
                    .setAutoCancel(true);
           mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
        mNotificationManager.notify(0, builder.build());



    }


}
