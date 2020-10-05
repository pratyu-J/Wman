package com.example.wman.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wman.R;
import com.google.gson.internal.$Gson$Preconditions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.wman.Fragments.GalleryFragment.galleryImage;
import static com.example.wman.Fragments.GalleryFragment.selectedImage;


public class ImageGridAdapter extends RecyclerView.Adapter<ImageGridAdapter.ItemHolder> {

    Context context;
    ArrayList<String> pics;

    public ImageGridAdapter(Context context, ArrayList<String> pics) {
        this.context = context;
        this.pics = pics;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridview_layout, parent, false);
        ItemHolder ih = new ItemHolder(v);
        return ih;
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemHolder holder, int position) {

        final String image = pics.get(position);

        Glide.with(context).load(image).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(context).load(image).into(galleryImage);
                selectedImage = image;
            }
        });
    }

    @Override
    public int getItemCount() {
        return pics.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.grid_image);

        }
    }



    /*public ImageGridAdapter(@NonNull Context context, int resource, ArrayList<String> pics) {
        super(context, resource);

        this.context = context;
        this.pics = pics;
        Log.d("Directory Chosen:" ," inside adapter0");
    }


    public static class ViewHolder{
        ImageView img;
    }

    @NonNull
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.d("Directory Chosen:" ," inside adapter");
        final ViewHolder holder;
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            holder = new ViewHolder();
            holder.img = (ImageView)view.findViewById(R.id.grid_image);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder)view.getTag();
        }

        String imgUrl = (String) getItem(i);

        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage("file:/" + imgUrl, holder.img, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                Log.d("GridAdapterSt", imageUri);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                Log.d("GridAdapterCm", imageUri);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        return view;
    }*/
}
