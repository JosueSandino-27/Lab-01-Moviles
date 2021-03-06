/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.dao;

import Aerolinea.datos.BaseDatos;
import Aerolinea.logica.Reserva;
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
public class GestorReservas {

    private static final String INSERTAR = "CALL insertar_reserva1(?,?,?,?,?)";
    private static final String ELIMINAR = "CALL ELIMINAR_CIUDAD(?)";
    private static final String LISTAR = "CALL listar_reservas()";

    public String listarReservas() {
        String json = "nada";
        ArrayList<Reserva> r = new ArrayList<>();
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(LISTAR);) {
            stm.clearParameters();
            try ( ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Reserva c = new Reserva(
                            rs.getInt("numeroReservas"),
                            rs.getInt("TipoPago_codigoTipoPago"),
                            rs.getInt("Viaje_numero"),
                            rs.getString("Usuario_idUsuario"),
                            rs.getString("Asiento"),
                            rs.getString("Viajero")
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

    public boolean insertarReserva(int tipoPago, int viaje,String usuario,String asiento,String viajero) { //ready
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setInt(1, tipoPago);
            stm.setInt(2, viaje);
            stm.setString(3, usuario);
            stm.setString(4, asiento);
            stm.setString(5, viajero);
                     
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
    
    
     public boolean insertarReserva2(String tp, String v,String usuario,String asiento,String viajero) { 
            
        int tipoPago = Integer.parseInt(tp);
        int viaje = Integer.parseInt(v);
        
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(INSERTAR);) {
            stm.clearParameters();
            stm.setInt(1, tipoPago);
            stm.setInt(2, viaje);
            stm.setString(3, usuario);
            stm.setString(4, asiento);
            stm.setString(5, viajero);
                     
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

    public boolean eliminarCiudad(String nombre) {
        try ( Connection cnx = obtenerConexion();  PreparedStatement stm = cnx.prepareStatement(ELIMINAR);) {
            stm.clearParameters();
            stm.setString(1, nombre);
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

