package com.example.appdevproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CampusGroupActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_group);

        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
       ListView  listgroups=(ListView)findViewById(R.id.grouplist);

        final ArrayList<ModelClass> groupslists=new ArrayList<ModelClass>();
        groupslists.add(new ModelClass(R.drawable.dsg,"Data Science Group, IITR","https://www.facebook.com/dsgiitr/"));
        groupslists.add(new ModelClass(R.drawable.sds ,"SDSLabs","https://www.facebook.com/SDSLabs/"));
         groupslists.add(new ModelClass(R.drawable.mdg,"Mobile Development Group, IIT Roorkee","https://www.facebook.com/mdgiitr/"));
        groupslists.add(new ModelClass(R.drawable.img,"IMG, IIT Roorkee","https://www.facebook.com/IMGIITRoorkee"));
        groupslists.add(new ModelClass(R.drawable.vlg,"VLG IITR","https://www.facebook.com/vlgiitr/"));
        groupslists.add(new ModelClass(R.drawable.paac,"Physics & Astronomy Club, IIT Roorkee","https://www.facebook.com/physastroclubiitr/"));
        groupslists.add(new ModelClass(R.drawable.asme,"ASME IIT Roorkee Chapter","https://www.facebook.com/asmeiitr"));
        groupslists.add(new ModelClass(R.drawable.pag,"PAG IITR","https://www.facebook.com/groups/sdspag"));
       groupslists.add(new ModelClass(R.drawable.mars,"Models and Robotics Section- MARS, IIT Roorkee","https://www.facebook.com/marsiitr"));
        groupslists.add(new ModelClass(R.drawable.robocon,"Team Robocon IITR","https://www.facebook.com/roboconiitr"));
       groupslists.add(new ModelClass(R.drawable.ecell,"E-Cell IIT Roorkee","https://www.facebook.com/ecelliitr"));
       groupslists.add(new ModelClass(R.drawable.aries,"ArIES: Artificial Intelligence and Electronics Society, IITR","https://www.facebook.com/ariesiitr"));
        groupslists.add(new ModelClass(R.drawable.share,"ShARE IITR","https://www.facebook.com/shareiitr/"));
       groupslists.add(new ModelClass(R.drawable.enactus,"Enactus IIT Roorkee","https://www.facebook.com/enactusiitroorkee"));
        groupslists.add(new ModelClass(R.drawable.motor,"IIT Roorkee Motorsports","https://www.facebook.com/iitrms.in"));
        groupslists.add(new ModelClass(R.drawable.design,"Design Studio","https://www.facebook.com/designstudio.iitr"));
        groupslists.add(new ModelClass(R.drawable.smp,"Student Mentorship Program, IIT Roorkee","https://www.facebook.com/MentorshipIITR"));
        groupslists.add(new ModelClass(R.drawable.iarc,"Institute Alumni Relations Cell, IIT-Roorkee","https://www.facebook.com/alumnicelliitr"));
        groupslists.add(new ModelClass(R.drawable.copi,"Corporate Interactions Group, IIT Roorkee","https://www.facebook.com/cig.iitroorkee/"));
        groupslists.add(new ModelClass(R.drawable.uba,"Unnat Bharat Abhiyan, IIT Roorkee","https://www.facebook.com/uba.iitroorkee/"));
        groupslists.add(new ModelClass(R.drawable.eco,"ECO Group IIT Roorkee","https://www.facebook.com/ecoiitr"));
        groupslists.add(new ModelClass(R.drawable.cec,"Civil Engineering Consortium, IIT Roorkee","https://www.facebook.com/cec.iitroorkee/"));
      groupslists.add(new ModelClass(R.drawable.sae,"SAE IIT Roorkee","https://www.facebook.com/SAEIITR"));
        groupslists.add(new ModelClass(R.drawable.heciit,"H.E.C IIT Roorkee","https://www.facebook.com/HECIITR/"));
        groupslists.add(new ModelClass(R.drawable.watchout,"Watch Out, IIT Roorkee","https://www.facebook.com/watchoutiitr"));
       groupslists.add(new ModelClass(R.drawable.kshitij,"Kshitij - The Literary Magazine","https://www.facebook.com/kshitijiitr"));
        groupslists.add(new ModelClass(R.drawable.cinsec,"Cinematic Section, IIT Roorkee","https://www.facebook.com/cinesecIITR"));
       groupslists.add(new ModelClass(R.drawable.drama,"Dramatics Section, IIT Roorkee","https://www.facebook.com/dramaticsiitr"));
       groupslists.add(new ModelClass(R.drawable.audio,"AUDIO Section IITR","https://www.facebook.com/audiosection.iitr"));
        groupslists.add(new ModelClass(R.drawable.music,"Music Section, IIT Roorkee","https://www.facebook.com/musicsectioniitr"));
      groupslists.add(new ModelClass(R.drawable.coreo,"Choreography and Dance section IIT Roorkee","https://www.facebook.com/choreo.iitr"));
        groupslists.add(new ModelClass(R.drawable.fine,"Fine Arts Section IIT Roorkee","https://www.facebook.com/FineArtsIITR"));
        groupslists.add(new ModelClass(R.drawable.cry,"Child Rights & You - CRY IIT Roorkee Chapter","https://www.facebook.com/CRY.Roorkee"));
        groupslists.add(new ModelClass(R.drawable.sanskrit,"Sanskrit Club IITR","https://www.facebook.com/sanskritiitr/"));

        GroupAdapter adapter=new GroupAdapter(this,groupslists);
        listgroups.setAdapter(adapter);
        listgroups.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ModelClass modelweb =groupslists.get(position);

                Intent intent = new Intent(CampusGroupActivity.this,groupinfo.class);
                 intent.putExtra(Intent.EXTRA_TEXT,modelweb.getMurl());
                 startActivity(intent);

            }
        });
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





