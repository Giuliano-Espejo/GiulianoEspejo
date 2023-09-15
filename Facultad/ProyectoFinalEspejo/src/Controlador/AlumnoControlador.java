package Controlador;

import Modelo.AlumnoModelo;
import Vista.AgregarAlumno;
import Vista.Alumno;
import Vista.EditarAlumno;
import Vista.MenuLateral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giuliano Espejo
 */
public class AlumnoControlador implements ActionListener {

    private AlumnoModelo alumno = new AlumnoModelo();
    private Validaciones validacion = new Validaciones();
    private AgregarAlumno agregaAlumno = new AgregarAlumno();
    private Alumno tablaAlumno = new Alumno();
    private EditarAlumno editarAlumno = new EditarAlumno();
    private MenuLateral menu = new MenuLateral();
    private DefaultTableModel modelo;

    public AlumnoControlador(MenuLateral menu, Alumno tablaAlumno) {
        this.tablaAlumno = tablaAlumno;
        this.menu = menu;

        this.tablaAlumno.jbNuevo.addActionListener(this);
        this.tablaAlumno.jbBorrar.addActionListener(this);
        this.tablaAlumno.jbEditar.addActionListener(this);

        this.agregaAlumno.jbGuardar.addActionListener(this);
        this.agregaAlumno.jbCancelar.addActionListener(this);

        this.editarAlumno.jbCancelar.addActionListener(this);
        this.editarAlumno.jbGuardar.addActionListener(this);

        //se carga la lista de alumnos cada vez que se abre la vista de alumno
        listarAlumnos(tablaAlumno.jtAlumnos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tablaAlumno.jbBorrar) {
            borraAlumno();
        } else if (e.getSource() == tablaAlumno.jbEditar) {
            cargarDatosEditar();
        } else if (e.getSource() == editarAlumno.jbCancelar) {
            editarAlumno.setVisible(false);
        } else if (e.getSource() == editarAlumno.jbGuardar) {
            guardaEdit();
        } else if (e.getSource() == tablaAlumno.jbNuevo) {
            agregaAlumno.setVisible(true);
            agregaAlumno.setLocationRelativeTo(null);
            agregaAlumno.setResizable(false);
        } else if (e.getSource() == agregaAlumno.jbCancelar) {
            limpiaAgregaAlumnos();
        } else if (e.getSource() == agregaAlumno.jbGuardar) {
            guarda();
        }
    }

    public void limpiaAgregaAlumnos() {
        agregaAlumno.jTextApellido.setText("");
        agregaAlumno.jTextDNI.setText("");
        agregaAlumno.jTextDomicilio.setText("");
        agregaAlumno.jTextNombre.setText("");
        agregaAlumno.jTextTelefono.setText("");
        agregaAlumno.jDateChooFechaNaci.setDate(null);
        agregaAlumno.setVisible(false);
    }

