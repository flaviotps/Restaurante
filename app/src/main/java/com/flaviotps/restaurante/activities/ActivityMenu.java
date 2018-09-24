package com.flaviotps.restaurante.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.flaviotps.restaurante.R;
import com.flaviotps.restaurante.fragments.FragmentMenu;
import com.flaviotps.restaurante.fragments.FragmentMain;
import com.flaviotps.restaurante.fragments.FragmentNotifications;
import com.flaviotps.restaurante.models.ModelProduct;
import com.flaviotps.restaurante.util.DataWrapper;

import java.util.ArrayList;
import java.util.List;

public class ActivityMenu extends AppCompatActivity implements View.OnClickListener {


    private FragmentManager fm;
    private BottomNavigationView navigation;


    private void bindActivity() {

        fm = getSupportFragmentManager();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        DataWrapper.modelProductList.add(new ModelProduct("https://www.natue.com.br/natuelife/wp-content/uploads/2016/08/Batata-frita-de-forno.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("http://cozinhasimples.com.br/wp-content/uploads/2016/02/cozinha-simples-bolinhho-de-bacalhau.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("https://s3-sa-east-1.amazonaws.com/delivery-direto/img/items/churrasco-misto-p4-pessoas1496858146.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("http://gambol.com.br/wp-content/uploads/2016/10/pastel.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("https://www.natue.com.br/natuelife/wp-content/uploads/2016/08/Batata-frita-de-forno.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("http://cozinhasimples.com.br/wp-content/uploads/2016/02/cozinha-simples-bolinhho-de-bacalhau.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("https://s3-sa-east-1.amazonaws.com/delivery-direto/img/items/churrasco-misto-p4-pessoas1496858146.jpg"));
        DataWrapper.modelProductList.add(new ModelProduct("http://gambol.com.br/wp-content/uploads/2016/10/pastel.jpg"));


        bindActivity();
        changeFragment(new FragmentMenu());

    }


    public void changeFragment(Fragment fragment) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}

