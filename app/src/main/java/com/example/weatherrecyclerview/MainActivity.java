package com.example.weatherrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private String city;
    private TextInputEditText input_city;
    private Button go;
    private static final String api_url = "http://api.openweathermap.org/data/2.5/forecast";
    private String json;


    AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_city = findViewById(R.id.input_city);
        go = findViewById(R.id.button_go);


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchWeather(v);
            }
        });



    }

    public void searchWeather(View view){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        city = input_city.getText().toString();

        RequestParams params = new RequestParams();
        params.put("q", city);
        params.put("appid", "4405eac90732bc35c793b1c4d5db3f77");
        params.put("units", "imperial");

        client.get(api_url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                json = new String(responseBody);
                intent.putExtra("json", json);
                startActivity(intent);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        }

        );


    }
}