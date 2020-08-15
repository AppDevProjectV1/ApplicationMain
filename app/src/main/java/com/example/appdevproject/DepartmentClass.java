package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DepartmentClass {
    private String mCountryName;
    private int mFlagImage;
    public  DepartmentClass(String countryName, int flagImage) {
        mCountryName = countryName;
        mFlagImage = flagImage;
    }
    public String getCountryName() {
        return mCountryName;
    }
    public int getFlagImage() {
        return mFlagImage;
    }
}