package com.campuscompass.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appdevproject.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class  OrderCanteen extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS =1 ;
    public static final String SHARED_PREFS="sharedPrefs";
    Map<Integer, String> myMap = new HashMap<>();
    String aa="",bb="",cc="", dd="", ee="", ff="", gg="", hh="", ii="", jj="", kk="", ll="", mm="", nn="", oo="";
    public static final String  mobno="phono";
    private String isMobile;
    ArrayList<String> mSpinnerData;
    String Text1, Text2, Text3, Text4, Text5, Text6, Text7, Text8, Text9, Text10, Text11, Text12, Text13, Text14, Text15, Text16, Text17, Text18, Text19, Text20;
    boolean check1, check2, check3, check4, check5, check6, check7, check8, check9, check10, check11, check12, check13, check14, check15;
    String Ordercomplete = "";

    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10, checkBox11, checkBox12, checkBox13, checkBox14, checkBox15,checkBox16, checkBox17, checkBox18, checkBox19, checkBox20;
    Spinner spinquan1, spinquan2, spinquan3, spinquan4, spinquan5, spinquan6, spinquan7, spinquan8, spinquan9, spinquan10, spinquan11, spinquan12, spinquan13, spinquan14, spinquan15, spinquan16, spinquan17, spinquan18, spinquan19, spinquan20;
    int Cost1,Cost2,Cost3,Cost4,Cost5,Cost6,Cost7,Cost8,Cost9,Cost10,Cost11,Cost12,Cost13,Cost14,Cost15,Cost16,Cost17,Cost18,Cost19,Cost20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_canteen);
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        isMobile = sharedPreferences.getString(mobno,"mobilenumber");
        //  use the actionbar here for go to previous activity
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mSpinnerData = new ArrayList<>();
        mSpinnerData.add("0");
        mSpinnerData.add("1");
        mSpinnerData.add("2");
        mSpinnerData.add("3");
        mSpinnerData.add("4");


        checkBox1 = (CheckBox) findViewById(R.id.checkorder1);
        checkBox2 = (CheckBox) findViewById(R.id.checkorder2);
        checkBox3 = (CheckBox) findViewById(R.id.checkorder3);
        checkBox4 = (CheckBox) findViewById(R.id.checkorder4);
        checkBox5 = (CheckBox) findViewById(R.id.checkorder5);
        checkBox6 = (CheckBox) findViewById(R.id.checkorder6);
        checkBox7 = (CheckBox) findViewById(R.id.checkorder7);
        checkBox8 = (CheckBox) findViewById(R.id.checkorder8);
        checkBox9 = (CheckBox) findViewById(R.id.checkorder9);
        checkBox10 = (CheckBox) findViewById(R.id.checkorder10);
        checkBox11 = (CheckBox) findViewById(R.id.checkorder11);
        checkBox12 = (CheckBox) findViewById(R.id.checkorder12);
        checkBox13 = (CheckBox) findViewById(R.id.checkorder13);
        checkBox14 = (CheckBox) findViewById(R.id.checkorder14);
        checkBox15 = (CheckBox) findViewById(R.id.checkorder15);
        checkBox16 = (CheckBox) findViewById(R.id.checkorder16);
        checkBox17 = (CheckBox) findViewById(R.id.checkorder17);
        checkBox18 = (CheckBox) findViewById(R.id.checkorder18);
        checkBox19 = (CheckBox) findViewById(R.id.checkorder19);
        checkBox20 = (CheckBox) findViewById(R.id.checkorder20);

        spinquan1 = (Spinner) findViewById(R.id.quantityspin1);
        spinquan2 = (Spinner) findViewById(R.id.quantityspin2);
        spinquan3 = (Spinner) findViewById(R.id.quantityspin3);
        spinquan4 = (Spinner) findViewById(R.id.quantityspin4);
        spinquan5 = (Spinner) findViewById(R.id.quantityspin5);
        spinquan6 = (Spinner) findViewById(R.id.quantityspin6);
        spinquan7 = (Spinner) findViewById(R.id.quantityspin7);
        spinquan8 = (Spinner) findViewById(R.id.quantityspin8);
        spinquan9 = (Spinner) findViewById(R.id.quantityspin9);
        spinquan10 = (Spinner) findViewById(R.id.quantityspin10);
        spinquan11 = (Spinner) findViewById(R.id.quantityspin11);
        spinquan12 = (Spinner) findViewById(R.id.quantityspin12);
        spinquan13 = (Spinner) findViewById(R.id.quantityspin13);
        spinquan14 = (Spinner) findViewById(R.id.quantityspin14);
        spinquan15 = (Spinner) findViewById(R.id.quantityspin15);
        spinquan16 = (Spinner) findViewById(R.id.quantityspin16);
        spinquan17 = (Spinner) findViewById(R.id.quantityspin17);
        spinquan18 = (Spinner) findViewById(R.id.quantityspin18);
        spinquan19 = (Spinner) findViewById(R.id.quantityspin19);
        spinquan20= (Spinner) findViewById(R.id.quantityspin20);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan3.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan4.setAdapter(adapter4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan5.setAdapter(adapter5);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan6.setAdapter(adapter6);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan7.setAdapter(adapter7);
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan8.setAdapter(adapter8);
        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan9.setAdapter(adapter9);
        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan10.setAdapter(adapter10);
        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan11.setAdapter(adapter11);
        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan12.setAdapter(adapter12);
        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan13.setAdapter(adapter13);
        ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan14.setAdapter(adapter14);
        ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan15.setAdapter(adapter15);

        ArrayAdapter<String> adapter16 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan16.setAdapter(adapter16);

        ArrayAdapter<String> adapter17 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan17.setAdapter(adapter17);
        ArrayAdapter<String> adapter18 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan18.setAdapter(adapter18);
    ArrayAdapter<String> adapter19 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan19.setAdapter(adapter19);

        ArrayAdapter<String> adapter20= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan20.setAdapter(adapter20);




        spinquan1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Text1 = parent.getItemAtPosition(position).toString();
                if(Text1.equals("1")||Text1.equals("2")||Text1.equals("3")||Text1.equals("4")){
                    checkBox1.setChecked(true);
                    Cost1 = Integer.parseInt(Text1);
                    aa= "Chole Bhature-" + Cost1 + "  Price:" + Cost1 * 40 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text1.equals("0")){
                    checkBox1.setChecked(false);
                    aa= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                System.out.println(Text1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text2 = parent.getItemAtPosition(position).toString();
                if(Text2.equals("1")||Text2.equals("2")||Text2.equals("3")||Text2.equals("4")){
                    checkBox2.setChecked(true);
                    Cost2 = Integer.parseInt(Text2);
                    bb= "Soup Maggie-" + Cost2 + "  Price:" + Cost2 * 25 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text2.equals("0")){
                    checkBox2.setChecked(false);
                    bb= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinquan3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Text3 = parent.getItemAtPosition(position).toString();
                if(Text3.equals("1")||Text3.equals("2")||Text3.equals("3")||Text3.equals("4")){
                    checkBox3.setChecked(true);
                    Cost3 = Integer.parseInt(Text3);
                    cc= "Fried Maggie-" + Cost3 + "  Price:" + Cost3 * 25 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text3.equals("0")){
                    checkBox3.setChecked(false);
                    cc="";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinquan4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text4 = parent.getItemAtPosition(position).toString();
                if(Text4.equals("1")||Text4.equals("2")||Text4.equals("3")||Text4.equals("4")){
                    checkBox4.setChecked(true);
                    Cost4 = Integer.parseInt(Text4);
                    dd= "Egg Roll-" + Cost4 + "  Price:" + Cost4* 45 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text4.equals("0")){
                    checkBox4.setChecked(false);
                    dd="";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinquan5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text5 = parent.getItemAtPosition(position).toString();
                if(Text5.equals("1")||Text5.equals("2")||Text5.equals("3")||Text5.equals("4")){
                    checkBox5.setChecked(true);
                    Cost5= Integer.parseInt(Text5);
                    ee= "Masala Dosha-" + Cost5 + "  Price:" + Cost5 * 40 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text5.equals("0")){
                    checkBox5.setChecked(false);
                    ee= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinquan6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text6 = parent.getItemAtPosition(position).toString();
                if(Text6.equals("1")||Text6.equals("2")||Text6.equals("3")||Text6.equals("4")){
                    checkBox6.setChecked(true);
                    Cost6 = Integer.parseInt(Text6);
                    ff= "Masala Paiteez-" + Cost6 + "  Price:" + Cost6 * 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text6.equals("0")){
                    checkBox6.setChecked(false);
                    ff= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinquan7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text7 = parent.getItemAtPosition(position).toString();
                if(Text7.equals("1")||Text7.equals("2")||Text7.equals("3")||Text7.equals("4")){
                    checkBox7.setChecked(true);
                    Cost7= Integer.parseInt(Text7);
                    gg= "Spring Roll-" + Cost7 + "  Price:" + Cost7 * 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text7.equals("0")){
                    checkBox7.setChecked(false);
                    gg= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinquan8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text8 = parent.getItemAtPosition(position).toString();
                if(Text8.equals("1")||Text8.equals("2")||Text8.equals("3")||Text8.equals("4")){
                    checkBox8.setChecked(true);
                    Cost8 = Integer.parseInt(Text8);
                    hh= "Aloo pyaz paratha-" + Cost8 + "  Price:" + Cost8* 10 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text8.equals("0")){
                    checkBox8.setChecked(false);
                    hh= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spinquan9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text9 = parent.getItemAtPosition(position).toString();
                if(Text9.equals("1")||Text9.equals("2")||Text9.equals("3")||Text9.equals("4")){
                    checkBox9.setChecked(true);
                    Cost9 = Integer.parseInt(Text9);

                    ii= "Paneer Paratha-" + Cost9 + "  Price:" + Cost9* 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text9.equals("0")){
                    checkBox9.setChecked(false);
                    ii= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text10 = parent.getItemAtPosition(position).toString();
                if(Text10.equals("1")||Text10.equals("2")||Text10.equals("3")||Text10.equals("4")){
                    checkBox10.setChecked(true);
                    Cost10 = Integer.parseInt(Text10);
                    jj= "Aloo sada Paratha-" + Cost10 + "  Price:" + Cost10 * 10 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text10.equals("0")){
                    checkBox10.setChecked(false);
                    jj= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text11 = parent.getItemAtPosition(position).toString();
                if(Text11.equals("1")||Text11.equals("2")||Text11.equals("3")||Text11.equals("4")){
                    checkBox11.setChecked(true);
                    Cost11 = Integer.parseInt(Text11);
                    kk= "Pakoday-" + Cost11 + "  Price:" + Cost11 * 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text11.equals("0")){
                    checkBox11.setChecked(false);
                    kk= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text12 = parent.getItemAtPosition(position).toString();
                if(Text12.equals("1")||Text12.equals("2")||Text12.equals("3")||Text12.equals("4")){
                    checkBox12.setChecked(true);
                    Cost12 = Integer.parseInt(Text12);
                    ll= "Samosha Bhujia-" + Cost12 + "  Price:" + Cost12 * 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text12.equals("0")){
                    checkBox12.setChecked(false);
                    ll= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text13 = parent.getItemAtPosition(position).toString();
                if(Text13.equals("1")||Text13.equals("2")||Text13.equals("3")||Text13.equals("4")){
                    checkBox13.setChecked(true);
                    Cost13 = Integer.parseInt(Text13);
                    mm= "Sada Paiteez-" + Cost13 + "  Price:" + Cost13* 15 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text13.equals("0")){
                    checkBox13.setChecked(false);
                    mm= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinquan14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text14 = parent.getItemAtPosition(position).toString();
                if(Text14.equals("1")||Text14.equals("2")||Text14.equals("3")||Text14.equals("4")){
                    checkBox14.setChecked(true);
                    Cost14 = Integer.parseInt(Text14);
                    nn= "Poha-" + Cost14+ "  Price:" + Cost14 * 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text14.equals("0")){
                    checkBox14.setChecked(false);
                    nn= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text15 = parent.getItemAtPosition(position).toString();
                if(Text15.equals("1")||Text15.equals("2")||Text15.equals("3")||Text15.equals("4")){
                    checkBox15.setChecked(true);
                    Cost15 = Integer.parseInt(Text15);
                    oo= "Oreo Shake-" + Cost15 + "  Price:" + Cost15* 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text15.equals("0")){
                    checkBox15.setChecked(false);
                    oo= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinquan16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text16 = parent.getItemAtPosition(position).toString();
                if(Text16.equals("1")||Text16.equals("2")||Text16.equals("3")||Text16.equals("4")){
                    checkBox16.setChecked(true);
                    Cost16 = Integer.parseInt(Text16);
                    oo= "Cold Coffee-" + Cost16 + "  Price:" + Cost16* 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text16.equals("0")){
                    checkBox16.setChecked(false);
                    oo= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinquan17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text17 = parent.getItemAtPosition(position).toString();
                if(Text17.equals("1")||Text17.equals("2")||Text17.equals("3")||Text17.equals("4")){
                    checkBox17.setChecked(true);
                    Cost17 = Integer.parseInt(Text17);
                    oo= "Bourn Vita-" + Cost17 + "  Price:" + Cost17* 20 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text17.equals("0")){
                    checkBox17.setChecked(false);
                    oo= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinquan18.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text18 = parent.getItemAtPosition(position).toString();
                if(Text18.equals("1")||Text18.equals("2")||Text18.equals("3")||Text18.equals("4")){
                    checkBox18.setChecked(true);
                    Cost18 = Integer.parseInt(Text18);
                    oo= "Chai-" + Cost18 + "  Price:" + Cost18* 10 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text18.equals("0")){
                    checkBox18.setChecked(false);
                    oo= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinquan19.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text19 = parent.getItemAtPosition(position).toString();
                if(Text19.equals("1")||Text19.equals("2")||Text19.equals("3")||Text19.equals("4")){
                    checkBox19.setChecked(true);
                    Cost19 = Integer.parseInt(Text19);
                    oo= "Coffee-" + Cost19 + "  Price:" + Cost19* 10 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text19.equals("0")){
                    checkBox19.setChecked(false);
                    oo= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinquan20.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Text20 = parent.getItemAtPosition(position).toString();
                if(Text20.equals("1")||Text20.equals("2")||Text20.equals("3")||Text20.equals("4")){
                    checkBox20.setChecked(true);
                    Cost20 = Integer.parseInt(Text20);
                    oo= "Cold Drink-" + Cost20 + "  Price:" + Cost20* 50 + "/-" + "\n";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
                else if(Text20.equals("0")){
                    checkBox20.setChecked(false);
                    oo= "";
                    Ordercomplete=aa+bb+cc+dd+ee+ff+gg+hh+ii+jj+kk+ll+mm+nn+oo;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ResetOrder();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ResetOrder();
    }

    public String Order() {

        return Ordercomplete+"\n"+"Order from me";

    }

    public void Submitorder(View view) {

        Toast.makeText(getApplicationContext(), "Order to Canteen Whatsapp no.", Toast.LENGTH_SHORT).show();
        Intent sendIntent = new Intent("android.intent.action.MAIN");
        sendIntent.setAction(Intent.ACTION_VIEW);
        sendIntent.setPackage("com.whatsapp");
        String url = "https://api.whatsapp.com/send?phone=" +isMobile + "&text=" + Order();
        sendIntent.setData(Uri.parse(url));
        if (sendIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
            startActivity(sendIntent);

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.resetorder, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contact_us) {
            Toast.makeText(getApplicationContext(), "Call to Canteen", Toast.LENGTH_LONG).show();

            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},
                            REQUEST_CODE_ASK_PERMISSIONS);
                }
            }
            else {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +isMobile));
                startActivity(intent);
            }
        }

        else if(id==R.id.reset_menu){
            ResetOrder();
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Call Permission Granted..Please dial again.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Call permission not granted", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    private void ResetOrder() {
        Ordercomplete="";
        checkBox20.setChecked(false);
        checkBox19.setChecked(false);
        checkBox18.setChecked(false);
        checkBox17.setChecked(false);
        checkBox16.setChecked(false);
        checkBox15.setChecked(false);
        checkBox14.setChecked(false);
        checkBox13.setChecked(false);
        checkBox12.setChecked(false);
        checkBox11.setChecked(false);
        checkBox10.setChecked(false);
        checkBox9.setChecked(false);
        checkBox8.setChecked(false);
        checkBox7.setChecked(false);
        checkBox6.setChecked(false);
        checkBox5.setChecked(false);
        checkBox4.setChecked(false);
        checkBox3.setChecked(false);
        checkBox2.setChecked(false);
        checkBox1.setChecked(false);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan2.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan3.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan4.setAdapter(adapter4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan5.setAdapter(adapter5);
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan6.setAdapter(adapter6);
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan7.setAdapter(adapter7);
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan8.setAdapter(adapter8);
        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan9.setAdapter(adapter9);
        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan10.setAdapter(adapter10);
        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan11.setAdapter(adapter11);
        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan12.setAdapter(adapter12);
        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan13.setAdapter(adapter13);
        ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan14.setAdapter(adapter14);
        ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan15.setAdapter(adapter15);

        ArrayAdapter<String> adapter16 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan16.setAdapter(adapter16);
        ArrayAdapter<String> adapter17 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan17.setAdapter(adapter17);
        ArrayAdapter<String> adapter18 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan18.setAdapter(adapter18);
        ArrayAdapter<String> adapter19 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan19.setAdapter(adapter19);
        ArrayAdapter<String> adapter20 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSpinnerData);
        spinquan20.setAdapter(adapter20);



    }
}
