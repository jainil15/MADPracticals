package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.toast_button);
        btn.setOnClickListener(view -> {
            Toast.makeText(this, "Hello, welcome to Android Lab", Toast.LENGTH_SHORT).show();
        });

    }
}
