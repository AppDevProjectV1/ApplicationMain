package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ToggleButton;

import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;

public class CareerInterest extends AppCompatActivity {


    private Button createAcc;


    NavigationView nav2;
    private ImageView toggle;
    DrawerLayout drawerLayout;

    ListView navlist;
    private RecyclerView careerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_interest);

        String[] options={"Software developement","Competitive Programming","Artificial Intelligence","Data science","Machine Learning",
                "Web Developement","Mobile App Developement","Game Developement","Finance","Enterpreneurship","Dramatics","Civil Services","Writing"
                ,"Poetry","Dancing","Standup Comedy","Debate","Music","Singing","Video Production","Video Editing","CGI Creating","Virtual Reality"
                ,"2D Animation","Desinging"};


        careerList=findViewById(R.id.careerlist);
        careerList.setLayoutManager(new LinearLayoutManager(this));
        careerList.setAdapter(new CareerAdapter(options));


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawerLayout=findViewById(R.id.interestdrawer);
        nav2=findViewById(R.id.nav2);


        toggle=findViewById(R.id.toggle);

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });



        String[] navlister={"About IITR","Campus Groups","Campus Map","Campus Fest","Sports","Activities","Campus Tour","Campus Videos"};
        navlist=findViewById(R.id.navlist);
        ArrayAdapter navAdapter=new ArrayAdapter(this,R.layout.nav2item, Arrays.asList(navlister));
        navlist.setAdapter(navAdapter);




        createAcc=findViewById(R.id.createacc);

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
                startActivity(intent);
            }
        });


    }

}