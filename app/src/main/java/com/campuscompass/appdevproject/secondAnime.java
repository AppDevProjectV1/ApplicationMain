package com.campuscompass.appdevproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdevproject.R;

import java.util.Timer;
import java.util.TimerTask;

public class secondAnime extends AppCompatActivity {


    private Timer timer;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String loggedin="loggedin";
    public static final String  Registered="registered";
    public boolean isLogged;
     public boolean isRegistered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_anime);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                if(isLogin()){
                    startActivity(new Intent(getApplicationContext(),StudentProfile.class));
                }
               else if(isRegister()){
                    startActivity(new Intent(getApplicationContext(),StudentProfile.class));
                }
               else{
                    Intent intent=new Intent(getApplicationContext(),GetStartActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },1500);


    }

    public boolean isRegister() {
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        isRegistered = sharedPreferences.getBoolean(Registered,false);
        if(isRegistered){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isLogin(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        isLogged=sharedPreferences.getBoolean(loggedin,false);


        if(isLogged){
            return true;
        }
        else{
            return false;
        }
    }

}