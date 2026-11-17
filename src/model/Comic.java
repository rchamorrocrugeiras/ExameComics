package model;

public class Comic {
    private int id;
    private String titulo;
    private int ano;
    private Autor autor;
    private Protagonista protagonista;

    public Comic(String titulo, int ano, Autor autor, Protagonista protagonista) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.protagonista = protagonista;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Protagonista getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Protagonista protagonista) {
        this.protagonista = protagonista;
    }
}
