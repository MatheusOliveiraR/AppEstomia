package com.example.estomia20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.estomia20.banco.dao;

public class calendario extends AppCompatActivity {

    private static final String tag = "Calendario";
    private CalendarView calendar;
    private Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        calendar = findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth+"/"+(month+1)+"/"+year;
                dao dao = new dao(getApplicationContext());
                dao.salvarDia(date);
            }
        });


    }
}