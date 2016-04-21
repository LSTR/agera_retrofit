package com.lesternr.mvp_agera.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lesternr.mvp_agera.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jmtech on 4/20/16.
 */
public class HomeActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }
}