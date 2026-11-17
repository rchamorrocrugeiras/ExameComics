package model;

import java.io.Serializable;

public class Autor implements Serializable {
    private int id;
    private String nome;
    private String apelidos;
    private String nacionalidade;

    public Autor(String nome, String apelidos, String nacionalidade) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.nacionalidade = nacionalidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String toString() {
        return nome + " " + apelidos;
    }
}