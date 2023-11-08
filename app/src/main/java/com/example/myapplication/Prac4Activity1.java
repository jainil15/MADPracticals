package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Prac4Activity1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac4_activity1);

        Button implicit_btn = (Button) findViewById(R.id.implicit_btn);
        Button explicit_btn = (Button) findViewById(R.id.explicit_btn);
        implicit_btn.setOnClickListener(view-> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitch.tv/"));
            startActivity(intent);
        });

        explicit_btn.setOnClickListener(view-> {
            Intent intent = new Intent(this, Prac4Activity2.class);
            startActivity(intent);
        });

    }


}