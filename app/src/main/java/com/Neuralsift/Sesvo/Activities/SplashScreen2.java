package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.Neuralsift.Sesvo.Adapters.OnBoardingAdapter;
import com.Neuralsift.Sesvo.R;

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