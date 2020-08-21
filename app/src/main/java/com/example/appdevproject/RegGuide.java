package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RegGuide extends AppCompatActivity {


    private TextView guideh,guideb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_guide);



        String h="NOTE:   1. All the candidates are requested to check & note their Enrollment \n" +
                "Number and batch pasted on the entrance of the auditorium. \n" +
                "  2. Candidates have to collect and fill 5 copies of Registration Cards. \n" +
                "  3. Candidates have to collect Time Table of their respective branch from \n" +
                "the entrance of the Auditorium, Multi‐Activity Center. \n\n" +
                "********************" ;


        String b="1. For verification of Identity & Admission To be present on the DIAS\n" +
                "after announcement of your name\n" +
                "2. (a)To collect registration kit containing:\n" +
                "Medical booklet, Identity Card, Time table.\n" +
                "Note: Fill the Medical booklet & Identity card and\n" +
                "submit at counter No.5.\n" +
                "To obtain the same from\n" +
                "Counter No. 1\n" +
                "(Academic Section)\n" +
                "3. OBC/EWS Category Certificate verification Counter No.2\n" +
                "(Academic Section)\n" +
                "4. Payment Proof of Institute fees with\n" +
                "Annexure-IV(b).\n" +
                "To be submitted at\n" +
                "Counter No. 3 (Accounts)\n" +
                "5. Documents verification/submission of\n" +
                "document as per check list, Annexure-IV(a)\n" +
                "To be shown/given at\n" +
                "Counter No. 4\n" +
                "(Academic Section)\n" +
                "6. Identity card, Form B (ii), Annexure I,\n" +
                "Annexure II, Annexure–III, Annexure-IV(c) &\n" +
                "Medical Booklet.\n" +
                "To be submitted at\n" +
                "Counter No. 5\n" +
                "(DoSW& CCB)\n" +
                "7. Opening of Bank Account SBI/PNB counter Outside the Auditorium\n" +
                "8. Getting SIM Cards and accounts Outside the Auditorium";



        guideh=findViewById(R.id.guideh);
        guideh.setText(h);


        guideb=findViewById(R.id.guideb);
        guideb.setText(b);

    }
}