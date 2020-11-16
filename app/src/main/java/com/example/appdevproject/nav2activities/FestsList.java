package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.appdevproject.R;

public class FestsList extends AppCompatActivity implements FestAdapter.linkClickListener {

    private RecyclerView recyclerView;
    private NavDeptAdapter navDeptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fests_list);

        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String[] festnames={
                "Thomso",
                "Cognizance",
                "Shrishti",
                "National Social Summit",
                "E Summit"
               };


        Integer[] festimages={ R.drawable.thomsonew,
                R.drawable.cogni,
                R.drawable.shrishti,
                R.drawable.ss,
                R.drawable.es
               };


        String[] festinfo={"Thomso is the annual cultural festival of IIT Roorkee, widely proclaimed to be one of the largest college festivals of the nation.\n" +
                "Thomso is the annual cultural festival of Indian Institute of Technology, Roorkee, which has also been recognized as the \"Annual Youth Festival of Uttarakhand\". Regarded as one of the greatest and the grandest youth festivals of India, Thomso encompasses in itself lavish history, splendid culture and a profoundly rich heritage of IIT Roorkee. The previous editions of the festival have witnessed the likes of Sunidhi Chauhan, Nikhil D Souza, DJ Marnik, Raghu Dixit Project, Farhan Akhtar, KK, Mohit Chauhan, Sonu Nigam, Shaan, Indian Ocean, Parikrama, Jal - The Band, Benea Reach and many more performing at the Pronites. The 35th edition of Thomso will be organized from Oct. 27 to Oct. 29 2017. The theme of Thomso ’17 is “A Magical Fantasia”. A mystical setting and fanatical aura surrounding it, brace yourself for a trip down magical lane. Thomso has always been about discovering the youth in ourselves. What could be better than fantasizing the world of ‘Magic and Fantasy’ and Thomso would have all of this on offer in October. The spell, the charms and the potions have always fascinated us, Thomso provides us a getaway to relinquish these and explore the occults involving the Hogwarts and Narnia among others. So this 27th-29th October, 2017 let’s dive into the world of wizardry and mystery, and traverse to relish the pledge, the turn and the prestige.",



                "Cognizance is the annual technical fest of IIT Roorkee. With this editions’ theme ‘Eccentricity of Excellence’, it is our ambition to manifest the thesis that perfection is not attainable, but if we are off to the path of perfection we can often catch excellence.",



                "Srishti is the Annual Technical Exhibition of IIT Roorkee that aims towards integrating all realms of technical activities conducted within the R-land.\n" +
                        "\n" +
                        "Since its inception in 1958, Srishti has inspired the brilliant minds of our institute to come up with creative ideas and practical innovations.",


                "National Social Summit is a premier festival under the aegis of NSS IIT Roorkee that celebrates people and students that work and think for the betterment of the nation. Join us if you feel you are the change!\n" +
                        "The National Social Summit is a resolution to come together and propose technical solutions to the country’s socio-economic problems. Our tagline, “Curing Indifferences” revolves around providing a common platform to NSS chapters and other socially active groups in IITs and other prestigious institutions as well as NGOs, to collaborate and discuss the possibility of working towards the betterment of the society by sensitizing people about the pertaining problems, in an integrated way.",




                "E-Summit being the flagship event of ECell, is held annually brings together the academic community, venture capitalists, new age entrepreneurs and all those passionate about entrepreneurship to common grounds. It provides an avenue to exhibit the entrepreneurial talent and creativity through many events like business ventures, product design competition, and social entrepreneurial idea competition.\n" +
                        "THEME\n" +
                        "\n" +
                        "Create impact and keep on innovating. In a startup journey there are three major stages: 0, 1 and n. At 0, you are just beginning and your idea is all you have. At 1, you have your startup established. At n, your startup is expanding and scaling-up. In the journey from 0 to 1, we hope to create something that would impact the society in a huge way. We want to disrupt the usual flow of the way things work. In the journey from 1 to n, every startup while scaling-up faces a lots of disruptions. With these constant disruptions it becomes difficult to keep on innovating. This year, we explore the ways to deal with these Dilemmas of Disruption. Join us as we try to inspire and to prepare the next wave of Indian Entrepreneurs who know how to create impact and keep on innovating!"




                 };


        String[] links={"https://www.facebook.com/thomsoiitroorkee/","https://www.facebook.com/cogni.iitr/","https://srishti.iitr.ac.in/",
                "https://nationalsocialsummit.org/","https://www.esummit.in/"};



        recyclerView=findViewById(R.id.festslist);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new FestAdapter(festnames,festimages,festinfo,links,this));


    }

    @Override
    public void onListItemClick(String link) {

        startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(link)));
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