package com.example.foodmanagement.farmer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FarmerSignup extends AppCompatActivity {

    private TextInputEditText name,address,phone,email,password;
    private Button register;
    private FirebaseAuth mAuth;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_signup);
        ImageView i = findViewById(R.id.iv);
        Toolbar tool = findViewById(R.id.toolbar2);
        setSupportActionBar(tool);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FarmerSignup.this, FarmerLogin.class);
                startActivity(i);
            }
        });
        mAuth=FirebaseAuth.getInstance();

        name = (TextInputEditText) findViewById(R.id.etName);
        address = (TextInputEditText) findViewById(R.id.etAddress);
        phone = (TextInputEditText) findViewById(R.id.etPhone);
        email = (TextInputEditText) findViewById(R.id.etEmail);
        password = (TextInputEditText) findViewById(R.id.etpassword);
        register = (Button) findViewById(R.id.btregister);


        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                rootnode = FirebaseDatabase.getInstance();

                reference = rootnode.getReference("FarmerInfo");

                String n=name.getEditableText().toString();
                String a=address.getEditableText().toString();
                String p=phone.getEditableText().toString();
                String e=email.getEditableText().toString();
                String pass=password.getEditableText().toString();

                if( TextUtils.isEmpty(name.getText())){
                    name.setError( "Name is required!" );
                    name.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(address.getText())){
                    address.setError( "Address is required!" );
                    address.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(phone.getText())){
                    phone.setError( "Mobile no. is required!" );
                    phone.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(email.getText())){
                    email.setError( "Email is required!" );
                    email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(e).matches())
                {
                    email.setError("Please provide valid e-mail!");
                    email.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(password.getText())){
                    password.setError( "Password is required!" );
                    password.requestFocus();
                    return;
                }
                if(pass.length()<6){
                    password.setError( "Password length should be 6 characters!" );
                    password.requestFocus();
                    return;
                }

                    mAuth.createUserWithEmailAndPassword(e,pass).addOnCompleteListener(FarmerSignup.this, task -> {
                        if (task.isSuccessful())
                        {
                            FarmerRegister fm=new FarmerRegister(n,a,p,e,pass);
                            FirebaseDatabase.getInstance().getReference("FarmerInfo")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(fm).addOnCompleteListener(task1 -> {
                                        if(task1.isSuccessful())
                                        {
                                            Toast.makeText(FarmerSignup.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(FarmerSignup.this, FarmerLogin.class);
                                            startActivity(intent);
                                        }
                                        else
                                        {
                                            Toast.makeText(FarmerSignup.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                        }
                        else
                        {
                            Toast.makeText(FarmerSignup.this, "Failed to register!", Toast.LENGTH_SHORT).show();
                        }
                    });

                    }
        });
    }
}