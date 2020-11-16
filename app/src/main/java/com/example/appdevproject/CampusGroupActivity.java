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
import android.os.StrictMode;
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
        groupslists.add(new ModelClass(R.drawable.quantumcomputing,"Quantum Computing Group", "This is a new group in iitr for quantum computing field.Student can explore the new field which is based on quantum theory with the help of this group.","https://www.facebook.com/qcgiitr/"));

        groupslists.add(new ModelClass(R.drawable.dsg,"Data Science Group, IITR", "We are Data Science Group, IIT Roorkee. A student organizaton, part of the umbrella organization Software Development Section. We aim to work on innovative open source projects in the domain of Machine Learning, Deep Learning & Reinforcement Learning, bridging the gap between research and industry. In the process, we fullfil our mission of cultivating and evolving the technical community at IIT Roorkee by organizing lectures, workshops, hackathons spanning the field of Data Science and AI.","https://www.facebook.com/dsgiitr/"));
        groupslists.add(new ModelClass(R.drawable.sds ,"SDSLabs","SDSLabs or Software Development Section Laboratories is a student-run technical group at IIT Roorkee, which aims to encourage the development of technology and innovation in the campus and beyond. We believe in learning and sharing knowledge; collaboration and experimentation; and human interaction that matters the most.\n" +
                "\n" +
                "We conduct lectures and workshops on all these topics and also conduct monthly competitions on our various self developed applications.","https://www.facebook.com/SDSLabs/"));
         groupslists.add(new ModelClass(R.drawable.mdg,"Mobile Development Group, IIT Roorkee","Mobile development group, SDS, IIT Roorkee is an active student group directing its efforts towards creating useful mobile applications and promoting tech based leaning for the same. The group is a part of SDSLabs which shares the same motto of promoting tech based activities. See less","https://www.facebook.com/mdgiitr/"));
        groupslists.add(new ModelClass(R.drawable.img,"IMG, IIT Roorkee","IMG (Information Management Group) is a student's group in IIT Roorkee responsible for development and maintainance of internet and intranet applications in the institute, including the website of IIT Roorkee.","https://www.facebook.com/IMGIITRoorkee"));
        groupslists.add(new ModelClass(R.drawable.vlg,"VLG IITR","The Vision and Language Group, part of the ACM IIT Roorkee Chapter, is a student run group which aims to foster a research-centric Deep Learning community at IIT Roorkee.\n" +
                "\n" +
                "We come together once a week to discuss research papers published in the latest Deep Learning conferences. Besides this, we work on research projects aiming to publish in top research conferences.","https://www.facebook.com/vlgiitr/"));
        groupslists.add(new ModelClass(R.drawable.paac,"Physics & Astronomy Club, IIT Roorkee","Physics & Astronomy Club of IIT Roorkee will be a forum to discuss, share, and spread all the interesting conundrums and events happening in the beautiful realm of Astronomy, Physics, and Science in general.","https://www.facebook.com/physastroclubiitr/"));
        groupslists.add(new ModelClass(R.drawable.asme,"ASME IIT Roorkee Chapter","The ASME Student Chapter at IIT Roorkee is an undergraduate club comprised of students majoring in various fields of Engineering. Our mission is to promote and enhance technical competency and professional well-being of our members through quality program","https://www.facebook.com/asmeiitr"));
        groupslists.add(new ModelClass(R.drawable.pag,"PAG IITR","Programming And Algorithms Group is a group of enthusiastic and young programmers under Software Development Section spanning across multiple departments, branches and years in IIT Roorkee with the aim of improving the algorithmic, mathematical and programmatically problem solving capability of students of IIT Roorkee. ","https://www.facebook.com/groups/sdspag"));
        groupslists.add(new ModelClass(R.drawable.mars,"Models and Robotics Section of IIT Roorkee","Models and Robotics Section of IIT Roorkee offers the student body of IIT Roorkee to experience robotics, develop robotic products of commercial value as well as spearhead the technical prowess of IITR in robotics.Models and Robotics Section- MARS, IIT Roorkee.The Models and Robotics Section has been a part of Hobbies Club, IIT Roorkee since the origination of Hobbies Club. This section provides a perfect platform for students to develop their innovative and technical skills such as mechanical, electronics and architectural. This section is a perfect place for transforming his/her imagination into reality.","https://www.facebook.com/marsiitr"));
        groupslists.add(new ModelClass(R.drawable.robocon,"Team Robocon IITR","A student group of IIT Roorkee competing in an international robotic extravaganza, organized by the Asian Broadcasting Unit (Doordarshan in India) in which teams from all over the world participate.","https://www.facebook.com/roboconiitr"));
        groupslists.add(new ModelClass(R.drawable.ecell,"E-Cell IIT Roorkee","Entrepreneurship Cell at IIT Roorkee is a student body which aims to help startups grow at IIT Roorkee.It wants not only to ignite the minds but also to nurture the ideas of one of the most talented students of India. E-Cell IIT Roorkee is committed to build a strong platform for budding entrepreneurs. The vision is to guide the students to take entrepreneurship as a career, as a path to success, as a journey of wisdom.","https://www.facebook.com/ecelliitr"));
        groupslists.add(new ModelClass(R.drawable.aries,"ArIES: Artificial Intelligence and Electronics Society, IITR","We, at ArIES, delineate a cluster of engineering maniacs, where we mold the ideas into reality and envision a better society guided by innovation and advancements that we design. Project Areas we deal with: --> Internet of Things --> Networks --> Control Systems --> Embedded Systems --> Power Electronics --> Signal & Image Processing --> Artificial Intelligence\n" +
                "\n" +
                "Our mission is to acquaint and assist students towards different features of next generation electronics to hone their skills for the helm of technological development.","https://www.facebook.com/ariesiitr"));
        groupslists.add(new ModelClass(R.drawable.share,"ShARE IITR","The IIT Roorkee chapter of ShARE offers a platform for young engineers to gain an international exposure on social, business and economic issues. ShARE, which stands for Sharing Analysis of Regional Economies, is a multicultural, non- profit organisation for students that connects talented students to global leaders to discuss global economic issues. We strive to better understand the complexities of local socio-economic issues through presentations, conferences and projects. ShARE’s long term mission is to generate, share and use knowledge to contribute to regions’ human, social and economic development.","https://www.facebook.com/shareiitr/"));
        groupslists.add(new ModelClass(R.drawable.enactus,"Enactus IIT Roorkee", "ENACTUS IIT Roorkee aims to create a culture of social entrepreneurship in IIT Roorkee to try and make the world a better place.","https://www.facebook.com/enactusiitroorkee"));
        groupslists.add(new ModelClass(R.drawable.motor,"IIT Roorkee Motorsports","IIT Roorkee Motorsports is a group of inter-disciplinary students from IIT Roorkee. We participate in the world’s largest Inter–Collegiate Engineering competition conducted by Formula Society of Automotive Engineers (FSAE). Our passion is not for the cars alone it is fuelled by our desire to use engineering and technology to change the mobility sector in India. With the same thrill our seniors started the team in 2010 and made its debut in 2011 by participating in FSAE-Australasia held in Melbourne, Australia with an internal combustion engine car. The Team further participated in Formula student UK - 2013 with a Hybrid Car followed by FSAE - Australasia in 2015 with a fully Electric car. The team consist of students of different disciplines - Mechanical Engineering, Electrical Engineering, Electronics, Industrial Engineering, and Materials Engineering. Team has different divisions such as Electrical, Mechanical, Marketing & Management and Design & Web Development which works in their respective departments.","https://www.facebook.com/iitrms.in"));
        groupslists.add(new ModelClass(R.drawable.design,"Design Studio","We are budding researchers, designers, engineers and architects working together to combine art, science and technology to create new products. Our range of activities spans planning through production. Our focus is on Design and Innovation Strategies, Digital-Physical Design, Technology based Innovation, UI/UX, Game Development and Product Brand Language. We strive to create engaging product experiences that connect with the people. Our team has a unique blend of creative and technical skills, and many years of design experience. Much of our work is done in the 3D environment, driven by our knowledge of materials. We also employ freehand sketching, 2D visualisation using a drawing package such as Photoshop and Illustrator, 3D visualisation using rendered views of 3D CAD models and animations of 3D CAD models, and even physical prototypes, to ensure unsurpassed quality of work. We’re an agile team, with mighty dreams! We’re empowering campus programs and teams at IIT Roorkee, by helping them apply market-centric product design practices to their daily work. We have started in 2015 and are on course to the distant world of future.","https://www.facebook.com/designstudio.iitr"));
        groupslists.add(new ModelClass(R.drawable.smp,"Student Mentorship Program, IIT Roorkee","Student Mentorship Program is one of the largest on-campus student body initiative which assigns a mentor(a pre-final or final year student) to all the freshmen within the same branch. It ensures bridging the communication gap between senior and first-year students by providing a dynamic environment for healthy discussion, guidance and one to one counseling.","https://www.facebook.com/MentorshipIITR"));
        groupslists.add(new ModelClass(R.drawable.finac,"Finance Club, IIT Roorkee", "A group to collaborate among finance enthusiasts and foster a permanent finance culture in the IITR campus.","https://www.facebook.com/financeclubiitr"));
        groupslists.add(new ModelClass(R.drawable.iarc,"Institute Alumni Relations Cell, IIT-Roorkee", "Institute Alumni Relations Cell (IARC), IIT-Roorkee is a cell working under the aegis of Dean of Resources and Alumni Affairs to act as a bridge between alumni and student community for the mutual greater good.","https://www.facebook.com/alumnicelliitr"));
        groupslists.add(new ModelClass(R.drawable.copi,"Corporate Interactions Group, IIT Roorkee","We believe in creating and nurturing excellent relationships with Industries that are mutually beneficial to both IIT Roorkee and the Industries","https://www.facebook.com/cig.iitroorkee/"));
        groupslists.add(new ModelClass(R.drawable.uba,"Unnat Bharat Abhiyan, IIT Roorkee","Unnat Bharat Abhiyan (UBA) is a project initiated by the Ministry of Human Resource Development (MHRD), Government of India. It is inspired by the vision of transformational change in rural development processes by leveraging knowledge institutions to help build the architecture of an inclusive India. Our mission is conceptualised as a movement to enable processes that connect institutes of higher education with local communities to address the development challenges of rural India through participatory processes and appropriate technologies for accelerating sustainable growth. It also aims to create a virtuous cycle between the society and an inclusive university system by providing knowledge and practices for emerging professions and to upgrade the capabilities of both the public and the private sectors.Under the aegis of UBA, IIT Roorkee has adopted five villages namely, Chharba, Meerpur, Mohand, Chandpur and Beladi Salhapur.","https://www.facebook.com/uba.iitroorkee/"));
        groupslists.add(new ModelClass(R.drawable.eco,"ECO Group IIT Roorkee","We focus on maintaining a sustainable and eco-friendly environment at IIT Roorkee.","https://www.facebook.com/ecoiitr"));
        groupslists.add(new ModelClass(R.drawable.cec,"Civil Engineering Consortium, IIT Roorkee",
                "Civil Engineering Consortium is the interaction community of the civil engineers on the web, a portal to notify the latest technical advancements of today.","https://www.facebook.com/cec.iitroorkee/"));
        groupslists.add(new ModelClass(R.drawable.sae,"SAE IIT Roorkee","Society of Automotive Engineers IIT Roorkee collegiate chapter was established in March 2000 with the collective effort of a group of students who had a strong urge to complement the theoretical knowledge imparted in the classroom, with emphasis on the practical aspects of engineering. With a humble beginning in March 2000, SAE IIT-R has grown steadily to it present strength and is one of the most active and popular technical societies in the campus. The chapter can proudly boast of having committed members from the entire gamut of engineering streams offered at IIT Roorkee.","https://www.facebook.com/SAEIITR"));
        groupslists.add(new ModelClass(R.drawable.heciit,"H.E.C IIT Roorkee","H.E.C stands for Himalayan Explorers' Club - the students organization of IIT Roorkee pioneering in trekking, mountaineering and adventure sports.","https://www.facebook.com/HECIITR/"));
        groupslists.add(new ModelClass(R.drawable.watchout,"Watch Out, IIT Roorkee",
                "Watch Out is the official student media body of the Indian Institute of Technology, Roorkee.","https://www.facebook.com/watchoutiitr"));
          groupslists.add(new ModelClass(R.drawable.kshitij,"Kshitij - The Literary Magazine",
                  "Kshitij is the official literary magazine of the Indian Institute of Technology , Roorkee- by the students , for the students . The basic aim of this bilingual magazine- with entries in English and Hindi- is to inculcate in the students of the institute a good reading habit and in turn spreading a literary culture in the campus. More than 1000 copies of an issue, in printed form, are distributed throughout the campus.","https://www.facebook.com/kshitijiitr"));
        groupslists.add(new ModelClass(R.drawable.cinsec,"Cinematic Section, IIT Roorkee",
                "Cinesec is dedicated in capturing imagination imagination on camera and turning them into videos. We publish vibrant categories of videos including short movies, campus news and trendz, interviews ,animations, info-videos ,gags, events coverage and feedbacks. Our section deals in various aspects of movie making such as scripting, editing, direction, production and a lot more.","https://www.facebook.com/cinesecIITR"));
       groupslists.add(new ModelClass(R.drawable.drama,"Dramatics Section, IIT Roorkee","Perhaps the oldest of the cultural sections of IIT Roorkee, Dramatics Section is a means to fulfill the passion for performing on stage, as well as in street plays. We are a team of insanely hard working people, with amazing camaraderie, who perform various plays round the year with arguably professional competency.","https://www.facebook.com/dramaticsiitr"));
       groupslists.add(new ModelClass(R.drawable.audio,"AUDIO Section IITR","Audio Section with an efficient team from all the years, provide the acoustics for events all around the year like Pehla Nasha, Swaranjali, Rock Show, etc. Loaded with state-of-the-art Aural and Mega Speakers the main attraction of the Audio Section is its known DJ nights, which are recognized as the best DJ nights of the campus, even better than the one those organized during Thomso.","https://www.facebook.com/audiosection.iitr"));
        groupslists.add(new ModelClass(R.drawable.music,"Music Section, IIT Roorkee","The Music Section is a group of talented and passionate musicians at IIT Roorkee. We regularly perform in shows within and outside campus.","https://www.facebook.com/musicsectioniitr"));
      groupslists.add(new ModelClass(R.drawable.coreo,"Choreography and Dance section IIT Roorkee","To show that IIT is not about just geeks and there is more to us than that. We gather the best dancers from the campus and practice until we are ready to rock the stage.","https://www.facebook.com/choreo.iitr"));
        groupslists.add(new ModelClass(R.drawable.fine,"Fine Arts Section IIT Roorkee","A melting pot of creativity and imagination, Fine Art’s section has been a fountainhead of artistic brilliance and splendour throughout its long and illustrious history. The walls of the section that lay shrouded with a remarkable aura of grace and beauty with contributions coming in right from the tiny tots of kindergarten to the well hailed veterans of the art bear testimony to this fact.","https://www.facebook.com/FineArtsIITR"));
        groupslists.add(new ModelClass(R.drawable.cry,"Child Rights & You - CRY IIT Roorkee Chapter","We are a group of CRY volunteers with a zeal to improve the lives of children of our society, especially around Roorkee.","https://www.facebook.com/CRY.Roorkee"));
        groupslists.add(new ModelClass(R.drawable.sanskrit,"Sanskrit Club IITR","Updates of activities organised by Sanskrit Club IIT Roorkee to promote learning of Sanskrit in campus and across the globe.","https://www.facebook.com/sanskritiitr/"));

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





