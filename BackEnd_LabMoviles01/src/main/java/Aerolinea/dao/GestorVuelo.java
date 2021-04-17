/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Pais;
import Aerolinea.logica.Vuelo;
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
public class GestorVuelo {

    private static final String INSERTAR = "CALL INSERTAR_VUELO (?,?,?,?,?,?,?)";
    private static final String MODIFICAR = "CALL MODIFICAR_VUELO (?,?,?,?,?,?,?)";
    private static final String ELIMINAR = "CALL ELIMINAR_VUELO(?)";
    private static final String LISTAR = "CALL LISTAR_VUELOS()";

    public String listarVuelos() {
        String json = "nada";
        ArrayList<Vuelo> r = new ArrayList<>();
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(LISTAR);) {
            stm.clearParameters();

            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Vuelo c = new Vuelo(
                            rs.getInt("numero"),
                            rs.getString("dia"),
                            rs.getString("horaSalida"),
                            rs.getString("Avion"),
                            rs.getString("horaLlegada"),
                            rs.getString("CiudadOrigen"),
                            rs.getString("CiudadDestino")
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

    public boolean insertarVuelo(String num, String dia, String horaSalida, String Avion, String horaLlegada, String CiudadOrigen, String CiudadDestino) { //ready
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setString(1, num);
            stm.setString(2, dia);
            stm.setString(2, horaSalida);
            stm.setString(2, Avion);
            stm.setString(2, horaLlegada);
            stm.setString(2, CiudadOrigen);
            stm.setString(2, CiudadDestino);

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
    
    public boolean modificarVuelo(String num, String dia, String horaSalida, String Avion, String horaLlegada, String CiudadOrigen, String CiudadDestino) { //ready
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(MODIFICAR);) {
            stm.clearParameters();
            stm.setString(1, num);
            stm.setString(2, dia);
            stm.setString(2, horaSalida);
            stm.setString(2, Avion);
            stm.setString(2, horaLlegada);
            stm.setString(2, CiudadOrigen);
            stm.setString(2, CiudadDestino);

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

    public boolean eliminarVuelo(String numero) {
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(ELIMINAR);) {
            stm.clearParameters();
            stm.setString(1, numero);
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
