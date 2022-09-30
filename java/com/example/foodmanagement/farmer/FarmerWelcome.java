package com.example.foodmanagement.farmer;

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

public class FarmerWelcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_welcome);
        Toolbar t= findViewById(R.id.toolbar);
        setSupportActionBar(t);

        Button b=findViewById(R.id.addgoods);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FarmerWelcome.this,FarmerUpload.class);
                startActivity(i);
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
                startActivity(new Intent(FarmerWelcome.this, MainActivity.class));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}