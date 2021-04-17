/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.logica;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Josue
 */
public class Vuelo implements Serializable {

    private Integer numero;
    private String dia;
    private Date horaSalida;
    private Date horaLlegada;
    private String horaSalida1;
    private String horaLlegada1;
    private Collection<Viaje> viajeCollection;
    private Avion avion;
    private String avion1;
    private Ciudad CiudadOrigen;
    private Ciudad CiudadDestino;
    private String CiudadOrigen1;
    private String CiudadDestino1;
    

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Collection<Viaje> getViajeCollection() {
        return viajeCollection;
    }

    public void setViajeCollection(Collection<Viaje> viajeCollection) {
        this.viajeCollection = viajeCollection;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ciudad getCiudadOrigen() {
        return CiudadOrigen;
    }

    public void setCiudadOrigen(Ciudad CiudadOrigen) {
        this.CiudadOrigen = CiudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return CiudadDestino;
    }

    public void setCiudadDestino(Ciudad CiudadDestino) {
        this.CiudadDestino = CiudadDestino;
    }

    public Vuelo() {
    }

    public Vuelo(Integer numero, String dia, Date horaSalida, Date horaLlegada, Collection<Viaje> viajeCollection, Avion avion, Ciudad CiudadOrigen, Ciudad CiudadDestino) {
        this.numero = numero;
        this.dia = dia;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.viajeCollection = viajeCollection;
        this.avion = avion;
        this.CiudadOrigen = CiudadOrigen;
        this.CiudadDestino = CiudadDestino;
    }

    public Vuelo(Integer numero, String dia, String horaSalida1, String horaLlegada1, String avion1, String CiudadOrigen1, String CiudadDestino1) {
        this.numero = numero;
        this.dia = dia;
        this.horaSalida1 = horaSalida1;
        this.horaLlegada1 = horaLlegada1;
        this.avion1 = avion1;
        this.CiudadOrigen1 = CiudadOrigen1;
        this.CiudadDestino1 = CiudadDestino1;
    }

}
