package com.example.weatherrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {
    // create the basic adapted extending from RecyclerView.Adapter
        // create an inner/helper class that specify the custom viewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        // helper class that provides direct reference to each of the views within the data item
        // used to cache the views within the item layout for fast access
        TextView textView_time;
        TextView textView_description;
        TextView textView_temp;

        public ViewHolder (View itemView){
            // itemview => represents the entire view of each row
            super(itemView);
            // look up each View from custom layout

            textView_time = itemView.findViewById(R.id.text_time);
            textView_temp = itemView.findViewById(R.id.text_temp);
            textView_description = itemView.findViewById(R.id.text_description);
        }

    }

    // list of data to be populated
    // storing an instance variable for the list of data to be populated
    // pass list into constructor of the adapter
    private List<Weather> weatherInfo;
    public WeatherAdapter(List<Weather> weatherInfo){
        this.weatherInfo = weatherInfo;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate a layout from xml and return the viewholder
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //inflate custom layout
        View weatherView = inflater.inflate(R.layout.item_weather, parent, false);

        //return new viewHolder
        ViewHolder viewHolder = new ViewHolder(weatherView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.ViewHolder holder, int position) {
        // populate data into the item through holder
        // grab the actual data model aka Weather object based on the position

        Weather weather = weatherInfo.get(position);
        holder.textView_description.setText(weather.getDescription());
        holder.textView_temp.setText(weather.getTemperature());
        holder.textView_time.setText(weather.getTime());

    }



    @Override
    public int getItemCount() {
        return weatherInfo.size();
    }
}
