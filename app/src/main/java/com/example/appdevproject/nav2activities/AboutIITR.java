package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appdevproject.CareerInterest;
import com.example.appdevproject.R;

public class AboutIITR extends AppCompatActivity implements View.OnClickListener {


    private TextView one ,two,three,four,five,six;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_i_i_t_r);


        one=findViewById(R.id.building);
        two=findViewById(R.id.dean);
        three=findViewById(R.id.departments);
        four=findViewById(R.id.hostels);
        five=findViewById(R.id.library);
        six=findViewById(R.id.clubs);
        back=findViewById(R.id.back);



        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        back.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.building:
                startActivity(new Intent(getApplicationContext(),Thomson.class));
                break;
            case R.id.departments:
                startActivity(new Intent(getApplicationContext(),Departments.class));
                break;
            case R.id.hostels:
                startActivity(new Intent(getApplicationContext(),Hostels.class));
                break;
            case R.id.library:
                startActivity(new Intent(getApplicationContext(),Library.class));
                break;
            case R.id.clubs:
                startActivity(new Intent(getApplicationContext(),Clubs.class));
                break;
            case R.id.back:
                startActivity(new Intent(getApplicationContext(), CareerInterest.class));
                break;

        }
    }
}