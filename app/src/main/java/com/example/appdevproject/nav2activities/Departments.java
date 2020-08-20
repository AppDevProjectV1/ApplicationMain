package com.example.appdevproject.nav2activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appdevproject.R;

public class Departments extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NavDeptAdapter navDeptAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);



        String[] deptnames={"Computer Science",
                "Electronic and Communication",
                "Electrical Engineering",
                "Civil Engineering",
                "Mechanical Engineering",
                "Production & Industrial",
                "Metallurgy",
                "Physics",
                "Engineering physics",
                "Applied Mathematics",
                "Chemistry",
                "Architecture",
                "GT",
                "Hydrology",
                "Chemical Engineering",
                "Earth Science",
                "Polymer Science",
                "Bio Technology",
                "Earthquake Engineering"};
        Integer[] deptimages={ R.drawable.computer,
                R.drawable.electrical,
                R.drawable.electri,
                R.drawable.civil,
                R.drawable.mechnical,
                R.drawable.pandi,
                R.drawable.meta,
                R.drawable.physics,
                R.drawable.electri,
                R.drawable.electri,
                R.drawable.chemistry,
                R.drawable.archti,
                R.drawable.gt,
                R.drawable.hydrology,
                R.drawable.chemical,
                R.drawable.earthscience,
                R.drawable.polymer,
                R.drawable.biotech,
                R.drawable.earthquake};
        String[] deptinfo={"In view of the increasing importance of the Electronics Engineering discipline, a " +
                "separate Department of Electronics & Communication Engineering was established in 1964 to offer" +
                " Bachelor of engineering degree in Electronics & Communication and Master of Engineering degrees " +
                "in (a) Advanced Electronics and (b) Applied Electronics & Servomechanisms. In 1968, the postgraduate" +
                " programme was restructured with specializations in the areas of Communication Systems, Control and guidance," +
                " Microwaves and Radar, and Solid State Electronics. Two new undergraduate and postgraduate programmes in Computer " +
                "Science and Technology were started in the year 1982. Keeping in view the activities of the Department, the name was " +
                "changed to Department of Electronics and Computer Engineering. In January 2013, the Department of Electronics and Computer " +
                "Engineering was been bifurcated into two separate departments i.e. 'Electronics and Communication Engineering' and 'Computer" +
                " Science and Engineering'.",



                "In view of the increasing importance of the Electronics Engineering discipline, a " +
                        "separate Department of Electronics & Communication Engineering was established in 1964 to offer" +
                        " Bachelor of engineering degree in Electronics & Communication and Master of Engineering degrees " +
                        "in (a) Advanced Electronics and (b) Applied Electronics & Servomechanisms. In 1968, the postgraduate" +
                        " programme was restructured with specializations in the areas of Communication Systems, Control and guidance," +
                        " Microwaves and Radar, and Solid State Electronics. Two new undergraduate and postgraduate programmes in Computer " +
                        "Science and Technology were started in the year 1982. Keeping in view the activities of the Department, the name was " +
                        "changed to Department of Electronics and Computer Engineering. In January 2013, the Department of Electronics and Computer " +
                        "Engineering was been bifurcated into two separate departments i.e. 'Electronics and Communication Engineering' and 'Computer" +
                        " Science and Engineering'.",



                "Presently the department is running the courses at both the undergraduate and the postgra" +
                        "duate levels and providing excellent facilities to carry out research work for Doctor of Philosophy (Ph.D.) degree," +
                        " R&D work for sponsored and consultancy projects and testing and consultancy work for industrial problems.This is," +
                        " of course, in addition to the regular courses in Bachelor of Technology (B.Tech.) and Master of Technology (M.Tech.) " +
                        "that are a part of the curriculum. So, we welcome you to this arena of the world which holds the pride of being a pioneer in the area of Electrical Engineering even when most of the world was evolving the subject .of Electrical Engineering was founded in the year 1957 under aegis of the Government of India. Since then Department of Electrical Engineering at IIT Roorkee (formerly University of Roorkee) has made landmark contributions to the development of cutting edge technology in various branches.  ",


                "The Department of Civil Engineering at the Indian Institute of Technology, Roorkee is the oldest and the largest in the country. It was established on November 25, 1847 as Roorkee Civil Engineering College and renamed as Thomason College of Civil Engineering in 1854. The department has produced several eminent engineers who have made significant contributions in the planning and execution of Civil Engineering projects in India as well as abroad.\n" +
                        "\n" +
                        "The Department offers a four-year course leading to the Bachelors Degree in Civil Engineering and two-year courses leading to Master’s degree in seven major specialisations of civil engineering (viz., Building Science and Technology, Environmental Engineering, Geomatics Engineering, Geotechnical Engineering, Hydraulics Engineering, Structural Engineering and Transportation Engineering). In total there are 577 students pursuing Bachelors degree and 182 students pursuing Masters Degree in the department. These programmes are supported with strong doctoral programmes in all the specialisations. More than 243 Ph. D. research scholars are currently working in the department on emerging research areas. There are currently 26 Professors, 8 Associate Professors, 13 Assistant Professors and 1 Technical Officer working in the department.",


                "The Department of Mechanical Engineering came into being in the year 1946 and the first batch of Mechanical Engineers graduated in the year 1949. The department was renamed as Department of Mechanical & Industrial Engineering on its silver jubilee in 1974 when an undergraduate programme in Industrial Engineering was started. At present it offers both undergraduate and postgraduate courses in various facets of Mechanical and Industrial Engineering. The department offers Master of Technology courses in Machine Design Engineering, Production and Industrial Systems Engineering, Thermal System Engineering, Welding Engineering and CAD, CAM and Robotics. The department has laboratory and workshop facilities with modern sophisticated equipment to carry out research in all areas related to Mechanical and Production & Industrial Engineering. The faculty actively participates in sponsored research and consultancy work.",



                "The Department of Mechanical Engineering came into being in the year 1946 and the first batch of Mechanical Engineers graduated in the year 1949. The department was renamed as Department of Mechanical & Industrial Engineering on its silver jubilee in 1974 when an undergraduate programme in Industrial Engineering was started. At present it offers both undergraduate and postgraduate courses in various facets of Mechanical and Industrial Engineering. The department offers Master of Technology courses in Machine Design Engineering, Production and Industrial Systems Engineering, Thermal System Engineering, Welding Engineering and CAD, CAM and Robotics. The department has laboratory and workshop facilities with modern sophisticated equipment to carry out research in all areas related to Mechanical and Production & Industrial Engineering. The faculty actively participates in sponsored research and consultancy work.",


                "no info",

                "The Department of Physics from its modest beginning in 1960 has now grown in to an active center of quality teaching and research. Today it stands as one of the leading departments in the country, well known for its excellence in teaching and research. The Department runs five year integrated M.Sc. (Physics), and two year M.Sc. (Physics) programs apart from catering the teaching of core Physics courses to undergraduate engineering students. Engineering Physics B.Tech Program has also started in 2015.\n" +
                        "\n" +
                        "The Department also has M.Tech. (Photonics) and M. Tech. (Solid State Electronic Materials) program.\n" +
                        "\n" +
                        "The faculties of the Department are actively engaged in different areas of research viz. Atmospheric and Space Physics, Atomic and Molecular Physics, Condensed Matter Physics, Nuclear Physics, Optics and Theoretical High Energy Physics.",


                "The Department of Physics from its modest beginning in 1960 has now grown in to an active center of quality teaching and research. Today it stands as one of the leading departments in the country, well known for its excellence in teaching and research. The Department runs five year integrated M.Sc. (Physics), and two year M.Sc. (Physics) programs apart from catering the teaching of core Physics courses to undergraduate engineering students. Engineering Physics B.Tech Program has also started in 2015.\n" +
                        "\n" +
                        "The Department also has M.Tech. (Photonics) and M. Tech. (Solid State Electronic Materials) program.\n" +
                        "\n" +
                        "The faculties of the Department are actively engaged in different areas of research viz. Atmospheric and Space Physics, Atomic and Molecular Physics, Condensed Matter Physics, Nuclear Physics, Optics and Theoretical High Energy Physics.",


                "The Department of Mathematics attained its present status of an independent department in 1960. Growing steadily, today the department runs its own Undergraduate and Postgraduate programs in Mathematics, Besides this, we also teach various topics in Mathematics to Undergraduate and Postgraduate students of different Engineering and Science Departments. " +
                        "Besides the central Computing facilities of the Institute, the department has its own state of the art Computational Lab and a Mathematical Modelling Lab. The Department also offers facilities for research work leading to Ph.D. degree in different branches of Pure and Applied Mathematics. Department had collaborated with different National and International Organizations and has expertise in various fields of Mathematics.",


                "The Department of Chemistry was established in 1960. It is , since then, engaged in providing highest level and quality of academic education. The main focus of the teaching and research in the department is centered on interdisciplinary themes which have gained worldwide attention and appreciation.\n" +
                        "\n" +
                        "This department features a 25 member faculty with expertise in frontier areas of research. Active research in the areas of asymmetric synthesis, heterocyclic synthesis, organometallic catalysis, organic functional materials, ion selective sensors, polymeric membranes, electro-organic chemistry of nucleosides/nucleotides, nanomaterials, photochemistry, extraction of heavy metals, resolution of therapeutic enantiomers, organotin compounds, protein sequencing, bioinorganic chemistry and origin of life, theoretical chemistry are being pursued. The faculty members have contributed towards the publication of over 10 books, several research papers and many patents in the last five years. There are about 20 research projects sponsored by various government organizations (MHRD, DST, CSIR, AICTE, DRDO, ISRO) and industries.",



                "The Department of Architecture and Planning imparts high-quality education in the professional fields of Architecture and Planning and offers Bachelor of Architecture (B. Arch.), Master of Architecture (M. Arch.), Master of Urban and Rural Planning (MURP) and Ph.D. programs. The B. Arch. was started in 1956. The department has the singular distinction of being the first in India in instituting a Masters Degree program M. Arch. in the year 1969-70 and later another one, MURP in 1973-74. The Department has facilities like Climatology Lab, Computer Lab, and Computerized Design Studios equipped with state-of-art equipment and software, an Art Lab and a Workshop. A prestigious lab on Net Zero Emissions, set up under the INDO-UK program, is the latest addition in the department. Alongside, six new labs have been set up in the Department namely Virtual Reality Lab, SPARSH (Spatial Planning research), Urban Dynamics Lab, Civic Design Lab, Industrial Design Lab, and Laboratory of Inclusive Design (LID) to conduct high-end research in various spectrum of architecture and planning. The Institute takes very special care in selecting students for admission to various academic programs with the objective of providing technical education only to the best ones.",



                "The Department of Earth Sciences (formerly the Department of Geology and Geophysics) is one of the leading departments in the country engaged in high quality teaching, research and consultancy in the field of Earth Sciences. It was established in year 1960. During the span of about six decades, the department has become one of the foremost centres of teaching, research and consultancy.\n" +
                        "\n" +
                        "The main strength of the department is amalgamation of two major divisions of Earth Sciences: Geology and Geophysics under one umbrella. During last six decades, department has produced large number of trained Earth Scientists who are the backbone of the Country's mineral, oil & gas, groundwater resources and other exploration industries.\n" +
                        "\n" +
                        "Presently, the department is running two five year Integrated M.Tech. programmes on Geological Technology and Geophysical Technology. In these programmes (started from 2007) admissions are made through Joint Entrance Examination (JEE). In addition, department also runs M.Sc. (Applied Geology) of two years duration having admissions through Joint Admission Test to M.Sc. (JAM).",


                "Indian Institute of Technology Roorkee has its roots in the Roorkee College established in 1847 as the first engineering college in India, which was soon rechristened as Thomason College of Civil Engineering in 1854 after its mentor James Thomason.  After about 100 years of distinguished services, the college was elevated to University of Roorkee as the first Engineering University of independent India on November 25, 1949. On 21 September, 2001, the university was converted into an IIT by the Government of India. It has now 21 academic departments/centres offering 12 undergraduate courses in engineering and architecture, 3 dual degree programmes in engineering and over 48 postgraduate courses in engineering, architecture, sciences, computer applications and business administration besides research programmes at doctoral level.",



                "no info",


                "The Department of Earth Sciences (formerly the Department of Geology and Geophysics) is one of the leading departments in the country engaged in high quality teaching, research and consultancy in the field of Earth Sciences. It was established in year 1960. During the span of about six decades, the department has become one of the foremost centres of teaching, research and consultancy.\n" +
                        "\n" +
                        "The main strength of the department is amalgamation of two major divisions of Earth Sciences: Geology and Geophysics under one umbrella. During last six decades, department has produced large number of trained Earth Scientists who are the backbone of the Country's mineral, oil & gas, groundwater resources and other exploration industries.\n" +
                        "\n" +
                        "Presently, the department is running two five year Integrated M.Tech. programmes on Geological Technology and Geophysical Technology. In these programmes (started from 2007) admissions are made through Joint Entrance Examination (JEE). In addition, department also runs M.Sc. (Applied Geology) of two years duration having admissions through Joint Admission Test to M.Sc. (JAM).",






                "Department of Polymer and Process Engineering (DPPE) is one of the unique departments of the Indian Institute of Technology Roorkee (IITR), located in the Saharanpur Campus of IIT Roorkee. The department performs fundamental and applied research in Polymer Science and Technology, Process Engineering and Management under the supervision of highly motivated faculty members, who are enthusiastically working towards creating highly competitive, academic and research environment in the department.",


                "A Centre of Biosciences was started in 1980 and upgraded to a full-fledged academic Department of Biosciences and Biotechnology in 1986. It was renamed as the Department of Biotechnology in the year 2002. The department has teaching and research programmes which encompass various basic and applied aspects of modern biotechnology. The main objective of the Department is to provide academic training and conduct research in the interdisciplinary areas of biotechnology with a particular emphasis on extending the knowledge generated from these studies towards the development of technologies of commercial significance. A B.Tech.(Biotechnology) course has been started in 2005.\n" +
                        "\n",


                "The Department of Earthquake Engineering, formerly known as School for Research and Training in Earthquake Engineering (SRTEE) was established at University of Roorkee (Now Indian Institute of Technology, Roorkee) in 1960, which has now completed 60 years of excellence in the service of nation. This department happens to be the only one of its kind in the country till date that deals with earthquake engineering problems and challenges. It is fully interdisciplinary since its existence, bringing together structural and soil engineers, geologist and seismologist working as a team under one roof."





        };



        recyclerView=findViewById(R.id.deptlist);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new NavDeptAdapter(deptnames,deptimages,deptinfo));


    }
}