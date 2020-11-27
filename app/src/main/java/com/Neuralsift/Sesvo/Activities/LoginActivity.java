package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.Neuralsift.Sesvo.Classes.AppPreferences;
import com.Neuralsift.Sesvo.R;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class LoginActivity extends AppCompatActivity {

    EditText email, pass;
    Button login;
    TextView toSignup, forgotPass;
    CheckBox showPass;
    String otp;
    final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.user_email_login);
        pass = findViewById(R.id.user_pass_login);
        toSignup = findViewById(R.id.go_to_signup);
        login = findViewById(R.id.login);
        showPass = findViewById(R.id.showpass);
        forgotPass = findViewById(R.id.forgot);

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

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPassword();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppPreferences.savePreferences(LoginActivity.this, "logged_in", "1");
                //logIn();
                startActivity(new Intent(LoginActivity.this, SellerHomeScreen.class));

            }
        });

        toSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAccount.class));
            }
        });

    }

    public void forgotPassword(){

        LayoutInflater inflater = LayoutInflater.from(this);
        View prompt = inflater.inflate(R.layout.forgot_password_prompt,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(prompt);
        final AlertDialog dialog1 =  builder.create();
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        Button ok = prompt.findViewById(R.id.okay);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OTPDialog();
                dialog1.dismiss();
            }
        });
        try {
            dialog1.show();
        }catch (Exception e){
            Log.d("exception", e.getMessage());
        }
    }

    private void OTPDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View prompt =inflater.inflate(getResources().getLayout(R.layout.otp_dialog), null);
        final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setView(prompt);
        final android.app.AlertDialog dialog1 =builder.create();
        dialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        //declaraation

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
                AppPreferences.savePreferences(LoginActivity.this, "logged_in", "1");
                AppPreferences.savePreferences(LoginActivity.this, "user_mode", "buyer");
                String mode = AppPreferences.loadPreferences(LoginActivity.this, "user_mode");
                if(mode=="buyer"){
                    startActivity(new Intent(LoginActivity.this, BuyerHomeScreen.class));
                }
                else{
                    startActivity(new Intent(LoginActivity.this, SellerHomeScreen.class));
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


    public void logIn(){

        Ion.with(this).load("https://neuralsiftappapi.herokuapp.com/login")
                .setBodyParameter("email", email.getText().toString()).setBodyParameter("password", pass.getText().toString())
                .asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {
                try{
                    Log.d(TAG + "result", result);
                    String mode = AppPreferences.loadPreferences(LoginActivity.this, "user_mode");

                    if(mode=="buyer"){
                        startActivity(new Intent(LoginActivity.this, BuyerHomeScreen.class));
                    }
                    else{
                        startActivity(new Intent(LoginActivity.this, SellerHomeScreen.class));
                    }

                }catch (Exception ex){
                    Log.d(TAG + "exptn", e.getMessage());
                }
            }
        });
    }
}