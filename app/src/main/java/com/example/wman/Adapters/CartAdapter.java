package com.example.wman.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.wman.Activities.ItemDescriptionScreen;
import com.example.wman.Classes.BuyerProductsClass;
import com.example.wman.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ItemHolder> {

    ArrayList<BuyerProductsClass> cartList = new ArrayList<>();
    Context context;

    public CartAdapter(ArrayList<BuyerProductsClass> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_recycler_layout, parent, false);
        CartAdapter.ItemHolder ih = new CartAdapter.ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        BuyerProductsClass item = cartList.get(position);

        try{
            holder.name.setText(item.getName());
            holder.price.setText("Rs. " + item.getPrice());

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
        return cartList.size();
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
