package com.flaviotps.restaurante.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.models.FeaturedModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {


    private List<FeaturedModel> featuredModels;
    private Activity activity;

    public FeaturedAdapter(List<FeaturedModel> featuredModels, Activity activity) {
        this.featuredModels = featuredModels;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mCustomView = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_featured, parent, false);

        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(mCustomView);
        return featuredViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {

        Glide.with(activity).load(featuredModels.get(position).image_src).into(holder.featuredImage);

    }

    @Override
    public int getItemCount() {
        return featuredModels.size();
    }


    public class FeaturedViewHolder extends RecyclerView.ViewHolder {

        CircleImageView featuredImage;


        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);


            featuredImage = itemView.findViewById(R.id.featuredImage);

        }
    }
}