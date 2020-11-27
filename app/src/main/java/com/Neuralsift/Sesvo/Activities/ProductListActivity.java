package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.Neuralsift.Sesvo.Adapters.ProductListAdapter;
import com.Neuralsift.Sesvo.Classes.BuyerProductsClass;
import com.Neuralsift.Sesvo.R;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    ImageView backBtn, cart;
    RecyclerView productList;
    TextView categoryTitle;
    SearchView searchView;
    ProductListAdapter adapter;
    ArrayList<BuyerProductsClass> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        categoryTitle = findViewById(R.id.category_title);
        categoryTitle.setText(title);
        backBtn = findViewById(R.id.back_btn);
        cart = findViewById(R.id.cart_btn);
        searchView = findViewById(R.id.search);
        productList = findViewById(R.id.product_list_grid);
        productList.setHasFixedSize(true);
        fillData();
        adapter = new ProductListAdapter(this, products);
        productList.setAdapter(adapter);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProductListActivity.this, MyCartActivity.class));
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return false;
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void filter(String newText) {

        ArrayList<BuyerProductsClass> filteredList = new ArrayList<>();

        for(BuyerProductsClass item: products){

            if(item.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    public void fillData() {
        products.add(new BuyerProductsClass("", "Pink chair", "2000"));
        products.add(new BuyerProductsClass("", "Screw Driver", "200"));
        products.add(new BuyerProductsClass("", "T-shirt", "1000"));
        products.add(new BuyerProductsClass("", "Gloves", "500"));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}