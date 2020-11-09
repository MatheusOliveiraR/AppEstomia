package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SelecionarPassoVideo extends AppCompatActivity {

    private ImageButton comoTirar;
    private ImageButton comoLimpar;
    private ImageButton comoColocar;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_passo_video);

        comoTirar=findViewById(R.id.button10);
        comoLimpar=findViewById(R.id.button11);
        comoColocar=findViewById(R.id.button12);
        back = findViewById(R.id.back);

        comoTirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),passotirarbolsaVideo.class));
            }
        });

        comoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),como_limpar_video.class));
            }
        });

        comoColocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),colocar_bolsa_video.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}