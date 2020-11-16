package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        one=findViewById(R.id.building);

        three=findViewById(R.id.departments);
        four=findViewById(R.id.hostels);
        five=findViewById(R.id.library);
        six=findViewById(R.id.clubs);




        one.setOnClickListener(this);

        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);




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


        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}