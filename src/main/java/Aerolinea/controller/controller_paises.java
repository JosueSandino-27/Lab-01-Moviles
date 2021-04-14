package Aerolinea.controller;

import Aerolinea.dao.GestorAvion;
import Aerolinea.dao.GestorCiudad;
import Aerolinea.dao.GestorPais;
import Aerolinea.dao.GestorTipoAvion;
import Aerolinea.dao.GestorUsuario;
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
        if ("insertar_pais".equals(action)) {
            String siglas = jsonObject.get("siglas").getAsString();
            String nombrePais = jsonObject.get("nombrePais").getAsString();
            gP.insertarPais(siglas, nombrePais);
        }
        if ("eliminar_pais".equals(action)) {
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
        if ("insertar_ciudad".equals(action)) {
            String nombre = jsonObject.get("nombre").getAsString();
            String Pais = jsonObject.get("Pais").getAsString();
            gC.insertarCiudad(nombre, Pais);
        }
        if ("eliminar_ciudad".equals(action)) {
            String nombre = jsonObject.get("nombre").getAsString();
            gC.eliminarCiudad(nombre);
        }

        // --------------
        if ("cargar_lista_tipoAviones".equals(action)) {
            String tipoAvionesJSON = gTA.listarTiposAviones();
            try {
                session.getBasicRemote().sendText(tipoAvionesJSON);
            } catch (IOException ex) {
            }
        }
        if ("insertar_tipoAvion".equals(action)) { // HACER ESTO
            String marca = jsonObject.get("marca").getAsString();
            String modelo = jsonObject.get("modelo").getAsString();
            String cantAsientos = jsonObject.get("cantAsientos").getAsString();
            String codigo = jsonObject.get("codigo").getAsString();
            String nombreTipo = jsonObject.get("nombreTipo").getAsString();
            String cantidadFilas = jsonObject.get("cantidadFilas").getAsString();
            String annio = jsonObject.get("annio").getAsString();
            String cantidadColumnas = jsonObject.get("cantidadColumnas").getAsString();

            gTA.insertarTipoAvion(cantidadFilas, cantidadColumnas, codigo, nombreTipo, annio, marca, modelo, cantAsientos);
        }
        if ("eliminar_tipoAvion".equals(action)) { //HACER ESTO
            String codigo = jsonObject.get("codigo").getAsString();
            gTA.eliminarTipoAvion(codigo);
        }

        // --------------
        if ("cargar_lista_aviones".equals(action)) {
            String avionesJSON = gA.listarAviones();
            try {
                session.getBasicRemote().sendText(avionesJSON);
            } catch (IOException ex) {
            }
        }
        if ("insertar_avion".equals(action)) { // HACER ESTO
            String codigo = jsonObject.get("codigo").getAsString();
            String nombre = jsonObject.get("nombre").getAsString();
            String tipo = jsonObject.get("tipo").getAsString();

            gA.insertarAvion(codigo, nombre, tipo);
        }
        if ("eliminar_Avion".equals(action)) { //HACER ESTO
            String codigo = jsonObject.get("codigo").getAsString();
            gA.eliminarAvion(codigo);
        }

        // --------------
        if ("cargar_lista_vuelos".equals(action)) {
            String vuelosJSON = gV.listarVuelos();
            try {
                session.getBasicRemote().sendText(vuelosJSON);
            } catch (IOException ex) {
            }
        }
        if ("insertar_vuelo".equals(action)) { // HACER ESTO
            String numero = jsonObject.get("numero").getAsString();
            String dia = jsonObject.get("dia").getAsString();
            String horaSalida = jsonObject.get("horaSalida").getAsString();
            String horaLlegada = jsonObject.get("horaLlegada").getAsString();
            String avion = jsonObject.get("avion").getAsString();
            String CiudadOrigen = jsonObject.get("CiudadOrigen").getAsString();
            String CiudadDestino = jsonObject.get("CiudadDestino").getAsString();

            gV.insertarVuelo(numero, dia,horaSalida,avion,horaLlegada,CiudadOrigen, CiudadDestino);
        }
        if ("eliminar_vuelo".equals(action)) { //HACER ESTO
            String numero = jsonObject.get("numero").getAsString();
            gV.eliminarVuelo(numero);
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
    GestorTipoAvion gTA = new GestorTipoAvion();
    GestorAvion gA = new GestorAvion();
    GestorVuelo gV = new GestorVuelo();
}
