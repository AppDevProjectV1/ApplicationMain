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
         activitylists.add(new ModelClass(R.drawable.nss,"NSS IIT Roorkee","https://www.facebook.com/nssiitr"));
         activitylists.add(new ModelClass(R.drawable.ncc ,"NCC IIT Roorkee","https://www.facebook.com/ncc.iitr/"));
         activitylists.add(new ModelClass(R.drawable.tkd,"Taekwondo Chapter, IIT Roorkee","https://www.facebook.com/tkdiitr"));
         activitylists.add(new ModelClass(R.drawable.yoga,"Yoga Club IIT Roorkee","https://www.facebook.com/Yoga.IITR"));
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