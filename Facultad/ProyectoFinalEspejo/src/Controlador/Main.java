/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controlador;

import Vista.MenuLateral;

/**
 *
 * @author Giuliano Espejo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MenuLateral menu = new MenuLateral();
        MenuLateralControlador mc = new MenuLateralControlador(menu);
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        menu.setResizable(false);
        menu.setTitle("Proyecto Final - Programacion II");

    }

}
