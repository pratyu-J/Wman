package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.Neuralsift.Sesvo.Adapters.TabAdapter;
import com.Neuralsift.Sesvo.Fragments.CreateAccountBuyer;
import com.Neuralsift.Sesvo.Fragments.CreateAccountSeller;
import com.Neuralsift.Sesvo.R;
import com.google.android.material.tabs.TabLayout;

public class CreateAccount extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tabLayout);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

    }


    private void setUpViewPager(ViewPager viewPager) {

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new CreateAccountBuyer(), "Buyer");
        adapter.addFragment(new CreateAccountSeller(), "Seller");
        viewPager.setAdapter(adapter);
    }

}