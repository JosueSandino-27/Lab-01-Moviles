/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.controller;

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
        
//   --------------Listar Paises
//      String paisesJSON = gP.listarPaises();
//        try {
//                session.getBasicRemote().sendText(paisesJSON);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        
       // -------------- INSERTAR PAISES
//        gP.insertarPais("EUW", "EUW");
//        session.getBasicRemote().sendText("EUW");
//      //  -------------- ELIMINAR PAISES
//        gP.eliminarPais("EUW");
//        session.getBasicRemote().sendText("Eliminando - > " + "EUW");


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
    
}
