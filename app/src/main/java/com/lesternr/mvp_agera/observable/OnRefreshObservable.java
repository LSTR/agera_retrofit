package com.lesternr.mvp_agera.observable;

import android.support.v4.widget.SwipeRefreshLayout;
import com.google.android.agera.BaseObservable;

/**
 * Created by jmtech on 4/20/16.
 */
public class OnRefreshObservable extends BaseObservable implements SwipeRefreshLayout.OnRefreshListener {

    /**
     * Triggered when the associated {@link SwipeRefreshLayout} is refreshed by the user. The event
     * is passed on to the observers, using the {@link com.google.android.agera.UpdateDispatcher} provided by {@link
     * BaseObservable}.
     */
    @Override
    public void onRefresh() {
        dispatchUpdate();
    }
}