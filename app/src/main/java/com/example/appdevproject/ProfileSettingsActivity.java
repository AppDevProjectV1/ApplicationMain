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
     circularImageView = findViewById(R.id.circularimageview);

       circularImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        ImageView  imageprivacy=(ImageView) findViewById(R.id.privacy);
         ImageView imagenotification=(ImageView) findViewById(R.id.notification );
         ImageView  imagehelp=(ImageView) findViewById(R.id.help);
        ImageView  imagedatause=(ImageView) findViewById(R.id.datause);
        ImageView  imageshare=(ImageView) findViewById(R.id.shareapp);
        TextView textprivacy=(TextView)findViewById(R.id.privacysetting);
        TextView textnotification=(TextView)findViewById(R.id.notificationsetting);
        TextView texthelp=(TextView)findViewById(R.id.helpsetting);
        TextView textdatause=(TextView)findViewById(R.id.datauseagesetting);
        textprivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( ProfileSettingsActivity.this, Privacy.class);
                startActivity(intent);

            }
        });
        textnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( ProfileSettingsActivity.this,Notifications.class);
                startActivity(intent);

            }
        });
        texthelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( ProfileSettingsActivity.this, AboutApp.class);
                startActivity(intent);

            }
        });
        imageprivacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( ProfileSettingsActivity.this, Privacy.class);
                startActivity(intent);

            }
        });
      imagenotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( ProfileSettingsActivity.this,Notifications.class);
                startActivity(intent);

            }
        });
        imagehelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent( ProfileSettingsActivity.this, AboutApp.class);
                startActivity(intent);

            }
        });
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

    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
             circularImageView.setImageURI(imageUri);

        }
    }

}