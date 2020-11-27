package com.Neuralsift.Sesvo.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.Neuralsift.Sesvo.Activities.BuyerHomeScreen;
import com.Neuralsift.Sesvo.R;


public class Checkout3 extends Fragment {

    Button continueShopping;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_checkout3, container, false);

        continueShopping = v.findViewById(R.id.cont_shopping);

        continueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), BuyerHomeScreen.class));
            }
        });

        return v;
    }
}