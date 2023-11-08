package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Practical10 extends AppCompatActivity {
    private EditText nameEdit, phoneEdit, emailEdit;
    private Button saveButton;
    private TextView textView;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical10);

        nameEdit = (EditText) findViewById(R.id.name_edit);
        emailEdit = (EditText) findViewById(R.id.email_edit);
        phoneEdit = (EditText) findViewById(R.id.phone_number_edit);
        textView = (TextView) findViewById(R.id.text_preference);
        saveButton = (Button) findViewById(R.id.save_preference);

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_PRIVATE);

        String name = sharedPreferences.getString("name", "");
        String phone = sharedPreferences.getString("phone_no", "");
        String email = sharedPreferences.getString("email", "");

        textView.setText("Name:" + name + " Phone: "+phone+" Email: "+email);

        saveButton.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();

            editor.putString("name", nameEdit.getText().toString());
            editor.putString("phone_no", phoneEdit.getText().toString());
            editor.putString("email", emailEdit.getText().toString());

            editor.apply();

            Toast.makeText(this, "Preferences Set   ", Toast.LENGTH_SHORT).show();

            String name2 = sharedPreferences.getString("name", "");
            String phone2 = sharedPreferences.getString("phone_no", "");
            String email2 = sharedPreferences.getString("email", "");


            textView.setText("Name:" + name2 + " Phone: "+phone2+" Email: "+email2 + "");

        });


    }
}
