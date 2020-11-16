package com.example.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikhaellopez.circularimageview.CircularImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileSettingsActivity extends AppCompatActivity {

    CircularImageView circularImageView;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

//        ImageView  imageprivacy=(ImageView) findViewById(R.id.privacy);
//         ImageView imagenotification=(ImageView) findViewById(R.id.notification );
//         ImageView  imagehelp=(ImageView) findViewById(R.id.help);

        ImageView  imageshare=(ImageView) findViewById(R.id.shareapp);

        ImageView deleteacc=(ImageView) findViewById(R.id.deleteaccount);
//        TextView textprivacy=(TextView)findViewById(R.id.privacysetting);
//        TextView textnotification=(TextView)findViewById(R.id.notificationsetting);
//        TextView texthelp=(TextView)findViewById(R.id.helpsetting);
//        TextView textdatause=(TextView)findViewById(R.id.datauseagesetting);




        imageshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mimeType = "text/plain";
                String title = "Example title";

                Intent shareIntent =   ShareCompat.IntentBuilder.from(ProfileSettingsActivity.this)
                        .setType(mimeType)
                        .setText(title)
                        .getIntent();
                if (shareIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(shareIntent);
                }
            }
        });
     deleteacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "It will be updated soon.", Toast.LENGTH_LONG).show();
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