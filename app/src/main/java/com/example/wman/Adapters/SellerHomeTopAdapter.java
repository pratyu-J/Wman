package com.example.wman.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wman.Classes.CategoryClass;
import com.example.wman.R;

import java.util.ArrayList;

public class SellerHomeTopAdapter extends RecyclerView.Adapter<SellerHomeTopAdapter.ItemHolder> {
    ArrayList<CategoryClass> catList = new ArrayList<>();
    Context context;
    public SellerHomeTopAdapter(ArrayList<CategoryClass> catList, Context context){
        this.catList = catList;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_home_rec_layout, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        CategoryClass categoryClass = catList.get(position);

        holder.name.setText(categoryClass.getCategoryName());
        //Glide.with(context).load(categoryClass.getImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cat_image);
            name = itemView.findViewById(R.id.cat_name);

        }
    }
}
