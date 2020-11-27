package com.Neuralsift.Sesvo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.Neuralsift.Sesvo.Adapters.BuyerCategoryAdapter;
import com.Neuralsift.Sesvo.Classes.CategoryClass;
import com.Neuralsift.Sesvo.R;

import java.util.ArrayList;

import static com.Neuralsift.Sesvo.Activities.BuyerHomeScreen.pageTitle;
import static com.Neuralsift.Sesvo.Activities.BuyerHomeScreen.searchView;

public class BuyerCategoryFragment extends Fragment {


    ArrayList<CategoryClass> categoryList = new ArrayList<>();
    RecyclerView recyclerView;
    BuyerCategoryAdapter adapter;
    public BuyerCategoryFragment() {
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
        View v = inflater.inflate(R.layout.fragment_buyer_category, container, false);
        searchView.setVisibility(View.VISIBLE);
        recyclerView = v.findViewById(R.id.category_type);
        recyclerView.setHasFixedSize(true);
        fillData();
        adapter = new BuyerCategoryAdapter(getContext(), categoryList);
        recyclerView.setAdapter(adapter);
        pageTitle.setText("Category");

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
        return v;
    }

    private void filter(String newText) {

        ArrayList<CategoryClass> filteredList = new ArrayList<>();

        for(CategoryClass item: categoryList){

            if(item.getCategoryName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    public void fillData(){
        categoryList.add(new CategoryClass("", "FootWear"));
        categoryList.add(new CategoryClass("", "Watches"));
        categoryList.add(new CategoryClass("", "Clothes"));
        categoryList.add(new CategoryClass("", "Curtains"));
    }
}