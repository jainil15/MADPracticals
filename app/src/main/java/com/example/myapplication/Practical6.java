package com.example.myapplication;

import android.content.res.Resources;
import android.os.Bundle;
import com.google.gson.Gson;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Models.Student;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Practical6 extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical5);


        ArrayList<Student> studentList = getStudentData();

        recyclerView= (RecyclerView) findViewById(R.id.student_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new StudentAdapter(this, studentList));
    }
    public ArrayList<Student> getStudentData() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        //--
        Resources res = getResources();
        int resourceId = res.getIdentifier("sample_data", "raw", getPackageName());
        InputStream inputStream = res.openRawResource(resourceId);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            studentArrayList.addAll(Arrays.asList(gson.fromJson(String.valueOf(content), Student[].class)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return studentArrayList;
    }
}
