package com.campuscompass.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.appdevproject.R;

public class GetStartActivity extends AppCompatActivity {
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String  GetStart="getstart";
    public static final String  Registered="registered";
    public boolean isGet;
    public boolean isRegistered;
    public  String isMobileno;
    private Button getStarted;
    private TextView signin;
    private TextView regGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        ScrollView parent  =findViewById(R.id.f);
//        AnimationDrawable gradientAnimator = (AnimationDrawable) parent.getBackground();
//        gradientAnimator.setEnterFadeDuration(500);
//        gradientAnimator.setExitFadeDuration(500);
//        gradientAnimator.start();

        getStarted=findViewById(R.id.getstarted);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (FirebaseAuth.getInstance().getCurrentUser() != null && isGetStart()) {
//
//                    Toast.makeText(GetStartActivity.this, "Already have an account please sign in", Toast.LENGTH_SHORT).show();
//
//                }
//               else{
                   Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                   startActivity(intent);
//               }
            }
        });

        regGuide=findViewById(R.id.regguidelink);
        regGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegGuide.class));
            }
        });



        signin=findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public boolean isGetStart() {
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        isGet = sharedPreferences.getBoolean(GetStart,false);
        if(isGet){
            return true;
        }
        else{
            return false;
        }
    }


}