package com.example.wman.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.wman.Adapters.SellerCategoryAdapter;
import com.example.wman.Classes.SellerCategoryClass;
import com.example.wman.R;

import java.util.ArrayList;

import static com.example.wman.Activities.SellerHomeScreen.screenTitle;


public class SellerCategoryFragment extends Fragment {


    SearchView searchView;
    RecyclerView recyclerView;
    SellerCategoryAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    ArrayList<SellerCategoryClass> sellCategoryList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_seller_category, container, false);

        screenTitle.setText("Categories");
        searchView = v.findViewById(R.id.search);
        recyclerView = v.findViewById(R.id.item_type);
        recyclerView.setHasFixedSize(true);

        fillData();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });


        adapter = new SellerCategoryAdapter(sellCategoryList, getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }

    private void filter(String newText) {
        ArrayList<SellerCategoryClass> filteredList = new ArrayList<>();
        for(SellerCategoryClass item: sellCategoryList){
            if(item.getCategoryName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    public void fillData(){

        sellCategoryList.add(new SellerCategoryClass("", "Home Decor"));
        sellCategoryList.add(new SellerCategoryClass("", "Watches"));
        sellCategoryList.add(new SellerCategoryClass("", "Curtains"));
    }
}