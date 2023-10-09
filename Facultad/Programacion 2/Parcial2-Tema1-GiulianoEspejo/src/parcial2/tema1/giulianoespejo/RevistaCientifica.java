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
public class RevistaCientifica extends Revista {

    protected int issn;

    public RevistaCientifica() {
    }

    public RevistaCientifica(int issn, String titulo, Biblioteca biblioteca, Editorial editorial, Categoria categoria) {
        super(titulo, biblioteca, editorial, categoria);
        this.issn = issn;
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    @Override
    public String toString() {
        return "RevistaCientifica{" + "issn=" + issn + ", Titulo= " + this.getTitulo() + ", Biblioteca=" + this.getBiblioteca().getNombre()+ ", Editorial= "+ this.getEditorial().getNombre()+ ", Categoria= " + this.getCategoria().getNombre()+ '}';
    }
    
    

}
