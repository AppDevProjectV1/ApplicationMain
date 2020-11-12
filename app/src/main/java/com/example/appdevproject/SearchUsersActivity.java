package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class SearchUsersActivity extends AppCompatActivity implements  SearchUsersAdapter.ListItemClickListener {
 private  SearchUsersAdapter searchUsersAdapter;
 private  RecyclerView usersrecview;
 private TextView mEmptyStateTextView;
 private ImageView sadimageView;
 public View loadingindicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mEmptyStateTextView = (TextView) findViewById(R.id.leftList);
        sadimageView=(ImageView)findViewById(R.id.sadimage);
       usersrecview=(RecyclerView)findViewById(R.id.searchusersrecview);

        usersrecview.setLayoutManager(new LinearLayoutManager(this));
        usersrecview.setHasFixedSize(true);



            FirebaseRecyclerOptions<UserHelperClass> options =
                    new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                            .setQuery(FirebaseDatabase.getInstance().getReference("Usersdata"), UserHelperClass.class)
                            .build();

            searchUsersAdapter = new SearchUsersAdapter(this,options);
            usersrecview.setAdapter(searchUsersAdapter);


  if(!isNetworkAvailable(getApplicationContext())){
    mEmptyStateTextView.setText("No Internet Connection");
    sadimageView.setImageResource(R.mipmap.sadinternet);

}


       else {
      Runnable job = new Runnable() {
          @Override
          public void run() {

              mEmptyStateTextView.setText("Loading...");
              mEmptyStateTextView.setVisibility(View.GONE);
              mEmptyStateTextView.postDelayed(this, 2500);

          }
      };

      mEmptyStateTextView.postDelayed(job, 2500);
  }


    }

    @Override
    protected void onStart() {
        super.onStart();
        searchUsersAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
      searchUsersAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.searchusersmenu,menu);
        MenuItem item=menu.findItem(R.id.action_search_name);

        SearchView searchCourse= (SearchView) item.getActionView();

        searchCourse.setQueryHint(Html.fromHtml("<font color = #000000>" +"Search Users" + "</font>"));
       // searchCourse.setBackgroundResource(R.drawable.searchdraw);
        EditText searchEditText = (EditText)searchCourse.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getResources().getColor(R.color.black));
        searchEditText.setBackgroundResource(R.drawable.searchdraw);
        searchCourse.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                searchprocess(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                searchprocess(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    private void searchprocess(String query) {
        FirebaseRecyclerOptions<UserHelperClass> options =
                new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Usersdata").orderByChild("username").startAt(query).endAt(query+"utf8ff/"),UserHelperClass.class)
                        .build();
        searchUsersAdapter=new SearchUsersAdapter(this,options);
        searchUsersAdapter.startListening();
        usersrecview.setAdapter(searchUsersAdapter);
    }


    @Override
    public void onListItemClick(String mobilenumber) {
        Intent intentToStartChat =new Intent(getApplicationContext(), IndividualUserProfile.class);
        intentToStartChat.putExtra("apkamobile",mobilenumber);
        startActivity(intentToStartChat);

    }
}