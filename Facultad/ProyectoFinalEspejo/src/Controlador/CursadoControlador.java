/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MenuLateral;
import Vista.Cursado;
import Vista.AgregarCursado;
import Vista.EditarCursado;
import Modelo.CursadoModelo;
import Modelo.AlumnoModelo;
import Modelo.MateriaModelo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giuliano Espejo
 */
public class CursadoControlador implements ActionListener {

    private MenuLateral menu = new MenuLateral();
    private Cursado cursado = new Cursado();
    private AgregarCursado agregaCursado = new AgregarCursado();
    private EditarCursado editarCursado = new EditarCursado();
    private CursadoModelo cursadoModelo = new CursadoModelo();
    private AlumnoModelo alumno = new AlumnoModelo();
    private MateriaModelo materia = new MateriaModelo();
    private Validaciones validacion = new Validaciones();
    private DefaultTableModel modelo;

    public CursadoControlador(MenuLateral menu, Cursado cursado) {
        this.cursado = cursado;
        this.menu = menu;

        //escucha las acciones realizadas en la vista del cursado
        this.cursado.jbBorrar.addActionListener(this);
        this.cursado.jbEditar.addActionListener(this);
        this.cursado.jbNuevo.addActionListener(this);

        //escucha la acciones realizadas en la vista de edicion
        this.editarCursado.jbCancelar.addActionListener(this);
        this.editarCursado.jbGuardar.addActionListener(this);

        //escucha la acciones realizadas en la vista de agregar
        this.agregaCursado.jbCancelar.addActionListener(this);
        this.agregaCursado.jbGuardar.addActionListener(this);

        listarCursados(cursado.jtCursado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cursado.jbBorrar) {
            borra();
        } else if (e.getSource() == cursado.jbEditar) {
            cargarVistaEditar();
        } else if (e.getSource() == editarCursado.jbCancelar) {
            editarCursado.dispose();
        } else if (e.getSource() == editarCursado.jbGuardar) {
            editar();
        } else if (e.getSource() == cursado.jbNuevo) {
            cargarComboBox();
        } else if (e.getSource() == agregaCursado.jbCancelar) {
            agregaCursado.dispose();
        } else if (e.getSource() == agregaCursado.jbGuardar) {
            guarda();
        }
    }

