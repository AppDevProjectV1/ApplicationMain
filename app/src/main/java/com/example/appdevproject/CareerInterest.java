package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appdevproject.nav2activities.AboutIITR;
import com.example.appdevproject.nav2activities.FestsList;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CareerInterest extends AppCompatActivity implements CareerAdapter.OnItemClickListener {


    private Button createAcc;
  private int c=1;

    NavigationView nav2;
    private ImageView toggle;
    DrawerLayout drawerLayout;

    ListView navlist;
    private ListView careerList;

    public ArrayList<String> selectedOpts;

    public static final String SHARED_PREFS="sharedPrefs2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career_interest);

        selectedOpts=new ArrayList<>();


        DrawerModel[] options={
                new DrawerModel("Software Developement"),
                new DrawerModel("Competitive Programming"),
                new DrawerModel("Artificial Intelligence"),
                new DrawerModel("Data science"),
                new DrawerModel("Machine Learning"),
                new DrawerModel("Web Developement"),
                new DrawerModel("Mobile App Developement"),
                new DrawerModel("Game Developement"),
                new DrawerModel("Finance"),
                new DrawerModel("Enterpreneurship"),
                new DrawerModel("Dramatics"),
                new DrawerModel("Civil Services"),
                new DrawerModel("Writing"),
                new DrawerModel("Poetry"),
                new DrawerModel("Dancing"),
                new DrawerModel("Standup Comedy"),
                new DrawerModel("Debate"),
                new DrawerModel("Music"),
                new DrawerModel("Singing"),
                new DrawerModel("Video Production"),
                new DrawerModel("Video Editing"),
                new DrawerModel("CGI Creating"),
                new DrawerModel("Virtual Reality"),
                new DrawerModel("2D Animation"),
                new DrawerModel("Desinging"),

        };


        careerList=findViewById(R.id.careerlist);
        CareerAdapter careerAdapter=new CareerAdapter(this,R.layout.all_interest_item,options,this);
        careerList.setAdapter(careerAdapter);

//
//        careerList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                String str=careerList.getItemAtPosition(position).toString();
//                Toast.makeText(CareerInterest.this, str, Toast.LENGTH_SHORT).show();
//                selectedOpts.add(str);
//                return true;
//            }
//        });



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


        DrawerModel[] data={
                new DrawerModel(R.drawable.aboutiitrr,"About IITR"),
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
                c++;
                saveData();

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


                startActivity(intent);
            }
        });


    }
 


    @Override
    public void OnItemClick(String name) {
        Toast.makeText(CareerInterest.this, name, Toast.LENGTH_SHORT).show();
        selectedOpts.add(name);
    }


    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        for(String opt : selectedOpts){
            editor.putString(opt,opt);
        }

        editor.apply();
    }
    public int getC(){
        return c;
    }
}