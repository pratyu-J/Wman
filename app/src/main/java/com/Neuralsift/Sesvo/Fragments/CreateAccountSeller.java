package com.Neuralsift.Sesvo.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Neuralsift.Sesvo.Activities.BuyerHomeScreen;
import com.Neuralsift.Sesvo.Activities.LoginActivity;
import com.Neuralsift.Sesvo.Activities.SellerHomeScreen;
import com.Neuralsift.Sesvo.Classes.AppPreferences;
import com.Neuralsift.Sesvo.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class CreateAccountSeller extends Fragment {

    EditText name, email, pass, phone;
    Button signup ;
    String otp="";
    final String TAG = "CreateAccountSeller";
    TextView toLogin;
    CheckBox showPass;
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_create_account_seller, container, false);



        name = v.findViewById(R.id.user_name_seller);
        email = v.findViewById(R.id.user_email_seller);
        pass = v.findViewById(R.id.user_pass_seller);
        toLogin = v.findViewById(R.id.go_to_Login_seller);
        signup = v.findViewById(R.id.Signup_seller);
        phone = v.findViewById(R.id.user_phone_seller);
        showPass = v.findViewById(R.id.showpass_seller);

        showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

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
                .setBodyParameter("number", phone.getText().toString())
                .setBodyParameter("password", pass.getText().toString())
                .setBodyParameter("userType", "seller")
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                try{
                    Log.d(TAG, result);
                    AppPreferences.savePreferences(getContext(), "user_mode", "seller");
                    OTPDialog() ;
                }catch (Exception ex){
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }

    private void OTPDialog() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View prompt =inflater.inflate(getResources().getLayout(R.layout.otp_dialog), null);
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getContext());
        builder.setView(prompt);
        final android.app.AlertDialog dialog1 =builder.create();
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        //declaration

        final EditText otp1, otp2, otp3, otp4 ;
        Button resend, next;
        resend = prompt.findViewById(R.id.resend);
        next = prompt.findViewById(R.id.next);
        otp1 = prompt.findViewById(R.id.otp1);
        otp2 = prompt.findViewById(R.id.otp2);
        otp3 = prompt.findViewById(R.id.otp3);
        otp4 = prompt.findViewById(R.id.otp4);


        otp1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL){
                    if(otp1.getText().toString().length() == 0){
                        otp1.setText("");
                    }
                }
                return false;
            }
        });

        otp2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL){
                    if(otp2.getText().toString().length() == 0){
                        otp2.setText("");
                    }
                }
                return false;
            }
        });

        otp3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL){
                    if(otp3.getText().toString().length() == 0){
                        otp3.setText("");
                    }
                }
                return false;
            }
        });

        otp4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL){
                    if(otp4.getText().toString().length() == 0){
                        otp4.setText("");
                    }
                }
                return false;
            }
        });

        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(otp1.getText().toString().length() == 1){
                    otp1.clearFocus();
                    otp2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(otp2.getText().toString().length() == 1){
                    otp2.clearFocus();
                    otp3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(otp3.getText().toString().length() == 1){
                    otp3.clearFocus();
                    otp4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(otp4.getText().toString().length() == 1){
                    otp4.clearFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                otp += otp1.getText().toString();
                otp +=otp2.getText().toString();
                otp +=otp3.getText().toString();
                otp +=otp4.getText().toString();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate otp

                //if valid
                AppPreferences.savePreferences(getContext(), "logged_in", "1");
                String mode = AppPreferences.loadPreferences(getContext(), "user_mode");
                if(mode=="buyer"){
                    startActivity(new Intent(getContext(), BuyerHomeScreen.class));
                }
                else{
                    startActivity(new Intent(getContext(), SellerHomeScreen.class));
                }
                dialog1.dismiss();
            }
        });

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //resend otp
                dialog1.dismiss();
            }
        });

        try {
            dialog1.show();
        }catch (Exception e){
            Log.d("exception", e.getMessage());
        }
    }



}