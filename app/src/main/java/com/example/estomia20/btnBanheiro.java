package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class btnBanheiro extends AppCompatActivity {
    private TextView txt;
    private ImageButton aumenta;
    private ImageButton diminui;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_banheiro);
        txt = findViewById(R.id.txtBanheiro);

        aumenta = findViewById(R.id.aumenta);
        diminui = findViewById(R.id.diminui);

        aumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 aumentarT();
            }
        });
        diminui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diminuirT();
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
    public void aumentarT(){
        txt = findViewById(R.id.txtBanheiro);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt.getTextSize()/metrics.density;
        tamanho++;

        txt.setTextSize(tamanho);
    }
    public void diminuirT(){
        txt = findViewById(R.id.txtBanheiro);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt.getTextSize()/metrics.density;
        tamanho--;

        txt.setTextSize(tamanho);

    }
}
