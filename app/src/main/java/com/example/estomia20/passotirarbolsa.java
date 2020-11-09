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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class passotirarbolsa extends AppCompatActivity {
    private ImageButton aumenta;
    private ImageButton diminui;
    private TextView txt1;
    private TextView txt2;
    private TextView txt3;
    private TextView txt4;
    private TextView tact1;
    private TextView tact2;
    private TextView tact3;
    private TextView tact4;
    private TextView tact5;
    private TextView tact6;
    private ImageView next;

    private Dialog dialog;
    private ImageView dicas;
    private Button remover;

    private ImageButton back;

    private TextView cd;
    private final long CountDownMili = 120000;
    private long restante;
    private CountDownTimer cdt;

    private ImageSlider is;
    private ImageSlider is2;


    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolsa1peca);
//        pb = findViewById(R.id.progressBar);
//        pb.setMax((int)CountDownMili);

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cdt.cancel();
                finish();
            }
        });
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cdt.cancel();
                startActivity(new Intent(getApplicationContext(),comoLimpar.class));
                finish();
            }
        });

        is = findViewById(R.id.slider1);
        List<SlideModel> slidemodesl2 = new ArrayList<>();
        slidemodesl2.add(new SlideModel(R.drawable.passo1tirar1p , ScaleTypes.CENTER_CROP));
        slidemodesl2.add(new SlideModel(R.drawable.passo2tirar1p , ScaleTypes.CENTER_CROP));
        is.setImageList(slidemodesl2,ScaleTypes.CENTER_CROP);

        is2 = findViewById(R.id.slider2);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.passo1tirar, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.passo2tirar, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(R.drawable.passo3tirar, ScaleTypes.CENTER_CROP));
        is2.setImageList(slideModels,ScaleTypes.CENTER_CROP);

        aumenta = findViewById(R.id.aumenta);
        diminui = findViewById(R.id.diminui);
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

        dialog = new Dialog(this);
        dicas = findViewById(R.id.dicas2);
        dicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.setContentView(R.layout.activity_popup_tirar);
                remover = dialog.findViewById(R.id.btn24);
                remover.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
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
                startActivity(new Intent(getApplicationContext(),comoLimpar.class));
            }
        }.start();
    }
    public void atualizarTimer(){
        int minutes = (int) (restante/1000)/60;
        int seconds = (int) (restante/1000)%60;
        String TextoFormatado = String.format(Locale.getDefault(), "%02d:%02d",minutes, seconds);

    }
    public void aumentar(){
        txt1 = findViewById(R.id.txt17);
        txt2 = findViewById(R.id.txt18);
        txt3 = findViewById(R.id.txt19);
        txt4 = findViewById(R.id.txt20);
        tact1 = findViewById(R.id.txtt20);
        tact2 = findViewById(R.id.txtt21);
        tact3 = findViewById(R.id.txtt22);
        tact4 = findViewById(R.id.txtt23);
        tact5 = findViewById(R.id.txtt24);
        tact6 = findViewById(R.id.txtt25);
        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho++;
        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        tact1.setTextSize(tamanho);
        tact2.setTextSize(tamanho);
        tact3.setTextSize(tamanho);
        tact4.setTextSize(tamanho);
        tact5.setTextSize(tamanho);
        tact6.setTextSize(tamanho);


    }
    public void diminuir(){
        txt1 = findViewById(R.id.txt17);
        txt2 = findViewById(R.id.txt18);
        txt3 = findViewById(R.id.txt19);
        txt4 = findViewById(R.id.txt20);
        tact1 = findViewById(R.id.txtt20);
        tact2 = findViewById(R.id.txtt21);
        tact3 = findViewById(R.id.txtt22);
        tact4 = findViewById(R.id.txtt23);
        tact5 = findViewById(R.id.txtt24);
        tact6 = findViewById(R.id.txtt25);
        DisplayMetrics metrics;
        metrics = getApplicationContext().getResources().getDisplayMetrics();
        float tamanho =txt1.getTextSize()/metrics.density;
        tamanho--;
        txt1.setTextSize(tamanho);
        txt2.setTextSize(tamanho);
        txt3.setTextSize(tamanho);
        txt4.setTextSize(tamanho);
        tact1.setTextSize(tamanho);
        tact2.setTextSize(tamanho);
        tact3.setTextSize(tamanho);
        tact4.setTextSize(tamanho);
        tact5.setTextSize(tamanho);
        tact6.setTextSize(tamanho);

    }
    protected void onDestroy(){
        super.onDestroy();
//        if(cdt!=null){
//            cdt.cancel();
//        }
    }
}
