package com.example.wman.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.wman.Activities.LoginActivity;
import com.example.wman.R;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class CreateAccountBuyer extends Fragment {


    EditText name, email, pass;
    Button signup ;
    String otp="";
    final String TAG = "CreateAccountBuyer";
    TextView toLogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_create_account_buyer, container, false);
        name = v.findViewById(R.id.user_name);
        email = v.findViewById(R.id.user_email);
        pass = v.findViewById(R.id.user_pass);
        toLogin = v.findViewById(R.id.go_to_Login);
        signup = v.findViewById(R.id.Signup);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

/*                AppPreferences.savePreferences(getContext(), "logged_in", "1");
                AppPreferences.savePreferences(getContext(), "user_mode", "buyer");
                Intent intent = new Intent(getContext(), BuyOrSellTab.class);
                startActivity(intent);*/
                signUp();

            }
        });

        toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        return v;
    }

    public void signUp(){

        Ion.with(getContext()).load("https://neuralsiftappapi.herokuapp.com/signup").setBodyParameter("name", name.getText().toString())
                .setBodyParameter("gender", "male")
                .setBodyParameter("dob", "2020-12-11")
                .setBodyParameter("email", email.getText().toString())
                .setBodyParameter("number", "686858558")
                .setBodyParameter("password", pass.getText().toString())
                .setBodyParameter("userType", "Buyer")
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                try{
                    Log.d(TAG, result);
                    //OTPDialog() ;
                }catch (Exception ex){
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }

}