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
public class Pago {
    
    private Integer codigo;
    private Integer monto;
    private Collection<TipoPago> tipopagoCollection;

    public Pago() {
    }

    public Pago(Integer codigo, Integer monto, Collection<TipoPago> tipopagoCollection) {
        this.codigo = codigo;
        this.monto = monto;
        this.tipopagoCollection = tipopagoCollection;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Collection<TipoPago> getTipopagoCollection() {
        return tipopagoCollection;
    }

    public void setTipopagoCollection(Collection<TipoPago> tipopagoCollection) {
        this.tipopagoCollection = tipopagoCollection;
    }
    
   
    
}
