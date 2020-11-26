package com.campuscompass.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CampusVideoClass{

    String mvideocodelink;
    public CampusVideoClass(String videocodelink){
        mvideocodelink=videocodelink;
    }

    public String getMvideocodelink() {
        return mvideocodelink;
    }
}