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
public class Ciudad {

    private String nombre;
    private Pais pais;
    private Collection<Vuelo> vueloCollection;
    private Collection<Vuelo> vueloCollection1;
    
    
    public Ciudad() {
    }

    public Ciudad(String nombre, Pais pais, Collection<Vuelo> vueloCollection, Collection<Vuelo> vueloCollection1) {
        this.nombre = nombre;
        this.pais = pais;
        this.vueloCollection = vueloCollection;
        this.vueloCollection1 = vueloCollection1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Collection<Vuelo> getVueloCollection() {
        return vueloCollection;
    }

    public void setVueloCollection(Collection<Vuelo> vueloCollection) {
        this.vueloCollection = vueloCollection;
    }

    public Collection<Vuelo> getVueloCollection1() {
        return vueloCollection1;
    }

    public void setVueloCollection1(Collection<Vuelo> vueloCollection1) {
        this.vueloCollection1 = vueloCollection1;
    }
   
   
}
