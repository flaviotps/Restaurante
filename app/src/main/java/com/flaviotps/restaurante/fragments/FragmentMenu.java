package com.flaviotps.restaurante.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.activities.ActivityMenu;
import com.flaviotps.restaurante.adapters.AdapterFeatured;
import com.flaviotps.restaurante.util.DataWrapper;

public class FragmentMenu extends Fragment implements View.OnClickListener {

    private AdapterFeatured mAdapterFeatured;
    private RecyclerView mRecyclerView;
    private View fragmentView;
    private int[] menuLayoutButtons = {R.id.layout_plates};


    private void bindFragment() {
        for (int i = 0; i < menuLayoutButtons.length; i++) {
            ConstraintLayout constraintLayout = fragmentView.findViewById(menuLayoutButtons[i]);
            constraintLayout.setOnClickListener(this);
        }

        mRecyclerView = fragmentView.findViewById(R.id.featuredRecyclerView);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_menu, container, false);

        bindFragment();

        initFeatured();

        return fragmentView;

    }

    private void initFeatured() {


        mAdapterFeatured = new AdapterFeatured(DataWrapper.modelProductList, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapterFeatured);
    }


    private void changeFragment(Fragment fragment) {
        ActivityMenu activityMenu = (ActivityMenu) getActivity();
        activityMenu.changeFragment(fragment);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layout_plates:
                Toast.makeText(getActivity(), "AAA", Toast.LENGTH_SHORT).show();
                changeFragment(new FragmentMenuProduct());
                break;
        }

    }
}
