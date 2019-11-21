package com.example.fcm;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
    public static final String channel_1_id="channel";
    public static final String channel_2_id="channel2";

    @Override
    public void onCreate() {
        super.onCreate();
    }
    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(
                    channel_1_id,"channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("welcome to channnel one");

            NotificationChannel  channel2=new NotificationChannel(
                    channel_2_id,"channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            channel2.setDescription("send feedback here");
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
            manager.createNotificationChannel(channel2);
        }
    }
}
