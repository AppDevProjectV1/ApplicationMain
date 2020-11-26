package com.campuscompass.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appdevproject.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class  IndividualUserProfile extends AppCompatActivity {


    //   private FirebaseDatabase allkadatabase= FirebaseDatabase.getInstance();
    private DatabaseReference databaseReferenceall ;


    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    private  ImageView profiletab,feedstab,inboxtab;
    private ImageView img,imagesearchView,editprofilebutton;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CircularImageView profileImageView;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    public int b=1;
    String Nameji ;
    String emailji ;
    String  yeraji ;
    String deptji ;
    String skillji ;
    String acheivementsji ;
    String groupji ;
    String hostalji ;
    String imageji;
    public ArrayList<String> selections;
    public  TextView   userterenaam,useremail,useryear,userdept,userhostal,userachievements,userskills,usergroups;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String loggedin="loggedin";
    public static final String  Registered="registered";
    public static final String  mobnore="phono";
    public  String ismobile;
    androidx.appcompat.app.ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_user_profile);


//        selections=getIntent().getStringArrayListExtra("selectedOpts");


//        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
//        ismobile = sharedPreferences.getString(mobnore, "mobilenumber");

         Intent intentji=getIntent();
       ismobile=intentji.getStringExtra("apkmobile");
        profileImageView = findViewById(R.id.profileimageview);
        userterenaam = findViewById(R.id.name);
        useremail = findViewById(R.id.email);
        useryear = findViewById(R.id.year);
        userdept = findViewById(R.id.dept);
        userhostal = findViewById(R.id.hostel);
        userachievements = findViewById(R.id.AchievementStudent);
        userskills = findViewById(R.id.SkillsStudent);
        usergroups = findViewById(R.id.groupsStudent);

        databaseReferenceall = FirebaseDatabase.getInstance().getReference("Usersdata").child(ismobile);
        databaseReferenceall.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Nameji = dataSnapshot.child("username").getValue().toString();
                emailji = dataSnapshot.child("email").getValue().toString();
                yeraji = dataSnapshot.child("year").getValue().toString();
                deptji = dataSnapshot.child("dept").getValue().toString();
                skillji = dataSnapshot.child("mskills").getValue().toString();
                acheivementsji = dataSnapshot.child("machievements").getValue().toString();
                groupji = dataSnapshot.child("mgroups").getValue().toString();
                hostalji = dataSnapshot.child("mbahawan").getValue().toString();
                imageji = dataSnapshot.child("imageUrl").getValue().toString();
                userterenaam.setText(Nameji);
                useremail.setText(emailji);
                userdept.setText(deptji);
                useryear.setText(yeraji + " year");
                userhostal.setText(hostalji);
                userachievements.setText(acheivementsji);
                usergroups.setText(groupji);
                userskills.setText(skillji);
                Glide.with(getApplicationContext()).load(imageji).into(profileImageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });








    }





}