    public void listarCursados(JTable table) {
        modelo = (DefaultTableModel) cursado.jtCursado.getModel();
        cursado.jtCursado.setRowHeight(30);
        List<CursadoModelo> lista = cursadoModelo.leeCursado();
        Object[] fila = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getAlumnoDni();
            fila[1] = lista.get(i).getCodigoMateria();
            fila[2] = lista.get(i).getNota();

            modelo.addRow(fila);
        }
        cursado.jtCursado.setModel(modelo);

    }

    public void limpiaTabla() {
        for (int i = 0; i < cursado.jtCursado.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void cargarVistaEditar() {
        int fila = cursado.jtCursado.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            
            editarCursado.setVisible(true);
            editarCursado.setLocationRelativeTo(null);
            editarCursado.setResizable(false);
            
            editarCursado.jTextCodMateria.setText(cursado.jtCursado.getValueAt(fila, 1).toString());
            editarCursado.jTextDNI.setText(cursado.jtCursado.getValueAt(fila, 0).toString());
            editarCursado.jTextNota.setText(cursado.jtCursado.getValueAt(fila, 2).toString());

        }
    }

    public void borra() {
        int fila = cursado.jtCursado.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar?", "ELIMINAR", JOptionPane.YES_NO_OPTION) == 0) {
                int id = Integer.parseInt((String) cursado.jtCursado.getValueAt(fila, 0).toString());
                cursadoModelo.borraCursado(id);
                limpiaTabla();
                listarCursados(cursado.jtCursado);
                JOptionPane.showMessageDialog(null, "Eliminado!");
            }

        }
    }

    public boolean revisarCamposEditar() {
        if (editarCursado.jTextNota.getText().isEmpty()
                || editarCursado.jTextDNI.getText().isEmpty()
                || editarCursado.jTextCodMateria.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void editar() {
         if (validacion.validarNota(Double.valueOf(editarCursado.jTextNota.getText())) == false) {
            JOptionPane.showMessageDialog(null, "La Nota Debe Ser Un Valor Entre 1 y 10");
        } else if (validacion.notaContieneLetras(editarCursado.jTextNota.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Nota Solo Puede Contener Numeros!");
        } else {

            cursadoModelo.setAlumnoDni(Integer.valueOf(editarCursado.jTextDNI.getText()));
            cursadoModelo.setCodigoMateria(Integer.valueOf(editarCursado.jTextCodMateria.getText()));
            cursadoModelo.setNota(Double.valueOf(editarCursado.jTextNota.getText()));

            if (cursadoModelo.actualizaCursado(this.cursadoModelo) == true) {

                limpiaTabla();
                listarCursados(cursado.jtCursado);
                JOptionPane.showMessageDialog(null, "Nota Editada Con Exito!");
                editarCursado.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }

    public void cargarComboBox() {

        List<AlumnoModelo> listaAlumnos = alumno.leeAlumnos();
        List<MateriaModelo> listaMaterias = materia.leeMaterias();

        agregaCursado.jcbDNIAlu.removeAllItems();
        agregaCursado.jcbDNIAlu.addItem("Seleccionar Alumno");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            agregaCursado.jcbDNIAlu.addItem(String.valueOf(listaAlumnos.get(i).getDni()) + " - " + listaAlumnos.get(i).getNombre()
                    + " " + listaAlumnos.get(i).getApellido());
        }

        agregaCursado.jcbCodMat.removeAllItems();
        agregaCursado.jcbCodMat.addItem("Seleccionar Materia");

        for (int i = 0; i < listaMaterias.size(); i++) {
            agregaCursado.jcbCodMat.addItem(String.valueOf(listaMaterias.get(i).getCodMateria() + " - " + listaMaterias.get(i).getNombreMateria()));
        }
        agregaCursado.setVisible(true);
        agregaCursado.setLocationRelativeTo(null);
        agregaCursado.setResizable(false);
    }

    public void guarda() {
        if (revisarCampos() == false) {
            JOptionPane.showMessageDialog(null, "Campos Vacios, Revise Alumno, Materia o Nota");
        } else if (validacion.validarNota(Double.valueOf(agregaCursado.jTextNota.getText())) == false) {
            JOptionPane.showMessageDialog(null, "La Nota Debe Ser Un Valor Entre 1 y 10");
        } else if (validacion.notaContieneLetras(agregaCursado.jTextNota.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Nota Solo Puede Contener Numeros!");
        } else {
            cursadoModelo.setAlumnoDni(splitearString(agregaCursado.jcbDNIAlu.getSelectedItem().toString()));
            cursadoModelo.setCodigoMateria(splitearString(agregaCursado.jcbCodMat.getSelectedItem().toString()));
            cursadoModelo.setNota(Double.valueOf(agregaCursado.jTextNota.getText()));

            if (cursadoModelo.creaCursado(cursadoModelo) == true) {

                limpiaTabla();
                listarCursados(cursado.jtCursado);
                JOptionPane.showMessageDialog(null, "Nota Registrada Con Exito!");
                agregaCursado.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }

    public boolean revisarCampos() {
        if (agregaCursado.jcbDNIAlu.getSelectedItem().equals("Seleccionar Alumno")
                || agregaCursado.jcbCodMat.getSelectedItem().equals("Seleccionar Materia")
                || agregaCursado.jTextNota.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    public int splitearString(String str) {
        String[] parts = str.split(" - ");
        String part1 = parts[0];

        return Integer.valueOf(part1);
    }

}
