/*
package com.example.wman.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.wman.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class AddPosts extends Fragment {

    BottomNavigationView bottomNavigationView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_add_posts, container, false);

        bottomNavigationView = v.findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        return v;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.gallery :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerHomeFragment()).commit();
                    selectedFragment = new GalleryFragment();
                    break;
                case R.id.photo :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerCategoryFragment()).commit();
                    selectedFragment = new PhotoFragment();
                    break;


            }

            getChildFragmentManager().beginTransaction().replace(R.id.frag_holder, selectedFragment).commit();
            return true;
        }
    };

}*/
