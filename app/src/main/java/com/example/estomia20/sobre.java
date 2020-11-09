package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class sobre extends AppCompatActivity {
    private Button back;
    private ImageButton iv;
    private ImageButton iv2;
    private ImageButton iv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        iv3 = findViewById(R.id.imageView23);
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),envolvidos.class));
            }
        });

        iv = findViewById(R.id.imageView27);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),direitosAutorais.class));
            }
        });

        iv2 = findViewById(R.id.imageView24);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),universidades.class));
            }
        });

        back = findViewById(R.id.button24);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private static Bitmap redimensionar(Context context, Bitmap bmpOriginal,
                                      float newWidth, float newHeight) {
        Bitmap novoBmp = null;

        int w = bmpOriginal.getWidth();
        int h = bmpOriginal.getHeight();

        float densityFactor = context.getResources().getDisplayMetrics().density;
        float novoW = newWidth * densityFactor;
        float novoH = newHeight * densityFactor;

        //Calcula escala em percentagem do tamanho original para o novo tamanho
        float scalaW = novoW / w;
        float scalaH = novoH / h;

        // Criando uma matrix para manipulação da imagem BitMap
        Matrix matrix = new Matrix();

        // Definindo a proporção da escala para o matrix
        matrix.postScale(scalaW, scalaH);

        //criando o novo BitMap com o novo tamanho
        novoBmp = Bitmap.createBitmap(bmpOriginal, 0, 0, w, h, matrix, true);

        return novoBmp;
    }
}