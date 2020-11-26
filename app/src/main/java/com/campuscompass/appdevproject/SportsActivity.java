package com.campuscompass.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.appdevproject.R;

import java.util.ArrayList;

public class SportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ListView listsports=(ListView)findViewById(R.id.sportslist);

        final ArrayList<ModelClass>  sportslists=new ArrayList<ModelClass>();
        sportslists.add(new ModelClass(R.drawable.iitsport,"Institute Sports Council, IITR","The Institute Sports Council (ISC) provides the students of the IIT Roorkee a forum for recreation and extends to them opportunities for playing games & sports. It assists in the development of skill in different sports activities among the students by inculcating in them a desire for active participation in sports and games. The various sections of the ISC shall act in a manner so as to achieve this objective. Core Team of ISC members: Chief Advisor Sports: Dr. Pravindra Kumar Sports Officer: Mr. K Sukumar Asstt. Sports Officer: Mr. H K Sharma & Dr. A K Pandey PTI: Mrs. Hema Pant & Mr Mukesh Choudhary Coach: Mr. S N Goel General Secretary: Ms. Soumita Talukdar Dy. General Secretary: Mr. Arjun Malik See less\n","https://www.facebook.com/iitrsports"));
        sportslists.add(new ModelClass(R.drawable.sangram , "Sangram, IIT Roorkee","Sangram, the Annual Sports Festival of IIT Roorkee, brings together sportsmen from all around the country to a common ground to compete for victory and excellence in sports. Sangram encompasses a wide range of sports from action filled athletics to strength driven powerlifting and peaceful yoga. The fest attracts an annual footfall of more than 1500 participants. Plethoras of events are hosted, accompanied by informal events like sports quiz, marathon. Sangram is the celebration of the union of mind, body and soul.","https://www.facebook.com/sangramiitr.in"));
        GroupAdapter adapter=new GroupAdapter(this,sportslists);
         listsports.setAdapter(adapter);
         listsports.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelClass modelweb = sportslists.get(position);

                Intent intent = new Intent(SportsActivity.this,groupinfo.class);
                intent.putExtra(Intent.EXTRA_TEXT,modelweb.getMurl());
                startActivity(intent);

            }
        });







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