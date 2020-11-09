package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class limparAviso extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;

    private ImageButton diminui;
    private ImageButton aumenta;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limpar_aviso);

        diminui = findViewById(R.id.diminui);
        diminui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diminuir();
            }
        });
        aumenta = findViewById(R.id.aumenta);
        aumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentar();
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), comoLimpar.class));
            }
        });
    }

    public void diminuir(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);

        float tamanho = txt1.getTextSize()/2;
        tamanho--;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        txt5.setTextSize(tamanho);
        txt6.setTextSize(tamanho);
        txt7.setTextSize(tamanho);
    }
    public void aumentar(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);

        float tamanho = txt1.getTextSize()/2;
        tamanho++;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        txt5.setTextSize(tamanho);
        txt6.setTextSize(tamanho);
        txt7.setTextSize(tamanho);
    }
}
