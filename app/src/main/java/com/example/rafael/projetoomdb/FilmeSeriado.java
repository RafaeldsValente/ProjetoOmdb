package com.example.rafael.projetoomdb;

/**
 * Created by Rafael on 25/03/2017.
 */

public class FilmeSeriado {

    private String titulo;
    private String genero;
    private String ano;
    private String pais;
    private String duracao;
    private String avaliacao;

    public FilmeSeriado() {
    }

    public FilmeSeriado(String titulo, String genero, String ano, String pais, String duracao, String avaliacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.pais = pais;
        this.duracao = duracao;
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "FilmeSeriado{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", ano=" + ano +
                ", pais='" + pais + '\'' +
                ", duracao=" + duracao +
                ", avaliacao='" + avaliacao + '\'' +
                '}';
    }
}