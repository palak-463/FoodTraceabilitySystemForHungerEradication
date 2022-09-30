package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login_Signup extends AppCompatActivity {

    private Button LoginSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        LoginSignup = (Button) findViewById(R.id.Login_Signup);

        LoginSignup.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                Intent intent = new Intent(Login_Signup.this,MainActivity.class);
                startActivity(intent);
            }


        });


    }

}