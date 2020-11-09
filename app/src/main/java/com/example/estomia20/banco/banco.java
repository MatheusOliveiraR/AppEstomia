package com.example.estomia20.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class banco extends SQLiteOpenHelper {

    public static int version = 1;
    public static String nome_db = "Estomia";
    public static String pessoa_tb = "pessoa";
    public static String info_tb = "info";
    public static String noti_tb = "notificacao";
    public static String hora_tb = "hora";
    public static String foto_tb= "foto";
    public static String dia_tb="dia";

    public banco(Context context ) {
        super(context, nome_db, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS " + pessoa_tb + " (nome VARCHAR NOT NULL PRIMARY KEY,dia INT,mes INT, ano INT,peso VARCHAR(3));";
        String sql2 = "CREATE TABLE IF NOT EXISTS " + info_tb + " (id VARCHAR, copos VARCHAR(2), litros VARCHAR(2));";
        String sql3= "CREATE TABLE IF NOT EXISTS " + noti_tb + " (id VARCHAR, quantidade VARCHAR);";
        String sql4= "CREATE TABLE IF NOT EXISTS " + hora_tb + "(id VARCHAR, hora VARCHAR);";
        String sql5 = "CREATE TABLE IF NOT EXISTS " + foto_tb + "(id Varchar, bitmap BLOB);";
        String sql6 = "CREATE TABLE IF NOT EXISTS " + dia_tb + "(id Varchar, dia VARCHAR);";


        try{
            db.execSQL(sql);
            db.execSQL(sql2);
            db.execSQL(sql3);
            db.execSQL(sql4);
            db.execSQL(sql5);
            db.execSQL(sql6);
            Log.i("Info", "Sucesso");
        }catch(Exception e){
            Log.i("INFO", "Erro ao criar banco de dados: "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Log.i("Info", "Sucesso");
        }catch(Exception e){
            Log.i("INFO", "Erro ao criar banco de dados: "+e.getMessage());
        }
    }
}
