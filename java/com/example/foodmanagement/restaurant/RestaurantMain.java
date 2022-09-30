package com.example.foodmanagement.restaurant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.MainActivity;
import com.example.foodmanagement.R;
import com.google.firebase.auth.FirebaseAuth;

public class RestaurantMain extends AppCompatActivity {

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);
        Toolbar t= findViewById(R.id.toolbar);
        setSupportActionBar(t);
        b1=(Button)findViewById(R.id.btupload);
        b2=(Button)findViewById(R.id.btorder);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantMain.this, RestaurantUpload.class);
                startActivity(intent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantMain.this, RestaurantOrder.class);
                startActivity(intent);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logout:{
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(RestaurantMain.this, MainActivity.class));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}