/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Giuliano Espejo
 */
public class Conexion {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATA_BASE = "pfiprog2";
    private static final String SSL = "?useSSL=false";
    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection Conexion() {
        Connection conexion = null;
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL + DATA_BASE + SSL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexion " + e);
            JOptionPane.showMessageDialog(null, "Ocurrio un error al conectarse a la base de datos");
            System.exit(0);
        }
        return conexion;
    }
    
////Metodos para finalizar la conexion  ya que no se usa un pool de conexiones como el de mysql u oracle
//

    public static void cerrar(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void cerrar(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void cerrar(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
