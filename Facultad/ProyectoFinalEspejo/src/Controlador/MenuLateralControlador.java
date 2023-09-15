/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuLateral;
import Vista.Alumno;
import Vista.Cursado;
import Vista.Materia;

/**
 *
 * @author Giuliano Espejo
 */
public class MenuLateralControlador implements ActionListener {

    private MenuLateral menu = new MenuLateral();
    private Alumno alumno = new Alumno();
    private Cursado cursado = new Cursado();
    private Materia materia = new Materia();
    private AlumnoControlador ac = new AlumnoControlador(menu, alumno);
    private CursadoControlador cc = new CursadoControlador(menu, cursado);
    private MateriaControlador mc = new MateriaControlador(menu, materia);

    public MenuLateralControlador(MenuLateral menu) {
        this.menu = menu;

        this.menu.jbAlumnos.addActionListener(this);
        this.menu.jbCursado.addActionListener(this);
        this.menu.jbMaterias.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.setVisible(false);
        if (e.getSource() == menu.jbAlumnos) {
            alumno.setVisible(true);
            alumno.jpLateral.add(menu.jpLateral);
            cursado.setVisible(false);
            materia.setVisible(false);
            alumno.setLocationRelativeTo(null);
            alumno.setResizable(false);
            alumno.setTitle("Proyecto Final - Programacion II");
        } else if (e.getSource() == menu.jbCursado) {
            alumno.setVisible(false);
            cursado.setVisible(true);
            cursado.jpLateral.add(menu.jpLateral);
            materia.setVisible(false);
            cursado.setLocationRelativeTo(null);
            cursado.setResizable(false);
            cursado.setTitle("Proyecto Final - Programacion II");
        } else if (e.getSource() == menu.jbMaterias) {
            alumno.setVisible(false);
            cursado.setVisible(false);
            materia.setVisible(true);
            materia.jpLateral.add(menu.jpLateral);
            materia.setLocationRelativeTo(null);
            materia.setResizable(false);
            materia.setTitle("Proyecto Final - Programacion II");
        }
    }

}
