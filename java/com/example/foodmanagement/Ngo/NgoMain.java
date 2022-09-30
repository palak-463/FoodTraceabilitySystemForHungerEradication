package com.example.foodmanagement.Ngo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.MainActivity;
import com.example.foodmanagement.R;
import com.google.firebase.auth.FirebaseAuth;

public class NgoMain extends AppCompatActivity {
private Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ngo_main);
        Toolbar t= findViewById(R.id.toolbar);
        setSupportActionBar(t);
        Button b1=findViewById(R.id.vff);
        Button b2=findViewById(R.id.lfh);
        ImageView i=findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(NgoMain.this, MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NgoMain.this,NGO_farmerdisplay.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NgoMain.this,NGO_Restaurantdisplay.class);
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
                startActivity(new Intent(NgoMain.this,MainActivity.class));
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}