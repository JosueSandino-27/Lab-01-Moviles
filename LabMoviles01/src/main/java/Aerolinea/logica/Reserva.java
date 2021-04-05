/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.logica;

import java.util.Collection;

/**
 *
 * @author Josue
 */
public class Reserva {
    
    private Integer numeroReservas;
    private String asiento;
    private String viajero;
    private Collection<Tiquete> tiqueteCollection;
    private TipoPago tipoPagocodigoTipoPago;
    private Usuario usuarioidUsuario;
    private Viaje viajenumero;

    public Integer getNumeroReservas() {
        return numeroReservas;
    }

    public void setNumeroReservas(Integer numeroReservas) {
        this.numeroReservas = numeroReservas;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getViajero() {
        return viajero;
    }

    public void setViajero(String viajero) {
        this.viajero = viajero;
    }

    public Collection<Tiquete> getTiqueteCollection() {
        return tiqueteCollection;
    }

    public void setTiqueteCollection(Collection<Tiquete> tiqueteCollection) {
        this.tiqueteCollection = tiqueteCollection;
    }

    public TipoPago getTipoPagocodigoTipoPago() {
        return tipoPagocodigoTipoPago;
    }

    public void setTipoPagocodigoTipoPago(TipoPago tipoPagocodigoTipoPago) {
        this.tipoPagocodigoTipoPago = tipoPagocodigoTipoPago;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    public Viaje getViajenumero() {
        return viajenumero;
    }

    public void setViajenumero(Viaje viajenumero) {
        this.viajenumero = viajenumero;
    }

    public Reserva(Integer numeroReservas, String asiento, String viajero, Collection<Tiquete> tiqueteCollection, TipoPago tipoPagocodigoTipoPago, Usuario usuarioidUsuario, Viaje viajenumero) {
        this.numeroReservas = numeroReservas;
        this.asiento = asiento;
        this.viajero = viajero;
        this.tiqueteCollection = tiqueteCollection;
        this.tipoPagocodigoTipoPago = tipoPagocodigoTipoPago;
        this.usuarioidUsuario = usuarioidUsuario;
        this.viajenumero = viajenumero;
    }

    public Reserva() {
    }
    
}
