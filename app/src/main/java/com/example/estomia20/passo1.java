package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class passo1 extends AppCompatActivity {
    ImageButton aumenta;
    ImageButton diminui;
    TextView tx20;
    TextView tx21;
    TextView tx23;
    TextView tx24;
    TextView tx25;
    TextView tx26;
    TextView jtv;
    TextView jtv2;

    private ImageButton next;

    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passo1);

        aumenta =findViewById(R.id.aumenta);
        aumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentar();
            }
        });
        diminui = findViewById(R.id.diminui);
        diminui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diminui();
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
    public void diminui(){
        tx24 = findViewById(R.id.textView99);
        tx25 = findViewById(R.id.textView98);
        TextView txt = findViewById(R.id.txt4);
        jtv = findViewById(R.id.txt15);
        jtv2 = findViewById(R.id.txt16);


        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =tx24.getTextSize()/metrics.density;
        tamanho--;
        tx24.setTextSize(tamanho);
        tx25.setTextSize(tamanho);
        txt.setTextSize(tamanho);
        jtv.setTextSize(tamanho);
        jtv2.setTextSize(tamanho);
    }

    public void aumentar(){
        tx24 = findViewById(R.id.textView99);
        tx25 = findViewById(R.id.textView98);
        TextView txt = findViewById(R.id.txt4);
        jtv = findViewById(R.id.txt15);
        jtv2 = findViewById(R.id.txt16);


        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =tx24.getTextSize()/metrics.density;
        tamanho++;
        tx24.setTextSize(tamanho);
        tx25.setTextSize(tamanho);
        txt.setTextSize(tamanho);
        jtv.setTextSize(tamanho);
        jtv2.setTextSize(tamanho);
    }
}
