package com.example.foodmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.Ngo.NgoLogin;
import com.example.foodmanagement.farmer.FarmerLogin;
import com.example.foodmanagement.restaurant.RestaurantLogin;

public class MainActivity extends AppCompatActivity {
    private Button farmer;
    private Button restaurant;
    private Button ngo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar t= findViewById(R.id.toolbar2);
        setSupportActionBar(t);


        farmer= (Button) findViewById(R.id.btfarmer);
        restaurant= (Button) findViewById(R.id.btrestaurant);
        ngo= (Button) findViewById(R.id.btngo);

        farmer.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, FarmerLogin.class);
                startActivity(intent);
            }

        });

        restaurant.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, RestaurantLogin.class);
                startActivity(intent);
            }

        });

        ngo.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view) {
                Intent intent = new Intent(MainActivity.this, NgoLogin.class);
                startActivity(intent);
            }

        });

    }

}