package com.example.wman.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wman.Activities.SellerProductDetailsActivity;
import com.example.wman.Classes.SellerCategoryClass;
import com.example.wman.R;

import java.util.ArrayList;

public class SellerCategoryAdapter extends RecyclerView.Adapter<SellerCategoryAdapter.ItemHolder> {
    ArrayList<SellerCategoryClass> items;
    Context context;

    public SellerCategoryAdapter(ArrayList<SellerCategoryClass> items, Context context){
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_layout,parent,false);
        ItemHolder ih = new ItemHolder(view);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        SellerCategoryClass currItem = items.get(position);

        holder.itemTypeName.setText(currItem.getCategoryName());
        //Glide.with(context).load(currItem.getImg()).into(holder.imageView);

        holder.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(new Intent(context, SellerProductDetailsActivity.class)));

            }
        });
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public void filterList(ArrayList<SellerCategoryClass> filteredList){
        items = filteredList;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView itemTypeName;
        Button register;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            itemTypeName = itemView.findViewById(R.id.category_name);
            imageView = itemView.findViewById(R.id.category_image);
            register = itemView.findViewById(R.id.category_register);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    context.startActivity(new Intent(new Intent(context, SellerProductDetailsActivity.class)));

                }
            });
        }
    }
}
