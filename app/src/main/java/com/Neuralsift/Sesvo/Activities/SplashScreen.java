package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.Neuralsift.Sesvo.Classes.AppPreferences;
import com.Neuralsift.Sesvo.R;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ImageView logo = findViewById(R.id.logo);

       /*logo.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               springAnimation(view, 1200);
           }
       });*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(AppPreferences.loadPreferences(SplashScreen.this, "logged_in").equals("1")){

                    if(AppPreferences.loadPreferences(SplashScreen.this,"user_mode").equals("seller")){
                        Intent intent = new Intent(SplashScreen.this, SellerHomeScreen.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(SplashScreen.this, BuyerHomeScreen.class);
                        startActivity(intent);
                    }

                }
                else {
                    Intent intent = new Intent(SplashScreen.this, SplashScreen2.class);
                    startActivity(intent);
                }


            }
        },5000);
    }

    public void springAnimation(View img, float position){
        SpringAnimation springAnimation = new SpringAnimation(img, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_LOW);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY);
        springForce.setFinalPosition(position);
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

}