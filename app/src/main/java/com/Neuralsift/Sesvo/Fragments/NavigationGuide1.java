package com.Neuralsift.Sesvo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Neuralsift.Sesvo.R;

public class NavigationGuide1 extends Fragment {

  ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =   inflater.inflate(R.layout.fragment_navigation_guide1, container, false);

        TextView next = v.findViewById(R.id.next);
        viewPager = getActivity().findViewById(R.id.viewpager);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
            }
        });
        return v;
    }
}