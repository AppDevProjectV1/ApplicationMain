package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InterestsClass  {
 String minterestname;
 String mbasictext;
 int mimageid1,mimageid2,mimageid3,mimageid4;
 String mlink1, mlink2, mlink3,mlink4;

 public InterestsClass(String interestname,String basictext,int imageid1, int imageid2 ,int imageid3,int imageid4,String link1,String link2,String link3,String link4){
     minterestname= interestname;
     mbasictext=basictext;
     mimageid1=imageid1;
     mimageid2=imageid2;
     mimageid3=imageid3;
     mimageid4=imageid4;
     mlink1=link1;
     mlink2=link2;
     mlink3=link3;
     mlink4=link4;
 }

    public String getMinterestname() {
        return minterestname;
    }

    public String getMbasictext() {
        return mbasictext;
    }

    public String getMlink1() {
        return mlink1;
    }

    public String getMlink2() {
        return mlink2;
    }

    public String getMlink3() {
        return mlink3;
    }

    public String getMlink4() {
        return mlink4;
    }

    public int getMimageid1() {
        return mimageid1;
    }

    public int getMimageid2() {
        return mimageid2;
    }

    public int getMimageid3() {
        return mimageid3;
    }

    public int getMimageid4() {
        return mimageid4;
    }
}