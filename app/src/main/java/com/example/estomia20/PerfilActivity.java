package com.example.estomia20;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.estomia20.Pessoa.Pessoa;
import com.example.estomia20.Pessoa.info;
import com.example.estomia20.banco.dao;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfilActivity extends AppCompatActivity implements popup.popupListener {
    private ImageButton btnGaleria;
    private TextView name;
    private TextView idade;
    private TextView peso;
    private TextView copos;
    private ImageButton volta;
    private CircleImageView perfil;
    private ImageButton editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        dao dao = new dao(getApplicationContext());
        Pessoa pessoa = new Pessoa();
        pessoa = dao.recuperarPessoa();

        perfil = findViewById(R.id.ImagemPerfil);

        name = findViewById(R.id.nome);
        name.setText(pessoa.getNome());

        idade = findViewById(R.id.idade);
        idade.setText(String.valueOf(CalcularIdade()));

        peso = findViewById(R.id.Peso);
        peso.setText(pessoa.getPeso());
        info info;
        info = dao.recuperarInfo();
        copos = findViewById(R.id.textCopos);
        copos.setText("    "+info.getLitros()+ " Litros \n   Equivalente a\n" +info.getCopos()+" copos de 200ml"  );
        copos.setTextAlignment(copos.TEXT_ALIGNMENT_CENTER);
        perfil.setImageBitmap(dao.recuperarFoto());

        btnGaleria = findViewById(R.id.galeria);
        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if(i.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(i, 200) ;

                }
            }
        });



        volta = findViewById(R.id.volta);
        volta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        editar = findViewById(R.id.imageButton9);
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });


    }
    public int CalcularIdade(){
        Calendar c = Calendar.getInstance();
        int diaAtual = c.get(c.DAY_OF_MONTH);
        int mesAtual = c.get(c.MONTH);
        int anoAtual = c.get(c.YEAR);
        dao dao = new dao(getApplicationContext());
        Pessoa pessoa = new Pessoa();
        pessoa = dao.recuperarPessoa();

        int idadeNova = anoAtual - pessoa.getAno();
        if(mesAtual<pessoa.getMes()){
            idadeNova--;
        }else if(diaAtual<pessoa.getDia()){
            idadeNova--;
        }
        if(idadeNova>=0){
        return idadeNova;
        }else return 0;
    }


    public void openDialog(){
        popup pop = new popup();
        pop.show(getSupportFragmentManager(),"Exemplo");
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
                perfil.setImageBitmap(resizeImage(this,imagem,200,200));
            }
        }
    }

    @Override
    public void apllyTexts(String peso) {
        dao dao = new dao(getApplicationContext());
        dao.updatePessoa(peso);
        Pessoa pessoa = dao.recuperarPessoa();

        TextView idades = findViewById(R.id.idade);
        idades.setText(String.valueOf(CalcularIdade()));

        TextView pesos = findViewById(R.id.Peso);
        pesos.setText(pessoa.getPeso());

        float qnt = Float.parseFloat(peso)*30;
        float copoS = qnt/200;
        int copo = (int)copoS;

        DecimalFormat f = new DecimalFormat("#.#");
        float litroS = qnt/1000;
        String litros =f.format(litroS);
        String copos = String.valueOf(copo);

        dao.updateinfo(copos,litros);

        info info;
        info = dao.recuperarInfo();
        TextView coposs = findViewById(R.id.textCopos);
        coposs.setText("    "+info.getLitros()+ " Litros \n   Equivalente a\n" +info.getCopos()+" copos de 200ml"  );

        startActivity(new Intent(getApplicationContext(),menu.class));
    }
}
