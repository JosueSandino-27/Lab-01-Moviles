/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.controller;

import Aerolinea.dao.GestorCiudad;
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
@ServerEndpoint("/controller_ciudades")
public class controller_ciudades {

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, EncodeException {

        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String action = jsonObject.get("action").getAsString();
        
        if ("cargar_lista".equals(action)) {
            String paisesJSON = gC.listarCiudades();
            try {
                session.getBasicRemote().sendText(paisesJSON);
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
        try {
            session.getBasicRemote().sendText("Coneccion Establecida");
        } catch (IOException ex) {

        }

    }

    @OnClose
    public void onClose(Session session) throws IOException {
        //session.getBasicRemote().sendText("Coneccion terminada");
        System.out.println("Sesion de: " + session.getId() + " ha terminado");
    }

    GestorCiudad gC = new GestorCiudad();

}
