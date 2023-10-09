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
public class CD extends Multimedia {

    protected String artista;

    public CD() {
    }

    public CD(String artista, String titulo, Biblioteca biblioteca, Editorial editorial, Categoria categoria) {
        super(titulo, biblioteca, editorial, categoria);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "CD{" + "artista=" + artista + ", Titulo= " + this.getTitulo() + ", Biblioteca=" + this.getBiblioteca().getNombre()+ ", Editorial= "+ this.getEditorial().getNombre()+ ", Categoria= " + this.getCategoria().getNombre()+ '}';
    }

    
}
