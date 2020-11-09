package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class menu extends AppCompatActivity {
    private ImageButton perfil;
    private ImageButton noti;
    private ImageButton passo;
    private ImageButton reco;
    private ImageButton button;
    private ImageButton estomia;
    private ImageButton bolsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2);

        estomia = findViewById(R.id.oqueEestomia);
        estomia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),selecionar.class));
            }
        });

        bolsa = findViewById(R.id.button22);
        bolsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),passo2.class));
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),sobre.class));
            }
        });

        perfil  = findViewById(R.id.perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PerfilActivity.class));
            }
        });
        noti = findViewById(R.id.noti);
        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),notificacao.class));
            }
        });
        passo = findViewById(R.id.passo);
        passo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SelecionarImagemOuVideo.class));
            }
        });
        reco = findViewById(R.id.reco);
        reco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),selecionarReco2.class));
            }
        });
    }
}
