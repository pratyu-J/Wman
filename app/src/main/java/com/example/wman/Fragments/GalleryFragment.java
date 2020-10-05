package com.example.wman.Fragments;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wman.Activities.NextShareActivity;
import com.example.wman.Adapters.ImageGridAdapter;
import com.example.wman.Classes.FilePaths;
import com.example.wman.Classes.FileSearch;
import com.example.wman.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private static final int NUM_GRID_COL = 3;
    private static final int MY_READ_PERMISSION_CODE = 101;

    RecyclerView gridView;
    Spinner directorySpinner;
    public static ImageView galleryImage;
    ImageView closeGal;
    ProgressBar progressBar;
    private final String TAG = "GALLERY FRAGMENT";

    private ArrayList<String> directories = new ArrayList<>();
    private ArrayList<String> files = new ArrayList<>();

    public static String selectedImage;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        gridView = v.findViewById(R.id.gridview);
        gridView.setHasFixedSize(true);
        directorySpinner = v.findViewById(R.id.spinner_directory);
        galleryImage = v.findViewById(R.id.galleryImg);
        progressBar = v.findViewById(R.id.progressbar1);
        progressBar.setVisibility(View.GONE);
        closeGal = v.findViewById(R.id.closegal);

        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_READ_PERMISSION_CODE);
        }
        else {
            loadImages();
        }

        closeGal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "closing gallery fragment");
                getActivity().finish();
            }
        });

        TextView next = v.findViewById(R.id.next_txt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), NextShareActivity.class);
                intent.putExtra("image", selectedImage);
                startActivity(intent);
            }
        });

        init();
        return v;
    }

    private void init(){

        //check for other folders inside "/storage/emulated/0/pictures"
        FilePaths filePaths = new FilePaths();

        if(FileSearch.getDirectoryPath(filePaths.PICTURES)!=null){

            directories = FileSearch.getDirectoryPath(filePaths.PICTURES);
        }

        ArrayList<String> directoryNames = new ArrayList<>();
        for(int i=0; i<directories.size(); i++){
            int index = directories.get(i).lastIndexOf("/");
            String substr = directories.get(i).substring(index+1);
            directoryNames.add(substr);
        }
        directories.add(filePaths.CAMERA);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, directoryNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        directorySpinner.setAdapter(adapter);

        directorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "on item selected:" + directories.get(i));

                //set up our image grid for the directory chosen
                setUpGridView(directories.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void setUpGridView(String selectedDirectory){

        Log.d(TAG, "Directory Chosen:" + selectedDirectory);

        final ArrayList<String> imgUrls = FileSearch.getFilePaths(selectedDirectory);

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_GRID_COL;


        Log.d(TAG, imageWidth + "");


        ImageGridAdapter adapter = new ImageGridAdapter(getContext(), imgUrls);
        gridView.setAdapter(adapter);

        selectedImage = imgUrls.get(0);
        Glide.with(getContext()).load(selectedImage).into(galleryImage);

        //grid adapter
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==MY_READ_PERMISSION_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getContext(), "Read Storage Permission Granted", Toast.LENGTH_SHORT).show();
                loadImages();
            }
        }else {
            Toast.makeText(getContext(), "Read Storage Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadImages(){
        init();
    }
}