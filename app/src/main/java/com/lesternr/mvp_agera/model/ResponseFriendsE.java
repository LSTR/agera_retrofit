package com.lesternr.mvp_agera.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jmtech on 4/20/16.
 */
public class ResponseFriendsE {
    @SerializedName("results")
    ArrayList<FriendE> friends;

    public ArrayList<FriendE> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<FriendE> friends) {
        this.friends = friends;
    }
}