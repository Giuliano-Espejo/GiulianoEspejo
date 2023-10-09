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
public class RevistaDeportiva extends Revista{
    protected String deporte;

    public RevistaDeportiva(String deporte, String titulo, Biblioteca biblioteca, Editorial editorial, Categoria categoria) {
        super(titulo, biblioteca, editorial, categoria);
        this.deporte = deporte;
    }

   

    public RevistaDeportiva() {
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    @Override
    public String toString() {
        return "RevistaDeportiva{" + "deporte=" + deporte +  ", Titulo= " + this.getTitulo() + ", Biblioteca=" + this.getBiblioteca().getNombre()+ ", Editorial= "+ this.getEditorial().getNombre()+ ", Categoria= " + this.getCategoria().getNombre()+ '}';
    }
    
    
    
}
