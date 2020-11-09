package com.example.estomia20.Pessoa;

public class Pessoa {
    int dia;
    int mes;
    int ano;
    String peso;
    String nome;

    public void setPeso(String peso){
        this.peso=peso;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public String getPeso(){
        return peso;
    }
    public String getNome(){
        return nome;
    }
}
