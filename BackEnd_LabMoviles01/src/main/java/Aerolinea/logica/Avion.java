/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.logica;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author Josue
 */
public class Avion implements Serializable {
    
    private String codigo;
    private String nombreAvion;
    private Collection<Vuelo> vueloCollection;
    private TipoAvion tipoAvion;
    private String tipoAvionString;

    public String getTipoAvionString() {
        return tipoAvionString;
    }

    public void setTipoAvionString(String tipoAvionString) {
        this.tipoAvionString = tipoAvionString;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public Collection<Vuelo> getVueloCollection() {
        return vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public TipoAvion getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(TipoAvion tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public Avion() {
    }

    public Avion(String codigo, String nombreAvion, Collection<Vuelo> vueloCollection, TipoAvion tipoAvion) {
        this.codigo = codigo;
        this.nombreAvion = nombreAvion;
        this.vueloCollection = vueloCollection;
        this.tipoAvion = tipoAvion;
    }
    
    public Avion(String codigo, String nombreAvion, String tipoAvionString) {
        this.codigo = codigo;
        this.nombreAvion = nombreAvion;
        this.tipoAvionString = tipoAvionString;
    }


   
    
}
