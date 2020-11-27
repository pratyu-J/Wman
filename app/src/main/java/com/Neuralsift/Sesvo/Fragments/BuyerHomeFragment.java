package com.Neuralsift.Sesvo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.Neuralsift.Sesvo.Adapters.BuyerHomeAdapter;
import com.Neuralsift.Sesvo.Adapters.StoryRecyclerAdapter;
import com.Neuralsift.Sesvo.Classes.BuyerProductsClass;
import com.Neuralsift.Sesvo.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

import static com.Neuralsift.Sesvo.Activities.BuyerHomeScreen.pageTitle;
import static com.Neuralsift.Sesvo.Activities.BuyerHomeScreen.searchView;


public class BuyerHomeFragment extends Fragment {

    TextView seeAll1, seeAll2;
    RecyclerView newRecycler, existingRecycler, storyRecycler;
    StoryRecyclerAdapter storyAdapter;
    ArrayList<String> stories = new ArrayList<>();
    ArrayList<BuyerProductsClass> newCategories = new ArrayList<>();
    ArrayList<BuyerProductsClass> existingCategories = new ArrayList<>();
    CarouselView carouselView;
    String [] urls = {"https://image.freepik.com/free-vector/empty-shelf-illustration_1284-9525.jpg", "https://image.freepik.com/free-vector/abstract-wavy-indian-flag-banner_1055-7052.jpg","https://image.freepik.com/free-vector/abstract-blue-watercolor-banner_1055-7223.jpg"};

    public BuyerHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_buyer_home, container, false);
        searchView.setVisibility(View.GONE);

        storyRecycler = v.findViewById(R.id.story_recycler);
        storyRecycler.setHasFixedSize(true);
        storyAdapter = new StoryRecyclerAdapter(getContext(), stories);
        storyRecycler.setAdapter(storyAdapter);
        carouselView = (CarouselView) v.findViewById(R.id.banner);
        carouselView.setPageCount(urls.length);

        carouselView.setImageListener(imageListener);
        seeAll1 = v.findViewById(R.id.see_all_1);
        seeAll2 = v.findViewById(R.id.see_all_2);
        newRecycler = v.findViewById(R.id.new_cat_recycler);
        existingRecycler = v.findViewById(R.id.existing_cat_recycler);
        newRecycler.setHasFixedSize(true);
        existingRecycler.setHasFixedSize(true);
        pageTitle.setText("Home");
        fillData();
        BuyerHomeAdapter adapterNew = new BuyerHomeAdapter(getContext(), newCategories);
        newRecycler.setAdapter(adapterNew);
        BuyerHomeAdapter adapterExisting = new BuyerHomeAdapter(getContext(), existingCategories);
        existingRecycler.setAdapter(adapterExisting);
        return v;
    }

    public void fillData(){
        newCategories.add(new BuyerProductsClass("", "Home Decor", " "));
        newCategories.add(new BuyerProductsClass("", "Electronics", " "));
        newCategories.add(new BuyerProductsClass("", "Mobile", " "));
        newCategories.add(new BuyerProductsClass("", "Plastics", " "));

        existingCategories.add(new BuyerProductsClass("", "Furniture", " "));
        existingCategories.add(new BuyerProductsClass("", "Clothes", " "));
        existingCategories.add(new BuyerProductsClass("", "Footwear", " "));
        existingCategories.add(new BuyerProductsClass("", "Tools", " "));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            //imageView.setImageResource(urls[position]);
            Glide.with(getContext()).load(urls[position]).into(imageView);
        }
    };
}