package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class envolvidos extends AppCompatActivity {
    private ImageView aline;
    private ImageView saskia;
    private ImageView nariane;
    private ImageView will;
    private ImageView matheus;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envolvidos);

        aline = findViewById(R.id.Aline);
        aline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Aline.class));
            }
        });
        saskia = findViewById(R.id.Saskia);
        saskia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Saskia.class));
            }
        });
        nariane = findViewById(R.id.Nariane);
        nariane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Nariane.class));
            }
        });
        will = findViewById(R.id.Will);
        will.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Will.class));
            }
        });
        matheus = findViewById(R.id.Matheus);
        matheus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Matheus.class));
            }
        });
        back = findViewById(R.id.imageView55);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}