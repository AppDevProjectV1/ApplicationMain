package com.campuscompass.appdevproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.appdevproject.R;

import org.w3c.dom.Text;

public class Notifications extends AppCompatActivity {
    private RelativeLayout toneSelector;
    private TextView toneName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);



        toneSelector=findViewById(R.id.tone);
        toneName=findViewById(R.id.tonename);


        toneSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseTone();
            }

        });


    }

    private void chooseTone() {

        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, (Uri) null);
        startActivityForResult(intent, 5);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==Activity.RESULT_OK && requestCode==5){
            Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

            String[] projection = {MediaStore.MediaColumns.DATA};
            ContentResolver contentResolver=getApplicationContext().getContentResolver();
            Cursor cursor =contentResolver.query(uri,projection,null,null,null);
            String path = "";
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        path = cursor.getString(0);
                    }
                } finally {
                    cursor.close();
                }
            }
            toneName.setText(path.substring(34));
        }
    }

}