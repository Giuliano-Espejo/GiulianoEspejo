/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package encriptador;

public class Encriptador {

    public static void main(String[] args) {
        Vista vista = new Vista();
        Controlador controler = new Controlador(vista);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setTitle("Encriptador");
    }
}
