package com.example.wman.Fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.wman.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import static com.example.wman.Activities.MyCartActivity.total;


public class Checkout2 extends Fragment  {

    public Checkout2() {
        // Required empty public constructor
    }

    Button pay;
    Checkout checkout;
    private String TAG = "UserCart";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_checkout2, container, false);

        pay = v.findViewById(R.id.pay);
        pay.setText(Float.toString(total));
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialiseRazorPayForPayment();
            }
        });

        return v;
    }

    public void initialiseRazorPayForPayment(){

        checkout = new Checkout();
        checkout.setKeyID("rzp_test_QJXvTl0ApkxlsX");

        final Activity activity = getActivity();

        try {
            JSONObject options = new JSONObject();

            options.put("name", "Test Price Comparison");

            options.put("description", "Transaction #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            //options.put("order_id", "123456");
            options.put("currency", "INR");

            /**
             * Amount is always passed in currency subunits
             * Eg: "500" = INR 5.00
             */
            options.put("amount", total*100);

            if (activity != null) {
                checkout.open(activity, options);
            }else{
                Toast.makeText(activity, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {
            Log.e(TAG, "Error in starting Razorpay Checkout", e);
            Toast.makeText(activity, R.string.something_went_wrong, Toast.LENGTH_SHORT).show();

        }
    }



}