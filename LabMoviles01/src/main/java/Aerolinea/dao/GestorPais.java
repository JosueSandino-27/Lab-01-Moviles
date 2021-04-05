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
    
    
     public String listarPaises() {
        String json = "nada";
        ArrayList<Pais> r = new ArrayList<>();
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_PAIS.LISTAR_PAISES.obtenerComando());) {
            stm.clearParameters();
//            stm.setString(1, usuario);
//            stm.setString(2, tipo);
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
     
     public boolean insertarPais(String siglas, String nombrePais){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_PAIS.INSERTAR.obtenerComando());) {
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
    
     public boolean eliminarPais(String nombrePais){
        try (Connection cnx = obtenerConexion();
                PreparedStatement stm = cnx.prepareStatement(IMEC_PAIS.DELETE.obtenerComando());) {
            stm.clearParameters();
            stm.setString(1, nombrePais);
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
