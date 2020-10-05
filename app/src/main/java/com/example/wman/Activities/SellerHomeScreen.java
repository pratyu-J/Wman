package com.example.wman.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wman.Classes.AppPreferences;
//import com.example.wman.Fragments.AddPosts;
import com.example.wman.Fragments.SellerCategoryFragment;
import com.example.wman.Fragments.SellerHomeFragment;
import com.example.wman.Fragments.SellerProfileFragment;
import com.example.wman.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SellerHomeScreen extends AppCompatActivity {

    public static SearchView searchView;
    public static Toolbar toolbar;
    public static TextView screenTitle;
    DrawerLayout drawerLayout;
    private static String TAG = "Tab filter";
    ImageButton showDrawer, cart;
    String mode = "Buyer";

    LinearLayout profile, home, previousOrders, toCart, settings, buyProducts, logout, categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home_screen);

        drawerLayout = findViewById(R.id.drawer_layout);
        showDrawer = findViewById(R.id.show_drawer);
        searchView = findViewById(R.id.search);
        screenTitle = findViewById(R.id.screen_title);
        toolbar = findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_nav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        mode =  AppPreferences.loadPreferences(SellerHomeScreen.this, "user_mode");

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerHomeFragment()).commit();

        profile = findViewById(R.id.dashboard);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SellerHomeScreen.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });


        previousOrders = findViewById(R.id.prev_orders);
        previousOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SellerHomeScreen.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });


        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SellerHomeScreen.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        buyProducts = findViewById(R.id.buyer_side);
        buyProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellerHomeScreen.this, BuyerHomeScreen.class));
            }
        });

        logout = findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SellerHomeScreen.this, LoginActivity.class));
            }
        });

        setNavigationDrawer();
    }

    private void setNavigationDrawer() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        showDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;

            switch (menuItem.getItemId()){
                case R.id.home_sell :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerHomeFragment()).commit();
                    selectedFragment = new SellerHomeFragment();

                    break;
                case R.id.categories_sell :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerCategoryFragment()).commit();
                    selectedFragment = new SellerCategoryFragment();

                    break;
                case R.id.add_post:
                   // selectedFragment = new AddPosts();
                    startActivity(new Intent(SellerHomeScreen.this, AddPost.class));
                    break;
                case R.id.profile_sell :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerProfileFragment()).commit();
                    selectedFragment = new SellerProfileFragment();

                    break;

            }
                if(selectedFragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment).commit();
                }

            return true;
        }
    };

}