
package Aerolinea.controller;

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
@ServerEndpoint("/endpoint")
public class Controller {

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, EncodeException {
        
        //--------------Listar Paises
//        String paisesJSON = gP.listarPaises();
//        try {
//                session.getBasicRemote().sendText(paisesJSON);
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
        
        //-------------- INSERTAR PAISES
//        gP.insertarPais("USA", "Estados Unidos");
        //-------------- ELIMINAR PAISES
//        gP.eliminarPais("Estados Unidos");
        
        //LOGIN
//        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
//        String username = jsonObject.get("username").getAsString();
//        String password = jsonObject.get("password").getAsString();
//        if (gU.validarUsuario(username, password)) {
//            try {
//                session.getBasicRemote().sendText(username);
//            } catch (IOException ex) {
//            }
//        }
//        else{
//            session.getBasicRemote().sendText("Error en LOGIN");
//        }
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
    public void onClose(Session session) {
        System.out.println("Sesion de: " + session.getId() + " ha terminado");
    }

    GestorUsuario gU = new GestorUsuario();
    GestorPais gP = new GestorPais();
}