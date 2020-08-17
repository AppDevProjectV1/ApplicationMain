package com.example.appdevproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentReg extends AppCompatActivity {

    private EditText name, email, pass, cpass;
    private ArrayList<DepartmentClass> mCountryList,myearLists;
    private  DepartmentAdapter mAdapter,mNewAdapter;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);


        name = findViewById(R.id.sname);
        email = findViewById(R.id.semail);
        pass= findViewById(R.id.spass);
        cpass = findViewById(R.id.cpass);
        next=findViewById(R.id.next);
        Spinner dropdown = findViewById(R.id.year);
       /* String[] items = new String[]{"I","II","III","IV","V"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);*/

        myearLists=new ArrayList<>();
        myearLists.add(new DepartmentClass("I", R.drawable.i));
        myearLists.add(new DepartmentClass("II", R.drawable.ii));
        myearLists.add(new DepartmentClass("III", R.drawable.iii));
        myearLists.add(new DepartmentClass("IV", R.drawable.iv));
        myearLists.add(new DepartmentClass("V", R.drawable.v));
        mNewAdapter = new DepartmentAdapter(this, myearLists);
        dropdown.setAdapter(mNewAdapter);





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

        Spinner departspin=(Spinner)findViewById(R.id.dept);

        mCountryList = new ArrayList<>();
        mCountryList.add(new DepartmentClass("Computer Science", R.drawable.computer));
        mCountryList.add(new DepartmentClass("Electronic and Communication", R.drawable.electrical));
        mCountryList.add(new DepartmentClass("Electrical Engineering", R.drawable.electri));
        mCountryList.add(new DepartmentClass("Civil Engineering", R.drawable.civil));
        mCountryList.add(new DepartmentClass("mechnical Engineering", R.drawable.mechnical));
        mCountryList.add(new DepartmentClass("Production & Industrial", R.drawable.pandi));
        mCountryList.add(new DepartmentClass("Metallurgy", R.drawable.meta));
        mCountryList.add(new DepartmentClass("Physics", R.drawable.physics));
        mCountryList.add(new DepartmentClass("Engneering physics", R.drawable.physics));
        mCountryList.add(new DepartmentClass("Applied Mathematics", R.drawable.electri));
        mCountryList.add(new DepartmentClass("Chemistry", R.drawable.chemistry));
        mCountryList.add(new DepartmentClass("Architecture", R.drawable.archti));
        mCountryList.add(new DepartmentClass("GT", R.drawable.gt));
        mCountryList.add(new DepartmentClass("Hydrology", R.drawable.hydrology));
        mCountryList.add(new DepartmentClass("Chemical Engineering", R.drawable.chemical));
        mCountryList.add(new DepartmentClass("Earth Science", R.drawable.earthscience));
        mCountryList.add(new DepartmentClass("Polymer Science", R.drawable.polymer));
        mCountryList.add(new DepartmentClass("Bio Techonology", R.drawable.biotech));
        mCountryList.add(new DepartmentClass("Earhtquake Engineering", R.drawable.earthquake));
        mAdapter = new DepartmentAdapter(this, mCountryList);
        departspin.setAdapter(mAdapter);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CareerInterest.class);
                startActivity(intent);
            }
        });
    }
}