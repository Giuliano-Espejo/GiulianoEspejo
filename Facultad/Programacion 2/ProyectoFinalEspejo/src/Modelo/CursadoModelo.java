/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Datos.CursadoDatos;
import java.util.List;

/**
 *
 * @author Giuliano Espejo
 */
public class CursadoModelo {
    private int alumnoDni;
    private int codigoMateria;
    private double nota;
    private CursadoDatos cursadoDatos = new CursadoDatos();

    public CursadoModelo() {
    }

    public int getAlumnoDni() {
        return alumnoDni;
    }

    public void setAlumnoDni(int alumnoDni) {
        this.alumnoDni = alumnoDni;
    }

    public int getCodigoMateria() {
        return codigoMateria;
    }

    public void setCodigoMateria(int codigoMateria) {
        this.codigoMateria = codigoMateria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    //CRUD
    //CREATE
    public boolean creaCursado(CursadoModelo cursado) {
        return cursadoDatos.crea(cursado);
    }

    //READ
    public List<CursadoModelo> leeCursado() {
        return cursadoDatos.lee();
    }

    //UPDATE
    public boolean actualizaCursado(CursadoModelo cursado) {
        return cursadoDatos.actualiza(cursado);
    }

    //DELETE
    public boolean borraCursado(int idCursado) {
        return cursadoDatos.borra(idCursado);
    }

    //BUSCAR
    public CursadoModelo buscaCursado(int idCursado) {
        return cursadoDatos.busca(idCursado);
    }
}
