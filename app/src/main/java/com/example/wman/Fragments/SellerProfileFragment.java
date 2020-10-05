package com.example.wman.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wman.Adapters.TabAdapter;
import com.example.wman.R;
import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.wman.Activities.SellerHomeScreen.screenTitle;


public class SellerProfileFragment extends Fragment {

    CircleImageView profileImage;
    TextView products, followers, following ,username, address;
    TabLayout tabLayout;
    ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_grid_on,
            R.drawable.ic_tag
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_seller_profile, container, false);

        screenTitle.setText("Your Profile");
        profileImage = v.findViewById(R.id.profile_image);
        products = v.findViewById(R.id.products_no);
        followers = v.findViewById(R.id.follower_no);
        following = v.findViewById(R.id.following_no);
        username = v.findViewById(R.id.username);
        address = v.findViewById(R.id.user_address);

        tabLayout = v.findViewById(R.id.tabLayout);
        viewPager = v.findViewById(R.id.viewpager);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        setHasOptionsMenu(true);
        return v;
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);

    }

    public void setUpViewPager(ViewPager viewPager){
        TabAdapter adapter = new TabAdapter(getChildFragmentManager());
        adapter.addFragment(new PostedPosts(), "");
        adapter.addFragment(new TaggedPosts(), "");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.profile_menu_options, menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.archive:
                Toast.makeText(getContext(), "Archive", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help:
                Toast.makeText(getContext(), "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                Toast.makeText(getContext(), "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout:
                Toast.makeText(getContext(), "Logout", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);



    }
}