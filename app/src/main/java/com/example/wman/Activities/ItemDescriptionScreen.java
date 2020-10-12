package com.example.wman.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wman.Classes.BuyerProductsClass;
import com.example.wman.R;

import static com.example.wman.Activities.MyCartActivity.cartItems;

public class ItemDescriptionScreen extends AppCompatActivity {

    ImageView imageView, backBtn, cartBtn;
    TextView productName, productPrice, description;
    RatingBar ratingBar;
    Button addToCart;
    Spinner qty;
    String name, image, price;
   String[] quantity = {"Select Quantity","1","2","3","4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description_screen);

        backBtn = findViewById(R.id.back_btn);
        imageView = findViewById(R.id.item_display);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        description = findViewById(R.id.product_description);
        addToCart = findViewById(R.id.to_cart);
        ratingBar = findViewById(R.id.rating);
        cartBtn = findViewById(R.id.cart_btn);


        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ItemDescriptionScreen.this, MyCartActivity.class));
            }
        });

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        try{
            image = intent.getStringExtra("image");
        }catch (Exception ex){
            image = "";

        }

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cartItems.add(new BuyerProductsClass(image, name, price ));
                MyCartActivity.total+= Float.parseFloat(price);
                Toast.makeText(ItemDescriptionScreen.this, "Added to cart", Toast.LENGTH_LONG).show();

            }
        });

        float rating = ratingBar.getRating();
        qty = findViewById(R.id.qty);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,quantity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qty.setAdapter(adapter);

        qty.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String number = adapterView.getItemAtPosition(i).toString();

                if(i>0){
                    Toast.makeText(ItemDescriptionScreen.this, "selected: "+number, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}