package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.Ngo.NgoLogin;
import com.example.foodmanagement.farmer.FarmerLogin;
import com.example.foodmanagement.restaurant.RestaurantLogin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    FirebaseAuth auth;
    EditText reset;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar tool = findViewById(R.id.toolbar2);
        setSupportActionBar(tool);
        ImageView i = findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getIntent().getStringExtra("from").equals("activity1")) {
                    Intent i = new Intent(ForgotPassword.this, FarmerLogin.class);
                    startActivity(i);
                }
                else if(getIntent().getStringExtra("from").equals("activity2")) {
                    Intent i = new Intent(ForgotPassword.this, RestaurantLogin.class);
                    startActivity(i);
                }
                else
                {
                    Intent i = new Intent(ForgotPassword.this, NgoLogin.class);
                    startActivity(i);
                }
            }
        });
        reset=(EditText)findViewById(R.id.etreset);
        submit=(Button)findViewById(R.id.btsubmit);

        auth=FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = reset.getEditableText().toString().trim();

                if( TextUtils.isEmpty(reset.getText())){
                    reset.setError( "Email is required!" );
                    reset.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(e).matches())
                {
                    reset.setError("Please provide valid e-mail!");
                    reset.requestFocus();
                    return;
                }

                auth.sendPasswordResetEmail(e).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful())
                       {
                           Toast.makeText(ForgotPassword.this, "Check your email to verify your account!", Toast.LENGTH_LONG).show();
                       }
                       else
                       {
                           Toast.makeText(ForgotPassword.this, "Try again!Something went wrong!", Toast.LENGTH_LONG).show();
                       }
                    }
                });
            }
        });
    }
}