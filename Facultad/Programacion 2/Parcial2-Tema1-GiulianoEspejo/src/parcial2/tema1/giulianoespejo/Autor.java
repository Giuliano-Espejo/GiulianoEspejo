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
public class Autor {
    private String nombre;
    private String apellido;
    List<Documento> documentos = new ArrayList();

    public Autor(String nombre, String apellido, Documento documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentos.add(documento);
    }

    public Autor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumentos(Documento documento) {
        this.documentos.add(documento);
    }
    
    public void removeDocumentos(Documento documento) {
        this.documentos.remove(documento);
    }
    
}
