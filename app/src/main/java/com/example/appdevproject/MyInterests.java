package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyInterests extends AppCompatActivity {


    private ArrayList<String> selections;
    private RecyclerView recyclerView;

    public static final String SHARED_PREFS="sharedPrefs2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_interests);


        selections=new ArrayList<>();

        addStrings();
        recyclerView=findViewById(R.id.interests);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MIntAdapter mIntAdapter=new MIntAdapter(selections);
        recyclerView.setAdapter(mIntAdapter);
    }


    public void addStrings(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);

        Map<String,String> prefsMap = (Map<String, String>) sharedPreferences.getAll();
        for (Map.Entry<String, String> entry: prefsMap.entrySet()) {
            Log.v("SharedPreferences", entry.getKey() + ":" +
                    entry.getValue());

            selections.add(entry.getValue());
        }

    }
}