package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView familyphysician=findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctor.this, DoctorDetails.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }
        });
        CardView Dietician=findViewById(R.id.cardFDDietician);
        Dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctor.this, DoctorDetails.class);
                it.putExtra("title","Dieticians");
                startActivity(it);
            }
        });
        CardView Dentist=findViewById(R.id.cardFDDentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctor.this, DoctorDetails.class);
                it.putExtra("title","Dentists");
                startActivity(it);
            }
        });
        CardView Surgeon=findViewById(R.id.cardFDSurgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctor.this, DoctorDetails.class);
                it.putExtra("title","Surgeons");
                startActivity(it);
            }
        });
        CardView Cardiologist=findViewById(R.id.cardFDCardiologists);
       Cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(FindDoctor.this, DoctorDetails.class);
                it.putExtra("title","Cardiologists");
                startActivity(it);
            }
        });
        CardView Back=findViewById(R.id.cardFDBack);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctor.this, Home.class));
            }
        });
    }
}