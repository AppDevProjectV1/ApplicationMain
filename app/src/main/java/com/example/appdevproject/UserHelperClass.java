package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import java.net.URI;

public class UserHelperClass {

    String musername,memail,mMobilenumber,year,dept;
    String mimageuri;

    public UserHelperClass( ){}


    public UserHelperClass(String username,String mobilenumber,String email,String Studentyear,String StudentDepartment,String imageuri) {
        this.musername = username;
        this.memail = email;
        this.mMobilenumber=mobilenumber;
        this.year=Studentyear;
        this.dept=StudentDepartment;
        this.mimageuri=imageuri;
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

    public  String getImageUri() {
        return mimageuri;
    }

    public  void  setUsername(String username) {
        this.musername = username;
    }

    public  void  setMimageuri(String imageuri) {
        this.mimageuri=imageuri;
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
}