package com.example.weatherrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Weather {
    private String time;
    private int temperature;
    private String description;


    public Weather(String time, int temperature, String description){

        this.time = time;
        this.temperature = temperature;
        this.description = description;
    }

    protected Weather(Parcel in) {
        time = in.readString();
        temperature = in.readInt();
        description = in.readString();
    }


    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }


    public String getTime() {
        return time;
    }

}
