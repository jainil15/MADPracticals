package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_DB extends AppCompatActivity {
    private static final String COL_ID = "eid";
    private static final String COL_NAME = "ename";
    private static final String COL_ADDRESS = "eaddress";
    private static final String COL_DESIGNATION = "edesignation";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_db);

        DBHelper dbHelper = new DBHelper(this);
        dbHelper.insertEmployee("Jainil", "55", "ENG");

        Cursor cursor = dbHelper.getAllEmployees();
        TextView textView = (TextView) findViewById(R.id.select_output);
        String result = "";
        if (cursor.moveToFirst()) {
            do {
                // Retrieve data from the cursor
                int employeeId = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String employeeName = cursor.getString(cursor.getColumnIndex(COL_NAME));
                String employeeAddress = cursor.getString(cursor.getColumnIndex(COL_ADDRESS));
                String employeeDesignation = cursor.getString(cursor.getColumnIndex(COL_DESIGNATION));

                result += employeeName + " ";


            } while (cursor.moveToNext());
        }
        textView.setText(result);

// Don't forget to close the cursor to avoid memory leaks
        cursor.close();
    }
}
