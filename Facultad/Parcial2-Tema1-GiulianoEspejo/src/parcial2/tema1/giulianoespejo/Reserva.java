/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.tema1.giulianoespejo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author giuli
 */
public class Reserva {
    private List<Documento> documentos = new ArrayList();
    private Date fechaDeReserva;

    public Reserva() {
    }

    public Reserva(Date fechaDeReserva, Documento documento) {
        this.fechaDeReserva = fechaDeReserva;
        documentos.add(documento);
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void addDocumentos(Documento documento) {
        this.documentos.add(documento);
    }

    public Date getFechaDeReserva() {
        return fechaDeReserva;
    }

    public void setFechaDeReserva(Date fechaDeReserva) {
        this.fechaDeReserva = fechaDeReserva;
    }
    
    
}
