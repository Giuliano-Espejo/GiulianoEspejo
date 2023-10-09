package Datos;

import static Datos.Conexion.Conexion;

import Modelo.ProfesorModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SkylakeFrost
 */
public class ProfesorDatos extends Conexion {

    private final String SQL_INSERT = "INSERT INTO profesor (prof_dni, prof_nombre,prof_apellido,prof_fec_nac,prof_domicilio, prof_telefono) VALUES (?,?,?,?,?,?)";
    private final String SQL_SELECT = "SELECT * FROM profesor";
    private final String SQL_DELETE = "DELETE FROM profesor WHERE prof_dni=?";
    private final String SQL_UPDATE = "UPDATE profesor SET prof_nombre=?,prof_apellido=?,prof_fec_nac=?,prof_domicilio=?, prof_telefono=? WHERE prof_dni=?";
    private final String SQL_FIND = "SELECT * FROM profesor WHERE prof_dni = ?";

    public boolean create(ProfesorModelo profesor) {
        PreparedStatement ps = null;
        /*La interfaz PrepareStatement hereda de la interfaz Statement y puede almacenar
        de manera precompilada una sentencia SQL, por lo que es una opción más eficiente
        si es que necesitamos ejecutar una sentencia SQL en repetidas ocasiones, a su vez
        también podemos especificar parámetros a ejecutar en nuestro query.*/
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_INSERT);

            ps.setInt(1, profesor.getDni());
            ps.setString(2, profesor.getNombre());
            ps.setString(3, profesor.getApellido());
            ps.setDate(4, profesor.getFechaNacimiento());
            ps.setString(5, profesor.getDomicilio());
            ps.setString(6, profesor.getTelefono());

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

    public List<ProfesorModelo> read() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ProfesorModelo profesor;
        List<ProfesorModelo> listaProfesores = new ArrayList<>();

        try {
            conn = Conexion.Conexion();//Me conecto a la base de datos
            ps = Conexion().prepareStatement(SQL_SELECT);//ejecuto la query
            rs = ps.executeQuery();//igualo la respuesta de la query a un resultSet


            /*El método de executeQuery se utiliza para ejecutar sentencias de tipo select y por
            ello el método regresa un objeto ResultSet, el cual almacena el resultado en forma
            de una matriz de dos dimensiones, es decir, en renglones y columnas, así podemos
            procesar el resultado del query sin ningún problema. */
            while (rs.next()) {
                profesor = new ProfesorModelo();

                profesor.setDni(rs.getInt(1));
                profesor.setNombre(rs.getString(2));
                profesor.setApellido(rs.getString(3));
                profesor.setFechaNacimiento(rs.getDate(4));
                profesor.setDomicilio(rs.getString(5));
                profesor.setTelefono(rs.getString(6));

                listaProfesores.add(profesor);

            }

        } catch (SQLException e) {

            System.out.println(e);

        } finally {
            Conexion.cerrar(conn);
            Conexion.cerrar(ps);
            Conexion.cerrar(rs);
        }
        return listaProfesores;
    }

    public boolean update(ProfesorModelo profesor) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_UPDATE);

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setDate(3, profesor.getFechaNacimiento());
            ps.setString(4, profesor.getDomicilio());
            ps.setString(5, profesor.getTelefono());

            ps.setInt(6, profesor.getDni());
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

    public boolean delete(int idProf) {
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, idProf);
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

    public boolean exist(int dniProf) {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;

        try {
            conn = Conexion.Conexion();
            ps = conn.prepareStatement(SQL_FIND);
            ps.setInt(1, dniProf);
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
