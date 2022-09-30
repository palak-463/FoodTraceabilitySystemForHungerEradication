package com.example.foodmanagement.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodmanagement.DisplayInfo;
import com.example.foodmanagement.MyAdapter;
import com.example.foodmanagement.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FarmerDisplay extends AppCompatActivity {
    RecyclerView r;
    MyAdapter ma;
    FloatingActionButton fbb;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_display);

        Toolbar tool = findViewById(R.id.toolbar2);
        setSupportActionBar(tool);


        fbb = findViewById(R.id.fb);
        ImageView i = findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerDisplay.this, FarmerWelcome.class);
                startActivity(i);
            }
        });
        fbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerDisplay.this, FarmerUpload.class);
                startActivity(i);
            }
        });
        String g = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("FarmerInfo/FarmerUpload").child(g);
        r = findViewById(R.id.recyclerview);
        r.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<DisplayInfo> options=new FirebaseRecyclerOptions.Builder<DisplayInfo>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("FarmerInfo/FarmerUpload").child(g),DisplayInfo.class).build();

        ma=new MyAdapter(options);
        r.setAdapter(ma);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        ma.startListening();
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        ma.stopListening();
    }
}
