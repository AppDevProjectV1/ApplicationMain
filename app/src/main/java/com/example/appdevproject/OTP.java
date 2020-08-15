package com.example.appdevproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class OTP extends AppCompatActivity implements TextWatcher {

    private Button verify;
    private EditText one,two,three,four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);


        one=findViewById((R.id.one));
        two=findViewById((R.id.two));
        three=findViewById((R.id.three));
        four=findViewById((R.id.four));


        one.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(one.getText().toString().length()==1)
                {
                    two.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        one.addTextChangedListener(this);
        two.addTextChangedListener(this);
        three.addTextChangedListener(this);
        four.addTextChangedListener(this);



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


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if(one.getText().toString().length()==1)
        {
            two.requestFocus();
        }
        if(two.getText().toString().length()==1)
        {
            three.requestFocus();
        }
        if(three.getText().toString().length()==1)
        {
            four.requestFocus();
        }


    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}