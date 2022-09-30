package com.example.foodmanagement.Ngo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodmanagement.R;
import com.example.foodmanagement.restaurant.RestaurantInfo;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NGO_Restaurantdisplay extends AppCompatActivity {
    RecyclerView r;
    MyNgo ma;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__restaurantdisplay);
        Toolbar tool = findViewById(R.id.toolbar2);
        setSupportActionBar(tool);
        ImageView i=findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NGO_Restaurantdisplay.this, NgoMain.class);
                startActivity(i);
            }
        });
        String g = FirebaseAuth.getInstance().getCurrentUser().getUid();
        reference = FirebaseDatabase.getInstance().getReference().child("RestaurantInfo/RestaurantUpload").child(g);
        r = findViewById(R.id.recyclerview);
        r.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<RestaurantInfo> options=new FirebaseRecyclerOptions.Builder<RestaurantInfo>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("RestaurantInfo/RestaurantUpload").child(g),RestaurantInfo.class).build();

        ma=new MyNgo(options);
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