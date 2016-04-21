package com.lesternr.mvp_agera.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jmtech on 4/20/16.
 */
public class NameE {
    @SerializedName("title")
    String title_name;

    @SerializedName("first")
    String first_name;

    @SerializedName("last")
    String last_name;

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}