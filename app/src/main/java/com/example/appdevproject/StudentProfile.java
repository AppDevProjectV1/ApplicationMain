package com.example.appdevproject;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.appdevproject.nav2activities.AboutIITR;
import com.example.appdevproject.nav2activities.FestsList;
import com.google.firebase.auth.FirebaseAuth;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StudentProfile extends AppCompatActivity {
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    private  ImageView profiletab,feedstab,inboxtab;
    private ImageView img,imagesearchView;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CircularImageView profileImageView;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    public int b=1;
    public ArrayList<String> selections;

    public static final String SHARED_PREFS="sharedPrefs";
    public static final String loggedin="loggedin";
    public static final String  Registered="registered";

    androidx.appcompat.app.ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav4_activity_main);


//        selections=getIntent().getStringArrayListExtra("selectedOpts");

        profiletab=findViewById(R.id.profiletab);
        feedstab=findViewById(R.id.feedstab);
        inboxtab=findViewById(R.id.inboxtab);
         imagesearchView=findViewById(R.id.action_hamara_users);
        profileImageView = findViewById(R.id.profileimageview);
        imagesearchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SearchUsersActivity.class);
                startActivity(intent);

            }
        });
        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            feedstab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
            profiletab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_info_tile) );
            inboxtab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
        }


        inboxtab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    feedstab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
                    profiletab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
                    inboxtab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_info_tile) );

                    Intent intent=new Intent(getApplicationContext(),InboxActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT,"student");
                    startActivity(intent);
                    finish();
                }
            }
        });

        profiletab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    feedstab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
                    profiletab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_info_tile) );
                    inboxtab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );


                }
            }
        });

        feedstab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    feedstab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_info_tile) );
                    profiletab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
                    inboxtab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );


                    Intent intent=new Intent(getApplicationContext(),StudentFeeds.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        //casting the drawble layout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        img=(ImageView)findViewById(R.id.profiletoggle);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);
        mDrawerLayout.closeDrawers();

//make an array of custom class object and Assign final because it is used in the other method also
        final DrawerModel[] drawerItem = new DrawerModel[10];
        drawerItem[0] = new DrawerModel(R.drawable.aboutiitrr, "About IITR");
        drawerItem[1] = new DrawerModel(R.drawable.group, "About Groups");
        drawerItem[2] = new DrawerModel(R.drawable.map, "Campus Map");
        drawerItem[3] = new DrawerModel(R.drawable.fests, "Campus Fest");
        drawerItem[4] = new DrawerModel(R.drawable.ic_baseline_sports_handball_24, "Sports");
        drawerItem[5] = new DrawerModel(R.drawable.activity, "Activities");
        drawerItem[6] = new DrawerModel(R.drawable.interests, "My Interests");
        drawerItem[7] = new DrawerModel(R.drawable.ordercan, "Canteen Order");
        drawerItem[8] = new DrawerModel(R.drawable.videocampus, "Campus Videos");
        drawerItem[9] = new DrawerModel( R.drawable.logout, "Log Out");

        //define the custom class adapter called DrawerItemCustomadapter
        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_item_nav,drawerItem);
        //Set the value of adapter to the listview
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDrawerLayout.openDrawer(GravityCompat.START);

            }
        });
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent=new Intent(getApplicationContext(), AboutIITR.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(getApplicationContext(),CampusGroupActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(Locale.ENGLISH,"geo:%f,%f",29.8649,77.8965))));
                        break;

                    case 3:
                        intent=new Intent(getApplicationContext(), FestsList.class);
                        startActivity(intent);
                        break;

                    case 4:
                        intent=new Intent(getApplicationContext(),SportsActivity.class);
                        startActivity(intent);
                        break;

                    case 5:
                        intent=new Intent(getApplicationContext(),CampusActivity.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent=new Intent(getApplicationContext(),MyInterests.class);
                        intent.putStringArrayListExtra("selectedOpts",selections);
                        startActivity(intent);
                        break;

                    case 8:
                        intent=new Intent(getApplicationContext(), CampusVideos.class);
                        startActivity(intent);
                        break;


                    case 7:
                        intent=new Intent(getApplicationContext(), CanteenOrderActivity.class);
                        startActivity(intent);
                        break;

                    case 9:
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        saveData();
                        saveData2();
                        break;
                    default:
                        break;
                }
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //calling the setupDrawerToggle method
        setupDrawerToggle();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);


        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;
//I used this to connect the connectfragment because fragment are neccesary to use for adding navigation drawer in the   activities
        switch (position) {
            case 0:
                fragment = new ConnectFragment();
                break;


            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }



    void setupDrawerToggle(){
        mDrawerToggle = new androidx.appcompat.app.ActionBarDrawerToggle(this,mDrawerLayout,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }
    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            profileImageView.setImageURI(imageUri);

        }
    }

    public void saveData2(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(Registered,false);
        editor.apply();
    }
    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(loggedin,false);
        editor.apply();
    }
}