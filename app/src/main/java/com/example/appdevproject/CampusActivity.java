package com.example.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CampusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ListView listactivity=(ListView)findViewById(R.id.activitylist);

        final ArrayList<ModelClass> activitylists=new ArrayList<ModelClass>();
         activitylists.add(new ModelClass(R.drawable.nss,"NSS IIT Roorkee","NSS IIT Roorkee is a student-run organization under the aegis of the Dean of Students Welfare. We believe each and every one of us is the light bearer to a society that is liberated from all shackles of social problems. Come join us and feel this change.","https://www.facebook.com/nssiitr"));
         activitylists.add(new ModelClass(R.drawable.ncc ,"NCC IIT Roorkee","IIT Roorkee offers the students an opportunity to be part of the NCC. The Institute cadets are part of the 3UK CTR (3 Uttarakhand Composite Technical Regiment) of the NCC and are divided into three companies viz. The Engineers, The Signals and The EME.","https://www.facebook.com/ncc.iitr/"));
         activitylists.add(new ModelClass(R.drawable.tkd,"Taekwondo Chapter, IIT Roorkee","Those people who are interested in pursuing Taekwondo at IIT Roorkee regularly.","https://www.facebook.com/tkdiitr"));
         activitylists.add(new ModelClass(R.drawable.yoga,"Yoga Club IIT Roorkee","Yoga is the way to develop values and self-discipline in a person.","https://www.facebook.com/Yoga.IITR"));
         GroupAdapter adapter=new GroupAdapter(this,activitylists);
           listactivity.setAdapter(adapter);
           listactivity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelClass modelweb =activitylists.get(position);

                Intent intent = new Intent(CampusActivity.this,groupinfo.class);
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