package com.lesternr.mvp_agera.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LSTR on 4/20/16.
 */
public class PictureE {
    @SerializedName("large")
    String img_large_url;

    @SerializedName("thumbnail")
    String img_thumbnail_url;

    public String getImg_large_url() {
        return img_large_url;
    }

    public void setImg_large_url(String img_large_url) {
        this.img_large_url = img_large_url;
    }

    public String getImg_thumbnail_url() {
        return img_thumbnail_url;
    }

    public void setImg_thumbnail_url(String img_thumbnail_url) {
        this.img_thumbnail_url = img_thumbnail_url;
    }
}