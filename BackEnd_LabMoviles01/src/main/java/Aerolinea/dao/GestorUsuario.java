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
