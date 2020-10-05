package com.example.wman.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wman.R;

import java.util.ArrayList;

public class PostsInProfile extends RecyclerView.Adapter<PostsInProfile.ItemHolder> {

    Context context;
    ArrayList<String> posts ;

    public PostsInProfile(Context context, ArrayList<String> posts) {
        this.context = context;
        this.posts = posts;
    }


    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_recycler_grid, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

/*        String item = posts.get(position);
        Glide.with(context).load(item).into(holder.post);*/
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView post;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            post = itemView.findViewById(R.id.posts);
        }
    }
}
