package com.flaviotps.restaurante.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.models.ModelProduct;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductHolder> {

    private List<ModelProduct> modelProducts;
    private Activity activity;

    public AdapterProduct(List<ModelProduct> modelProducts, Activity activity) {
        this.modelProducts = modelProducts;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View productView = LayoutInflater.from(parent.getContext()).inflate(R.layout.include_product, parent, false);

        ProductHolder productHolder = new ProductHolder(productView);

        return productHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Glide.with(activity).load(modelProducts.get(position).image_src).into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return modelProducts.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {

        ImageView productImage;

        public ProductHolder(View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }
}
