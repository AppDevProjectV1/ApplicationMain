package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AccountDeletion extends AppCompatActivity {

    private CardView mayank;
    private CardView jatin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_deletion);

        mayank=findViewById(R.id.mayank);
        jatin=findViewById(R.id.jatin);


        mayank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent1=new Intent(Intent.ACTION_SEND);
                intent1.setType("message/rfc822");
                intent1.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mayankpatidar19082001@gmail.com"});
                intent1.putExtra(Intent.EXTRA_SUBJECT, "CampusCompass Account Deletion");
                intent1.putExtra(Intent.EXTRA_TEXT   , "Hi Sir, My Name is (your name) and Email (your app email id) ,I want my account to be deleted. \n\n\n Thank you");

                startActivity(Intent.createChooser(intent1, "Send mail..."));

            }
        });


        jatin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1=new Intent(Intent.ACTION_SEND);
                intent1.setType("message/rfc822");
                intent1.putExtra(Intent.EXTRA_EMAIL  , new String[]{"jatinramchandani307@gmail.com"});
                intent1.putExtra(Intent.EXTRA_SUBJECT, "CampusCompass Account Deletion");
                intent1.putExtra(Intent.EXTRA_TEXT   , "Hi Sir, My Name is (your name) and Email (your app email id) ,I want my account to be deleted. \n\n\n Thank you");

                startActivity(Intent.createChooser(intent1, "Send mail..."));

            }
        });
    }
}