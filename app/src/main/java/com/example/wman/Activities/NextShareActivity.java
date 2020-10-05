package com.example.wman.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wman.R;

public class NextShareActivity extends AppCompatActivity {

    private final String TAG = "NextShareActivity";

    ImageView shareImage;
    EditText description, sharePrice;
    TextView tagPeople, addLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_share);

        Intent intent = getIntent();
        String img = intent.getStringExtra("image");
        Log.d(TAG, img);

        shareImage =  findViewById(R.id.share_image);
        description = findViewById(R.id.caption);
        sharePrice = findViewById(R.id.share_price);
        tagPeople = findViewById(R.id.tag_people);
        addLocation = findViewById(R.id.add_location);

        Glide.with(this).load(img).into(shareImage);

    }
}