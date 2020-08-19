package com.example.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

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
        sportslists.add(new ModelClass(R.drawable.iitsport,"Institute Sports Council, IITR","https://www.facebook.com/iitrsports"));
        sportslists.add(new ModelClass(R.drawable.sangram , "Sangram, IIT Roorkee","https://www.facebook.com/sangramiitr.in"));
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