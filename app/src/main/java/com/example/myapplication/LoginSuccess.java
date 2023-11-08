package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginSuccess extends AppCompatActivity {
    TextView welcomeText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_success);
        welcomeText = (TextView) findViewById(R.id.welcome_text);
        Intent intent = getIntent();
        if (intent.getStringExtra("username") != null) {
            welcomeText.setText("Welcome, "+getIntent().getStringExtra("username"));
        }

    }
}
