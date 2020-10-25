package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class SearchUsersActivity extends AppCompatActivity {
 private  SearchUsersAdapter searchUsersAdapter;
 private  RecyclerView usersrecview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);

       usersrecview=(RecyclerView)findViewById(R.id.searchusersrecview);
        usersrecview.setLayoutManager(new LinearLayoutManager(this));
        usersrecview.setHasFixedSize(true);
        FirebaseRecyclerOptions<UserHelperClass> options =
                new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Usersdata") ,UserHelperClass.class)
                        .build();

        searchUsersAdapter=new SearchUsersAdapter(options);
   usersrecview.setAdapter(searchUsersAdapter);

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
        searchCourse.setQueryHint(Html.fromHtml("<font color = #ffffff>" +"Search Users" + "</font>"));
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



    private void searchprocess(String query) {
        FirebaseRecyclerOptions<UserHelperClass> options =
                new FirebaseRecyclerOptions.Builder<UserHelperClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Usersdata").orderByChild("username").startAt(query).endAt(query+"utf8ff/"),UserHelperClass.class)
                        .build();
        searchUsersAdapter=new SearchUsersAdapter(options);
        searchUsersAdapter.startListening();
        usersrecview.setAdapter(searchUsersAdapter);
    }
}