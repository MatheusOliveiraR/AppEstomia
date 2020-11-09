package com.example.estomia20.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.estomia20.Pessoa.Pessoa;
import com.example.estomia20.Pessoa.hora;
import com.example.estomia20.Pessoa.info;
import com.example.estomia20.Pessoa.notifi;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class dao {
    private SQLiteDatabase escrever;
    private SQLiteDatabase ler;

    public String pessoa_tb = "pessoa";
    public String info_tb = "info";
    public String noti_tb = "notificacao";
    public static String hora_tb = "hora";
    public static String foto_tb= "foto";
    public static String dia_tb="dia";
    public byte[] img;

    public dao(Context context){
        banco db = new banco(context);
        escrever = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    public boolean salvarPessoa(String nome, String peso, int dia, int mes, int ano) {
        ContentValues cv = new ContentValues();
        cv.put("nome", nome) ;
        cv.put("peso", peso);
        cv.put("dia", dia);
        cv.put("mes", mes);
        cv.put("ano",ano);

        try {
            escrever.insert(pessoa_tb, null, cv);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }
    public boolean salvarDia(String dia) {
        ContentValues cv = new ContentValues();
        cv.put("id",01);
        cv.put("dia", dia) ;

        try {
            escrever.insert(dia_tb, null, cv);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }

    public String recuperarDia(){
        String sql = "SELECT * FROM " + banco.dia_tb+" ;";

        Cursor c = ler.rawQuery(sql,null);

        info info = new info();
        String dia="";
        while(c.moveToNext()){
            dia = c.getString(c.getColumnIndex("dia"));
        }
        return dia;
    }

    public boolean salvarHora(String hora) {
        ContentValues cv = new ContentValues();
        cv.put("hora", hora) ;
        cv.put("id","01");

        try {
            escrever.insert(hora_tb, null, cv);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }

    public boolean salvarInfo(String copos,String litros,String id) {
        ContentValues cv = new ContentValues();
        cv.put("id",id);
        cv.put("copos", copos) ;
        cv.put("litros", litros);

        try {
            escrever.insert(info_tb, null, cv);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }

    public boolean salvarFoto(String id, String bitmap) {
        ContentValues cv = new ContentValues();
        cv.put("id",id);
        cv.put("bitmap", bitmap) ;

        try {
            escrever.insert(foto_tb, null, cv);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }
    public boolean updateFoto(Bitmap array) {
        ContentValues cv = new ContentValues();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        array.compress(Bitmap.CompressFormat.JPEG,100,stream);
        img = stream.toByteArray();
        cv.put("bitmap", img) ;

        try {
            String args[]={"01"};
            escrever.update(foto_tb,cv,"id=?",args);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }

    public boolean salvarNotifi(String id,String qnt) {
        ContentValues cv = new ContentValues();
        cv.put("id", id) ;
        cv.put("quantidade", qnt);

        try {
            escrever.insert(noti_tb, null, cv);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }
    public boolean updateNoti(notifi notifi){
        ContentValues cv = new ContentValues();
        cv.put("quantidade",notifi.getQant());
        try{
            String[] args = {notifi.getId()};
            escrever.update(noti_tb,cv,"id=?",args);
            Log.i("Banco","Sucesso");
        }catch (Exception e){
            Log.e("Banco","Erro ao salvar: hehehehe "+e.getMessage());
            return false;
        }
        return true;
    }

    public boolean updateinfo(String copos,String litros) {
        ContentValues cv = new ContentValues();
        cv.put("copos", copos) ;
        cv.put("litros", litros);


        try {
            String args[] = {"01"};
            escrever.update(info_tb,cv,"id=?",args);
            Log.i("Banco", "Salvo com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }


    public boolean updatePessoa(String peso) {
        ContentValues cv = new ContentValues();
        cv.put("peso", peso);
        Pessoa pessoa = recuperarPessoa();
        try {
            String[] args = {pessoa.getNome()};
            escrever.update(pessoa_tb,cv,"nome=?",args);
            Log.i("Banco", "Update feito com sucesso");
        }catch (Exception e){
            Log.e("Banco: ", "Erro ao salvar, erro:" +e.getMessage());
        }
        return true;
    }

    public boolean updateHoras(hora horas){
        ContentValues cv = new ContentValues();
        cv.put("hora",horas.getHoras());
        try{
            String[] args = {horas.getId()};
            escrever.update(hora_tb,cv,"id=?",args);
            Log.i("Banco","Sucesso");
        }catch (Exception e){
            Log.e("Banco","Erro ao salvar: hehehehe "+e.getMessage());
            return false;
        }
        return true;
    }

    public boolean removerHoras() {

        try{
            String[] args = {"01"};
            escrever.delete(hora_tb,"id=?",args);
            Log.i("Banco","Sucesso");
        }catch (Exception e){
            Log.e("Banco","Erro ao salvar: hehehehe "+e.getMessage());
            return false;
        }
        return true;
    }

    public info recuperarInfo(){
        List<info> infos = new ArrayList<>();
        String sql = "SELECT * FROM " + banco.info_tb +" ;";

        Cursor c = ler.rawQuery(sql,null);

        info info = new info();
        while(c.moveToNext()){
            String copos = c.getString(c.getColumnIndex("copos"));
            String litros = c.getString(c.getColumnIndex("litros"));
            info.setCopos(copos);
            info.setLitros(litros);
            infos.add(info);
        }
        return info;
    }
    public Bitmap recuperarFoto(){
        String sql = "SELECT * FROM " + banco.foto_tb +" ;";

        Cursor c = ler.rawQuery(sql,null);
        byte[] bites=null;
        while(c.moveToNext()){
            String id = c.getString(c.getColumnIndex("id"));
            bites = c.getBlob(c.getColumnIndex("bitmap"));
        }
        Bitmap bitmap = BitmapFactory.decodeByteArray(bites,0,bites.length);
        return bitmap;
    }

    public hora recuperarHoras(){
        String sql = "SELECT * FROM " + banco.hora_tb +" ;";

        Cursor c = ler.rawQuery(sql,null);

        hora horas = new hora();
        while(c.moveToNext()){
            String id = c.getString(c.getColumnIndex("id"));
            String horass = c.getString(c.getColumnIndex("hora"));
            horas.setId(id);
            horas.setHoras(horass);
        }
        return horas;
    }
    public notifi recuperarNotifi(){
        List<notifi> notifi = new ArrayList<>();
        String sql = "SELECT * FROM " + banco.noti_tb +" ;";

        Cursor c = ler.rawQuery(sql,null);

        notifi notifis = new notifi();
        while(c.moveToNext()){
            String quant = c.getString(c.getColumnIndex("quantidade"));
            String dispa = c.getString(c.getColumnIndex("id"));
            notifis.setdispa(dispa);
            notifis.setQant(quant);
            notifi.add(notifis);
        }
        return notifis;
    }


    public Pessoa recuperarPessoa(){
        List<Pessoa> pessoa = new ArrayList<>();
        String sql = "SELECT * FROM " + banco.pessoa_tb +";";

        Cursor c = ler.rawQuery(sql,null);
            Pessoa gente = new Pessoa();
            while(c.moveToNext()) {
                String nome = c.getString(c.getColumnIndex("nome"));
                String peso = c.getString(c.getColumnIndex("peso"));
                int dia = c.getInt(c.getColumnIndex("dia"));
                int mes = c.getInt(c.getColumnIndex("mes"));
                int ano = c.getInt(c.getColumnIndex("ano"));
                gente.setNome(nome);
                gente.setDia(dia);
                gente.setAno(ano);
                gente.setMes(mes);
                gente.setPeso(peso);
                pessoa.add(gente);
            }
        return gente;
    }


    public boolean deletar(String x, String y) {
        return false;
    }
}
