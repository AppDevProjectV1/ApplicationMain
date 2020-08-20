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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class InboxActivity extends AppCompatActivity implements InboxAdapter.ListItemClickListener {
    private  SearchView searchView;
    private   boolean isSearch=true;
    private RecyclerView inboxList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        final TextView profiletext=(TextView)findViewById(R.id.profiletext);
        final TextView noticetext=(TextView)findViewById(R.id.noticestext);
        final TextView inboxtext=(TextView)findViewById(R.id.inboxtext);
        int color1= ContextCompat.getColor(this,R.color.blueviolet);
        int color2= ContextCompat.getColor(this,R.color.white);
        inboxtext.setBackgroundColor(color1);
        inboxtext.setTextColor(color2);
        profiletext.setTextColor(Color.parseColor("#1A237E"));
        profiletext.setBackgroundColor(color2);
        noticetext.setTextColor(Color.parseColor("#1A237E"));
         noticetext.setBackgroundColor(color2);
        profiletext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InboxActivity.this,Facultyprofile.class);
                startActivity(intent);

              finish();
            }
        });
        noticetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InboxActivity.this,NoticeProfActivity.class);
                startActivity(intent);

                finish();
            }
        });

    inboxList = (RecyclerView) findViewById(R.id.inbox_recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        inboxList.setLayoutManager(layoutManager);
        inboxList.setHasFixedSize(true);



        String[] a={"jatin","Ajay","Huzaib","G.G.","M5 BR Civil","Ojas","Yuvraj","Anmol","Vansh","I","k","l","m","n"};

        inboxList.setAdapter( new InboxAdapter(this,a));


    }



    @Override
    public void onListItemClick(String username, TextView message) {
        Intent intentToStartChat =new Intent(InboxActivity.this, ChatsActivity.class);
        intentToStartChat.putExtra(Intent.EXTRA_TEXT,username);
        startActivity(intentToStartChat);
        message.setTextColor(Color.parseColor("#c9c9c9"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.inbox_menu,menu);
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