    public void guardaEdit() {
        if (camposLlenosEdiccion() == false) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        } else if (validarTextoCamposEditar() == false) {
            JOptionPane.showMessageDialog(null, "Los Campos Nombre, Apellido Y Domicilio Pueden Tener Maximo 45 Caracteres!");
        } else if (validacion.verificarTelefono(editarAlumno.jTextTelefono.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Telefono Puede Contener Un Maximo De 12 Caracteres Alfanumericos");
        } else {
            //Se Actualiza El Alumno Una Vez Que Se Validaron Los Datos Ingresados Por La Vista
            alumno.setDni(Integer.valueOf(editarAlumno.jTextDNI.getText()));
            alumno.setNombre(editarAlumno.jTextNombre.getText());
            alumno.setApellido(editarAlumno.jTextApellido.getText());
            alumno.setFechaNacimiento(new Date(editarAlumno.jDateFechaNaci.getDate().getTime()));
            alumno.setDomicilio(editarAlumno.jTextDomicilio.getText());
            alumno.setTelefono(editarAlumno.jTextTelefono.getText());

            if (alumno.actualizaAlumno(alumno) == true) {

                limpiarTabla();
                listarAlumnos(tablaAlumno.jtAlumnos);
                JOptionPane.showMessageDialog(null, "Editado Con Exito");
                editarAlumno.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "ERROR, Revisar Consola...");

            }
        }
    }

    public void cargarDatosEditar() {
        int fila = tablaAlumno.jtAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccione Una Fila!");
        } else {
            editarAlumno.jTextDNI.setText(tablaAlumno.jtAlumnos.getValueAt(fila, 0).toString());
            editarAlumno.jTextNombre.setText(tablaAlumno.jtAlumnos.getValueAt(fila, 1).toString());
            editarAlumno.jTextApellido.setText(tablaAlumno.jtAlumnos.getValueAt(fila, 2).toString());
            editarAlumno.jDateFechaNaci.setDate((Date) tablaAlumno.jtAlumnos.getValueAt(fila, 3));
            editarAlumno.jTextDomicilio.setText(tablaAlumno.jtAlumnos.getValueAt(fila, 4).toString());
            editarAlumno.jTextTelefono.setText(tablaAlumno.jtAlumnos.getValueAt(fila, 5).toString());
            editarAlumno.setVisible(true);
            editarAlumno.setLocationRelativeTo(null);
            editarAlumno.setResizable(false);
        }

    }

    public void guarda() {
        agregaAlumno.setVisible(true);
        if (camposLlenosAgregar() == false) {
            JOptionPane.showMessageDialog(null, "Hay campos vacios");
        } else if (validarTextoCamposAgregar() == false) {
            JOptionPane.showMessageDialog(null, "Los Campos Nombre, Apellido Y Domicilio Pueden Tener Maximo 45 Caracteres!");
        } else if (validacion.verificarDni(agregaAlumno.jTextDNI.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DNI Debe Contener 8 Digitos");
        } else if (validacion.verificarTelefono(agregaAlumno.jTextTelefono.getText()) == false) {
            JOptionPane.showMessageDialog(null, "Telefono Puede Contener Un Maximo De 12 Caracteres Alfanumericos");
        } else if (validacion.dniContieneLetras(agregaAlumno.jTextDNI.getText()) == false) {
            JOptionPane.showMessageDialog(null, "DNI Solo Puede Contener Numeros!");
        } else if (alumno.existeAlumno(Integer.valueOf(agregaAlumno.jTextDNI.getText())) == true) {
            JOptionPane.showMessageDialog(null, "El Alumno Con DNI : " + agregaAlumno.jTextDNI.getText() + " Ya Existe!");
        } else {
            //Se Crea El Alumno Una Vez Que Se Validaron Los Datos Ingresados Por La Vista
            alumno.setDni(Integer.valueOf(agregaAlumno.jTextDNI.getText()));
            alumno.setNombre(agregaAlumno.jTextNombre.getText());
            alumno.setApellido(agregaAlumno.jTextApellido.getText());
            alumno.setFechaNacimiento(new Date(agregaAlumno.jDateChooFechaNaci.getDate().getTime()));
            alumno.setDomicilio(agregaAlumno.jTextDomicilio.getText());
            alumno.setTelefono(agregaAlumno.jTextTelefono.getText());

            if (alumno.creaAlumno(alumno) == true) {

                limpiarTabla();
                listarAlumnos(tablaAlumno.jtAlumnos);
                JOptionPane.showMessageDialog(null, "Guardado Con Exito!");
                agregaAlumno.dispose();
                limpiaAgregaAlumnos();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR, Revisar Consola...");
            }
        }
    }
    
    public void borraAlumno() {
        int fila = tablaAlumno.jtAlumnos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt((String) tablaAlumno.jtAlumnos.getValueAt(fila, 0).toString());
            if (JOptionPane.showConfirmDialog(null, "Desea Eliminar al Alumno con el id " + id, "¿Desea Eliminar?", JOptionPane.YES_NO_OPTION) == 0) {
                alumno.borraAlumno(id);
                limpiarTabla();
                listarAlumnos(tablaAlumno.jtAlumnos);
                JOptionPane.showMessageDialog(null, "Alumno con id " + id + " ELIMINADO");
            }
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < tablaAlumno.jtAlumnos.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void listarAlumnos(JTable table) {
        modelo = (DefaultTableModel) tablaAlumno.jtAlumnos.getModel();
        tablaAlumno.jtAlumnos.setRowHeight(30);
        List<AlumnoModelo> lista = alumno.leeAlumnos();
        Object[] fila = new Object[7];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getDni();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getApellido();
            fila[3] = lista.get(i).getFechaNacimiento();
            fila[4] = lista.get(i).getDomicilio();
            fila[5] = lista.get(i).getTelefono();
            fila[6] = lista.get(i).getCodigoInscripcion();
            modelo.addRow(fila);
        }
        tablaAlumno.jtAlumnos.setModel(modelo);

    }

    public boolean camposLlenosEdiccion() {
        if (editarAlumno.jTextApellido.getText().isEmpty() || editarAlumno.jTextNombre.getText().isEmpty()
                || editarAlumno.jTextDomicilio.getText().isEmpty() || editarAlumno.jTextTelefono.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean camposLlenosAgregar() {
        if (agregaAlumno.jTextApellido.getText().isEmpty() || agregaAlumno.jTextNombre.getText().isEmpty()
                || agregaAlumno.jTextDomicilio.getText().isEmpty() || agregaAlumno.jTextTelefono.getText().isEmpty()
                || agregaAlumno.jTextDNI.getText().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean validarTextoCamposEditar() {
        if (editarAlumno.jTextNombre.getText().length() > 45 || editarAlumno.jTextApellido.getText().length() > 45
                || editarAlumno.jTextDomicilio.getText().length() > 45) {
            return false;

        } else {
            return true;
        }
    }

    public boolean validarTextoCamposAgregar() {
        if (agregaAlumno.jTextNombre.getText().length() > 45 || agregaAlumno.jTextApellido.getText().length() > 45
                || agregaAlumno.jTextDomicilio.getText().length() > 45) {
            return false;

        } else {
            return true;
        }
    }
}
