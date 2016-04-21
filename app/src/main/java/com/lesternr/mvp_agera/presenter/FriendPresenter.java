package com.lesternr.mvp_agera.presenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;

import com.google.android.agera.Updatable;
import com.lesternr.mvp_agera.observable.FriendRepository;
import com.lesternr.mvp_agera.observable.OnRefreshObservable;
import com.lesternr.mvp_agera.model.FriendE;

import java.util.ArrayList;

/**
 * Created by LSTR on 4/20/16.
 */
public class FriendPresenter implements Updatable {

    private FriendRepository friendRepository;
    private OnRefreshObservable refreshObservable;
    private FriendView delegate;

    public FriendPresenter(FriendView delegate){
        this.delegate = delegate;
        refreshObservable = new OnRefreshObservable();
        friendRepository = new FriendRepository();
    }

    public void addUpdatable(){
        refreshObservable.addUpdatable(friendRepository);
        friendRepository.addUpdatable(this);
    }

    public void removeUpdatable(){
        refreshObservable.removeUpdatable(friendRepository);
        friendRepository.removeUpdatable(this);
    }

    @Override
    public void update() {
        if (friendRepository.isError()) {
            delegate.onError();
        } else {
            delegate.onSuccess(friendRepository.get());
        }
    }

    public SwipeRefreshLayout.OnRefreshListener getRefreshObservable() {
        return refreshObservable;
    }

    public interface FriendView{
        void onError();
        void onSuccess(ArrayList<FriendE> friends);
        Context getContext();
    }
}