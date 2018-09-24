package com.flaviotps.restaurante.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.models.ModelProduct;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFeatured extends RecyclerView.Adapter<AdapterFeatured.FeaturedViewHolder> {


    private List<ModelProduct> modelProducts;
    private Activity activity;

    public AdapterFeatured(List<ModelProduct> modelProducts, Activity activity) {
        this.modelProducts = modelProducts;
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

        Glide.with(activity).load(modelProducts.get(position).image_src).into(holder.featuredImage);

    }

    @Override
    public int getItemCount() {
        return modelProducts.size();
    }


    public class FeaturedViewHolder extends RecyclerView.ViewHolder {

        CircleImageView featuredImage;


        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);


            featuredImage = itemView.findViewById(R.id.featuredImage);

        }
    }
}