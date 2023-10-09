/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

    Vista vista = new Vista();
    Modelo modelo = new Modelo();

    public Controlador(Vista vista) {
        this.vista = vista;

        this.vista.jbBorrar.addActionListener(this);
        this.vista.jbDesc.addActionListener(this);
        this.vista.jbEnci.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jbBorrar) {
            vista.jtSalida.setText("");
        } else if (e.getSource() == vista.jbEnci) {
            try {
                modelo.crearAbecedario(vista.jtCantMov.getText());
                vista.jtSalida.setText(modelo.encriptar(vista.jtEntrada1.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en al ingresar cantidad de lugares", "ERROR", 0);
            }
        } else if (e.getSource() == vista.jbDesc) {
            try {
                modelo.crearAbecedario(vista.jtCantMov.getText());
                vista.jtSalida.setText(modelo.desencriptar(vista.jtEntrada1.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error en al ingresar cantidad de lugares", "ERROR", 0);
            }
        }
    }

}
