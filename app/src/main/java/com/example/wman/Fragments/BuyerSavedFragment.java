package com.example.wman.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wman.Adapters.BuyerSavedAdapter;
import com.example.wman.Classes.BuyerProductsClass;
import com.example.wman.R;

import java.util.ArrayList;

import static com.example.wman.Activities.BuyerHomeScreen.pageTitle;
import static com.example.wman.Activities.BuyerHomeScreen.searchView;

public class BuyerSavedFragment extends Fragment {

    ArrayList<BuyerProductsClass> savedList = new ArrayList<>();
    RecyclerView recyclerView;
    public BuyerSavedFragment() {
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
        View v = inflater.inflate(R.layout.fragment_buyer_saved, container, false);

        searchView.setVisibility(View.GONE);
        recyclerView = v.findViewById(R.id.saved_recycler);
        recyclerView.setHasFixedSize(true);
        fillData();
        BuyerSavedAdapter adapter = new BuyerSavedAdapter(getContext(), savedList);
        recyclerView.setAdapter(adapter);

        pageTitle.setText("Saved Items");
        return v;
    }

    public void fillData(){
        savedList.add(new BuyerProductsClass("", "Pink chair", "2000"));
        savedList.add(new BuyerProductsClass("", "Screw Driver", "200"));
        savedList.add(new BuyerProductsClass("", "T-shirt", "1000"));
        savedList.add(new BuyerProductsClass("", "Gloves", "500"));
    }
}