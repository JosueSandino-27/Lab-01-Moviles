/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Pais;
import Aerolinea.logica.Usuario;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;

/**
 *
 * @author Josue
 */
public class GestorUsuario {

    public Usuario validarUsuario(String nombreUsuario, String contrasena) {
        Usuario r = null;
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(IMEC_Usuario.CONSULTAR_USUARIO.obtenerComando());) {
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
