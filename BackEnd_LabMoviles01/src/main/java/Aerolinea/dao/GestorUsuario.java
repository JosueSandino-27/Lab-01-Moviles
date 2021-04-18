package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Josue
 */
public class GestorUsuario {

    private static final String CONSULTAR_USUARIO = "CALL verificar_usuario(?,?)";
    private static final String INSERTAR = "CALL insertar_usuario(?,?,?,?,?,?,?,?,?,?)";

    public Usuario validarUsuario(String nombreUsuario, String contrasena) {
        Usuario r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(CONSULTAR_USUARIO);) {
            stm.clearParameters();
            stm.setString(1, nombreUsuario);
            stm.setString(2, contrasena);
            try ( ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    r = new Usuario(
                            rs.getString("nombreusuario"),
                            rs.getString("apellidos"),
                            rs.getString("correo"),
                            rs.getString("fechaNacimiento"),
                            rs.getString("direccion"),
                            rs.getString("telefonoTrabajo"),
                            rs.getString("celular"),
                            rs.getString("idUsuario"),
                            rs.getString("contrasena"),
                            rs.getBoolean("usuarioAdmin")
                    );
                    System.out.println("entro a datos");
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return r;
    }

    public boolean insertarUsuario(String nombreUsuario, String apellidos, String correo,
            String fechaNacimiento, String direccion, String telefonoTrabajo, String celular,
            String idUsuario, String contrasena, String UsuarioAdmin) {
        int useradmin = Integer.parseInt(UsuarioAdmin);
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setString(1, nombreUsuario);
            stm.setString(2, apellidos);
            stm.setString(3, correo);
            stm.setString(4, fechaNacimiento);
            stm.setString(5, direccion);
            stm.setString(6, telefonoTrabajo);
            stm.setString(7, celular);
            stm.setString(8, idUsuario);
            stm.setString(9, contrasena);
            stm.setInt(10, useradmin);

            if (stm.executeUpdate() == 1) {
                return true;
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return false;
    }

    public Connection obtenerConexion() throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            IOException,
            SQLException {
        BaseDatos bd = BaseDatos.obtenerInstancia();
        Connection cnx = bd.obtenerCon();
        return cnx;
    }

}
