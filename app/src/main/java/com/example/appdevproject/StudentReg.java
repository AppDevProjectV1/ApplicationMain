package com.example.appdevproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class StudentReg extends AppCompatActivity {

    private EditText name, email, pass, cpass;
    private  String  Name ,Email,mobilenumber,Studentyear,StudentDepartment,imagesid;
    public int b=1,c;
    private ArrayList<DepartmentClass> mCountryList,myearLists;
    private  DepartmentAdapter mAdapter,mNewAdapter;
    private Button next;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
      private CircularImageView addprofileImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_reg);

        firebaseAuth=FirebaseAuth.getInstance();
        name =(EditText) findViewById(R.id.sname);
        email = (EditText)findViewById(R.id.semail);
        pass= (EditText)findViewById(R.id.spass);
        cpass = (EditText)findViewById(R.id.cpass);
        addprofileImageView = findViewById(R.id.addprofilephotoid);
        Name =name.getText().toString().trim();
        Email=email.getText().toString().trim();
        mobilenumber= getIntent().getStringExtra("mobile_number");
         progressBar=(ProgressBar)findViewById(R.id.studentprogress);
        next=findViewById(R.id.next);
        addprofileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmyGallery();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               c= b++;
                Name=name.getText().toString().trim();
                Email=email.getText().toString().trim();
                String Pass=pass.getText().toString().trim();
                String Cpass=cpass.getText().toString().trim();
                if(TextUtils.isEmpty(Name)){
                    Toast.makeText(StudentReg.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(StudentReg.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Pass)){
                    Toast.makeText(StudentReg.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Cpass)){
                    Toast.makeText(StudentReg.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Pass.length()<8 ){
                    Toast.makeText(StudentReg.this, "Password contain atleast 8 characters", Toast.LENGTH_SHORT).show();

                }
//                  progressBar.setVisibility(View.VISIBLE);
                if(Pass.equals(Cpass)){
                    firebaseAuth.createUserWithEmailAndPassword(Email,Pass)
                            .addOnCompleteListener(StudentReg.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Storeuserdata();

                                        Intent intent=new Intent(getApplicationContext(),CareerInterest.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        Toast.makeText(StudentReg.this, "Select Your Interest", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(StudentReg.this, "Email Already Exist or wrong", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }
            }
        });
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



        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DepartmentClass year= myearLists.get(position);
                        Studentyear= year.getCountryName();
               System.out.println(Studentyear);



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

        departspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                DepartmentClass depart= mCountryList.get(position);
                      StudentDepartment  = depart.getCountryName();

                    System.out.println(StudentDepartment);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
    private void openmyGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            addprofileImageView.setImageURI(imageUri);
           imagesid=imageUri.toString();
        }
    }
    private void Storeuserdata() {

        FirebaseDatabase rootNode=FirebaseDatabase.getInstance();
        DatabaseReference reference=rootNode.getReference("Usersdata");
        UserHelperClass userHelperClass=new UserHelperClass(Name, mobilenumber,Email,Studentyear,StudentDepartment,imagesid);
        reference.child(mobilenumber).setValue(userHelperClass);
    }
 public int getB(){
        return b;
}
}