/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Pais;
import Aerolinea.logica.Viaje;
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
public class GestorViaje {

    private static final String INSERTAR = "CALL insertar_viaje (?,?,?,?)";
    private static final String MODIFICAR = "CALL modificar_viaje (?,?,?,?,?)";
    private static final String ELIMINAR = "CALL eliminar_viaje(?)";
    private static final String LISTAR = "CALL listar_viajes()";

    public String listarViajes() {
        String json = "nada";
        ArrayList<Viaje> r = new ArrayList<>();
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(LISTAR);) {
            stm.clearParameters();

            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Viaje c = new Viaje(
                            rs.getInt("numero"),
                            rs.getInt("precio"),
                            rs.getString("Fecha"),
                            rs.getInt("asientosDisponibles"),
                            rs.getInt("Vuelo")
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

    public boolean insertarViaje(String p, String Fecha, String a, String v) {
        int precio = Integer.parseInt(p);
        int asientosDisponibles = Integer.parseInt(a);
        int Vuelo = Integer.parseInt(v);
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setInt(1, precio);
            stm.setString(2, Fecha);
            stm.setInt(3, asientosDisponibles);
            stm.setInt(4, Vuelo);
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

    public boolean modificarViaje(String n,String p, String Fecha, String a, String v) { //ready
        int numero = Integer.parseInt(n);
        int precio = Integer.parseInt(p);
        int asientosDisponibles = Integer.parseInt(a);
        int Vuelo = Integer.parseInt(v);
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(MODIFICAR);) {
            stm.clearParameters();
            stm.setInt(1, numero);
            stm.setInt(2, precio);
            stm.setString(3, Fecha);
            stm.setInt(4, asientosDisponibles);
            stm.setInt(5, Vuelo);
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

    public boolean eliminarViaje(String siglas) {
        int numero = Integer.parseInt(siglas);
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(ELIMINAR);) {
            stm.clearParameters();
            stm.setInt(1, numero);
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
