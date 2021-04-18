/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Avion;
import Aerolinea.logica.Pais;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josue
 */
public class GestorAvion {

    private static final String INSERTAR = "CALL insertar_avion (?,?,?)";
    private static final String MODIFICAR = "CALL modificar_avion (?,?,?)";
    private static final String ELIMINAR = "CALL ELIMINAR_AVION(?)";
    private static final String LISTAR = "CALL LISTAR_AVIONES()";

    public String listarAviones() {

        String json = "nada";
        ArrayList<Avion> r = new ArrayList<>();
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(LISTAR);) {
            stm.clearParameters();

            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Avion c = new Avion(
                            rs.getString("codigo"),
                            rs.getString("nombreAvion"),
                            rs.getString("TipoAvion")
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

    public boolean insertarAvion(String codigo, String nombreAvion, String TipoAvion) { //ready
        try ( Connection cnx = obtenerConexion();  
                PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setString(1, codigo);
            stm.setString(2, nombreAvion);
            stm.setString(3, TipoAvion);
            
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
    public boolean modificarAvion(String codigo, String nombreAvion, String TipoAvion) { //ready
        try ( Connection cnx = obtenerConexion();  
                PreparedStatement stm = cnx.prepareStatement(MODIFICAR);) {
            stm.clearParameters();
            stm.setString(1, codigo);
            stm.setString(2, nombreAvion);
            stm.setString(3, TipoAvion);
            
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

    
    public boolean eliminarAvion(String codigo) {
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(ELIMINAR);) {
            stm.clearParameters();
            stm.setString(1, codigo);
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
