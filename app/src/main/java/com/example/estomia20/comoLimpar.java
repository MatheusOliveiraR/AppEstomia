package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class comoLimpar extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;

    private ImageButton diminui;
    private ImageButton aumenta;
    private ImageButton btn;
    private ImageButton next;

    private Dialog dialog;
    private ImageButton close;
    private ProgressBar pb;

    private ImageSlider is;

    private ImageButton back;

    private final long CountDownMili = 120000;
    private long restante;
    private CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_como_limpar);

//        pb = findViewById(R.id.progressBar5);
//        pb.setMax((int)CountDownMili);
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cdt.cancel();
                startActivity(new Intent(getApplicationContext(),colocar1peca.class));
                finish();
            }
        });

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
//                cdt.cancel();
                finish();
            }
        });
        dialog = new Dialog(this);
        btn = findViewById(R.id.dicas);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.activity_limpar_aviso);
                close = dialog.findViewById(R.id.close);
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

        is = findViewById(R.id.slider);
        List<SlideModel> slidemodesl = new ArrayList<>();
        slidemodesl.add(new SlideModel(R.drawable.passo1limpar , ScaleTypes.FIT));
        slidemodesl.add(new SlideModel(R.drawable.passo2limpar , ScaleTypes.FIT));
        is.setImageList(slidemodesl,ScaleTypes.CENTER_CROP);



//        restante = CountDownMili;
//        startCountDown();
    }
    public void startCountDown(){
        cdt = new CountDownTimer(restante,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                restante = millisUntilFinished;
                int restanto = (int) restante;
                int ctdINT = (int) CountDownMili;
                pb.setProgress(ctdINT-restanto);
            }

            @Override
            public void onFinish() {
                restante = 0;
                finish();
                startActivity(new Intent(getApplicationContext(),colocar1peca.class));
            }
        }.start();
    }
    public void atualizarTimer(){
        int minutes = (int) (restante/1000)/60;
        int seconds = (int) (restante/1000)%60;
        String TextoFormatado = String.format(Locale.getDefault(), "%02d:%02d",minutes, seconds);

    }

    public void diminuir(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);

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
    }
    public void aumentar(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);

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
    }

    protected void onDestroy(){
        super.onDestroy();
//        if(cdt!=null){
//            cdt.cancel();
//        }
    }
}
