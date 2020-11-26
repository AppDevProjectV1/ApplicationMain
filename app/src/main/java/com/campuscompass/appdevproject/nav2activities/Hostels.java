package com.campuscompass.appdevproject.nav2activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.appdevproject.R;

public class Hostels extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NavDeptAdapter navDeptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostels);

        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String[] hostelnames={"Azad Bhawan" ,
                "Cautley Bhawan" ,
                "Ganga Bhawan" ,
                "Govind Bhawan" ,
                "Jawahar Bhawan" ,
                "Radhakrishnan Bhawan" ,
                "Rajendra Bhawan" ,
                "Rajiv Bhawan" ,
                "Ravindra Bhawan" ,
                "Malviya Bhawan",
                "Sarojini Bhawan",
                "Kasturba Bhawan"
        };

        Integer[] hostelimages={ R.drawable.azad,
                R.drawable.cautlay,
                R.drawable.ganga,
                R.drawable.govind,
                R.drawable.jawahar,
                R.drawable.radakrishna,
                R.drawable.rajendra,
                R.drawable.rajiv,
                R.drawable.ravindra,
                R.drawable.malviya,
                R.drawable.sarojini,
                R.drawable.kasturba
        };
        String[] hostelinfo={ "Bhawans has facility of  carom board, chess, Table Tennis. Comfort of Students: Bhawan have all the amenities like Barber shop, Tailor Shop, Cafeteria for the use of its inmates. Bhawan has got almost all of its bathroom renovated. The whole Bhawan is networked through wireless network (Wi-Fi) working 24 hours. Bhawan comprises one new wing having 66 rooms (Single seated).",

                "Cautley Bhawan being one of the oldest structure, has always been reckoning for its construction plan and strong healthy principled environment. This Bhawan with its infrastructure and facilities like Gym, SBI-ATM, T.V. Hall. Lipton, a huge canteen and above the beautiful greenery around, make the Bhawan a prefect place in IIT Roorkee to live in. Recently, a new block of 201 seat in year 2001 was established. Now a new building (72 double seated room) is under construction, making a total strength of Cautley Bhawan around 657 seats.",

                "Ganga Bhawan, one of the oldest in IIT Roorkee, was named after Sir Ganga Ram, one of the greatest products of the erstwhile Thomason College of Engineering. The foundation stone of D.S. hostel D Block (presently 'A' Block) was laid by Sri B.R. Sabbarwal, Retired Chief Engineer, Bengal on Nov. 26,1956. This wing was opened by Ch.Girdhari Lal, Minister for Irrigation, Power and P.W.D., U.P. Government on Nov. 27 1960. Ganga Bhawan, inspite of being the oldest in the institute provides the modern amenities and facilities to its residents and caters well to the needs of the 650 odd residents of the bhawan alongwith new equipped modern mess facility.",


                "Govind Bhawan is one of the oldest hostels in the campus with its foundation stone laid by Shrimati Durgabhai Deshmukh,Chairman,Social Welfare Board on 25th April,1957,& subsequently opened by Shri Hafiz Muhammed Ibrahim,Union Minister of Irrigation & Power on April 16,1958. It comprises of 2 new wings having a total of 114 rooms inaugurated 2 years back by then Director Dr. Premvrat. Construction of a whole new wing having 84 single seated rooms has been completed, which is soon to be inaugurated, and construction of 2 new wings having a total of 45 rooms is under process. The Bhawan has all the amenities like barber shop, tailor shop, STD/PCO for the comfort of students. Bhawan has facility of a small library, carrom board, chess, Table Tennis and music room (which has Drum, Synthesizer, Fluets, Guitar and Violin) for the use of its inmates. The whole bhawan is networked through wireless network (Wi-Fi) working 24x7.",



                "Jawahar Bhawan is one of the oldest and most beautiful bhawans in the institute. Its large and spacious rooms are a abode to talented IITians. Its sprawling and well maintained lawns are the best of all bhawans. Jawahar is the only bhawan to have its own club with a billiards and pool table, with sports facilities such as table tennis, volleyball and tennis courts and other facilities like 24 hour cyber room, Wi-Fi connectivity in each room, tailor, canteen and barber shop Jawahar bhawan provides an ideal environment for the overall development of a true IITian.",


                "Named after the legendary teacher, visionary, philosopher, humanist and former President of India, Dr. S. Radhakrishnan, the Radhakrishnan Bhawan is the latest bhawan of IIT Roorkee. It is the first of its kind in more respects than one, the first multi-storied hostel comprising 8 storeys including the ground floor, the first Bhawan to have Lift facility and also the first bhawan that has outsourced all its services including the Mess and House-keeping. Its massive structure resembles the New Taj of Mumbai and is everybody's delight in its full view at night. This is the first bhawan to have 24 hour electric supply with the facility of state of the art generator. The Bhawan has a huge dining Hall capable of catering to 1300 students and a wide open  terrace over it with four domes of transparent glass. It has a Recreation Hall on the Ground Floor having recreational facilities and also a canteen. Being a new Bhawan that started functioning quite recently, i.e. from 19 July, 2010, it is still in the process of creating facilities like, Cyber Cafe, Music Room, Badminton and Volleyball Courts, Reading Room, Library , Science Club etc. The Bhawan, nonetheless, is one of the most vibrant and dynamic with lot of academic and co-curricular activities going on all the time. Promises to be one of the best on the campus in time to come.",


                "Rajendra Bhawan exults of being the latest boys bhawan of IIT Roorkee.Deriving its name from the ascetic President of India Dr. Rajendra Prasad. The whole Bhawan is divided into Three wings, the new wing (all rooms single seated), “A” block (all rooms double seated) and “B” Block (all rooms double seated).The “A” Block wing was a previously a part of the Ganga Bhawan, opposite Rajendra Bhawan but after the completion of “B” block in 1989 the “A” Block and “B” Block together came to be known as Rajendra Bhawan. Since then it has been acting as a second home exclusively for all undergraduate students joining this Institute. At present total 218 double seated and 165 single seated rooms are available in the Bhawan and 32 new single seated rooms are under construction. The Bhawan is also having a small library for the use of its inmates. This hostel boast its large and beautiful lawns.",



                "Rajiv Bhawan is the newest jewel among the 19 hostels of IIT Roorkee. It is named on the 6th prime minister of India, Rajiv Gandhi. It was on 27 October, 2008 that the founding stone of the Bhawan was laid by the then director of IITR , Dr. S.C. Saxena. The construction was completed on 12 November 2010.The Bhawan came to be known in its present inhabitable form on 17 July, 2011, when the students first walked in.\n" +
                        "\n" +
                        " \n" +
                        "Rajiv Bhawan boasts of 675 rooms distributed between 6 floors, dining mess , canteen and 8 guest rooms. The bhawan also has a state of art cyber cafe with 20 high end desktop computers, a party room and a common room with HD television , 2 table tennis tables , 2 foosball tables ,2 caroms and 6 chess boards. It also has a washing room with 6 front loading fully automatic washing machines. The bhawan provides ease of accessibility with 6 lifts. Bhawan inmates also enjoy high speed internet through wired LAN. Rajiv Bhawan also boasts of an eco friendly design with solar powered water heater and lighting.\n" +
                        " ",


                "Ravindra Bhawan  was established as Engineer Student's Hostel. It was inaugurated by Shri V.V.Giri, Chancellor of the then University of Roorkee (now Indian Institute of Technology Roorkee) & Governor of Uttar Pradesh on the auspicious day of Tuesday, the November 24th in the year 1959. According to hindi calendar this day was 3 Margshirsha 1881 (Saka).\n" +
                        "Since then Ravindra Bhawan has always occupied an important place among all the hostels of this coveted campus. It has been home for all the 4th yearites till 2003. In the August of 2003 when all the hostels were jumbled, 2nd & 3rd yearites too got chance to occupy room in this centrally located hostel. It marked a phase change in Ravindra Bhawan's history. Its now colourful student community is bound to take Ravindra Bhawan to new heights. In continuation of this very effort Bhawan's website is being launched on its Bhawan Day, the 11th March 2005. The Bhawan has been recently provided with Wi-Fi facility in each room. Cyber Cafe, Gym Room and T.T. Room facilities have been provided since 2004. The capacity of the Bhawan has been increased by 72 rooms by adding 03 new wings in August, 2007",




                "The Malviya Bhawan, established in 2010 is the boys hostel of the Saharanpur campus of IIT Roorkee. In terms of infrastructure, it's one of the best with single rooms for every student, and facilities ranging from table tennis room to tv room. It provides everything a student can ask for in a hostel. The gardens provide aesthetic value and mess provides nutritious food keeping the students fit and nourishd in their home away from home.",

                "Sarojini Bhawan, the first Girls Hostel in IIT Roorkee, was established in the year 1966-67 by Smt. Lakshi Kanntamma Reddy.As the time passed,it was extended four times. The wing named Krishna was constructed in year 1985-86 and the second extension,which resulted in the Disang wing ,was build in year 1988-89.The Alaknanda wing was constructed in 2000-2001. The Newest wing,Sabarmati was built in 2002-2003. The name of the bhawan is dedicated to the Nightangle of India, Sarojini Naidu, who is an inspiration for all girls that sky is the limit. The WINGS are named after the four pious rivers that flow from the four directions of our sacred country. In addition to this the construction of the wing is such that each one has a separate lawn in front with a beatific garden that is well maintained by the gardeners. Furthermore Bhawan has a well furnished COMPUTER ROOM (Cyber Cafe), WASHING MACHINE ROOM and T.V. ROOM with the premises of the Bhawan. To boast about the bhawan sooner a GYM ROOM is going to get established. Moreover, the WI-FI connection has also been set up in 2007 for the convenience of the girls. Apart from the above said facilities a small CANTEEN and a STATIONARY SHOP are there in the Bhawan itself. Lots of construction has been done to provide the best ventilation in the mess kitchen. A ROTI MAKER MACHINE has been provided in the mess. Emergency light is also provided in the MESS to meet the power cut. The idea of keeping a stereo player in the mess is in progress. In short SAROJINI BHAWAN IS SUPPOSED TO BE THE WELL FURNISHED Bhawan.",

                "Kasturba Bhawan is the latest addition to the group of hostels present in IIT Roorkee and it is the second Girls Hostel with Sarojini Bhawan being the first and foremost bhawan. Intercom connection installed in the Bhawan"





        };



        recyclerView=findViewById(R.id.hostellist);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NavDeptAdapter(hostelnames,hostelimages,hostelinfo));
        recyclerView.setNestedScrollingEnabled(false);

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