package com.lesternr.agera_app.observable;

import android.support.annotation.NonNull;

import com.google.android.agera.BaseObservable;
import com.google.android.agera.Supplier;
import com.google.android.agera.Updatable;
import com.lesternr.agera_app.model.FriendE;
import com.lesternr.agera_app.model.ResponseFriendsE;
import com.lesternr.agera_app.service.FriendService;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by LSTR on 4/20/16.
 */
public class FriendRepository extends BaseObservable implements Supplier<ArrayList<FriendE>>, Updatable, Callback<ResponseFriendsE> {

    private ArrayList<FriendE> friendsList;

    private boolean lastRefreshError;

    private final FriendService friendServiceFetcher;

    public FriendRepository() {
        super();
        this.friendServiceFetcher = new FriendService();
    }

    @NonNull
    @Override
    public ArrayList<FriendE> get() {
        return friendsList;
    }

    public boolean isError() {
        return lastRefreshError;
    }

    @Override
    public void update() {
        Call<ResponseFriendsE> friendList = friendServiceFetcher.getApi().getFriendList(15);
        friendList.enqueue(this);
    }

    @Override
    protected void observableActivated() {
        update();
    }

    @Override
    public void onResponse(Response<ResponseFriendsE> response, Retrofit retrofit) {
        this.friendsList = response.body().getFriends();
        lastRefreshError = false;
        dispatchUpdate();
    }

    @Override
    public void onFailure(Throwable t) {
        lastRefreshError = true;
        dispatchUpdate();
    }
}