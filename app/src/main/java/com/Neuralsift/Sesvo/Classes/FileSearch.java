package com.Neuralsift.Sesvo.Classes;

import android.util.Log;

import java.io.File;
import java.util.ArrayList;

public class FileSearch {

    // returns list of all **directories** contained in the directory
    public static ArrayList<String> getDirectoryPath(String directory){

        ArrayList<String> pathArray = new ArrayList<>();

        File file = new File(directory);
        File[] listFiles = file.listFiles();

        Log.d("dirSearch", file.exists()+"");
        Log.d("dirSearch", file.isDirectory()+"");
        Log.d("dirSearch", file.canRead()+"");

            if(listFiles !=null){

                for(int i=0; i<listFiles.length; i++){
                    if(listFiles[i].isDirectory()){
                        pathArray.add(listFiles[i].getAbsolutePath());

                    }
                }
            }else {
                Log.d("DirectorySearch: ", "null");
            }


        return pathArray;
    }


    // returns list of all **files** contained in the directory
    public static ArrayList<String> getFilePaths(String directory){

        ArrayList<String> pathArray = new ArrayList<>();
        File file = new File(directory);
        File[] listFiles = file.listFiles();

        Log.d("FileSerach", file.exists()+"");
        Log.d("FileSerach", file.isDirectory()+"");
        Log.d("FileSerach", file.canRead()+"");
        if(listFiles != null){

            for(int i=0; i<listFiles.length; i++){
                if(listFiles[i].isFile()){
                    pathArray.add(listFiles[i].getAbsolutePath());
                }
            }
        }
        else {
            Log.d("FileSearch: ", "null");
        }

        return pathArray;
    }
}
