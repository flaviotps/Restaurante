package com.flaviotps.restaurante.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.adapters.AdapterFeatured;
import com.flaviotps.restaurante.adapters.AdapterProduct;
import com.flaviotps.restaurante.util.DataWrapper;

public class FragmentMenuProduct extends Fragment {

    private View fragmentView;
    private AdapterProduct adapterProduct;
    private RecyclerView mRecyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_product, container, false);

        adapterProduct = new AdapterProduct(DataWrapper.modelProductList, getActivity());
        initProducts();
        return fragmentView;
    }


    private void initProducts() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView = fragmentView.findViewById(R.id.productsRecyclerView);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapterProduct);
    }

}
