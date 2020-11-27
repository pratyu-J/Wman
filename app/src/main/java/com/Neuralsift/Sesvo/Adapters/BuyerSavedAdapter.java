package com.Neuralsift.Sesvo.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Neuralsift.Sesvo.Activities.ItemDescriptionScreen;
import com.Neuralsift.Sesvo.Classes.BuyerProductsClass;
import com.Neuralsift.Sesvo.R;

import java.util.ArrayList;

public class BuyerSavedAdapter extends RecyclerView.Adapter<BuyerSavedAdapter.ItemHolder> {

    ArrayList<BuyerProductsClass> savedItems = new ArrayList<>();
    Context context;
    public BuyerSavedAdapter(Context context, ArrayList<BuyerProductsClass> savedItems){
        this.context = context;
        this.savedItems = savedItems;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_recycler_layout, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        BuyerProductsClass saved = savedItems.get(position);

        try{
            holder.name.setText(saved.getName());
            holder.price.setText("Rs. " + saved.getPrice());
            //Glide.with(context).load(saved.getImage()).into(holder.imageView);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ItemDescriptionScreen.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return savedItems.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.saved_item_image);
            name =  itemView.findViewById(R.id.saved_item_name);
            price = itemView.findViewById(R.id.saved_item_Price);
        }
    }
}
