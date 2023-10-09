package Modelo;

import Datos.ProfesorDatos;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author SkylakeFrost
 */
public class ProfesorModelo {

    private int dni;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private String domicilio;
    private String telefono;
    private ProfesorDatos profesorDAO = new ProfesorDatos();

    public ProfesorModelo() {
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

    //CRUD
    //CREATE
    public boolean createProfesor(ProfesorModelo profesor) {
        return profesorDAO.create(profesor);
    }

    //READ
    public List<ProfesorModelo> readProfesores() {
        return profesorDAO.read();
    }

    //UPDATE
    public boolean updateProfesores(ProfesorModelo profesor) {
        return profesorDAO.update(profesor);
    }

    //DELETE
    public boolean deleteProfesor(int idProfesor) {
        return profesorDAO.delete(idProfesor);
    }

    //FIND
    public boolean profesorExist(int dniProf) {
        return profesorDAO.exist(dniProf);
    }
}
