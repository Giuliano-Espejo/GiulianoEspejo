/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.AlumnoDatos;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author Giuliano Espejo
 */
public class AlumnoModelo {
    private int dni;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String domicilio;
    private String telefono;
    private int codigoInscripcion;
    private AlumnoDatos alumnoDatos = new AlumnoDatos();
    
    public AlumnoModelo() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCodigoInscripcion() {
        return codigoInscripcion;
    }

    public void setCodigoInscripcion(int codigoInscripcion) {
        this.codigoInscripcion = codigoInscripcion;
    }
    
     //CRUD
    //CREATE
    public boolean creaAlumno(AlumnoModelo alumno) {
        return alumnoDatos.crear(alumno);
    }

    //READ
    public List<AlumnoModelo> leeAlumnos() {
        return alumnoDatos.lee();
    }

    //UPDATE
    public boolean actualizaAlumno(AlumnoModelo alumno) {
        return alumnoDatos.actualizar(alumno);
    }

    //DELETE
    public boolean borraAlumno(int idAlumno) {
        return alumnoDatos.borra(idAlumno);
    }

    public AlumnoModelo buscaAlumno(int dniAlumno) {
        return alumnoDatos.busca(dniAlumno);
    }

    public boolean actualizaCarreraAlumno(AlumnoModelo alumno) {
        return alumnoDatos.actualizarCarrera(alumno);
    }

    public boolean existeAlumno(int dniAlumno) {
        return alumnoDatos.existe(dniAlumno);
    }
}
