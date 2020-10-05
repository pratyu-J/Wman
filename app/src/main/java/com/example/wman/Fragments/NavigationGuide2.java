package com.example.wman.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wman.Activities.CreateAccount;
import com.example.wman.Activities.LoginActivity;
import com.example.wman.R;


public class NavigationGuide2 extends Fragment {


    public NavigationGuide2() {
        // Required empty public constructor
    }

        TextView textView;
    ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_navigation_guide2, container, false);

        TextView next = v.findViewById(R.id.next);
        viewPager = getActivity().findViewById(R.id.viewpager);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });

        return v;
    }
}