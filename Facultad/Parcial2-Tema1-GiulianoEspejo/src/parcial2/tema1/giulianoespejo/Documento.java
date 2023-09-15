/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.tema1.giulianoespejo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giuli
 */
public class Documento {

    private String titulo;
    private List<Autor> autores = new ArrayList();
    private Biblioteca biblioteca;
    private Editorial editorial;
    private Categoria categoria;

    public Documento(String titulo, Biblioteca biblioteca, Editorial editorial, Categoria categoria) {
        this.titulo = titulo;
        this.biblioteca = biblioteca;
        this.editorial = editorial;
        this.categoria = categoria;
    }

    public Documento() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void addAutores(Autor autor) {
        this.autores.add(autor);
    }

    public void removeAutores(Autor autor) {
        this.autores.remove(autor);
    }

    @Override
    public String toString() {
        return "Documento{" + "titulo=" + titulo + ", biblioteca=" + biblioteca.getNombre() + ", editorial=" + editorial.getNombre() + ", categoria=" + categoria.getNombre() + '}';
    }

}
