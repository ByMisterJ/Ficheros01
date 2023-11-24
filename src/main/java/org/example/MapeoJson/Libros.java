package org.example.MapeoJson;

public class Libros {

    private int isbn;
    private String titulo;
    private String autor;
    private int anyo_publicacion;

    public Libros(){

    }
    public Libros(int isbn, String titulo, String autor, int anyo_publicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anyo_publicacion = anyo_publicacion;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnyo_publicacion() {
        return anyo_publicacion;
    }

    public void setAnyo_publicacion(int anyo_publicacion) {
        this.anyo_publicacion = anyo_publicacion;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "isbn=" + isbn +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anyo_publicacion=" + anyo_publicacion +
                '}';
    }
}
