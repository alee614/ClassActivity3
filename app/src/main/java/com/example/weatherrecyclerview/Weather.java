package com.example.weatherrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Weather implements Parcelable{
    private String time;
    private String date;
    private int temperature;
    private String description;


    public Weather(String time, String date, int temperature, String description){
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.description = description;
    }

    protected Weather(Parcel in) {
        time = in.readString();
        temperature = in.readInt();
        description = in.readString();
        date = in.readString();
    }


    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public String getDescription() {
        return description;
    }

    public String getDate(){ return date;}

    public int getTemperature() {
        return temperature;
    }


    public String getTime() {
        return time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeInt(temperature);
        dest.writeString(description);
        dest.writeString(date);
    }
}
