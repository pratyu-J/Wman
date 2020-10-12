package com.example.wman.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wman.Adapters.CartAdapter;
import com.example.wman.Classes.BuyerProductsClass;
import com.example.wman.R;

import java.util.ArrayList;

public class MyCartActivity extends AppCompatActivity {

    ImageButton backBtn;
    RecyclerView cartRecycler;
    Button next;
    TextView bill;
    CartAdapter adapter;
    public static float total=0;
    public static ArrayList<BuyerProductsClass> cartItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        backBtn = findViewById(R.id.back_btn);
        cartRecycler = findViewById(R.id.cart);
        cartRecycler.setHasFixedSize(true);
        next = findViewById(R.id.to_checkout);
        bill = findViewById(R.id.bill);

        adapter = new CartAdapter(cartItems, this);
        cartRecycler.setAdapter(adapter);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

        bill.setText(Float.toString(total));

    }
}