package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class intimidade extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;

    private ImageButton aumentar;
    private ImageButton diminuir;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intimidade);

        aumentar = findViewById(R.id.aumenta);
        diminuir = findViewById(R.id.diminui);
        aumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentarT();
            }
        });
        diminuir.setOnClickListener(new View.OnClickListener() {
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
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho++;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);

    }
    public void diminuirT(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho--;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);

    }
}
