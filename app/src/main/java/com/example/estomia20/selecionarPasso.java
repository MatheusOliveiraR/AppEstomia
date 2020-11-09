package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.VideoView;

import net.cachapa.expandablelayout.ExpandableLayout;

public class selecionarPasso extends AppCompatActivity {

    private ImageButton comoTirar;
    private ImageButton comoLimpar;
    private ImageButton comoColocar;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passo_a_passo_versao2);

        comoTirar=findViewById(R.id.button10);
        comoLimpar=findViewById(R.id.button11);
        comoColocar=findViewById(R.id.button12);
        back = findViewById(R.id.back);

        comoTirar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),passotirarbolsa.class));
            }
        });

        comoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),comoLimpar.class));
            }
        });

        comoColocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),colocar1peca.class));
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
