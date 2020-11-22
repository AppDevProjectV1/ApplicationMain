package com.example.appdevproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText phone, email, pass, cpass;
    private Button login;
    private FirebaseAuth firebaseAuth;


    public static final String SHARED_PREFS="sharedPrefs";
    public static final String loggedin="loggedin";
    public static final String  Registered="";
  //  private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth=FirebaseAuth.getInstance();

        phone=(EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.emailpass);
        pass= (EditText)findViewById(R.id.loginpass);

        //progressBar=(ProgressBar)findViewById(R.id.studentprogress);
        login=findViewById(R.id.loginbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=email.getText().toString().trim();
                String Pass=pass.getText().toString().trim();
                String Number="+91"+phone.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(Pass)){
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }


               firebaseAuth.signInWithEmailAndPassword(Email,Pass)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    saveData();
                                    Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_LONG).show();
                                    Intent intent1=new Intent(getApplicationContext(),StudentProfile.class);
//                                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    intent1.putExtra("phonenumber",Number);
                                    startActivity(intent1);


                                }
                                else if(isNetworkAvailable(getApplicationContext())){
                                    Toast.makeText(LoginActivity.this, "Wrong Email or Password",
                                            Toast.LENGTH_SHORT).show();

                                }
                                else{
                                    Toast.makeText(LoginActivity.this, "no Internet Connection",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
            }
        });
    }
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(loggedin,true);
        editor.apply();
    }

}