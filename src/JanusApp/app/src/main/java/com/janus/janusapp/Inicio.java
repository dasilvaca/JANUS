package com.janus.janusapp;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.gson.Gson;
import com.janus.janusapp.classes.Project;
import com.janus.janusapp.classes.User;

public class Inicio extends AppCompatActivity {
    Gson gson;
    public static User MainUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        String MainUserStr = getIntent().getStringExtra("usuario");
        gson=new Gson();
        MainUser= gson.fromJson(MainUserStr,User.class);
        newProjectFragment frag = new newProjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("usuario",MainUserStr);
        frag.setArguments(bundle);
        BottomNavigationView bottomnav = findViewById(R.id.bottomNavigationView2);
        bottomnav.setOnNavigationItemSelectedListener(navListener);
        bottomnav.setSelectedItemId(R.id.homeFragment);
        bottomnav.setSelectedItemId(R.id.homeFragment);
    }

    /**
     *  Bueno, aquí es donde se cambian por defecto las vistas de la aplicación. Por defecto, es decir, cuando arranca se manda a Home
     */
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch(item.getItemId()){
                        case R.id.configFragment:
                            selectedFragment = new configFragment();
                            break;
                        case R.id.homeFragment:
                            selectedFragment = new homeFragment();
                            break;
                        case R.id.newProjectFragment:
                            selectedFragment = new newProjectFragment();
                            break;
                        case R.id.profileFragment:
                            selectedFragment = new profileFragment();
                            break;
                        case R.id.searchFragment:
                            selectedFragment = new searchFragment();
                            break;
                        default: selectedFragment = new newProjectFragment();
                        break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selectedFragment).commit();
                    return true;
                }
            };
    /** ==========================Hasta aquí el selector de fragment=============================**/



}