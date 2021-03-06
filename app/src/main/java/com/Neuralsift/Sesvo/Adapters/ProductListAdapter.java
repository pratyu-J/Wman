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

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ItemHolder> {

    Context context;
    ArrayList<BuyerProductsClass> productList;

    public ProductListAdapter(Context context, ArrayList<BuyerProductsClass> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_grid_layout, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        final BuyerProductsClass product = productList.get(position);
        try{
            holder.name.setText(product.getName());
            holder.price.setText("Rs. " +product.getPrice());
           // Glide.with(context).load(product.getImage()).into(holder.imageView);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDescriptionScreen.class);
                intent.putExtra("name", product.getName());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("image", product.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void filterList(ArrayList<BuyerProductsClass> filteredList){
        productList = filteredList;
        notifyDataSetChanged();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, price;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.product_image);
            name = itemView.findViewById(R.id.product_name);
            price = itemView.findViewById(R.id.product_price);
        }
    }
}
