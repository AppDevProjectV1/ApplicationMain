package com.example.appdevproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class StudentReg extends AppCompatActivity {

    private EditText name, email, pass, cpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);


        name = findViewById(R.id.sname);
        email = findViewById(R.id.semail);
        pass= findViewById(R.id.spass);
        cpass = findViewById(R.id.cpass);

        Spinner dropdown = findViewById(R.id.year);
        String[] items = new String[]{"I","II","III","IV","V"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        Spinner dropdown2 = findViewById(R.id.branch);
        String[] items2 = new String[]{"Computer Science","Electronics and Communication","Electrical","Mechanical","Production and Industrial"
        ,"Civil","Metallurgy","Polymer Science","Engineering Physics","Chemical","Bio Technology","GPT","GT","Applied Mathematics","Physics","Chemistry"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        dropdown2.setAdapter(adapter2);


        Spinner dropdown3 = findViewById(R.id.hostel);
        String[] items3 = new String[]{"Azad Bhawan",
                "Cautley Bhawan",
                "Ganga Bhawan",
                "Govind Bhawan",
                "Jawahar Bhawan",
                "Radhakrishnan Bhawan",
                "Rajendra Bhawan",
                "Rajiv Bhawan",
                "Ravindra Bhawan",
                "Malviya Bhawan",
                "Sarojini Bhawan",
                "Kasturba Bhawan",
                "Indira Bhawan"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items3);
        dropdown3.setAdapter(adapter3);


    }
}