package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyInterests extends AppCompatActivity {


    private ArrayList<String> selections;
    private RecyclerView recyclerView;

    private Toolbar toolbar;
    public static final String SHARED_PREFS = "sharedPrefs2";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_interests);



        toolbar=(Toolbar)findViewById(R.id.mytool);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Interests");
        }
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        toolbar.inflateMenu(R.menu.myinterestmenu);

        selections = new ArrayList<>();

        addStrings();
        recyclerView = findViewById(R.id.interests);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MIntAdapter mIntAdapter = new MIntAdapter(selections);
        recyclerView.setAdapter(mIntAdapter);
    }


    public void addStrings() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        Map<String, String> prefsMap = (Map<String, String>) sharedPreferences.getAll();
        for (Map.Entry<String, String> entry : prefsMap.entrySet()) {
            Log.v("SharedPreferences", entry.getKey() + ":" +
                    entry.getValue());

            selections.add(entry.getValue());
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.myinterestmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.editinterests:
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.clear();
                editor.commit();

                startActivity(new Intent(getApplicationContext(),CareerInterest.class));

        }

        return true;
    }

}