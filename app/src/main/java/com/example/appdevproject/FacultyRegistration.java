package com.example.appdevproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class FacultyRegistration extends AppCompatActivity {
    private EditText fname, femail, fpass, fcpass;
    private ArrayList<DepartmentClass> mCountryList;
    private  DepartmentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_registration);

        fname = (EditText)findViewById(R.id.fname);
        femail = (EditText)findViewById(R.id.femail);
        fpass= (EditText)findViewById(R.id.fpass);
        fcpass = (EditText)findViewById(R.id.fcpass);
        Spinner departspin=(Spinner)findViewById(R.id.department);
      /*  String[] departments=new String[]{"Computer Science","Electronics and Communication","Electrical","Mechanical","Production and Industrial"
                ,"Civil","Metallurgy","Polymer Science","Engineering Physics","Chemical","Bio Technology","GPT","GT","Applied Mathematics","Physics","Chemistry"};
        ArrayAdapter departadapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,departments);*/
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

    }
}