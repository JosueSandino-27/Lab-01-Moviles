/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.controller;

import Aerolinea.dao.GestorUsuario;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Josue
 */
@ServerEndpoint("/usuario")
public class controller_usuario {

    @OnMessage
    public void onMessage(String message) {
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String action = jsonObject.get("action").getAsString();
        
        if ("insertar_usuario".equals(action)) {
            String nombre = jsonObject.get("nombre").getAsString();
            String apellido = jsonObject.get("apellido").getAsString();
            String email = jsonObject.get("email").getAsString();
            String nacimiento = jsonObject.get("nacimiento").getAsString();
            String direccion = jsonObject.get("direccion").getAsString();
            String trabajo = jsonObject.get("trabajo").getAsString();
            String casa = jsonObject.get("casa").getAsString();
            String idUsuario = jsonObject.get("idUsuario").getAsString();
            String contrasena = jsonObject.get("contrasena").getAsString();
            
            
            
            gU.insertarUsuario(nombre, apellido, email, nacimiento, direccion, trabajo, casa,idUsuario, contrasena,"0");
        }
        

    }

    @OnOpen
    public void onOpen(Session session) {

    }

    @OnClose
    public void onClose(Session session) throws IOException {
//session.getBasicRemote().sendText("Coneccion terminada");
        System.out.println("Sesion de: " + session.getId() + " ha terminado");
    }
    
    GestorUsuario gU = new GestorUsuario();
}
