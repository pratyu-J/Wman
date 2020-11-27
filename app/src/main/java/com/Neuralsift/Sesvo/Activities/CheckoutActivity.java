package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.Neuralsift.Sesvo.Fragments.Checkout1;
import com.Neuralsift.Sesvo.Fragments.Checkout3;
import com.Neuralsift.Sesvo.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

public class CheckoutActivity extends AppCompatActivity implements PaymentResultListener {

    ImageButton back;
    final String TAG = "CHECKOUT_ACTI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        back = findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, new Checkout1()).commit();

    }

    @Override
    public void onPaymentSuccess(String s) {
        Checkout.clearUserData(this);
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment_container, new Checkout3()).addToBackStack(null).commit();
        Log.d(TAG +" success: ", s );
    }

    @Override
    public void onPaymentError(int i, String s) {

    }
}