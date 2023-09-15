/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Giuliano Espejo
 */
public class Validaciones {
    //Validaciones Que Se Usan Para Varios Modelos, Alumno, Profesor, etc

    public boolean verificarDni(String dni) {
        //DNI Debe Contener 8 Caracteres, Ni Mas Ni Menos!
        if (dni.length() > 8 || dni.length() < 8) {
            return false;
        } else {
            return true;
        }
    }

    public boolean dniContieneLetras(String dni) {

        try {
            Integer.parseInt(dni);
            return true;//Si El DNI No Contiene Letras Retorna True
        } catch (NumberFormatException e) {
            return false;//Lo Contrario retorna false
        }
    }

    public boolean verificarTelefono(String tel) {
        //El Telefono No Puede Tener Mas De 12 Caracteres Alfanumericos
        //Por Ej. +2617684576
        if (tel.length() > 12) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarNota(double nota) {
        if (nota >= 1.0 && nota <= 10.0) {
            return true; // si la nota esta entre 1 y 10 retorna true
        } else {
            return false; // de lo contrario retorna false
        }

    }

    public boolean notaContieneLetras(String nota) {
        try {
            System.out.println("nota " + nota);
            Double.parseDouble(nota);
            return true;//Si La Nota No Contiene Letras Retorna true
        } catch (NumberFormatException e) {
            return false;//De lo contrario retorna false
        }
    }

    public boolean validaCodigoMat(String codigo){
        try{
            Integer.parseInt(codigo);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
