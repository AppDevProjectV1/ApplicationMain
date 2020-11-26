package com.campuscompass.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class  CanteenClass {
    private int mimagecanteen;
    private String mnamecanteen;

    public CanteenClass(String canteen,int canteenicon) {

        mimagecanteen=canteenicon;
        mnamecanteen=canteen;
    }



    public int getMimagecanteen() {
        return mimagecanteen;
    }

    public String getMnamecanteen() {
        return  mnamecanteen;
    }

}