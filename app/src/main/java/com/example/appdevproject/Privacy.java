package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Privacy extends AppCompatActivity {


    private RelativeLayout profilectrl;
    private RelativeLayout aboutctrl;
    private TextView selectedControl;
    private TextView aSelectedControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);


        profilectrl=findViewById(R.id.profilectrl);
        aboutctrl=findViewById(R.id.aboutctrl);
        selectedControl=findViewById(R.id.selectedcontrol);
        aSelectedControl=findViewById(R.id.aselectedcontrol);

        profilectrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRadioButtonDialog();
            }
        });
        aboutctrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRadioButtonDialog1();
            }
        });
    }


    private void showRadioButtonDialog() {

        // custom dialog

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogradios);

        List<String> stringList=new ArrayList<>();  // here is list
        stringList.add("Everyone");
        stringList.add("My contacts");
        stringList.add("Nobody");

        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);

        for(int i=0;i<stringList.size();i++){
            RadioButton rb=new RadioButton(this);// dynamically creating RadioButton and adding to RadioGroup.
            rb.setTextSize(20);
            rb.setText(stringList.get(i));
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedControl.setText(rb.getText());
                }
            });
            rg.addView(rb);

            dialog.show();
        }
    }




    private void showRadioButtonDialog1() {

        // custom dialog

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogradios);

        List<String> stringList=new ArrayList<>();  // here is list
        stringList.add("Everyone");
        stringList.add("My contacts");
        stringList.add("Nobody");

        RadioGroup rg = (RadioGroup) dialog.findViewById(R.id.radio_group);

        for(int i=0;i<stringList.size();i++){
            RadioButton rb=new RadioButton(this);// dynamically creating RadioButton and adding to RadioGroup.
            rb.setTextSize(20);
            rb.setText(stringList.get(i));
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aSelectedControl.setText(rb.getText());
                }
            });
            rg.addView(rb);

            dialog.show();
        }
    }


}

