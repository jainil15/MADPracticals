package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Practical8 extends AppCompatActivity {
    private Button sendNotificationBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical8);

        sendNotificationBtn = (Button) findViewById(R.id.send_notification_btn);

        sendNotificationBtn.setOnClickListener(view -> {
            Intent notificationIntent = new Intent( this, NotifactionBroadcastReciever.class );
            sendBroadcast(notificationIntent);
        });

    }
}
