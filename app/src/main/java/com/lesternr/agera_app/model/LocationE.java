package com.lesternr.agera_app.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LSTR on 4/20/16.
 */
public class LocationE {
    @SerializedName("street")
    String street_name;

    @SerializedName("city")
    String city;

    public String getStreet_name() {
        return street_name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}