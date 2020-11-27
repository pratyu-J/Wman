package com.Neuralsift.Sesvo.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.Neuralsift.Sesvo.Fragments.NavigationGuide1;
import com.Neuralsift.Sesvo.Fragments.NavigationGuide2;

public class OnBoardingAdapter extends FragmentPagerAdapter {

    public OnBoardingAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new NavigationGuide1();
            case 1: return new NavigationGuide2();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
