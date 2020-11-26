package com.campuscompass.appdevproject.nav2activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.appdevproject.R;

public class Library extends AppCompatActivity {

    private TextView Linfo,Lsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        Linfo=findViewById(R.id.Linfo);
        Lsite=findViewById(R.id.lsite);

        String Binfo="About Mahatma Gandhi Central Library The MGCL of the Institute finds a unique place in the academic library scenario in this part of the world. It is an amalgamation of the classic and the modern. While it is one of the oldest academic libraries in country, it is housed in a 80,000 sq. ft. state-of-the-art ultra-modern centrally airconditioned building equipped with all latest ICT facilities spread over in four floors. Library building, equipped with surveillance system, has been aesthetically designed for around 500 users keeping in view comfort for cozy access and intelligent use by all kinds of users. Main attraction of building is availability of ample natural lights for reading. It uses RFID technology for providing human intervention free service to users. It provides seamless wi-fi access connectivity throughout the buildingbesides wired connectivity for more than 200 computers. Its well-equipped imaging center uses two Minolta Planetary Scanners for digitization of documents for Institute Repositories “Bhagirathi” and “Shodh-Bhagirathi” containing Institute's archival materials, theses, dissertations and other valuable publications.";
        Linfo.setText(Binfo);
        Lsite.setText("http://mgcl.iitr.ac.in/");
       Lsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://mgcl.iitr.ac.in/"));
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