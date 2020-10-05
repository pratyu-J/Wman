package com.example.wman.Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wman.Adapters.SellerHomeTopAdapter;
import com.example.wman.Adapters.StoryRecyclerAdapter;
import com.example.wman.Classes.CategoryClass;
import com.example.wman.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import static com.example.wman.Activities.SellerHomeScreen.screenTitle;



public class SellerHomeFragment extends Fragment {

  RecyclerView newRecycler, existingRecycler, storyRecycler;
  ArrayList<CategoryClass> list = new ArrayList<>();
  ArrayList<String> stories = new ArrayList<>();
  StoryRecyclerAdapter storyAdapter;
    //ArrayList<Drawable> bannerArrayList = new ArrayList<>();
    String [] urls = {"https://image.freepik.com/free-vector/empty-shelf-illustration_1284-9525.jpg", "https://image.freepik.com/free-vector/abstract-wavy-indian-flag-banner_1055-7052.jpg","https://image.freepik.com/free-vector/abstract-blue-watercolor-banner_1055-7223.jpg"};
  CarouselView carouselView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_seller_home, container, false);

        screenTitle.setText("Home");
        storyRecycler = v.findViewById(R.id.story_recycler);
        newRecycler = v.findViewById(R.id.new_cat_recycler);
        existingRecycler = v.findViewById(R.id.existing_cat_recycler);
        newRecycler.setHasFixedSize(true);
        storyRecycler.setVisibility(View.VISIBLE);

        storyRecycler.setHasFixedSize(true);
        storyAdapter = new StoryRecyclerAdapter(getContext(), stories);
        storyRecycler.setAdapter(storyAdapter);
        fillData();

        carouselView = v.findViewById(R.id.banner);
        carouselView.setPageCount(urls.length);
        carouselView.setImageListener(imageListener);
        existingRecycler.setHasFixedSize(true);
        SellerHomeTopAdapter adapter = new SellerHomeTopAdapter(list, getContext());
        newRecycler.setAdapter(adapter);
        existingRecycler.setAdapter(adapter);

        return v;
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            Glide.with(getContext()).load(urls[position]).into(imageView);

        }
    };

    public void fillData(){

        list.add(new CategoryClass("", "Curtains"));
        list.add(new CategoryClass("", "Clothes"));
        list.add(new CategoryClass("", "Sofas"));


    }
}