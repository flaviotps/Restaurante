package com.flaviotps.restaurante.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.activities.ActivityMain;
import com.flaviotps.restaurante.activities.ActivityMenu;

import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentMain extends Fragment
        implements AppBarLayout.OnOffsetChangedListener, View.OnClickListener {

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private FrameLayout mFrameLayout;
    private View fragmentView;
    private CircleImageView circleImageViewToolbar;
    private CircleImageView circleImageView;
    private int[] menuLayoutButtons = {R.id.menu_food, R.id.menu_event, R.id.menu_loyalty};

    private FragmentManager mFragmentManager;

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

        bindFragment();

        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_main);

        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

        return fragmentView;
    }

    private void bindFragment() {

        mToolbar = (Toolbar) fragmentView.findViewById(R.id.main_toolbar);
        mTitle = (TextView) fragmentView.findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) fragmentView.findViewById(R.id.main_linearlayout_title);
        mAppBarLayout = (AppBarLayout) fragmentView.findViewById(R.id.main_appbar);
        mFrameLayout = fragmentView.findViewById(R.id.fragmentContainer);
        circleImageViewToolbar = fragmentView.findViewById(R.id.circleImageViewToolbar);
        circleImageView = fragmentView.findViewById(R.id.circleImageView);

        for (int i = 0; i < menuLayoutButtons.length; i++) {
            ConstraintLayout constraintLayout = fragmentView.findViewById(menuLayoutButtons[i]);
            constraintLayout.setOnClickListener(this);
        }

    }


    private void changeFragment(Fragment fragment) {
        ActivityMain activityMenu = (ActivityMain) getActivity();
        activityMenu.changeFragment(fragment);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            circleImageViewToolbar.setVisibility(View.VISIBLE);
            circleImageView.setVisibility(View.INVISIBLE);

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            circleImageViewToolbar.setVisibility(View.INVISIBLE);
            circleImageView.setVisibility(View.VISIBLE);
            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu_food:
                startActivity(new Intent(getActivity(), ActivityMenu.class));
                break;
            case R.id.menu_loyalty:
                changeFragment(new FragmentLoyalty());
                break;
        }

    }
}
