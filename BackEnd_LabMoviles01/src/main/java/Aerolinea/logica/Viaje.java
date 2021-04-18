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
public class Viaje implements Serializable {
    
     private Integer numero;
    private Integer precio;
    private Date fecha;
    private String fecha1;
    private Integer asientosDisponibles;
    private Vuelo vuelo;
    private int vuelo1;
    private Collection<Reserva> reservaCollection;
    
    public Viaje(Integer numero, Integer precio, String fecha1, Integer asientosDisponibles, int vuelo1) {
        this.numero = numero;
        this.precio = precio;
        this.fecha1 = fecha1;
        this.asientosDisponibles = asientosDisponibles;
        this.vuelo1 = vuelo1;
    }

    public Viaje() {
    }

    public Viaje(Integer numero, Integer precio, Date fecha, Integer asientosDisponibles, Vuelo vuelo, Collection<Reserva> reservaCollection) {
        this.numero = numero;
        this.precio = precio;
        this.fecha = fecha;
        this.asientosDisponibles = asientosDisponibles;
        this.vuelo = vuelo;
        this.reservaCollection = reservaCollection;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }
    

  
    
}
