package com.example.estomia20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.estomia20.Pessoa.Pessoa;
import com.example.estomia20.banco.dao;

import java.text.DecimalFormat;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class cadastro extends AppCompatActivity {
    private TextView nome;
    private TextView idade;
    private TextView peso;
    private Button proximo;
    private Button btn_peso;
    private ImageButton galeria;
    private CircleImageView profile;
    Pessoa pessoa = new Pessoa();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        profile = findViewById(R.id.perfilzin);
        final dao dao = new dao(getApplicationContext());
        dao.salvarFoto("01","");

        nome = findViewById(R.id.NomeView);
        idade = findViewById(R.id.IdadeView);
        peso = findViewById(R.id.PesoView);

        galeria = findViewById(R.id.galeria);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(i, 200) ;

                }
            }
        });

        proximo = findViewById(R.id.proximo);
        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verificarNome()){
                    TextView tx = findViewById(R.id.nomeValido);
                    tx.setVisibility(tx.VISIBLE);
                }if(buscarIdade()){
                    TextView tx = findViewById(R.id.idadeValido);
                    tx.setVisibility(tx.VISIBLE);
                }if(buscarPeso()) {
                    TextView tx = findViewById(R.id.pesoValido);
                    tx.setVisibility(tx.VISIBLE);
                }if(!verificarNome()){
                        TextView tx = findViewById(R.id.nomeValido);
                        tx.setVisibility(tx.GONE);
                }if(!buscarIdade()) {
                    TextView tx = findViewById(R.id.idadeValido);
                    tx.setVisibility(tx.GONE);
                }if(!buscarPeso()) {
                    TextView tx = findViewById(R.id.pesoValido);
                    tx.setVisibility(tx.GONE);
                }
                if(!buscarPeso() && !buscarIdade() && !verificarNome()){
                        nome = findViewById(R.id.NomeView);
                        idade = findViewById(R.id.IdadeView);
                        peso = findViewById(R.id.PesoView);
                        pessoa.setNome(nome.getText().toString());
                        pessoa.setPeso(peso.getText().toString());

                        dao.salvarPessoa(nome.getText().toString(),peso.getText().toString(),pessoa.getDia(),pessoa.getMes(),pessoa.getAno());
                        dao.salvarNotifi("01","0");
                        float qnt = Float.parseFloat(pessoa.getPeso())*30;
                        float copoS = qnt/200;
                        int copo = (int)copoS;

                        DecimalFormat f = new DecimalFormat("#.#");
                        float litroS = qnt/1000;
                        String litros =f.format(litroS);
                        String copos = String.valueOf(copo);

                        dao.salvarInfo(copos,litros,"01");
                        startActivity(new Intent(getApplicationContext(), menu.class));
                        finish();
                    }
                }
        });
    }

    public void abrirCalendario(View view){
        Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int ano = calendario.get(Calendar.YEAR);
        final TextView tx = findViewById(R.id.IdadeView);

        DatePickerDialog datePickerDialog = new DatePickerDialog(cadastro.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int ano, int mes, int dia) {
                tx.setText(dia+"/"+(mes+1)+"/"+ano);
                tx.setTextColor(Color.BLACK);
                pessoa.setDia(dia);
                pessoa.setAno(ano);
                pessoa.setMes(mes+1);

            }
        },ano,mes,dia);
        datePickerDialog.show();
    }
    public boolean verificarNome(){
        TextView nome = findViewById(R.id.NomeView);
        if(nome.getText().toString().isEmpty()){
            return true;
        }else
        return false;
    }
    public boolean buscarIdade(){
        idade = findViewById(R.id.IdadeView);
        if(idade.getText().toString().equals("")){
            return true;
        }else
            return false;
    }
    public boolean buscarPeso(){
        peso = findViewById(R.id.PesoView);
        if(peso.getText().toString().equals("")){
            return true;
        }else
            return false;
    }

    private static Bitmap resizeImage(Context context, Bitmap bmpOriginal,
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);

        if(resultCode==RESULT_OK){
            Bitmap imagem = null;
            try{
                Uri localImg = data.getData();
                    imagem = MediaStore.Images.Media.getBitmap(getContentResolver(), localImg);

            }catch(Exception e){
                e.printStackTrace();
            }
            if(imagem!=null){
                dao dao = new dao(getApplicationContext());

                dao.updateFoto(imagem);
                profile.setImageBitmap(resizeImage(this,imagem,200,200));
            }
        }
    }
}
