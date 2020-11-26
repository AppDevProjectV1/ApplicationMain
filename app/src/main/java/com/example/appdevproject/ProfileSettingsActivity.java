package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProfileSettingsActivity extends AppCompatActivity {

    private DatabaseReference databaseReferenceall ;

    public static final String SHARED_PREFS="sharedPrefs";
    public static final String  MOB_NO="phono";

    public  String ismobile;

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

        View imageshare=findViewById(R.id.ifriend);
        View deleteacc=findViewById(R.id.daccount);
        View aboutapp=findViewById(R.id.aapp);
        View privacypolicy=findViewById(R.id.policy);
//        TextView textprivacy=(TextView)findViewById(R.id.privacysetting);
//        TextView textnotification=(TextView)findViewById(R.id.notificationsetting);
//        TextView texthelp=(TextView)findViewById(R.id.helpsetting);
//        TextView textdatause=(TextView)findViewById(R.id.datauseagesetting);




        imageshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mimeType = "text/plain";
                String title = "Hey!join the Campus Compass network, download the app from playstore";

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
                startActivity(new Intent(getApplicationContext(),AccountDeletion.class));
            }
        });


        aboutapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AboutApp.class));
            }
        });

        privacypolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PrivacyPolicy.class));
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