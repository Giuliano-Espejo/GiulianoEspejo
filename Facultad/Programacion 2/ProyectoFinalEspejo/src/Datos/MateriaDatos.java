/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import static Datos.Conexion.Conexion;
import Modelo.MateriaModelo;
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
public class MateriaDatos extends Conexion {

    private final String SQL_INSERT = "INSERT INTO materia (mat_cod,mat_nombre, mat_prof_dni) VALUES (?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM materia";
    private final String SQL_DELETE = "DELETE FROM materia WHERE mat_cod=?";
    private final String SQL_UPDATE = "UPDATE materia SET mat_nombre =?, mat_prof_dni=? WHERE mat_cod=?";
    private final String SQL_FIND = "SELECT * FROM materia WHERE mat_cod =?";

    public boolean crea(MateriaModelo materia) {
        PreparedStatement ps = null;
        /*La interfaz PrepareStatement hereda de la interfaz Statement y puede almacenar
        de manera precompilada una sentencia SQL, por lo que es una opción más eficiente
        si es que necesitamos ejecutar una sentencia SQL en repetidas ocasiones, a su vez
        también podemos especificar parámetros a ejecutar en nuestro query.*/
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setInt(1, materia.getCodMateria());
            ps.setString(2, materia.getNombreMateria());
            ps.setInt(3, materia.getDniProfesor());

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

    public List<MateriaModelo> lee() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MateriaModelo materia;
        List<MateriaModelo> listaMaterias = new ArrayList<>();

        try {
            conn = Conexion.Conexion();//Me conecto a la base de datos
            ps = Conexion().prepareStatement(SQL_SELECT);//ejecuto la query
            rs = ps.executeQuery();//igualo la respuesta de la query a un resultSet


            /*El método de executeQuery se utiliza para ejecutar sentencias de tipo select y por
            ello el método regresa un objeto ResultSet, el cual almacena el resultado en forma
            de una matriz de dos dimensiones, es decir, en renglones y columnas, así podemos
            procesar el resultado del query sin ningún problema. */
            while (rs.next()) {
                materia = new MateriaModelo();

                materia.setCodMateria(rs.getInt(1));
                materia.setNombreMateria(rs.getString(2));
                materia.setDniProfesor(rs.getInt(3));

                listaMaterias.add(materia);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaMaterias;
    }

    public boolean actualiza(MateriaModelo materia) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_UPDATE);

            ps.setString(1, materia.getNombreMateria());
            ps.setInt(2, materia.getDniProfesor());

            ps.setInt(3, materia.getCodMateria());
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

    public boolean borra(int idMateria) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, idMateria);
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

    public boolean existe(int codMate) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_FIND);
            ps.setInt(1, codMate);
            rs = ps.executeQuery();

            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error al Buscar : " + e);

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);

        }

        return false;
    }

}
