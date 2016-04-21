package com.lesternr.mvp_agera.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lesternr.mvp_agera.R;
import com.lesternr.mvp_agera.model.FriendE;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jmtech on 4/20/16.
 */
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    private final ArrayList<FriendE> mValues;
    private Context ctx;

    public FriendAdapter(Context ctx,ArrayList<FriendE> items) {
        mValues = items;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getName().getFirst_name()+" "+mValues.get(position).getName().getLast_name());
        holder.mContentView.setText(mValues.get(position).getLocation().getStreet_name() + " - " +mValues.get(position).getLocation().getCity());

        Picasso.with(ctx).load(mValues.get(position).getPicture().getImg_large_url()).placeholder(R.mipmap.ic_launcher).into(holder.iv_item);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {}
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        @Bind(R.id.iv_item) ImageView iv_item;
        @Bind(R.id.content) TextView mContentView;
        @Bind(R.id.id) TextView mIdView;

        public FriendE mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            mView = view;
        }

    }
}