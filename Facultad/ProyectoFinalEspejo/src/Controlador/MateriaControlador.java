/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.AgregarMateria;
import Vista.Materia;
import Vista.MenuLateral;
import Vista.EditarMateria;
import Modelo.MateriaModelo;
import Datos.ProfesorDatos;
import Modelo.ProfesorModelo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giuliano Espejo
 */
public class MateriaControlador implements ActionListener {

    private Materia materia = new Materia();
    private AgregarMateria agregaMateria = new AgregarMateria();
    private MenuLateral menu = new MenuLateral();
    private EditarMateria editarMateria = new EditarMateria();
    private MateriaModelo materiaModelo = new MateriaModelo();
    private Validaciones validacion = new Validaciones();
    private DefaultTableModel modelo;
    private ProfesorDatos profesorDAO = new ProfesorDatos();

    public MateriaControlador(MenuLateral menu, Materia materia) {
        this.menu = menu;
        this.materia = materia;

        this.materia.jbBorrar.addActionListener(this);
        this.materia.jbEditar.addActionListener(this);
        this.materia.jbNuevo.addActionListener(this);

        this.editarMateria.jbCancelar.addActionListener(this);
        this.editarMateria.jbGuardar.addActionListener(this);

        this.agregaMateria.jbCancelar.addActionListener(this);
        this.agregaMateria.jbGuardar.addActionListener(this);
        listarMateria(materia.jtMaterias);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == materia.jbBorrar) {
            eliminar();
        } else if (e.getSource() == materia.jbEditar) {
            cargarComboBoxProfesores();
            cargaDatosEditar();
        } else if (e.getSource() == editarMateria.jbCancelar) {
            editarMateria.setVisible(false);
        } else if (e.getSource() == editarMateria.jbGuardar) {
            editar();
        } else if (e.getSource() == materia.jbNuevo) {
            agregaMateria.setVisible(true);
            agregaMateria.setLocationRelativeTo(null);
            agregaMateria.setResizable(false);
            cargarComboBoxProfesores();
        } else if (e.getSource() == agregaMateria.jbCancelar) {
            limpiarNuevo();
        } else if (e.getSource() == agregaMateria.jbGuardar) {
            guarda();
        }
    }

    public void listarMateria(JTable table) {
        modelo = (DefaultTableModel) materia.jtMaterias.getModel();
        materia.jtMaterias.setRowHeight(30);
        List<MateriaModelo> lista = materiaModelo.leeMaterias();
        Object[] fila = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getCodMateria();
            fila[1] = lista.get(i).getNombreMateria();
            fila[2] = lista.get(i).getDniProfesor();

            modelo.addRow(fila);
        }
        materia.jtMaterias.setModel(modelo);
    }

    public void limpiarTabla() {
        for (int i = 0; i < materia.jtMaterias.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void eliminar() {
        int fila = materia.jtMaterias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Desea Elimnar La Materia " + materia.jtMaterias.getValueAt(fila, 1) + "?", "Seleccione Una Opc.", JOptionPane.YES_NO_OPTION) == 0) {
                int id = Integer.parseInt((String) materia.jtMaterias.getValueAt(fila, 0).toString());
                materiaModelo.borraMateria(id);
                limpiarTabla();
                listarMateria(materia.jtMaterias);
                JOptionPane.showMessageDialog(null, "Eliminado!");
            }

        }
    }

    public void cargaDatosEditar() {
        int fila = materia.jtMaterias.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            editarMateria.jTextCodMateria.setText(materia.jtMaterias.getValueAt(fila, 0).toString());
            editarMateria.jTextNombreMat.setText(materia.jtMaterias.getValueAt(fila, 1).toString());
            editarMateria.jcbProfesor.setSelectedItem(materia.jtMaterias.getValueAt(fila, 2).toString());
            editarMateria.setVisible(true);
            editarMateria.setLocationRelativeTo(null);
            editarMateria.setResizable(false);
        }
    }

    public void editar() {
        if (validarTextoCamposEditar() == false) {
            JOptionPane.showMessageDialog(null, "Campo Vacio!");
        } else {
            materiaModelo.setCodMateria(Integer.valueOf(editarMateria.jTextCodMateria.getText()));
            materiaModelo.setNombreMateria(editarMateria.jTextNombreMat.getText());
            materiaModelo.setDniProfesor(splitearProfe(editarMateria.jcbProfesor.getSelectedItem().toString()));

            if (materiaModelo.actualizaMateria(materiaModelo) == true) {

                limpiarTabla();
                listarMateria(materia.jtMaterias);
                JOptionPane.showMessageDialog(null, "Editado Con Exito!");
                editarMateria.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }

    public boolean validarTextoCamposEditar() {
        if (editarMateria.jTextNombreMat.getText().isEmpty()
                || editarMateria.jcbProfesor.getSelectedItem().equals("Seleccionar Profesor")) {
            return false;
        } else {
            return true;
        }
    }

    public void limpiarNuevo() {
        agregaMateria.setVisible(false);
        agregaMateria.jTextCodMateria.setText("");
        agregaMateria.jTextNomMateria.setText("");
        agregaMateria.jcbProfesor.addItem("Seleccionar Profesor");
    }

    public void cargarComboBoxProfesores() {
        List<ProfesorModelo> listaProfesores = profesorDAO.read();

        agregaMateria.jcbProfesor.removeAllItems();
        agregaMateria.jcbProfesor.addItem("Seleccionar Profesor");
        for (int i = 0; i < listaProfesores.size(); i++) {
            agregaMateria.jcbProfesor.addItem(listaProfesores.get(i).getDni() + " - " + listaProfesores.get(i).getNombre() + " " + listaProfesores.get(i).getApellido());
        }
        editarMateria.jcbProfesor.removeAllItems();
        editarMateria.jcbProfesor.addItem("Seleccionar Profesor");
        for (int i = 0; i < listaProfesores.size(); i++) {
            editarMateria.jcbProfesor.addItem(listaProfesores.get(i).getDni() + " - " + listaProfesores.get(i).getNombre() + " " + listaProfesores.get(i).getApellido());

        }
    }

    public void guarda() {
        if (camposVacios() == false) {
            JOptionPane.showMessageDialog(null, "Campos Vacios!");
        } else if (validacion.validaCodigoMat(agregaMateria.jTextCodMateria.getText()) == false) {
            JOptionPane.showMessageDialog(null, "El codigo: " + agregaMateria.jTextCodMateria.getText() + " no es un numero!");
        } else if (materiaModelo.ExisteMateria(Integer.valueOf(agregaMateria.jTextCodMateria.getText())) == true) {
            JOptionPane.showMessageDialog(null, "La Materia Con Codigo " + agregaMateria.jTextCodMateria.getText() + " Ya Existe!");
        } else {
            materiaModelo.setCodMateria(Integer.valueOf(agregaMateria.jTextCodMateria.getText()));
            materiaModelo.setNombreMateria(agregaMateria.jTextNomMateria.getText());
            materiaModelo.setDniProfesor(splitearProfe(agregaMateria.jcbProfesor.getSelectedItem().toString()));

            if (materiaModelo.creaMateria(materiaModelo) == true) {

                limpiarTabla();
                listarMateria(materia.jtMaterias);
                JOptionPane.showMessageDialog(null, "Guardado Con Exito!");
                agregaMateria.dispose();
                limpiarNuevo();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }

    public int splitearProfe(String profeDniNombre) {
        String[] parts = profeDniNombre.split(" - ");
        String part1 = parts[0]; // DNI

        return Integer.valueOf(part1);
    }

    public boolean camposVacios() {
        if (agregaMateria.jTextCodMateria.getText().isEmpty()
                || agregaMateria.jTextNomMateria.getText().isEmpty()
                || agregaMateria.jcbProfesor.getSelectedItem().equals("Seleccionar Profesor")) {
            return false;
        } else {
            return true;
        }
    }

}
