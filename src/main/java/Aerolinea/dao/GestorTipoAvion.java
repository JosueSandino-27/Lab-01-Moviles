/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Ciudad;
import Aerolinea.logica.TipoAvion;
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
public class GestorTipoAvion {

    private static final String INSERTAR = "CALL INSERTAR_TIPOAVION (?,?,?,?,?,?,?,?)";
    private static final String ELIMINAR = "CALL ELIMINAR_TIPOAVION(?)";
    private static final String LISTAR = "CALL LISTAR_TIPOSAVIONEs()";

    public String listarTiposAviones() {
        String json = "nada";
        ArrayList<TipoAvion> r = new ArrayList<>();
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(LISTAR);) {
            stm.clearParameters();
            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    TipoAvion c = new TipoAvion(
                            rs.getInt("cantidadFilas"),
                            rs.getInt("cantidadColumnas"),
                            rs.getString("codigo"),
                            rs.getString("nombreTipo"),
                            rs.getInt("annio"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getInt("cantAsientos")
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

    public boolean insertarTipoAvion(String cF, String cC, String codigo, String nombreTipo,
            String an, String marca, String modelo, String cA) {
        int cantFilas = Integer.parseInt(cF);
        int cantColumnas = Integer.parseInt(cC);
        int annio = Integer.parseInt(an);
        int cantAsientos = Integer.parseInt(cA);
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setInt(1, cantFilas);
            stm.setInt(2, cantColumnas);
            stm.setString(3, codigo);
            stm.setString(4, nombreTipo);
            stm.setInt(5, annio);
            stm.setString(6, marca);
            stm.setString(7, modelo);
            stm.setInt(8, cantAsientos);
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

    public boolean eliminarTipoAvion(String codigo) {
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
