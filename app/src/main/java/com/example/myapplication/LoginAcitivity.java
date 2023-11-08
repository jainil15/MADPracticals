package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginAcitivity extends AppCompatActivity {
    EditText username, password;
    Button login_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login_btn = (Button) findViewById(R.id.login_btn);
        login_btn.setOnClickListener(view -> {
            if (username.getText().toString().equals("Jainil") && password.getText().toString().equals("12345")) {
                Intent intent = new Intent(this, LoginSuccess.class);
                intent.putExtra("username", username.getText().toString());
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
