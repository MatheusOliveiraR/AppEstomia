package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class teste2 extends AppCompatActivity {
    private Button button6;
    private Button button7;
    private ScrollView sv;
    private ScrollView sv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste2);

        sv = findViewById(R.id.scrollview);
        sv.setVisibility(sv.GONE);
        sv2 = findViewById(R.id.sv2);

        button6 = findViewById(R.id.Botao1);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv.getVisibility()==sv.GONE){
                    button6.setBackgroundResource(R.drawable.btn);
                    button6.setTextColor(getResources().getColor(R.color.bra));
                    desabilitarSV();
                    sv.setVisibility(sv.VISIBLE);
                }else{
                    button6.setBackgroundResource(R.drawable.btnpassov2);
                    button6.setTextColor(getResources().getColor(R.color.verde));
                    button6.setText("O que é uma estomia intestinal?");
                    sv.setVisibility(sv.GONE);
                }

            }
        });

        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sv2.getVisibility()==sv2.GONE){
                    button7.setBackgroundResource(R.drawable.btn);
                    button7.setTextColor(getResources().getColor(R.color.bra));
                    desabilitarSV();
                    sv2.setVisibility(sv2.VISIBLE);
                }else{
                    button7.setBackgroundResource(R.drawable.btnpassov2);
                    button7.setTextColor(getResources().getColor(R.color.verde));
                    sv2.setVisibility(sv2.GONE);
                }
            }
        });
    }
    public void desabilitarSV(){
        sv = findViewById(R.id.scrollview);
        sv2 = findViewById(R.id.sv2);

        sv.setVisibility(sv.GONE);
        sv2.setVisibility(sv.GONE);
    }

}