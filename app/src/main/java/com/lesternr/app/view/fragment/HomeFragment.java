package com.lesternr.app.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lesternr.app.R;
import com.lesternr.app.model.FriendE;
import com.lesternr.app.presenter.FriendPresenter;
import com.lesternr.app.view.adapter.FriendAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by LSTR on 4/20/16.
 */
public class HomeFragment extends Fragment implements FriendPresenter.FriendView {

    @Bind(R.id.rv_friend_list) RecyclerView recyclerView;
    @Bind(R.id.refresh_layout) SwipeRefreshLayout swipeRefreshLayout;

    FriendPresenter friendPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this,root);

        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
        friendPresenter = new FriendPresenter(this);
        swipeRefreshLayout.setOnRefreshListener(friendPresenter.getRefreshObservable());

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        friendPresenter.addUpdatable();
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        friendPresenter.removeUpdatable();
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public void onSuccess(ArrayList<FriendE> friends) {
        FriendAdapter fAdapter = new FriendAdapter(getContext(), friends);
        recyclerView.setAdapter(fAdapter);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}