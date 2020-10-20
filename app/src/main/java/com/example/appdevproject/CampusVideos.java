package com.example.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class CampusVideos extends AppCompatActivity {
    private RecyclerView Campusvideoslist;
    private  ArrayList<CampusVideoClass> mVideoList;
    private CampusVideoAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_videos);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Campusvideoslist=(RecyclerView)findViewById(R.id.recyclevideo);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        Campusvideoslist.setLayoutManager(layoutManager);
       Campusvideoslist.setHasFixedSize(true);
        String[] campusvideolinks={"Co4CGjYwHF4","b7xePppEUIU","IipII2Eq8sM","EUei7-LIP7c","CfsMrBxmMd8","ZlWyNhq7sUs","GKB0EsH8-Xk","Uhrt8h4ajFg","TyLwbXwBPVk","xbxwwYbD5Rw","O_3UjdtZotM","JQJykIgVrHM","u514fr4ve8w","2JWF-H5tHVo","6T_T07hglvk","nNIVVciZDrs","VqA9EkHsns4","9PBfIdqb15E","izVw4y3brtY","nDCfqBgFJoQ","gmRCHMoqWiE","oNUk19ImCp0","CeHLn9qHXPs","6KtoO6G3EvM","-bSsZkaXHa0","7QHtfqaycNQ","Wfvsv7faCQk","kD8ZvzmgVlo","D5g_xuP3IuI","EEJoV7jD1yc","pd2UN1xPxQ4","bOzwvRhMUYE","sfAQUZXlzL0","OqINFNQStqU","2kZyut1YaEI","OpbB4VlgtfU","iBlTDjC_L9g","S3-uYYpYWzc","c2JjDwmitQg","n7Eul5N1MIo","dmDtH9beJ_Y","FDKFGReqMvk","WThtXSymFfk","-m39zlyngnI","NGPApDVOQ9o","XxUvWD2PJEo"};

//        mVideoList.add(new CampusVideoClass("Production & Industrial", R.drawable.pandi));
//        mVideoList.add(new CampusVideoClass("Metallurgy", R.drawable.meta));
//        mVideoList.add(new CampusVideoClass("Physics", R.drawable.physics));
//        mVideoList.add(new CampusVideoClass("Engneering physics", R.drawable.physics));
//        mVideoList.add(new CampusVideoClass("Applied Mathematics", R.drawable.electri));
//        mVideoList.add(new CampusVideoClass("Chemistry", R.drawable.chemistry));
//        mVideoList.add(new CampusVideoClass("Architecture", R.drawable.archti));
//        mVideoList.add(new CampusVideoClass("GT", R.drawable.gt));
//        mVideoList.add(new CampusVideoClass("Hydrology", R.drawable.hydrology));
//        mVideoList.add(new CampusVideoClass("Chemical Engineering", R.drawable.chemical));
//        mVideoList.add(new CampusVideoClass("Earth Science", R.drawable.earthscience));
//        mVideoList.add(new CampusVideoClass("Polymer Science", R.drawable.polymer));
//        mVideoList.add(new CampusVideoClass("Bio Techonology", R.drawable.biotech));
//        mVideoList.add(new CampusVideoClass("Earhtquake Engineering", R.drawable.earthquake));

       mAdapter = new CampusVideoAdapter(campusvideolinks,getLifecycle());
        Campusvideoslist.setAdapter(mAdapter);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}