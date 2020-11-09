package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.estomia20.Pessoa.Pessoa;
import com.example.estomia20.Pessoa.notifi;
import com.example.estomia20.banco.dao;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class MainActivity extends AppCompatActivity {
    Button proximo;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verificarUsuarioCriado();
        dao dao = new dao(getApplicationContext());
        notifi pessoa = new notifi();
        pessoa = dao.recuperarNotifi();
        proximo = findViewById(R.id.proximo);
        if(pessoa.getId()!=null){
            proximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(),menu.class));
                    finish();
                }
            });
        }else {

            proximo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    startActivity(new Intent(getApplicationContext(), cadastro.class));
                    finish();
                }
            });
        }
    }
    private void verificarUsuarioCriado(){
        dao dd = new dao(getApplicationContext());
        notifi temp = new notifi();
        temp = dd.recuperarNotifi();
        if(temp.getId()!=null){
            startActivity(new Intent(getApplicationContext(),menu.class));
            finish();
        }
    }
}
