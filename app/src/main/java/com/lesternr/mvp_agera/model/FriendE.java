package com.lesternr.mvp_agera.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jmtech on 4/20/16.
 */
public class FriendE {
    String gender;
    String phone;
    String cell;
    String email;

    @SerializedName("location")
    LocationE location;

    @SerializedName("name")
    NameE name;

    @SerializedName("picture")
    PictureE picture;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public LocationE getLocation() {
        return location;
    }

    public void setLocation(LocationE location) {
        this.location = location;
    }

    public NameE getName() {
        return name;
    }

    public void setName(NameE name) {
        this.name = name;
    }

    public PictureE getPicture() {
        return picture;
    }

    public void setPicture(PictureE picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}