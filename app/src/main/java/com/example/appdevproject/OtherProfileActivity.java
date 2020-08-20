package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class OtherProfileActivity extends AppCompatActivity {
    private  SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_profile);

        final TextView oprofiletext=(TextView)findViewById(R.id.oprofiletext);
        final TextView onoticetext=(TextView)findViewById(R.id.onoticestext);
        final TextView oinboxtext=(TextView)findViewById(R.id.oinboxtext);
        int color1= ContextCompat.getColor(this,R.color.blueviolet);
        int color2= ContextCompat.getColor(this,R.color.white);
        oprofiletext.setBackgroundColor(color1);
        oprofiletext.setTextColor(color2);
        onoticetext.setTextColor(Color.parseColor("#1A237E"));
        onoticetext.setBackgroundColor(color2);
        oinboxtext.setTextColor(Color.parseColor("#1A237E"));
        oinboxtext.setBackgroundColor(color2);
        onoticetext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),NoticeProfActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,"other");

                startActivity(intent);

                finish();
            }
        });

        oinboxtext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OtherProfileActivity.this,InboxActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT,"other");
                startActivity(intent);
                finish();
            }
        });}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.profile_menu,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.action_search_user:
                searchView=(SearchView)item.getActionView();
                searchView.setQueryHint(Html.fromHtml("<font color = #ffffff>" +"Search users" + "</font>"));

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
            case R.id.campusmap:
                String uri=String.format(Locale.ENGLISH,"geo:%f,%f",29.8649,77.8965);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(uri)));

        }
        return super.onOptionsItemSelected(item);
    }
}