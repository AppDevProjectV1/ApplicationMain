package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.MalformedURLException;
import java.net.URL;

public class groupinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupinfo);
        Intent newIntent=getIntent();


        WebView iitrweb=(WebView)findViewById(R.id.Website);
        iitrweb.getSettings().setJavaScriptEnabled(true);
        iitrweb.setWebViewClient(new WebViewClient());
        iitrweb.loadUrl(newIntent.getStringExtra(Intent.EXTRA_TEXT));

    }
}