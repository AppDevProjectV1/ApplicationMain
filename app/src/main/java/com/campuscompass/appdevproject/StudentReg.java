package com.campuscompass.appdevproject;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appdevproject.R;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.theartofdev.edmodo.cropper.CropImage;

import java.util.ArrayList;

public class StudentReg extends AppCompatActivity {
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String  Registered="registered";
    public static final String  GetStart="getstart";
    public static final String  mobno="phono";
    public static final String emailjio="emailuser";
    public  String isMobile;
    UserHelperClass userHelperClass;
    private int uploads = 0;
    private FirebaseStorage storage;

    private StorageReference storageReference;
    private EditText name, email, pass, cpass, achieve ,groups,skills;
    private  String  Name ,Email,mobilenumber,Studentyear,StudentDepartment,profileImageUrl,Groups,Skills ,Achievements, Bahawan;
    public int b=1,c;
    private ArrayList<DepartmentClass> mCountryList,myearLists;
    private  DepartmentAdapter mAdapter,mNewAdapter;
    private Button next;
    public String newUri="https://firebasestorage.googleapis.com/v0/b/appdevproject-76786.appspot.com/o/common?alt=media&token=d2995571-abe0-4c42-afb2-63d4b2cdf957";
    private DatabaseReference reference;
    private static final int PICK_IMAGE = 100;

    private static final int MY_CAMERA_PERMISSION_CODE = 100;
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

        achieve = (EditText)findViewById(R.id.sachieve2);
        groups= (EditText)findViewById(R.id.groupsji2);
        skills = (EditText)findViewById(R.id.skills2);

        Name =name.getText().toString().trim();
        Email=email.getText().toString().trim();
        Achievements=achieve.getText().toString().trim();
        Groups =groups.getText().toString().trim();
        Skills=skills.getText().toString().trim();
        mobilenumber= getIntent().getStringExtra("mobile_number");
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        isMobile = sharedPreferences.getString(mobno,"mobilenumber");
        storageReference=FirebaseStorage.getInstance().getReference().child(isMobile);
        reference=FirebaseDatabase.getInstance().getReference("Usersdata").child(isMobile);
        progressBar=(ProgressBar)findViewById(R.id.studentprogress);
        next=findViewById(R.id.next);
        addprofileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfilechooser();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Name=name.getText().toString().trim();
                Email=email.getText().toString().trim();
                Achievements=achieve.getText().toString().trim();
                Groups =groups.getText().toString().trim();
                Skills=skills.getText().toString().trim();
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
                     return;
                }
//                if(TextUtils.isEmpty(Achievements)){
//                    Toast.makeText(StudentReg.this, "Please Enter Achievements or No", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(Groups)){
//                    Toast.makeText(
//                            StudentReg.this, "Please Enter Groups or No", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(Skills)){
//                    Toast.makeText(
//                            StudentReg.this, "Please Enter Skills or No", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                 progressBar.setVisibility(View.VISIBLE);
                if(Pass.equals(Cpass) && isNetworkAvailable(getApplicationContext())){
                    firebaseAuth.createUserWithEmailAndPassword(Email,Pass)
                            .addOnCompleteListener(StudentReg.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    // progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Storeuserdata();
                                        saveData();
                                        saveData2();
                                        saveEmail();
                                        Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        Toast.makeText(StudentReg.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                                    } else {
                                        Toast.makeText(StudentReg.this, "Email Already Exist or wrong", Toast.LENGTH_SHORT).show();
                                    }

                                    // ...
                                }
                            });
                }
                else{
                    Toast.makeText(StudentReg.this, "no internet connection", Toast.LENGTH_SHORT).show();
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
        dropdown3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



               Bahawan = parent.getItemAtPosition(position).toString();
               System.out.println(Bahawan);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Spinner departspin=(Spinner)findViewById(R.id.dept);

        mCountryList = new ArrayList<>();
        mCountryList.add(new DepartmentClass("Computer Science", R.drawable.computer));
        mCountryList.add(new DepartmentClass("Electronic and Communication", R.drawable.electrical));
        mCountryList.add(new DepartmentClass("Electrical Engineering", R.drawable.electri));
        mCountryList.add(new DepartmentClass("Civil Engineering", R.drawable.civil));
        mCountryList.add(new DepartmentClass("mechnical Engineering", R.drawable.mechnical));
        mCountryList.add(new DepartmentClass("Production & Industrial", R.drawable.pandi));
        mCountryList.add(new DepartmentClass("Metallurgy", R.drawable.meta));
        mCountryList.add(new DepartmentClass("Physics", R.drawable.phys ));
        mCountryList.add(new DepartmentClass("Engneering physics", R.drawable.phys));
        mCountryList.add(new DepartmentClass("Applied Mathematics", R.drawable.phys));
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
    //    private void openmyGallery() {
//        Intent  gallerycam=new Intent();
//        gallerycam.setType("image/*");
//        gallerycam.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(gallerycam,"Select Image"),PICK_IMAGE);
//
//    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE&& data.getData()!=null&&data!=null){
//            imageUri = data.getData();
//            try{
//                Bitmap bitmap =MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
//                addprofileImageView.setImageBitmap(bitmap);
//            }
//            catch (IOException e){
//                     e.printStackTrace();
//                }
//
//        }
//    }
    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Registered,true);
        editor.apply();
    }
    public void saveEmail(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(emailjio,Email);

        editor.apply();
    }
    /**/


//    private void uploadfile() {
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Uploading");
//        progressDialog.show();
//
//       // final StorageReference profileImageRef = FirebaseStorage.getInstance().getReference("profilepics/" + System.currentTimeMillis() + ".jpg");
//
//        if (imageUri != null) {
//            File file = new File(String.valueOf(imageUri));
//            FirebaseStorage storage = FirebaseStorage.getInstance();
//            StorageReference storageRef = storage.getReference().child("images");
//
//            storageRef.child(file.getName()).putFile(imageUri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//
//                            Task<Uri> downloadUri = taskSnapshot.getStorage().getDownloadUrl();
//
//                            if(downloadUri.isSuccessful()){
//                                profileImageUrl = downloadUri.getResult().toString();
//                                System.out.println("## Stored path is "+profileImageUrl);
//                            }}
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//
//                        }
//                    });
//
//        }
//        else
//            Toast.makeText(this, "Please Select a Image", Toast.LENGTH_SHORT).show();
//
//
//
//
//
//    }

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
                Picasso.get().load(resultUri).into(addprofileImageView);
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
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }

    }

    /* */
    public void saveData2(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(GetStart,true);
        editor.apply();
    }
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
    private void Storeuserdata() {

        userHelperClass=new UserHelperClass(Name,isMobile,Email,Achievements,Groups,Skills,Studentyear,StudentDepartment,Bahawan,newUri);
        reference.setValue(userHelperClass);
    }
    public int getB(){
        return c;
    }

}