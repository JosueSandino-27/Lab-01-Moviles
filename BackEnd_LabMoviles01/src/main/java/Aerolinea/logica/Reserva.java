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
    private int tipoPagocodigoTipoPago1;
    private String usuarioidUsuario1;
    private int viajenumero1;

    private Collection<Tiquete> tiqueteCollection;
    private TipoPago tipoPagocodigoTipoPago;
    private Usuario usuarioidUsuario;
    private Viaje viajenumero;
    
    public Reserva(Integer numeroReservas, int tipoPagocodigoTipoPago1, int viajenumero1, String usuarioidUsuario1 ,String asiento, String viajero) {
        this.numeroReservas = numeroReservas;
        this.asiento = asiento;
        this.viajero = viajero;
        this.tipoPagocodigoTipoPago1 = tipoPagocodigoTipoPago1;
        this.usuarioidUsuario1 = usuarioidUsuario1;
        this.viajenumero1 = viajenumero1;
    }

    public int getTipoPagocodigoTipoPago1() {
        return tipoPagocodigoTipoPago1;
    }

    public void setTipoPagocodigoTipoPago1(int tipoPagocodigoTipoPago1) {
        this.tipoPagocodigoTipoPago1 = tipoPagocodigoTipoPago1;
    }

    public String getUsuarioidUsuario1() {
        return usuarioidUsuario1;
    }

    public void setUsuarioidUsuario1(String usuarioidUsuario1) {
        this.usuarioidUsuario1 = usuarioidUsuario1;
    }

    public int getViajenumero1() {
        return viajenumero1;
    }

    public void setViajenumero1(int viajenumero1) {
        this.viajenumero1 = viajenumero1;
    }

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
