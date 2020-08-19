package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ModelClass {
         private int mimage;
         private String mname;
         private String murl;
    public ModelClass(int image, String name,String url) {
        mimage=image;
        mname=name;
        murl=url;
    }

    public int getMimage() {
        return mimage;
    }

    public String getMname() {
        return mname;
    }
    public String getMurl() {
        return murl;
    }
}