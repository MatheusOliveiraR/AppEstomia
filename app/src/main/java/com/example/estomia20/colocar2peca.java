package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class colocar2peca extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txt8;
    private TextView txt9;
    private TextView txt10;
    private TextView txt11;
    private TextView txt12;
    private TextView txt13;
    private TextView txt14;

    private ImageButton diminui;
    private ImageButton aumentar;

    private ImageButton back;
    private ImageButton alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar2peca);

        aumentar = findViewById(R.id.aumenta);
        diminui = findViewById(R.id.diminui);

        aumentar.setOnClickListener(new View.OnClickListener() {
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
                startActivity(new Intent(getApplicationContext(), selecionarPasso.class));
            }
        });

        alerta = findViewById(R.id.imageButton8);
        alerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),colocarAlerta.class));
            }
        });
    }
    public void aumentarT(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        txt9 = findViewById(R.id.txt9);
        txt10 = findViewById(R.id.txt10);
        txt11 = findViewById(R.id.txt11);
        txt12 = findViewById(R.id.txt12);
        txt13 = findViewById(R.id.txt13);
        txt14 = findViewById(R.id.txt14);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho++;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        txt5.setTextSize(tamanho);
        txt6.setTextSize(tamanho);
        txt7.setTextSize(tamanho);
        txt8.setTextSize(tamanho);
        txt9.setTextSize(tamanho);
        txt10.setTextSize(tamanho);
        txt11.setTextSize(tamanho);
        txt12.setTextSize(tamanho);
        txt13.setTextSize(tamanho);
        txt14.setTextSize(tamanho);


    }
    public void diminuirT(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        txt9 = findViewById(R.id.txt9);
        txt10 = findViewById(R.id.txt10);
        txt11 = findViewById(R.id.txt11);
        txt12 = findViewById(R.id.txt12);
        txt13 = findViewById(R.id.txt13);
        txt14 = findViewById(R.id.txt14);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho--;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        txt5.setTextSize(tamanho);
        txt6.setTextSize(tamanho);
        txt7.setTextSize(tamanho);
        txt8.setTextSize(tamanho);
        txt9.setTextSize(tamanho);
        txt10.setTextSize(tamanho);
        txt11.setTextSize(tamanho);
        txt12.setTextSize(tamanho);
        txt13.setTextSize(tamanho);
        txt14.setTextSize(tamanho);

    }
}
