package com.example.appdevproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class secondAnime extends AppCompatActivity {


    private Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_anime);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent intent=new Intent(getApplicationContext(),GetStartActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }

}