package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

public class Facultyprofile extends AppCompatActivity {
   private  SearchView searchView;
  private   boolean isSearch=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultyprofile);
        final TextView profiletext=(TextView)findViewById(R.id.profiletext);
        final TextView noticetext=(TextView)findViewById(R.id.noticestext);
        final TextView inboxtext=(TextView)findViewById(R.id.inboxtext);
        int color1= ContextCompat.getColor(this,R.color.blueviolet);
        int color2= ContextCompat.getColor(this,R.color.white);
         profiletext.setBackgroundColor(color1);
         profiletext.setTextColor(color2);
        noticetext.setTextColor(Color.parseColor("#1A237E"));
        noticetext.setBackgroundColor(color2);
        inboxtext.setTextColor(Color.parseColor("#1A237E"));
         inboxtext.setBackgroundColor(color2);
         noticetext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),NoticeProfActivity.class);
                startActivity(intent);

                finish();
            }
        });

         inboxtext.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Facultyprofile.this,InboxActivity.class);
                startActivity(intent);
                  finish();
            }
        });


    }

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
        }
        return super.onOptionsItemSelected(item);
    }

}