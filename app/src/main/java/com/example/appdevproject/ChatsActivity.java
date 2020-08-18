package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChatsActivity extends AppCompatActivity {

    TextView chatName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);


        chatName=findViewById(R.id.chatname);

        Intent newIntent=getIntent();
        chatName.setText(newIntent.getStringExtra(Intent.EXTRA_TEXT));
    }
}