package com.example.appdevproject;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentFeeds extends AppCompatActivity {

    private ImageView profiletab,feedstab,inboxtab;
    private RecyclerView recyclerViewinterest;
    private ArrayList<InterestsClass> interestsClasseslist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_feeds);
        //  use the actionbar here for go to previous activity

        profiletab=findViewById(R.id.profiletab);
        feedstab=findViewById(R.id.feedstab);
        inboxtab=findViewById(R.id.inboxtab);
        recyclerViewinterest=(RecyclerView)findViewById(R.id.interestrecycleview);
       recyclerViewinterest.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewinterest.setHasFixedSize(true);
         recyclerViewinterest.setNestedScrollingEnabled(false);
        interestsClasseslist=new ArrayList<InterestsClass>();
        interestsClasseslist.add(new InterestsClass("    Coding Languages","Three Important languages we have to learn for all coding skills."+"\n"+"1] C++"+"\n"+"2] Java"+"\n"+"3] Python",R.drawable.w3sch,R.drawable.codecademy,R.drawable.geeksforgeeks,R.drawable.sololearn,"https://www.w3schools.com/","https://www.codecademy.com/","https://www.geeksforgeeks.org","https://play.google.com/store/apps/details?id=com.sololearn"));
        interestsClasseslist.add(new InterestsClass("Competitive Programming","Always keep yourself motivated enough to solve the problem, it will help you in enhancing your problem solving skills. As now you have good knowledge of Data Structures and Algorithms you can do really well in world of Competitive programming if you keep practicing continuously.",R.drawable.hackji,R.drawable.geeksforgeeks,R.drawable.codechefji,R.drawable.youtube,"https://www.hackerrank.com","https://www.geeksforgeeks.org","https://www.codechef.com","https://www.youtube.com/watch?v=lxja8wBwN0k&list=PLKKfKV1b9e8ps6dD3QA5KFfHdiWj9cB1s"));
         interestsClasseslist.add(new InterestsClass("  Quantum Computing","Quantum computing is an area of computing focused on developing computer technology based on the principles of quantum theory, which explains the behavior of energy and material on the atomic and subatomic levels.Quantum computing, on the other hand, uses quantum bits or qubits.",R.drawable.acm,R.drawable.coursera,R.drawable.udacity,R.drawable.youtube,"https://medium.com/@acmiitr/guide-to-quantum-computing-d9249d400e2","https://www.coursera.org/learn/quantum-computing-lfmu","https://www.udemy.com/course/qc101-introduction-to-quantum-computing-quantum-physics-for-beginners/","https://www.youtube.com/watch?v=S52rxZG-zi0"));
        interestsClasseslist.add(new InterestsClass("         Data Science","Data Science has three parts-"+"\n"+"1) Data Analytics-[Microsoft Excel,SQL,Numpy,Pandas,tableau,Probability and Statistics]."+"\n"+"2) Machine Learning-[Two Frameworks-Tenserflow and Pytorch,scikit learn]"+"\n"+"3) Deep learning.",R.drawable.coursera,R.drawable.dsg,R.drawable.udemy,R.drawable.youtube,"https://www.coursera.org/learn/machine-learning?utm_source=gg&utm_medium=sem&utm_campaign=07-StanfordML-IN&utm_content=07-StanfordML-IN&campaignid=1950458127&adgroupid=72270203673&device=c&keyword=machine%20learning%20mooc&matchtype=b&network=g&devicemodel=&adpostion=&creativeid=351348153584&hide_mobile_promo&gclid=Cj0KCQiA48j9BRC-ARIsAMQu3WQLcDx0fhz_Y8A0V-25bPsC0Z3BMPmhAepo6DULAPvVAXMVwGbAzHEaAp6_EALw_wcB","https://github.com/dsgiitr","https://www.udemy.com/user/joseportilla","https://www.youtube.com/watch?v=PPLop4L2eGk&list=PLLssT5z_DsK-h9vYZkQkYNWcItqhlRJLN"));
        interestsClasseslist.add(new InterestsClass("Mobile App Development","Android Studio is best for Mobile App development.Mobile App development has two ways-"+"\n"+"1) Native Apps by Java and Kotlin."+"\n"+"2) Flutter Apps by Dart.Today Most of the developers choice is flutter.",R.drawable.udemy,R.drawable.coursera,R.drawable.udacity,R.drawable.youtube,"https://www.udemy.com/course/flutter-bootcamp-with-dart/","https://www.coursera.org/specializations/android-app-development","https://www.udacity.com/course/new-android-fundamentals--ud851","https://www.youtube.com/watch?v=O3BVBzV58hg&feature=youtu.be"));
        interestsClasseslist.add(new InterestsClass("    Web Development","Web development has two part-"+"\n"+"1)Frontend-[by HTML,CSS,JavaScript,Bootstrap]."+"\n"+"2)Backend-[by Nodejs & Django]."+"\n"+"\n"+"For Most Professional Web application like linkedin we have to use nodejs.some simple application we can do by python framework Django.Today Most of the developers are learning React for Web development.",R.drawable.udemy,R.drawable.coursera,R.drawable.boot,R.drawable.youtube,"https://www.udemy.com/course/the-complete-web-development-bootcamp/","https://www.coursera.org/specializations/full-stack-react","https://getbootstrap.com/docs/4.5/getting-started/introduction/","https://www.youtube.com/watch?v=JT80XhYJdBw&t"));
        interestsClasseslist.add(new InterestsClass("          Git & Github","For Code Contribution We have to first make account on github.Git bash is a terminal use to push our code on github.",R.drawable.github,R.drawable.git,R.drawable.w3sch,R.drawable.youtube,"https://github.com/","https://git-scm.com/downloads","https://www.w3schools.com/whatis/whatis_github.asp","https://www.youtube.com/watch?v=iR5WIknxdkY"));

        interestsClasseslist.add(new InterestsClass("   Game Development","As you are a beginner in Game Development, it is best to start with a known Game Engine. They are quite useful in general as they provide various functionalities for your games like 3D and 2D graphics rendering, audio support, animation, collision detection, artificial intelligence, networking, etc.The most popular Game Engine is Unity as it is quite easy to learn, and also has the personal edition which is free! Another popular Game Engine is the Unreal Engine which can be modified to create unique games.",R.drawable.sds,R.drawable.youtube,R.drawable.coursera,R.drawable.udemy,"https://github.com/sdslabs/recommends#Game-Development","https://www.youtube.com/playlist?list=PLZlv_N0_O1gbQjgY0nDwZNYe_N8IcYWS-","https://www.coursera.org/learn/game-development","https://www.udemy.com/course/unreale4/"));
        interestsClasseslist.add(new InterestsClass("           Designing","For Designing we have to use software Adobe Illustrator",R.drawable.llustrator,R.drawable.youtube,R.drawable.coursera,R.drawable.udemy,"https://getintopc.com/softwares/graphic-design/adobe-illustrator-cc-2020-free-download/","https://www.youtube.com/watch?v=vd1vRpoWC3M&t","https://www.coursera.org/learn/adobe-illustrator-cc","https://www.udemy.com/course/logodesign/"));
        interestsClasseslist.add(new InterestsClass("         Civil Services","For Civil services examination like UPSC we have to read newspapers daily.because most of the question in upsc are related to current affairs.And we have to read ncert in free time.",R.drawable.epart,R.drawable.indianpol,R.drawable.modern,R.drawable.youtube,"https://play.google.com/store/apps/details?id=in.gov.epathshala","https://zbukarf1.cf/read.php?id=PKElDwAAQBAJ","https://www.pdfdrive.com/modern-india-e33405805.html","https://www.youtube.com/watch?v=DrOWbHHxaSA&list=PLNdRsMqHda58g-ilcmHTy6k534Xw_HhBA"));
        interestsClasseslist.add(new InterestsClass("              Music","If you are really good a singer or a musician  you can explore this field.",R.drawable.musictheory,R.drawable.tutor,R.drawable.youtube,R.drawable.youtube,"https://www.pdfdrive.com/music-theory-from-beginner-to-expert-the-ultimate-step-by-step-guide-to-understanding-and-learning-music-theory-effortlessly-with-audio-examples-book-1-e187392745.html","https://tutorful.co.uk/blog/best-singing-resources-for-2020-1","https://www.youtube.com/watch?v=IrhFwXdj3Q8&list=PLKGvp3fRSRxbidFAk1u1WsEaRgzcdXz-o","https://www.youtube.com/watch?v=wAfbTvEeMmw&list=PLovStLXqoeZ1ncXap2csJ-FKgLuCyPQzY"));



        StudentFeedsAdapter interestsadapter=new StudentFeedsAdapter(this,interestsClasseslist);
        recyclerViewinterest.setAdapter(interestsadapter);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            feedstab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_info_tile) );
            profiletab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
            inboxtab.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_nav_tile) );
        }

     profiletab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
             startActivity(intent);
             finish();
         }
     });

        inboxtab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ChatsActivity.class);
                startActivity(intent);
                finish();
            }
        });









    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(getApplicationContext(),StudentProfile.class);
        startActivity(intent);
    }
}