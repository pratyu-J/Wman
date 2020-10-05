package com.example.wman.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wman.Activities.ProductListActivity;
import com.example.wman.Classes.BuyerProductsClass;
import com.example.wman.Classes.CategoryClass;
import com.example.wman.R;

import java.util.ArrayList;

public class BuyerCategoryAdapter extends RecyclerView.Adapter<BuyerCategoryAdapter.ItemHolder> {

    ArrayList<CategoryClass> buyerCategory ;
    Context context;

    public BuyerCategoryAdapter(Context context, ArrayList<CategoryClass> buyerCategory){
        this.buyerCategory = buyerCategory;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.buyer_category_layout, parent, false);
        BuyerCategoryAdapter.ItemHolder ih = new BuyerCategoryAdapter.ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

         final CategoryClass item = buyerCategory.get(position);

         holder.name.setText(item.getCategoryName());
        //Glide.with(context).load(item.getImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductListActivity.class);
                intent.putExtra("title", item.getCategoryName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return buyerCategory.size();
    }

    public void filterList(ArrayList<CategoryClass> filteredList){
        buyerCategory = filteredList;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, about;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.category_name);
            imageView = itemView.findViewById(R.id.category_image);
            about = itemView.findViewById(R.id.about_category);
        }
    }
}
