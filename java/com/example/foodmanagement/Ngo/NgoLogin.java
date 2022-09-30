package com.example.foodmanagement.Ngo;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.foodmanagement.ForgotPassword;
import com.example.foodmanagement.MainActivity;
import com.example.foodmanagement.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NgoLogin extends AppCompatActivity {

    private EditText email;
    private EditText Password;
    private Button BtLogin;
    private TextView Signup;
    private TextView Forgot;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_login);
        Toolbar tool = findViewById(R.id.toolbar2);
        setSupportActionBar(tool);
        mAuth = FirebaseAuth.getInstance();
        ImageView i=findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NgoLogin.this, MainActivity.class);
                startActivity(i);
            }
        });
        email = (EditText) findViewById(R.id.etemail);
        Password = (EditText) findViewById(R.id.etPassword);
        BtLogin = (Button) findViewById(R.id.btlogin);
        Signup = (TextView) findViewById(R.id.tvsignup);
        Forgot = (TextView) findViewById(R.id.tvforgot);

        Forgot.setOnTouchListener(new NgoLogin.CustomTouchListener());
        Forgot.setPaintFlags(Forgot.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Forgot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(NgoLogin.this, ForgotPassword.class).putExtra("from","activity3");
                startActivity(intent);
            }

        });

        Signup.setOnTouchListener(new NgoLogin.CustomTouchListener());
        Signup.setPaintFlags(Signup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(NgoLogin.this, NgoSignup.class);
                startActivity(intent);
            }

        });

        BtLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String u = email.getEditableText().toString().trim();
                String pass = Password.getEditableText().toString().trim();
                if (TextUtils.isEmpty(email.getText())) {
                    email.setError("Email is required!");
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(u).matches()) {
                    email.setError("Please provide valid e-mail!");
                    email.requestFocus();
                    return;
                }
                if (pass.isEmpty()) {
                    Password.setError("Password is required");
                    Password.requestFocus();
                    return;
                }
                if (pass.length() < 6) {
                    Password.setError("Password length should be 6 characters!");
                    Password.requestFocus();
                    return;
                }

                mAuth.signInWithEmailAndPassword(u, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = (FirebaseAuth.getInstance().getCurrentUser());
                            if (user.isEmailVerified()) {
                                Intent intent = new Intent(NgoLogin.this, NgoMain.class);
                                startActivity(intent);
                            } else {
                                user.sendEmailVerification();
                                Toast.makeText(NgoLogin.this, "Check your email to verify your account!", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(NgoLogin.this, "Failed to login!,Please check your credentials!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }
    public class CustomTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    ((TextView) view).setTextColor(0xFFFFFFFF); // white
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    ((TextView) view).setTextColor(Color.parseColor("#4a4a4a")); // lightblack
                    break;
            }
            return false;
        }

    }
}
