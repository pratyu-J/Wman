package com.Neuralsift.Sesvo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Neuralsift.Sesvo.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryRecyclerAdapter extends RecyclerView.Adapter<StoryRecyclerAdapter.ItemHolder> {

    Context context;
    ArrayList<String> prof_pics;

    public StoryRecyclerAdapter(Context context, ArrayList<String> prof_pics) {
        this.context = context;
        this.prof_pics = prof_pics;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_recycler_layout, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
       // String item = prof_pics.get(position);

/*        if(position==0){
            holder.storyTile.setImageResource(R.drawable.prof_pic);
            holder.add.setVisibility(View.VISIBLE);
        }*/
        //Glide.with(context).load(item).into(holder.storyTile);
    }

    @Override
    public int getItemCount() {
        return 9; //replace with prof_pic.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        CircleImageView storyTile;
        ImageView add;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            storyTile = itemView.findViewById(R.id.story_tile);
            add = itemView.findViewById(R.id.add_btn);
        }
    }
}
