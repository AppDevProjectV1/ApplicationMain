package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class CanteenList extends AppCompatActivity implements  CanteenAdapter.ListItemClickListener {


    private RecyclerView canteenList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canteen_list);

        canteenList = (RecyclerView) findViewById(R.id.cantlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        canteenList.setLayoutManager(layoutManager);
        canteenList.setHasFixedSize(true);



        String[] a={"Azad Bhawan" ,
                "Cautley Bhawan" ,
                "Ganga Bhawan" ,
                "Govind Bhawan" ,
                "Jawahar Bhawan" ,
                "Radhakrishnan Bhawan" ,
                "Rajendra Bhawan" ,
                "Rajiv Bhawan" ,
                "Ravindra Bhawan" ,
                "Malviya Bhawan",
                "Sarojini Bhawan",
                "Kasturba Bhawan"};

        canteenList.setAdapter( new CanteenAdapter(this,a));
    }


    @Override
    public void onListItemClick(String username) {

    }
}