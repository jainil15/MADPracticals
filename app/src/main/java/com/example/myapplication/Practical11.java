package com.example.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Practical11 extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical11);

        listView = (ListView) findViewById(R.id.list_view_title);
        new FetchDataAsyncTask().execute();
    }

    private class FetchDataAsyncTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {
            String apiUrl = "https://reqres.in/api/users?page=1";
            ArrayList<String> firstNames = new ArrayList<>();
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
                connection.setRequestMethod("GET");
                InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                    Log.d("Exception1", "doInBackground: "+1);
                }


                JSONObject object = new JSONObject(result.toString());
                JSONArray dataArray = object.getJSONArray("data");

                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject item = dataArray.getJSONObject(i);
                    String firstName = item.getString("first_name");
                    firstNames.add(firstName);
                    Log.d("Exception1", "doInBackground: "+firstName);
                }



            }

            catch (Exception e) {
                Log.d("Exception", "doInBackground: "+e);
            }
            return firstNames;
        }

        @Override
        protected void onPostExecute(ArrayList<String> firstNames) {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(Practical11.this,
                    android.R.layout.simple_list_item_1, firstNames);
            listView.setAdapter(adapter);
        }
    }
}
