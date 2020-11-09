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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class colocar1peca extends AppCompatActivity {
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView txt5;
    private TextView txt6;
    private TextView txt7;
    private TextView txtt1;
    private TextView txtt2;
    private TextView txtt3;
    private TextView txtt4;
    private TextView txtt5;
    private TextView txtt6;
    private TextView txtt7;
    private TextView txtt8;
    private TextView txtt9;
    private TextView txtt10;
    private TextView txtt11;
    private TextView txtt12;
    private TextView txtt13;
    private TextView txtt14;

    private ProgressBar pb;

    private TextView aumenta;
    private TextView diminui;

    private ImageButton back;
    private Dialog dialog;
    private ImageButton close;

    private ImageSlider is;
    private ImageSlider is2;


    private ImageButton btnAlerta;

    private final long CountDownMili = 120000;
    private long restante;
    private CountDownTimer cdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocar1peca);

//        pb = findViewById(R.id.progressBar9);
//        pb.setMax((int) CountDownMili);

        aumenta = findViewById(R.id.aumenta3);
        diminui = findViewById(R.id.diminui3);

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

        //Slider1
        is = findViewById(R.id.sliderColocar);
        List<SlideModel> slidemodesl2 = new ArrayList<>();
        slidemodesl2.add(new SlideModel(R.drawable.passo1colocar1 , ScaleTypes.FIT));
        slidemodesl2.add(new SlideModel(R.drawable.passo1bcolocar1 , ScaleTypes.FIT));
        slidemodesl2.add(new SlideModel(R.drawable.passo2colocar1 , ScaleTypes.FIT));
        slidemodesl2.add(new SlideModel(R.drawable.passo3colocar1 , ScaleTypes.FIT));
        slidemodesl2.add(new SlideModel(R.drawable.passo3bcolocar1 , ScaleTypes.FIT));
        slidemodesl2.add(new SlideModel(R.drawable.passo4colocar1 , ScaleTypes.FIT));
        is.setImageList(slidemodesl2,ScaleTypes.CENTER_CROP);
        //Slider 1

        //Slider 2
        is2 = findViewById(R.id.sliderColocar2);
        List<SlideModel> slidemodesl = new ArrayList<>();
        slidemodesl.add(new SlideModel(R.drawable.passo1colocar2 , ScaleTypes.FIT));
        slidemodesl.add(new SlideModel(R.drawable.passo1bcolocar2 , ScaleTypes.FIT));
        slidemodesl.add(new SlideModel(R.drawable.passo3colocar2 , ScaleTypes.FIT));
        slidemodesl.add(new SlideModel(R.drawable.passo4colocar2 , ScaleTypes.FIT));
        slidemodesl.add(new SlideModel(R.drawable.passo5colocar2 , ScaleTypes.FIT));
        slidemodesl.add(new SlideModel(R.drawable.passo6colocar2 , ScaleTypes.FIT));
        is2.setImageList(slidemodesl,ScaleTypes.CENTER_CROP);
        //Slider2



        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cdt.cancel();
                finish();
            }
        });

        dialog = new Dialog(this);

        btnAlerta = findViewById(R.id.dicas);
        btnAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.activity_colocar_alerta);
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
//
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
                startActivity(new Intent(getApplicationContext(),passotirarbolsa.class));
            }
        }.start();
    }
    public void atualizarTimer(){
        int minutes = (int) (restante/1000)/60;
        int seconds = (int) (restante/1000)%60;
        String TextoFormatado = String.format(Locale.getDefault(), "%02d:%02d",minutes, seconds);

    }
    public void aumentar(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txtt1 = findViewById(R.id.txtt1);
        txtt2 = findViewById(R.id.txtt2);
        txtt3 = findViewById(R.id.txtt3);
        txtt5 = findViewById(R.id.txtt5);
        txtt6 = findViewById(R.id.txtt6);
        txtt7 = findViewById(R.id.txtt7);
        txtt8= findViewById(R.id.txtt8);
        txtt9 = findViewById(R.id.txtt9);
        txtt10 = findViewById(R.id.txtt10);
        txtt11 = findViewById(R.id.txtt11);
        txtt12 = findViewById(R.id.txtt12);
        txtt14 = findViewById(R.id.txtt14);

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
        txtt1.setTextSize(tamanho);
        txtt2.setTextSize(tamanho);
        txtt3.setTextSize(tamanho);
        txtt4.setTextSize(tamanho);
        txtt5.setTextSize(tamanho);
        txtt6.setTextSize(tamanho);
        txtt7.setTextSize(tamanho);
        txtt8.setTextSize(tamanho);
        txtt9.setTextSize(tamanho);
        txtt10.setTextSize(tamanho);
        txtt11.setTextSize(tamanho);
        txtt12.setTextSize(tamanho);
        txtt13.setTextSize(tamanho);
        txtt14.setTextSize(tamanho);
    }
    public void diminuir(){
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txtt1 = findViewById(R.id.txtt1);
        txtt2 = findViewById(R.id.txtt2);
        txtt3 = findViewById(R.id.txtt3);
        txtt5 = findViewById(R.id.txtt5);
        txtt6 = findViewById(R.id.txtt6);
        txtt7 = findViewById(R.id.txtt7);
        txtt8= findViewById(R.id.txtt8);
        txtt9 = findViewById(R.id.txtt9);
        txtt10 = findViewById(R.id.txtt10);
        txtt11 = findViewById(R.id.txtt11);
        txtt12 = findViewById(R.id.txtt12);
        txtt14 = findViewById(R.id.txtt14);

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
        txtt1.setTextSize(tamanho);
        txtt2.setTextSize(tamanho);
        txtt3.setTextSize(tamanho);
        txtt4.setTextSize(tamanho);
        txtt5.setTextSize(tamanho);
        txtt6.setTextSize(tamanho);
        txtt7.setTextSize(tamanho);
        txtt8.setTextSize(tamanho);
        txtt9.setTextSize(tamanho);
        txtt10.setTextSize(tamanho);
        txtt11.setTextSize(tamanho);
        txtt12.setTextSize(tamanho);
        txtt13.setTextSize(tamanho);
        txtt14.setTextSize(tamanho);
    }

    protected void onDestroy(){
        super.onDestroy();
//        if(cdt!=null){
//            cdt.cancel();
//        }
    }
}
