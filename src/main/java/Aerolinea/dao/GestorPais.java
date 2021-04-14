/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Pais;
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
public class GestorPais {
    private static final String INSERTAR = "CALL INSERTAR_PAIS (?,?)";
    private static final String ELIMINAR = "CALL ELIMINAR_PAIS(?)";
    private static final String LISTAR = "CALL LISTAR_PAISES()";
    
    
     public String listarPaises() {
        String json = "nada";
        ArrayList<Pais> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(LISTAR);) {
            stm.clearParameters();

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Pais c = new Pais(
                            rs.getString("siglas"),
                            rs.getString("nombrePais")
                    );
                    r.add(c);
                    json = new Gson().toJson(r);
                }
            }
        } catch (IOException
                | ClassNotFoundException
                | IllegalAccessException
                | InstantiationException
                | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
        return json;
    }
     
     
     public boolean insertarPais(String siglas, String nombrePais){ //ready
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setString(1, siglas);
            stm.setString(2, nombrePais);
            if(stm.executeUpdate() == 1) {
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
     
    
     public boolean eliminarPais(String siglas){ 
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(ELIMINAR);) {
            stm.clearParameters();
            stm.setString(1, siglas);
            if(stm.executeUpdate() == 1) {
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
