package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.appdevproject.R;

public class Clubs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NavDeptAdapter navDeptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        String[] clubnames={"Photography",
                "Gardening" ,

                "Students Club"


        };

        Integer[] clubimages={ R.drawable.photogrphy,
                R.drawable.gardening,
                R.drawable.stars,
                R.drawable.ugclub,
                R.drawable.hec,
        };
        String[] clubinfo={
                "Photography Section is home for your passion where you will learn more, explore more and create more..!!\n" +
                        "\n" +
                        "Capturing today for tomorrow..!!",


                "GARDENING SECTION of Hobbies club is the section which loves nature and lives with the motive that they reject sham & look for what is real.\n" +
                        "\n" +
                        "Gardening is the practice of growing and cultivating plants as part of horticulture. In gardens, ornamental plants are often grown for their flowers, foliage, or overall appearance; useful plants, such as root vegetables, leaf vegetables, fruits, and herbs, are grown for consumption, for use as dyes, or for medicinal or cosmetic use. Gardening is considered to be a relaxing activity for many people.",

                " Students club is located in the heart of campus and is a major stress buster for students after hectic work loads and tutorials. Students can fancy themselves various indoor games like\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Table Tennis\n" +
                        "\n" +
                        "Pool\n" +
                        "\n" +
                        "Billiards\n" +
                        "\n" +
                        "Snooker\n" +
                        "\n" +
                        "Carrom\n" +
                        "\n" +
                        "Foose Ball\n" +
                        "\n" +
                        "The club is a major center of attraction especially during cricket matches as it has a 29 inch color TV with the perfect ambience and surround sound which makes watching cricket matches a really wonderful experience. Various section of Cultural Society conducts these Quizzes & rehearsal of programmes throughout the year in T.V. Hall. A rink just outside the students club an ideally place for celebration of Festival & putting install during COGNIZENCE & THOMSO.",







        };



        recyclerView=findViewById(R.id.clublist);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NavDeptAdapter(clubnames,clubimages,clubinfo));


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