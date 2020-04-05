package com.example.calculandoseupeso.activity.activity.model;

public class TabelaImc {

    private String titulo;
    private String resultado;

    //Construtor vazio
    public TabelaImc(){

    }

    //Construtor com Parametros
    public TabelaImc(String titulo, String resultado) {
        this.titulo = titulo;
        this.resultado = resultado;

    }

    //Getter and Seter
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
