package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appdevproject.R;

public class Clubs extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NavDeptAdapter navDeptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);



        String[] clubnames={"Photography",
                "Gardening" ,
                "Star Gazing" ,
                "Students Club",
                "Himalayan Explorer's Club(HEC)"

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

                "Physics & Astronomy Club is a group of Science enthusiasts of campus who want to cherish their love for Science and create and preserve an environment where one can cherish one's love for Science. Our usual activities include Star Parties, Physics Journal Club, Webinars with working Scientists, Group Discussion sessions, and projects on Astronomical Technology. We are also experimenting with some new activities like Astrophotography, Theoretical Physics Projects, Experimental Physics Projects, and Astronomical Trips.",


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



                "In July 1975 the first major high altitude expedition in the Himalayas was organized successfully in joint collaboration with the Nainital Mountaineering Club, Nainital. With effect from the academic session of 1975-76 , the Mountaineering and Trekking Club was rechristened as the Himalayan Explorers' Club (HEC). Between July 1976 and August 1977 , the HEC organized a series of three major expeditions in the Garhwal Himalayas (to Mt. Rudragaigra (19500 ft) in July 1976, to Mt. Thelu (20,000 ft) in October 1976 and to Mt. Kedar Dome (23,000 ft) in June 1977) in which as many as 35 students of the University of Roorkee participated.\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "With effect from the academic session of 1978-79 , the Himalayan Explorers' Club was accorded the status of a separate functional body. As an independent body, HEC, was restructured and to start with had three different sections:\n" +
                        "\n" +
                        "The High Altitude Adventure Center\n" +
                        "The Regional Development Center\n" +
                        "The Conditioning And Training Center\n" +
                        "\n" +
                        "\n" +
                        "In its enlarged form as of today, HEC encompasses three more sections. They are:\n" +
                        "\n" +
                        "The Database Management Section\n" +
                        "The Event Management Section\n" +
                        "The Rangering and Rovering Section\n" +
                        "\n" +
                        "\n" +
                        "In addition to organizing mountaineering and high altitude trekking expeditions, rock and ice craft training camps, HEC has during the last ten years pioneered in the field of organizing a new generation of Himalayan expeditions which seek to combine high adventure feats with a whole range of specialized creative endeavors in the Himalayas.\n"




        };



        recyclerView=findViewById(R.id.clublist);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NavDeptAdapter(clubnames,clubimages,clubinfo));


    }
}