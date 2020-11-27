package com.Neuralsift.Sesvo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Neuralsift.Sesvo.Classes.BuyerProductsClass;
import com.Neuralsift.Sesvo.R;

import java.util.ArrayList;

public class BuyerHomeAdapter extends RecyclerView.Adapter<BuyerHomeAdapter.ItemHolder> {

    ArrayList<BuyerProductsClass> homeItems;
    Context context;

    public BuyerHomeAdapter (Context context, ArrayList<BuyerProductsClass> homeItems){
        this.context = context;
        this.homeItems = homeItems;
    }
    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.buyer_home_rec_layout, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        BuyerProductsClass saved = homeItems.get(position);

        try{
            holder.name.setText(saved.getName());
            //holder.price.setText("Rs." + saved.getPrice());
            ///Glide.with(context).load(saved.getImage()).into(holder.imageView);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cat_image);
            name =  itemView.findViewById(R.id.cat_name);
            price = itemView.findViewById(R.id.cat_price);
        }
    }
}
