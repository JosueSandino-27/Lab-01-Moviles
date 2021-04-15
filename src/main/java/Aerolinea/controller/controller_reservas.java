/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.controller;

import Aerolinea.dao.GestorReservas;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Carlos
 */
@ServerEndpoint("/controller_reservas")
public class controller_reservas {

    @OnMessage
    public String onMessage(String message) {

        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String action = jsonObject.get("action").getAsString();

        if ("cargar_reservas".equals(action)) {
            String nombre = jsonObject.get("nombre").getAsString() + " " + jsonObject.get("apellido").getAsString();
            int tipoPago = parseInt(jsonObject.get("tipoPago").getAsString());
            String boleto = jsonObject.get("boleto").getAsString();
            
            gR.insertarReserva(tipoPago, 1, "2", boleto, nombre);
            
        }

        return null;

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

    GestorReservas gR = new GestorReservas();

}
