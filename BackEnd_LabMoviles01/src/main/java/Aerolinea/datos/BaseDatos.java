package Aerolinea.datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {

    public BaseDatos() {

    }

    public static Connection obtenerCon() throws IOException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2","root","root");
            System.out.print("SE pudo conectar a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("No se pudo conectar a la base de datos");
        }
        return con;
    }

    public static BaseDatos obtenerInstancia() throws
            ClassNotFoundException,
            IOException,
            IllegalAccessException,
            InstantiationException {
        if (instancia == null) {
            instancia = new BaseDatos();
        }
        return instancia;
    }
    private static BaseDatos instancia = null;

}
