/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import static Datos.Conexion.Conexion;
import Modelo.CursadoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giuliano Espejo
 */
public class CursadoDatos extends Conexion {

    private final String SQL_INSERT = "INSERT INTO cursado (cur_alu_dni, cur_mat_cod,cur_nota) VALUES (?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM cursado";
    private final String SQL_DELETE = "DELETE FROM cursado WHERE cur_alu_dni=?";
    private final String SQL_UPDATE = "UPDATE cursado SET cur_mat_cod=?, cur_nota=? WHERE cur_alu_dni=?";
    private final String SQL_FIND = "SELECT * FROM cursado WHERE cur_alu_dni=?";//Falta Optimizar!

    public boolean crea(CursadoModelo cursado) {
        PreparedStatement ps = null;
        /*La interfaz PrepareStatement hereda de la interfaz Statement y puede almacenar
        de manera precompilada una sentencia SQL, por lo que es una opción más eficiente
        si es que necesitamos ejecutar una sentencia SQL en repetidas ocasiones, a su vez
        también podemos especificar parámetros a ejecutar en nuestro query.*/
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setInt(1, cursado.getAlumnoDni());
            ps.setInt(2, cursado.getCodigoMateria());
            ps.setDouble(3, cursado.getNota());

            ps.executeUpdate();
            /*El método executeUpdate se utiliza para ejecutar sentencias DML (Data
            Manipulation Language) como son las sentencias insert, update y delete. También
            nos va a permitir ejecutar sentencias de tipo DDL (Data Definition Language) como
            son las sentencias create table, truncate table, entre otras. La función
            executeUpdate regresa un entero, indicando el número de registros afectados como
            resultado de ejecutar el query deseado.
             */

            System.out.println("Agregado Con Exito");

            return true;
        } catch (SQLException e) {
            System.out.println("Error al Crear : " + e);
            return false;

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);
        }
    }

    public List<CursadoModelo> lee() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        CursadoModelo cursado;
        List<CursadoModelo> listaCursados = new ArrayList<>();

        try {
            conn = Conexion.Conexion();//Me conecto a la base de datos
            ps = Conexion().prepareStatement(SQL_SELECT);//ejecuto la query
            rs = ps.executeQuery();//igualo la respuesta de la query a un resultSet


            /*El método de executeQuery se utiliza para ejecutar sentencias de tipo select y por
            ello el método regresa un objeto ResultSet, el cual almacena el resultado en forma
            de una matriz de dos dimensiones, es decir, en renglones y columnas, así podemos
            procesar el resultado del query sin ningún problema. */
            while (rs.next()) {
                cursado = new CursadoModelo();

                cursado.setAlumnoDni(rs.getInt(1));
                cursado.setCodigoMateria(rs.getInt(2));
                cursado.setNota(rs.getDouble(3));

                listaCursados.add(cursado);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaCursados;
    }

    public boolean actualiza(CursadoModelo cursado) {
      PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_UPDATE);

            ps.setInt(1, cursado.getCodigoMateria());
            ps.setDouble(2, cursado.getNota());

            ps.setInt(3, cursado.getAlumnoDni());
            ps.executeUpdate();
            System.out.println("Actualizado Con Exito");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al Actualizar : " + e);
            return false;

        } finally {

            Conexion.cerrar(conn);
            Conexion.cerrar(ps);

        }
    }

    public boolean borra(int codCursado) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, codCursado);
            ps.executeUpdate();
            System.out.println("Eliminado con Exito");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al Eliminar : " + e);
            return false;

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);

        }
    }

    public CursadoModelo busca(int codCursado) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        CursadoModelo cursado = new CursadoModelo();
        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_FIND);
            ps.setInt(1, codCursado);
            rs = ps.executeQuery();

            while (rs.next()) {
                cursado.setAlumnoDni(rs.getInt(1));
                cursado.setCodigoMateria(rs.getInt(2));
                cursado.setNota(rs.getDouble(3));
            }

        } catch (SQLException e) {
            System.out.println("Error al Buscar : " + e);

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);

        }

        return cursado;
    }

}
