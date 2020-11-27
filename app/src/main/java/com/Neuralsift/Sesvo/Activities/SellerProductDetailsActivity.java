package com.Neuralsift.Sesvo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.asura.library.views.PosterSlider;
import com.Neuralsift.Sesvo.R;

public class SellerProductDetailsActivity extends AppCompatActivity {

    Button upload, getApproval;
    ImageView backBtn;
    ImageButton addImage;
    EditText productDescription;
    PosterSlider posterSlider;
    Spinner categorySpinner;

    String[] categories = {"Select Category","Home Decor", "Clothes", "Footwear", "Watches"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_product_details);

        posterSlider = findViewById(R.id.poster_slider);
        backBtn = findViewById(R.id.back_btn);
        upload = findViewById(R.id.upload_image);
        getApproval = findViewById(R.id.get_approval);
        addImage = findViewById(R.id.add_img_btn);
        productDescription = findViewById(R.id.product_details);
        categorySpinner = findViewById(R.id.category_spinner);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);

        adapter.setDropDownViewResource(android.R.layout.activity_list_item);

        categorySpinner.setAdapter(adapter);



        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String category = adapterView.getItemAtPosition(i).toString();

                if(i>0){
                    Toast.makeText(SellerProductDetailsActivity.this, "selected: "+category, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}