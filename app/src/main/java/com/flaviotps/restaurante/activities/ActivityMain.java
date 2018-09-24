package com.flaviotps.restaurante.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.fragments.FragmentMenu;
import com.flaviotps.restaurante.fragments.FragmentMain;
import com.flaviotps.restaurante.fragments.FragmentNotifications;

public class ActivityMain extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fm;
    private BottomNavigationView navigation;


    private void bindActivity() {

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);


        fm = getSupportFragmentManager();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindActivity();
        changeFragment(new FragmentMain());

    }


    public void changeFragment(Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.bottom_menu_principal:
                changeFragment(new FragmentMain());
                return true;
            case R.id.bottom_menu_notification:
                changeFragment(new FragmentNotifications());
                return true;

            case R.id.bottom_menu_location:
                startActivity(new Intent(this, ActivityMenu.class));
                return true;


        }


        return false;

    }

}

