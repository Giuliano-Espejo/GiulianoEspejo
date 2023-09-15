/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.MateriaDatos;
import java.util.List;
/**
 *
 * @author Giuliano Espejo
 */
public class MateriaModelo {
    private int codMateria;
    private String nombreMateria;
    private int dniProfesor;
    private MateriaDatos materiaDatos = new MateriaDatos();

    public MateriaModelo() {
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getDniProfesor() {
        return dniProfesor;
    }

    public void setDniProfesor(int dniProfesor) {
        this.dniProfesor = dniProfesor;
    }

    public MateriaDatos getMateriaDAO() {
        return materiaDatos;
    }

    public void setMateriaDatos(MateriaDatos materiaDatos) {
        this.materiaDatos = materiaDatos;
    }

//CRUD
    //CREATE
    public boolean creaMateria(MateriaModelo materia) {
        return materiaDatos.crea(materia);
    }

    //READ
    public List<MateriaModelo> leeMaterias() {
        return materiaDatos.lee();
    }

    //UPDATE
    public boolean actualizaMateria(MateriaModelo materia) {
        return materiaDatos.actualiza(materia);
    }

    //DELETE
    public boolean borraMateria(int idMateria) {
        return materiaDatos.borra(idMateria);
    }

    public boolean ExisteMateria(int codMate) {
        return materiaDatos.existe(codMate);
    }
}
