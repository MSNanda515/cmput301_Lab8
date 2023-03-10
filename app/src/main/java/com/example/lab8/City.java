package com.example.lab8;

/**
 * City object
 */
public class City {

    private String city;
    private String province;

    /**
     * Constructor
     * @param city the city
     * @param province the province
     */
    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Getter for city
     * @return city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Getter for province name
     * @return the province name
     */
    String getProvinceName(){
        return this.province;
    }
}
