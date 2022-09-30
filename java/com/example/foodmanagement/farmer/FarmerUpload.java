package com.example.foodmanagement.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FarmerUpload extends AppCompatActivity {
    EditText e1;
    EditText e2;
    EditText e3;
    EditText e4;
    int m=0;
    Button b1;
    FirebaseAuth mAuth;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_upload);

        Toolbar t= findViewById(R.id.toolbar2);
        setSupportActionBar(t);
        ImageView i=findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FarmerUpload.this,FarmerWelcome.class);
                startActivity(i);
            }
        });
        e2=(EditText)findViewById(R.id.name);
        e3=(EditText)findViewById(R.id.qty);
        e4=(EditText)findViewById(R.id.price);
        b1=(Button)findViewById(R.id.btndone);

        mAuth=FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( TextUtils.isEmpty(e2.getText())){
                    e2.setError( "Goods name is required!" );
                    e2.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(e3.getText())){
                    e3.setError( "Quantity is required!" );
                    e3.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(e4.getText())){
                    e4.setError( "Price is required!" );
                    e4.requestFocus();
                    return;
                }

                String g=e2.getEditableText().toString();
                String q=e3.getEditableText().toString();
                String p=e4.getEditableText().toString();
                String g2=FirebaseAuth.getInstance().getCurrentUser().getUid();
                ref=FirebaseDatabase.getInstance().getReference("FarmerInfo/FarmerUpload/"+g2);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                            m=(int)snapshot.getChildrenCount();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                FarmerUploadConst fm=new FarmerUploadConst(g,q,p);
                FirebaseDatabase.getInstance().getReference("FarmerInfo/FarmerUpload/"+g2)
                        .child(String.valueOf(m+1))
                        .setValue(fm).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(FarmerUpload.this, "Uploaded Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(FarmerUpload.this,FarmerDisplay.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(FarmerUpload.this, "Failed to upload!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

            }
        });

    }
}