package com.flaviotps.restaurante.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flaviotps.restaurante.R;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class FragmentLoyalty extends Fragment {

    private View fragmentView;
    private CircularProgressIndicator circularProgress;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        fragmentView = inflater.inflate(R.layout.fragment_loyality, container, false);
        circularProgress = fragmentView.findViewById(R.id.circular_progress);
        circularProgress.setProgress(5000, 10000);


        return fragmentView;
    }
}
