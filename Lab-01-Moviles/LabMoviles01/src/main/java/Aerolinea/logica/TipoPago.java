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
public class TipoPago {
  
    private Integer codigo;
    private String descripcion;
    private Pago pagocodigo;
    private Collection<Reserva> reservaCollection;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Pago getPagocodigo() {
        return pagocodigo;
    }

    public void setPagocodigo(Pago pagocodigo) {
        this.pagocodigo = pagocodigo;
    }

    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public TipoPago(Integer codigo, String descripcion, Pago pagocodigo, Collection<Reserva> reservaCollection) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pagocodigo = pagocodigo;
        this.reservaCollection = reservaCollection;
    }

    public TipoPago() {
    }
}
