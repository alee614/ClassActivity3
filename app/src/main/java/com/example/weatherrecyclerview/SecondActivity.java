package com.example.weatherrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    // receive the intent in this page
    // initalize the Weather class
    // add them all to a list

    private String location;
    private ArrayList<Weather> weatherInfo;
    private RecyclerView recyclerView;

    // WeatherAdapter adapter = new WeatherAdapter(weatherinfo);
    // recyclerView.setAdapter(adapter);
    // recyclerView.setLayoutManager(new LinearLayoutManager(this));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.recyclerView_weather);
        // weatherInfo will be the Intent get
        weatherInfo = new ArrayList<Weather>();
        weatherInfo = getIntent().getParcelableArrayListExtra("weatherList");
        Log.d("intent", String.valueOf(weatherInfo));

        for (Weather weather : weatherInfo){
            Log.d("feels", String.valueOf(weather.getTemperature()));
            Log.d("date", weather.getTime());
            Log.d("description", weather.getDescription());


        }







    }
}