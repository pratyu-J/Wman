package com.Neuralsift.Sesvo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Neuralsift.Sesvo.R;


public class Checkout1 extends Fragment {

    Button next;
    public static int amount=0;
    EditText user, address, city, state, zip;
    String USER, ADDRESS,CITY, STATE, ZIP;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v = inflater.inflate(R.layout.fragment_checkout1, container, false);

        user = v.findViewById(R.id.shipping_username);
        address = v.findViewById(R.id.shipping_address);
        city = v.findViewById(R.id.shipping_city);
        state = v.findViewById(R.id.shipping_state);
        zip = v.findViewById(R.id.shipping_zip);
        next = v.findViewById(R.id.next2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container, new Checkout2()).addToBackStack(null).commit();

                }
            }
        });


        return v;
    }

    public boolean validate(){

        USER = user.getText().toString();
        ADDRESS = address.getText().toString();
        CITY = city.getText().toString();
        STATE = state.getText().toString();
        ZIP = zip.getText().toString();

        if(USER.isEmpty() || ADDRESS.isEmpty() || CITY.isEmpty() || STATE.isEmpty() || ZIP.isEmpty()){
            Toast.makeText(getContext(), "Enter All Details", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}