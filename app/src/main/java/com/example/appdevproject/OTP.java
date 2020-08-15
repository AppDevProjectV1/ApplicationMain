package com.example.appdevproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class OTP extends AppCompatActivity {

    private Button verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);

        verify=(findViewById(R.id.verify));

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyCode();
            }
        });

    }

    private void verifyCode() {
        Intent intent=new Intent(getApplicationContext(),AboutYou.class);
        startActivity(intent);
    }


}