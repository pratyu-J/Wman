package com.example.wman.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wman.Classes.AppPreferences;
import com.example.wman.Fragments.BuyerCategoryFragment;
import com.example.wman.Fragments.BuyerHomeFragment;
import com.example.wman.Fragments.BuyerProfileFragment;
import com.example.wman.Fragments.BuyerSavedFragment;
import com.example.wman.Fragments.SellerHomeFragment;
import com.example.wman.HelperChatBot.ChatScreenActivity;
import com.example.wman.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BuyerHomeScreen extends AppCompatActivity {

    public static SearchView searchView;
    public static FrameLayout frame;
    DrawerLayout drawerLayout;
    public static TextView pageTitle;
    private static String TAG = "BuyerHomeSc";
    ImageButton showDrawer, cart;
    String mode = "Buyer";
    LinearLayout profile, assistant, previousOrders, toCart, settings, sellProducts, logout, categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_home_screen);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_nav_menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        pageTitle = findViewById(R.id.page_title);
        pageTitle.setText("Home");
        drawerLayout = findViewById(R.id.drawer_layout);
        showDrawer = findViewById(R.id.show_drawer);
        searchView = findViewById(R.id.search);
        cart = findViewById(R.id.cart);
        mode =  AppPreferences.loadPreferences(BuyerHomeScreen.this, "user_mode");

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyerHomeScreen.this, MyCartActivity.class));
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, new BuyerHomeFragment()).commit();

        profile = findViewById(R.id.dashboard);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyerHomeScreen.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });


        previousOrders = findViewById(R.id.prev_orders);
        previousOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyerHomeScreen.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });


        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BuyerHomeScreen.this, "Coming Soon", Toast.LENGTH_SHORT).show();
            }
        });

        assistant = findViewById(R.id.assistant_bot);
        assistant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyerHomeScreen.this, ChatScreenActivity.class));
            }
        });

        sellProducts = findViewById(R.id.seller_side);
        sellProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyerHomeScreen.this, SellerHomeScreen.class));
            }
        });

        logout = findViewById(R.id.Logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyerHomeScreen.this, LoginActivity.class));
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
                case R.id.home_buy :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerHomeFragment()).commit();
                    selectedFragment = new BuyerHomeFragment();

                    break;
                case R.id.categories_buy :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerCategoryFragment()).commit();
                    selectedFragment = new BuyerCategoryFragment();

                    break;
                case R.id.saved:
                    selectedFragment = new BuyerSavedFragment();

                    break;
                case R.id.profile_buy :
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new SellerProfileFragment()).commit();
                    selectedFragment = new BuyerProfileFragment();

                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, selectedFragment).commit();
            return true;
        }
    };
}