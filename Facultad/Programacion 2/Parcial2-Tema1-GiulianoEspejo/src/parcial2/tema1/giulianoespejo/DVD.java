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
public class DVD extends Multimedia {

    protected int duracion;

    public DVD() {
    }

    public DVD(int duracion, String titulo, Biblioteca biblioteca, Editorial editorial, Categoria categoria) {
        super(titulo, biblioteca, editorial, categoria);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "DVD{" + "duracion=" + duracion +  ", Titulo= " + this.getTitulo() + ", Biblioteca=" + this.getBiblioteca().getNombre()+ ", Editorial= "+ this.getEditorial().getNombre()+ ", Categoria= " + this.getCategoria().getNombre()+ '}';
    }

    
}
