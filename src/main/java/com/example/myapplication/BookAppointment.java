package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5,ed6;
private DatePickerDialog dp;
private TimePickerDialog tp;
private Button db,tb,btnBook,btnBack;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        tv=findViewById(R.id.textViewBA);
        ed1=findViewById(R.id.editTextRegUsername);
        ed2=findViewById(R.id.editTextRegAddress);
        ed3=findViewById(R.id.editTextRegContact);
        ed4=findViewById(R.id.editTextRegFees);
        ed5=findViewById(R.id.editTextRegSelectDate);
        ed6=findViewById(R.id.editTextRegSelectTime);
        btnBook=findViewById(R.id.buttonBookAppointment);
        btnBack=findViewById(R.id.buttonback);
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);
        ed5.setKeyListener(null);
        ed6.setKeyListener(null);
        db=findViewById(R.id.buttonBookAppointment5);
        tb=findViewById(R.id.buttonBookAppointment6);
        Intent it=getIntent();
        String Title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        String fees=it.getStringExtra("text5");
        tv.setText(Title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText(fees+"/-");
        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDatePicker();
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTimePicker();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointment.this, FindDoctor.class));
            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                db.setText(dayOfMonth+"/"+month+"/"+year);
                // After selecting the date, show the time picker
                initTimePicker();
            }
        };

        // Initialize the date picker with the current date
        Calendar cal= Calendar.getInstance();
        int y=cal.get(Calendar.YEAR);
        int m=cal.get(Calendar.MONTH);
        int d=cal.get(Calendar.DAY_OF_MONTH);
        int style= AlertDialog.THEME_HOLO_DARK;
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, style, dateSetListener, y, m, d);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()); // Set min date to today
        datePickerDialog.show();
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                tb.setText(hourOfDay+":"+minute);
            }
        };

        // Initialize the time picker without setting a default time
        int style= AlertDialog.THEME_HOLO_DARK;
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, style, timeSetListener, 0, 0, true);
        timePickerDialog.show();
    }
}