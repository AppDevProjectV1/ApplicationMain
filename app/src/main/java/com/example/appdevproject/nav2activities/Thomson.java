package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.appdevproject.R;

public class Thomson extends AppCompatActivity {

    private TextView Tinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thomson);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Tinfo=findViewById(R.id.Tinfo);


        String Binfo="The main administrative building is a gentle reminder of the glorious past of the institute. Its grandeur establishes the institute's importance in technical education and research work on global scale. The noble edifice looks across the plains towards the snowy caps of the Himalayas. Built in renaissance style, its construction began in 1852. Several constructions were added to it along the timeline.\n" +
                "\n" +
                "The building's quadrangle housed the teaching facilities along with the administration for about a century. The lush green lawns in front provide perfect ambience of an evening walk and the building leaves an indelible impression on everyone who sees it.";


        Tinfo.setText(Binfo);
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