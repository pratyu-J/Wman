package com.Neuralsift.Sesvo.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Neuralsift.Sesvo.Adapters.PostsInProfile;
import com.Neuralsift.Sesvo.R;

import java.util.ArrayList;

public class PostedPosts extends Fragment {

    RecyclerView posts;
    PostsInProfile adapter;
    ArrayList<String> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_posted_posts, container, false);
        posts = v.findViewById(R.id.posts_posted);
        posts.setHasFixedSize(true);
        adapter = new PostsInProfile(getContext(),list);
        posts.setAdapter(adapter);


        return v;
    }
}