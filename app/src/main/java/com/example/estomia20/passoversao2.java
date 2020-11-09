package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class passoversao2 extends AppCompatActivity {
    boolean verificar = false;
    private Button btnOq;
    private Button btnColetora;
    private Button btn1peca;
    private Button btnLimpar;
    private Button colocar1;
    private Button colocar2;
    private ImageButton back;
    private ScrollView sv;
    private ScrollView sv2;
    private ScrollView sv3;
    private ScrollView sv4;
    private ScrollView sv5;
    private ScrollView sv6;
    private ScrollView sv7;

    private Button mostrar1;
    private Button mostrar2;
    private ImageButton mostrar3;
    private ImageButton mostrar4;
    private ImageButton mostrar5;
    private ImageButton mostrar6;
    private ImageButton mostrar7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passoversao2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_passo);
        sv = findViewById(R.id.scrollView6);
        sv2 = findViewById(R.id.scrolloqueE);
        sv4 = findViewById(R.id.scrollVideoDois);
        sv5 = findViewById(R.id.scrollComoLimpar);
        sv6 = findViewById(R.id.scrollColocar);
        sv7 = findViewById(R.id.scrollColocarDois);

        final int visivel = sv.VISIBLE;
        final int gone = sv.GONE;

        sv.setVisibility(sv.GONE);
        sv2.setVisibility(sv.GONE);
        sv4.setVisibility(sv.GONE);
        sv5.setVisibility(sv.GONE);
        sv6.setVisibility(sv.GONE);
        sv7.setVisibility(sv.GONE);

        btnOq = findViewById(R.id.button2);
        btnOq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),passo1.class));
            }
        });

        btnColetora = findViewById(R.id.button4);
        btnColetora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),passo2.class));
            }
        });
        btn1peca = findViewById(R.id.button8);
        btn1peca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificar){
                    startActivity(new Intent(getApplicationContext(),bolsa1peca.class));
                }else{
                    startActivity(new Intent(getApplicationContext(),bolsa2peca.class));
                }
            }
        });

        btnLimpar = findViewById(R.id.button12);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), comoLimpar.class));
            }
        });

        colocar1 = findViewById(R.id.button14);
        colocar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),colocar1peca.class));
            }
        });

        colocar2 = findViewById(R.id.button16);
        colocar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),colocar2peca.class));
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),menu.class));
            }
        });



        mostrar2 = findViewById(R.id.mostrar2);
        mostrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv2.getVisibility()==visivel){
                    sv2.setVisibility(gone);
                    mostrar2.setBackgroundResource(R.drawable.flecha_baixo);
                }else{
                    sv2.setVisibility(visivel);
                    mostrar2.setBackgroundResource(R.drawable.flecha_cima);
                }
            }
        });
        mostrar3 = findViewById(R.id.mostrarTirar);
        mostrar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv4.getVisibility()==gone){
                    sv4.setVisibility(visivel);
                    mostrar3.setBackgroundResource(R.drawable.flecha_cima);
                    verificar=true;
                }else{
                    sv4.setVisibility(gone);
                    verificar=false;
                    mostrar3.setBackgroundResource(R.drawable.flecha_baixo);
                }
            }
        });
        mostrar4 = findViewById(R.id.mostrarTirar2);
        mostrar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv4.getVisibility()==visivel){
                    sv4.setVisibility(gone);
                    mostrar4.setBackgroundResource(R.drawable.flecha_baixo);
                }else{
                    sv4.setVisibility(visivel);
                    mostrar4.setBackgroundResource(R.drawable.flecha_cima);
                }

            }
        });
        mostrar5 = findViewById(R.id.mostrarLimpar);
        mostrar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv5.getVisibility()==gone){
                    sv5.setVisibility(visivel);
                    mostrar5.setBackgroundResource(R.drawable.flecha_cima);
                }else{
                    sv5.setVisibility(gone);
                    mostrar5.setBackgroundResource(R.drawable.flecha_baixo);
                }
            }
        });
        mostrar6 = findViewById(R.id.mostrarColocar);
        mostrar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv6.getVisibility()==gone){
                    sv6.setVisibility(visivel);
                    mostrar6.setBackgroundResource(R.drawable.flecha_cima);
                }else{
                    sv6.setVisibility(gone);
                    mostrar6.setBackgroundResource(R.drawable.flecha_baixo);
                }
            }
        });
        mostrar7 = findViewById(R.id.mostrarColocar2);
        mostrar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv7.getVisibility()==gone){
                    sv7.setVisibility(visivel);
                    mostrar7.setBackgroundResource(R.drawable.flecha_cima);
                }else{
                    sv7.setVisibility(gone);
                    mostrar7.setBackgroundResource(R.drawable.flecha_baixo);
                }
            }
        });
        mostrar1 = findViewById(R.id.mostrar1);
        mostrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(sv.getVisibility()==gone){
                    sv.setVisibility(visivel);
                    mostrar1.setBackgroundResource(R.drawable.flecha_cima);
                }else{
                    sv.setVisibility(gone);
                    mostrar1.setBackgroundResource(R.drawable.flecha_baixo);
                }
            }
        });
    }
}