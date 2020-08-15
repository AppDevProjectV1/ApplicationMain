package com.example.appdevproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AboutYou extends AppCompatActivity implements View.OnClickListener {

    private Button student,faculty,others;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_you);

        student=findViewById(R.id.student);
        faculty=findViewById(R.id.faculty);
        others=findViewById(R.id.others);

        student.setOnClickListener(this);
        faculty.setOnClickListener(this);
        others.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.student:
                Intent intent=new Intent(getApplicationContext(), StudentReg.class);
                startActivity(intent);
                break;

            /*case R.id.faculty:
                intent = new Intent(getApplicationContext(), FacultyReg.class);
                startActivity(intent);
                break;*/

            case R.id.others:
                intent = new Intent(getApplicationContext(), OthersReg.class);
                startActivity(intent);
                break;

        }

    }
}