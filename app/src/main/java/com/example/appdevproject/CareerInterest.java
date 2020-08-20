package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.appdevproject.nav2activities.AboutIITR;
import com.example.appdevproject.nav2activities.FestsList;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

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


        DrawerModel[] data={new DrawerModel(R.drawable.aboutiitrr,"About IITR"),
                new DrawerModel(R.drawable.group,"Campus Groups"),
                new DrawerModel(R.drawable.map,"Campus Maps"),
                new DrawerModel(R.drawable.fests,"Campus Fests"),
                new DrawerModel(R.drawable.ic_baseline_sports_handball_24,"Sports"),
                new DrawerModel(R.drawable.activity,"Activities"),
                new DrawerModel(R.drawable.videocampus,"Campus Videos")};

        navlist=findViewById(R.id.navlist);
        InterestNavAdapter interestNavAdapter=new InterestNavAdapter(this,R.layout.nav2item,data);
        navlist.setAdapter(interestNavAdapter);



        navlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position==0){
                    startActivity(new Intent(getApplicationContext(),AboutIITR.class));
                }
                if(position==1){
                    startActivity(new Intent(getApplicationContext(),CampusGroupActivity.class));
                }
                if(position==2){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(Locale.ENGLISH,"geo:%f,%f",29.8649,77.8965))));
                }
                if(position==3){
                    startActivity(new Intent(getApplicationContext(), FestsList.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(),SportsActivity.class));
                }
                if(position==5){
                    startActivity(new Intent(getApplicationContext(),CampusActivity.class));
                }

            }
        });


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