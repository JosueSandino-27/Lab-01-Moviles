/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package Aerolinea.controller;

import Aerolinea.dao.GestorVuelo;
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
@ServerEndpoint("/controller_vuelos")
public class controller_vuelos {

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, EncodeException {

        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String action = jsonObject.get("action").getAsString();
        String vuelosJSON = gV.listarVuelos();
        String origen = "";
        String destino = "";
        String dia = "";
        String index = "";
        try {
            origen = jsonObject.get("origen").getAsString();
            destino = jsonObject.get("destino").getAsString();
            dia = jsonObject.get("dia").getAsString();
            index = jsonObject.get("index").getAsString();
        } catch (Exception ex) {

        }
        if ("cargar_lista_vuel".equals(action)) {
            if (index.equals("1")) {
                vuelosJSON = gV.listarVuelos();
            }
            if (index.equals("2")) {
                vuelosJSON = gV.buscarVuelosOrigen(origen, dia);
            }
            if (index.equals("3")) {
                vuelosJSON = gV.buscarVuelosDestino(destino, dia);
            }
            if (index.equals("4")) {
                vuelosJSON = gV.buscarVuelosOrigenDestino(destino, origen, dia);
            }

            try {
                session.getBasicRemote().sendText(vuelosJSON);
            } catch (IOException ex) {
            }
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

    GestorVuelo gV = new GestorVuelo();
}
