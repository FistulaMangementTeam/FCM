package com.example.fcm;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static com.example.fcm.App.channel_1_id;
import static com.example.fcm.App.channel_2_id;

public class Notification extends AppCompatActivity {
    private NotificationManagerCompat notificationmanager;
    private EditText edittexttitle;
    private EditText editTextmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        notificationmanager=NotificationManagerCompat.from(this);
        edittexttitle=findViewById(R.id.txt1);
        editTextmessage=findViewById(R.id.txt2);
    }
    //SETTING UP THE CURRENT NOTIFICATION TO DISPLAY IN THE DROP DOWN WINDOW
    public void sendonchannel2(View v){
        String title=edittexttitle.getText().toString();
        String message=editTextmessage.getText().toString();
        android.app.Notification notify=new NotificationCompat.Builder(this,channel_2_id)
                .setSmallIcon(R.drawable.ic_meso)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();
        notificationmanager.notify(2,notify);


    }
}
