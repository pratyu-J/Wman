package com.example.wman.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wman.Adapters.PostsInProfile;
import com.example.wman.R;

import java.util.ArrayList;

public class TaggedPosts extends Fragment {

    RecyclerView posts;
    PostsInProfile adapter;
    ArrayList<String> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_tagged_posts, container, false);
        posts = v.findViewById(R.id.tagged_post);
        posts.setHasFixedSize(true);
        adapter = new PostsInProfile(getContext(),list);
        posts.setAdapter(adapter);

        return v;
    }
}