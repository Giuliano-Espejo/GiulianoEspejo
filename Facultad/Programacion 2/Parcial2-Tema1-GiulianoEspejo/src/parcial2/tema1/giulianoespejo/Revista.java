/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.tema1.giulianoespejo;

/**
 *
 * @author giuli
 */
public class Revista extends Documento {

    private String titulo;

    public Revista(String titulo, Biblioteca biblioteca, Editorial editorial, Categoria categoria) {
        super(titulo, biblioteca, editorial, categoria);
        this.titulo = titulo;
    }

    public Revista() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
