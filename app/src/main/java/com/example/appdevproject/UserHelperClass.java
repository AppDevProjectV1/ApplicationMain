package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import java.net.URI;
import java.util.Map;

public class UserHelperClass {

    String musername,memail,machievements,mgroups,mskills,mMobilenumber,year,dept,mbahawan,imageurl;



  UserHelperClass(){}





    public UserHelperClass(String name, String isMobile, String email, String achievements, String groups, String skills, String studentyear, String studentDepartment,String bhawan, String data) {
        this.musername = name;
        this.memail = email;
        this.mMobilenumber=isMobile;
        this.year=studentyear;
        this.dept=studentDepartment;
        this.imageurl=data;
        this.machievements=achievements;
        this.mgroups=groups;
        this.mskills=skills;
        this.mbahawan=bhawan;
    }



    public String getMobilenumber() {
        return mMobilenumber;
    }

    public String getYear() {
        return year;
    }

    public String getDept() {
        return dept;
    }
    public String getUsername() {
        return musername;
    }



    public String getEmail() {
        return memail;
    }

    public String getImageUrl() {
        return imageurl;
    }
public String getMbahawan(){
      return mbahawan;
}
    public String getMachievements() {
        return machievements;
    }

    public String getMgroups() {
        return mgroups;
    }
    public String getMskills() {
        return  mskills;
    }
    public  void  setUsername(String username) {
        this.musername = username;
    }

    public  void setImageUrl( String data) {
        this.imageurl=data;
    }

    public  void setEmail(String email ) {
        this.memail = email;
    }
    public  void  setMobilenumber(String Mobilenumber) {
        this.mMobilenumber = Mobilenumber;
    }
    public  void setYear(String Studentyear ) {
        this.year =Studentyear ;
    }
    public  void setDept(String StudentDepartment ) {
        this.dept=StudentDepartment;
    }
    public  void setMachievements(String achievements) {
        this.machievements=achievements;

    }

    public void setMbahawan(String mbahawan) {
        this.mbahawan = mbahawan;
    }

    public void  setMgroups(String groups) {
this.mgroups=groups;
    }
    public void setMskills(String skills) {
this.mskills=skills;
    }
}