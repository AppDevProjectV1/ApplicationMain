package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class GetStartActivity extends AppCompatActivity {


    private Button getStarted;
    private TextView signin;
    private TextView regGuide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        ScrollView parent  =findViewById(R.id.f);
        AnimationDrawable gradientAnimator = (AnimationDrawable) parent.getBackground();
        gradientAnimator.setEnterFadeDuration(500);
        gradientAnimator.setExitFadeDuration(500);
        gradientAnimator.start();

        getStarted=findViewById(R.id.getstarted);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
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
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
            StudentReg studentReg=new StudentReg();
             CareerInterest careerInterest=new CareerInterest();
        if (FirebaseAuth.getInstance().getCurrentUser() != null && studentReg.getB()==1 && careerInterest.getC()==1) {
            Intent intent = new Intent(this,StudentReg.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
        else if (FirebaseAuth.getInstance().getCurrentUser() != null && studentReg.getB()>1 && careerInterest.getC()==1) {
            Intent intent = new Intent(this,CareerInterest.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
        else if (FirebaseAuth.getInstance().getCurrentUser() != null && studentReg.getB()>1 && careerInterest.getC()>1) {
            Intent intent = new Intent(this,StudentProfile.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }
}