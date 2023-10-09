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
public class Prestamo implements InterfazDevolucion {

    private Date fechaDeInicio;
    private Date fechaDedevolicion;
    private List<Documento> documentos = new ArrayList();
    private List<Reserva> reservas = new ArrayList();

    public Prestamo(Date fechaDeInicio, Date fechaDedevolicion, Documento documento) {
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDedevolicion = fechaDedevolicion;
        documentos.add(documento);
    }

    public Prestamo() {
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaDedevolicion() {
        return fechaDedevolicion;
    }

    public void setFechaDedevolicion(Date fechaDedevolicion) {
        this.fechaDedevolicion = fechaDedevolicion;
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

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void addReservas(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void removeReservas(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public boolean chequeReserva(Reserva reserva) {
        if (reserva.getFechaDeReserva() != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean devolverLibro() {
        return true;
    }

}
