package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class bolsa1peca extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txtt1;
    private TextView txtt2;
    private TextView txtt3;
    private TextView txtt4;
    private TextView txtt5;
    private TextView txtt6;
    private ImageButton diminui;
    private ImageButton aumenta;
    private ImageButton back;
    private ImageView dicas;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsa1peca);

        diminui = findViewById(R.id.diminui);
        aumenta = findViewById(R.id.aumenta);

        aumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aumentar();
            }
        });

        diminui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diminuir();
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), selecionarPasso.class));
            }
        });

        dialog = new Dialog(this);
        dicas = findViewById(R.id.dicas);
        dicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button close;
                dialog.setContentView(R.layout.activity_popup_tirar);
                close = dialog.findViewById(R.id.btn24);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
    }

    public void aumentar(){
        txt1 = findViewById(R.id.txt17);
        txt2 = findViewById(R.id.txt18);
        txt3 = findViewById(R.id.txt19);
        txt4 = findViewById(R.id.txt20);
        txtt1 = findViewById(R.id.txtt20);
        txtt2 = findViewById(R.id.txtt21);
        txtt3 = findViewById(R.id.txtt22);
        txtt4 = findViewById(R.id.txtt23);
        txtt5 = findViewById(R.id.txtt24);
        txtt6 = findViewById(R.id.txtt25);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho++;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        txtt1.setTextSize(tamanho);
        txtt2.setTextSize(tamanho);
        txtt3.setTextSize(tamanho);
        txtt4.setTextSize(tamanho);
        txtt5.setTextSize(tamanho);
        txtt6.setTextSize(tamanho);
    }
    public void diminuir(){
        txt1 = findViewById(R.id.txt17);
        txt2 = findViewById(R.id.txt18);
        txt3 = findViewById(R.id.txt19);
        txt4 = findViewById(R.id.txt20);
        txtt1 = findViewById(R.id.txtt20);
        txtt2 = findViewById(R.id.txtt21);
        txtt3 = findViewById(R.id.txtt22);
        txtt4 = findViewById(R.id.txtt23);
        txtt5 = findViewById(R.id.txtt24);
        txtt6 = findViewById(R.id.txtt25);

        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho--;

        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        txtt1.setTextSize(tamanho);
        txtt2.setTextSize(tamanho);
        txtt3.setTextSize(tamanho);
        txtt4.setTextSize(tamanho);
        txtt5.setTextSize(tamanho);
        txtt6.setTextSize(tamanho);
    }
}
