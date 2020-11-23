package com.example.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CanteenOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_order);

        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ListView canteenbahwan=(ListView)findViewById(R.id.canteenlist);

        ArrayList<CanteenClass> mcanteenlist= new ArrayList<CanteenClass>();

        mcanteenlist.add(new CanteenClass("Azad Bhawan Canteen",  R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass( "Cautley Bhawan Canteen",  R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass( "Ganga Bhawan Canteen",  R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass( "Govind Bhawan Canteen" , R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass("Indra Bahwan Canteen", R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass( "Jawahar Bhawan Canteen" ,  R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass("Kasturba Bhawan Canteen", R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass("Radhakrishnan Bhawan Canteen" , R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass(  "Rajendra Bhawan Canteen" , R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass("Rajiv Bhawan Canteen",  R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass( "Ravindra Bhawan Canteen",  R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass(  "Malviya Bhawan Canteen", R.drawable.canteenimg));
        mcanteenlist.add(new CanteenClass( "Sarojini Bhawan Canteen", R.drawable.canteenimg));


       CanteenAdapter adapter= new CanteenAdapter(this,mcanteenlist);

       canteenbahwan.setAdapter(adapter);
       canteenbahwan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent (getApplicationContext(),OrderCanteen.class);
               Toast.makeText(getApplicationContext(), "Select Order", Toast.LENGTH_LONG).show();
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