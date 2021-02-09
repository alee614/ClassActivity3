package com.example.weatherrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {


    // receive the intent in this page
    // initalize the Weather class
    // add them all to a list

    private TextView location;
    private ArrayList<Weather> weatherInfo;
    private RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerView_weather);
        location = findViewById(R.id.textView_title);

        weatherInfo = new ArrayList<>();

        Intent intent = getIntent();
        location.setText(intent.getStringExtra("location"));

        weatherInfo = intent.getParcelableArrayListExtra("value");
        WeatherAdapter adapter = new WeatherAdapter(weatherInfo);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

/**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerView_weather);
        location = findViewById(R.id.textView_title);

        weatherInfo = new ArrayList<>();

        Intent intent = getIntent();
        String value = intent.getStringExtra("json");

        JSONObject json = null;


        try {
            json = new JSONObject(value);
            JSONObject jsonCity = json.getJSONObject("city");
            String city = jsonCity.getString("name");
            String country = jsonCity.getString("country");
            String stringlocation = city + ", " + country;
            location.setText(stringlocation);

            JSONArray list = json.getJSONArray("list");
            for (int i = 0; i < list.length(); i++){
                JSONObject info = list.getJSONObject(i);
                // feels like
                JSONObject main = info.getJSONObject("main");
                int feelsLike = main.getInt("feels_like");
                        Log.d("temp", String.valueOf(feelsLike));
                // description
                JSONArray weather = info.getJSONArray("weather");
                JSONObject obj = weather.getJSONObject(0);
                String description = obj.getString("description");
                        Log.d("descrip", description);

                // time
                String time = info.getString("dt_txt");
                        Log.d("time", time);

                Weather weatherObject = new Weather(time, feelsLike, description);
                weatherInfo.add(weatherObject);
            }



             WeatherAdapter adapter = new WeatherAdapter(weatherInfo);
             recyclerView.setAdapter(adapter);
             recyclerView.setLayoutManager(new LinearLayoutManager(this));




        } catch (JSONException e) {
            e.printStackTrace();
        }






/**






//
//        // weatherInfo will be the Intent get
//        weatherInfo = new ArrayList<Weather>();
//        weatherInfo = getIntent().getParcelableArrayListExtra("weatherList");

        Log.d("intent", String.valueOf(weatherInfo));

//        for (Weather weather : weatherInfo){
//            Log.d("feels", String.valueOf(weather.getTemperature()));
//            Log.d("date", weather.getTime());
//            Log.d("description", weather.getDescription());
//
//
//        }








    }
    */


}