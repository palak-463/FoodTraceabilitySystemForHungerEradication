package com.example.foodmanagement.restaurant;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class RestaurantUpload extends AppCompatActivity {

    EditText Date1,Time1,name,qty,Date2,Time2;
    Button b;
    DatePickerDialog dpd1,dpd2;
    TimePickerDialog tpd1,tpd2;
    int th1,tm1,th2,tm2;
    FirebaseAuth mAuth;
    int m=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_upload);
        Toolbar tool = findViewById(R.id.toolbar2);
        setSupportActionBar(tool);
        Date1=(EditText)findViewById(R.id.datep);
        Time1=(EditText)findViewById(R.id.timep);
        Date2=(EditText)findViewById(R.id.datef);
        Time2=(EditText)findViewById(R.id.timef);
        qty=(EditText)findViewById(R.id.etquantity);
        name=(EditText)findViewById(R.id.etitemname);
        b=(Button)findViewById(R.id.btrupload);
        ImageView i=findViewById(R.id.iv);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RestaurantUpload.this, RestaurantMain.class);
                startActivity(i);
            }
        });

        mAuth=FirebaseAuth.getInstance();

        Date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c=Calendar.getInstance();
                int Year=c.get(Calendar.YEAR);
                int Month=c.get(Calendar.MONTH);
                int Day=c.get(Calendar.DAY_OF_MONTH);

                dpd1=new DatePickerDialog(RestaurantUpload.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Date1.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },Year,Month,Day);
                dpd1.show();
            }
        });

        Time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tpd1 = new TimePickerDialog(RestaurantUpload.this, android.R.style.Theme_Holo_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        th1 = hourOfDay;
                        tm1 = minute;
                        String st = th1 + ":" + tm1;
                        SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = sdf24.parse(st);
                            SimpleDateFormat sdf12 = new SimpleDateFormat("HH:mm aa");
                            Time1.setText(sdf12.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, 12, 0, false
                );
                tpd1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tpd1.updateTime(th1,tm1);
                tpd1.show();
            }
        });
        Date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c=Calendar.getInstance();
                int Year=c.get(Calendar.YEAR);
                int Month=c.get(Calendar.MONTH);
                int Day=c.get(Calendar.DAY_OF_MONTH);

                dpd2=new DatePickerDialog(RestaurantUpload.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        Date2.setText(dayOfMonth+"-"+(month+1)+"-"+year);
                    }
                },Year,Month,Day);
                dpd2.show();
            }
        });

        Time2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tpd2 = new TimePickerDialog(RestaurantUpload.this, android.R.style.Theme_Holo_Dialog_MinWidth, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        th2 = hourOfDay;
                        tm2 = minute;
                        String st = th2 + ":" + tm2;
                        SimpleDateFormat sdf24 = new SimpleDateFormat("HH:mm");
                        try {
                            Date date = sdf24.parse(st);
                            SimpleDateFormat sdf12 = new SimpleDateFormat("HH:mm aa");
                            Time2.setText(sdf12.format(date));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }, 12, 0, false
                );
                tpd2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                tpd2.updateTime(th2,tm2);
                tpd2.show();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(name.getText())){
                    name.setError( "Item name is required!" );
                    name.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(qty.getText())){
                    qty.setError( "Quantity is required!" );
                    qty.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(Time1.getText())){
                    Time1.setError( "Time is required!" );
                    Time1.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(Date1.getText())){
                    Date1.setError( "Date is required!" );
                    Date1.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(Time2.getText())){
                    Time2.setError( "Time is required!" );
                    Time2.requestFocus();
                    return;
                }
                if( TextUtils.isEmpty(Date2.getText())){
                    Date2.setError( "Date is required!" );
                    Date2.requestFocus();
                    return;
                }
                String n=name.getEditableText().toString();
                String q=qty.getEditableText().toString();
                String t1=Time1.getEditableText().toString();
                String d1=Date1.getEditableText().toString();
                String t2=Time2.getEditableText().toString();
                String d2=Date2.getEditableText().toString();
                String g2=FirebaseAuth.getInstance().getCurrentUser().getUid();
                RestaurantUploadConst fm=new RestaurantUploadConst(n,q,t1,d1,t2,d2);
                DatabaseReference ref =FirebaseDatabase.getInstance().getReference("RestaurantInfo/RestaurantUpload/"+g2);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        m=(int)snapshot.getChildrenCount();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                FirebaseDatabase.getInstance().getReference("RestaurantInfo/RestaurantUpload/"+g2)
                        .child(String.valueOf(m+1))
                        .setValue(fm).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(RestaurantUpload.this, "Uploaded Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RestaurantUpload.this, RestaurantDisplay.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(RestaurantUpload.this, "Failed to upload!", Toast.LENGTH_SHORT).show();
                        }
                    }

                });

            }
        });
    }
}
