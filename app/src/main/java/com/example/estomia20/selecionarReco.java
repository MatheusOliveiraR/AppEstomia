package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class selecionarReco extends AppCompatActivity {
    private Button btnComo;
    private ImageButton back;
    private Button descartar;
    private Button banho;
    private Button trocar;
    private Button btnEsvaziar;
    private Button btnQuando;
    private Button btnAlimen;
    private Button intimidade;
    private Button banheiro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_reco);

        btnComo = findViewById(R.id.btnComo);
        btnComo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),orientacaoSer.class));
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),menu.class));
            }
        });
        descartar = findViewById(R.id.btnDescartar);
        descartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),descarte.class));
            }
        });
        banho = findViewById(R.id.btnBanho);
        banho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),banho.class));
            }
        });
        trocar = findViewById(R.id.btnTrocar);
        trocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),trocar.class));
            }
        });
        btnEsvaziar = findViewById(R.id.btnEsvaziar);
        btnEsvaziar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),comoEsvaziar.class));
            }
        });
        btnQuando = findViewById(R.id.btnQuando);
        btnQuando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),quandoEsvaziar.class));
            }
        });
        btnAlimen = findViewById(R.id.btnAlimen);
        btnAlimen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),alimentacao.class));
            }
        });
        intimidade = findViewById(R.id.bntIntimidade);
        intimidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),intimidade.class));
            }
        });
        banheiro = findViewById(R.id.btnBanheiro);
        banheiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),btnBanheiro.class));
            }
        });

    }
}
