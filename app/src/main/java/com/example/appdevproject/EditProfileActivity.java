package com.example.appdevproject;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity {
    public static final String SHARED_PREFS="sharedPrefs";

    public static final String  mobno="phono";
    public static final String Email="emailuser";
    public  String isMobile,isEmail;
    UserHelperClass userHelperClass;
    private int uploads = 0;
    private FirebaseStorage storage;

    private StorageReference storageReference;
    private EditText name, achieve ,groups,skills,studept,stuyear,stubhawan;
    private  String  Name ,Achievements,mobilenumber,Studentyear,StudentDepartment,Groups,Skills ,profileImageUrl, Bahawan;
    public int b=1,c;
    private ArrayList<DepartmentClass> mCountryList,myearLists;
    private  DepartmentAdapter mAdapter,mNewAdapter;
    private Button next;
    public String newUri;
    private DatabaseReference reference;
    private static final int PICK_IMAGE = 100;
    public String imgji;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    Uri imageUri;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    private CircularImageView addprofileImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        firebaseAuth= FirebaseAuth.getInstance();
        name =(EditText) findViewById(R.id.sname1);
        achieve = (EditText)findViewById(R.id.sachieve);
        groups= (EditText)findViewById(R.id.groupsji);
        skills = (EditText)findViewById(R.id.skills);
        stubhawan = (EditText)findViewById(R.id.bhawanedit);
        studept= (EditText)findViewById(R.id.deptedit);
        stuyear = (EditText)findViewById(R.id.yearedit);

        name.setText(getIntent().getStringExtra("name"));
        achieve.setText(getIntent().getStringExtra("achi"));
        groups.setText(getIntent().getStringExtra("groups"));
        skills.setText(getIntent().getStringExtra("skills"));
        stubhawan.setText(getIntent().getStringExtra("hostal"));
        stuyear.setText(getIntent().getStringExtra("year"));
        studept.setText(getIntent().getStringExtra("dept"));
        addprofileImageView = findViewById(R.id.addprofilephotoid1);
        isEmail=getIntent().getStringExtra("email");
        imgji=getIntent().getStringExtra("imageurl");
        Glide.with(getApplicationContext()).load(imgji).into(addprofileImageView);
        Name =name.getText().toString().trim();
        Achievements=achieve.getText().toString().trim();

        Groups =groups.getText().toString().trim();
        Skills=skills.getText().toString().trim();

        mobilenumber= getIntent().getStringExtra("mobile_number");
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        isMobile = sharedPreferences.getString(mobno,"mobilenumber");

        storageReference= FirebaseStorage.getInstance().getReference().child(isMobile);
        reference= FirebaseDatabase.getInstance().getReference("Usersdata").child(isMobile);
        // progressBar=(ProgressBar)findViewById(R.id.studentprogress);
        next=findViewById(R.id.saveeditbtn);
        addprofileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfilechooser();
                Toast.makeText(getApplicationContext(), "It will be updated soon.", Toast.LENGTH_LONG).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
                Name=name.getText().toString().trim();
                Achievements=achieve.getText().toString().trim();

                Groups =groups.getText().toString().trim();
                Skills=skills.getText().toString().trim();
                Studentyear=stuyear.getText().toString().trim();
                StudentDepartment=studept.getText().toString().trim();
                Bahawan=stubhawan.getText().toString().trim();

                if(TextUtils.isEmpty(Name)){
                    Toast.makeText(EditProfileActivity.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                }
//                if(TextUtils.isEmpty(Achievements)){
//                    Toast.makeText(EditProfileActivity.this, "Please Enter Achievements or No", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(Groups)){
//                    Toast.makeText(
//                            EditProfileActivity.this, "Please Enter Groups or No", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(Skills)){
//                    Toast.makeText(
//                            EditProfileActivity.this, "Please Enter Skills or No", Toast.LENGTH_SHORT).show();
//                    return;
//                }

//                  progressBar.setVisibility(View.VISIBLE);
                if(isNetworkAvailable(getApplicationContext())){
                    Storeuserdata();

                    Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
                    startActivity(intent);
                    Toast.makeText(EditProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditProfileActivity.this, "no internet connection", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    private void openfilechooser() {
        Intent gallery =new Intent();
        gallery.setType("image/*");
        gallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(gallery,PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE  && resultCode == RESULT_OK && data !=null &&
                data.getData()!=null){
            imageUri = data.getData();
            // start cropping activity for pre-acquired image saved on the device
            CropImage.activity(imageUri)
                    .start(this);



        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                Glide.with(getApplicationContext()).load(resultUri).into(addprofileImageView);
                storageReference.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>(){
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        task.getResult().getStorage().getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {


                                newUri=uri.toString();




                            }
                        });
                    }
                });
            }


            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

    }

    /* */

    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    private void Storeuserdata() {
        userHelperClass=new UserHelperClass(Name,isMobile,isEmail,Achievements,Groups,Skills,Studentyear,StudentDepartment,Bahawan,imgji);
        reference.setValue(userHelperClass);
    }
}