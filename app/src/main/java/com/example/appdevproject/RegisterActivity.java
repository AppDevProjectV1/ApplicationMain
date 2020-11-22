package com.example.appdevproject;

import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String  MOB_NO="phono";
    private Spinner spinner;
    private EditText editText;

    private DatabaseReference databaseReferenceall ;

    String phonenumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = findViewById(R.id.spinnerCountries);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, CountryData.countryNames));

        editText = findViewById(R.id.editTextPhone);

        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = CountryData.countryAreaCodes[spinner.getSelectedItemPosition()];

                String number = editText.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }



                phonenumber = "+" + code + number;

                databaseReferenceall= FirebaseDatabase.getInstance().getReference("Usersdata").child(phonenumber);
                databaseReferenceall.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Toast.makeText(getApplicationContext(), "Number Already Registered", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            savePhone();
                            Intent intent = new Intent(RegisterActivity.this, OtpActivity.class);
                            intent.putExtra("phonenumber", phonenumber);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                });


            }
        });

    }
    public void savePhone(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(MOB_NO,phonenumber);
        editor.apply();
    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
//            Intent intent = new Intent(this, StudentReg.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//            startActivity(intent);
//        }
//    }
}