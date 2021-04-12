package Aerolinea.controller;

import Aerolinea.dao.GestorCiudad;
import Aerolinea.dao.GestorPais;
import Aerolinea.dao.GestorUsuario;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Josue
 */
@ServerEndpoint("/controller_paises")
public class controller_paises {

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, EncodeException {
        
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String action = jsonObject.get("action").getAsString();

        if ("cargar_lista_paises".equals(action)) {
            String paisesJSON = gP.listarPaises();
            try {
                session.getBasicRemote().sendText(paisesJSON);
            } catch (IOException ex) {
            }
        }
        if("insertar_pais".equals(action)){
            String siglas = jsonObject.get("siglas").getAsString();
            String nombrePais = jsonObject.get("nombrePais").getAsString();
            gP.insertarPais(siglas, nombrePais);
        }
        if("eliminar_pais".equals(action)){
            String siglas = jsonObject.get("siglas").getAsString();
            gP.eliminarPais(siglas);
        }
        
        if ("cargar_lista_ciudades".equals(action)) {
            String ciudadesJSON = gC.listarCiudades();
            try {
                session.getBasicRemote().sendText(ciudadesJSON);
            } catch (IOException ex) {
            }
        }
        if("insertar_ciudad".equals(action)){
            String nombre = jsonObject.get("nombre").getAsString();
            String Pais = jsonObject.get("Pais").getAsString();
            gC.insertarCiudad(nombre, Pais);
        }
        if("eliminar_ciudad".equals(action)){
            String nombre = jsonObject.get("nombre").getAsString();
            gC.eliminarCiudad(nombre);
        }
        
         
       
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.getId() + " ha abierto una sesion");
        try {
            session.getBasicRemote().sendText("Coneccion Establecida");
        } catch (IOException ex) {

        }

    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("Sesion de: " + session.getId() + " ha terminado");
    }

    GestorPais gP = new GestorPais();
    GestorCiudad gC = new GestorCiudad();
}
