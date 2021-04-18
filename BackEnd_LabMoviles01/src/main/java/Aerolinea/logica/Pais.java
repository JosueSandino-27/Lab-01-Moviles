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
public class Pais {

    private String siglas;
    private String nombrePais;
    private Collection<Ciudad> ciudadCollection;
    
    public Pais() {
    }
    public Pais(String siglas, String nombrePais) {
         this.siglas = siglas;
        this.nombrePais = nombrePais;
    }

    public Pais(String siglas, String nombrePais, Collection<Ciudad> ciudadCollection) {
        this.siglas = siglas;
        this.nombrePais = nombrePais;
        this.ciudadCollection = ciudadCollection;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Collection<Ciudad> getCiudadCollection() {
        return ciudadCollection;
    }

    public void setCiudadCollection(Collection<Ciudad> ciudadCollection) {
        this.ciudadCollection = ciudadCollection;
    }


    
}
