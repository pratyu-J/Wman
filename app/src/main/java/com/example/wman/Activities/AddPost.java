package com.example.wman.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.wman.Fragments.GalleryFragment;
import com.example.wman.Fragments.PhotoFragment;
import com.example.wman.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddPost extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_holder, new GalleryFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
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

            getSupportFragmentManager().beginTransaction().replace(R.id.frag_holder, selectedFragment).commit();
            return true;
        }
    };
}