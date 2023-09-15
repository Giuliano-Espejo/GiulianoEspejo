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
public class Usuario {
    private String nombre;
    private String correoElectronico;
    private List<Prestamo> prestamos = new ArrayList();
    private List<Reserva> reservas = new ArrayList();

    public Usuario(String nombre, String correoElectronico) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void addPrestamos(Prestamo prestamo) {
        this.prestamos.add(prestamo);
    }

    public void removePrestamos(Prestamo prestamo) {
        this.prestamos.remove(prestamo);
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

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", correoElectronico=" + correoElectronico + '}';
    }
    
}
