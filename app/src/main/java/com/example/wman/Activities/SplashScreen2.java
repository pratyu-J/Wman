package com.example.wman.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.wman.Adapters.OnBoardingAdapter;
import com.example.wman.R;

public class SplashScreen2 extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        viewPager = findViewById(R.id.viewpager);

        OnBoardingAdapter adapter = new OnBoardingAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
}