package com.example.appdevproject;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentFeeds extends AppCompatActivity {

    private TextView profiletab,feedstab,inboxtab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feeds);

        profiletab=findViewById(R.id.profiletab);
        feedstab=findViewById(R.id.feedstab);
        inboxtab=findViewById(R.id.inboxtab);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            feedstab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_info_tile) );
            profiletab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
            inboxtab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
        }

     profiletab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
             startActivity(intent);
             finish();
         }
     });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
        startActivity(intent);
    }
}