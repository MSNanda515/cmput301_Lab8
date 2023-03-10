package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 * Custom list Array adapter
 */
public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    /**
     * Constructor
     * @param context the context
     * @param cities the list of cities
     */
    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * Gets the count
     * @return
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * Adds cities
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * Determines whether the given city is in the city list
     * @param city (City): the city to check in the list
     * @return (boolean) whether the given city is in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes the given city from the list
     * @param city (City): the city to delete
     * @throws IllegalArgumentException when the city is not present in the list
     */
    public void delete(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("City does not exist");
        }
    }

    /**
     * Count the number of cities present in the list
     * @return (int) the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}
