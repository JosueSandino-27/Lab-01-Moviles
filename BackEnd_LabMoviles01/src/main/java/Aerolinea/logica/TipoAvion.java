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
public class TipoAvion {
    
    private Integer cantidadFilas;
    private Integer cantidadColumnas;
    private String codigo;
    private String nombreTipo;
    private Integer annio;
    private String marca;
    private String modelo;
    private Integer cantAsientos;
    private Collection<Avion> avionCollection;
    
    public TipoAvion(Integer cantidadFilas, Integer cantidadColumnas, String codigo, String nombreTipo, Integer annio, String marca, String modelo, Integer cantAsientos) {
        this.cantidadFilas = cantidadFilas;
        this.cantidadColumnas = cantidadColumnas;
        this.codigo = codigo;
        this.nombreTipo = nombreTipo;
        this.annio = annio;
        this.marca = marca;
        this.modelo = modelo;
        this.cantAsientos = cantAsientos;
    }
    

    public Integer getCantidadFilas() {
        return cantidadFilas;
    }

    public void setCantidadFilas(Integer cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }

    public Integer getCantidadColumnas() {
        return cantidadColumnas;
    }

    public void setCantidadColumnas(Integer cantidadColumnas) {
        this.cantidadColumnas = cantidadColumnas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public Integer getAnnio() {
        return annio;
    }

    public void setAnnio(Integer annio) {
        this.annio = annio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(Integer cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    public Collection<Avion> getAvionCollection() {
        return avionCollection;
    }

    public void setAvionCollection(Collection<Avion> avionCollection) {
        this.avionCollection = avionCollection;
    }

    public TipoAvion() {
    }

    public TipoAvion(Integer cantidadFilas, Integer cantidadColumnas, String codigo, String nombreTipo, Integer annio, String marca, String modelo, Integer cantAsientos, Collection<Avion> avionCollection) {
        this.cantidadFilas = cantidadFilas;
        this.cantidadColumnas = cantidadColumnas;
        this.codigo = codigo;
        this.nombreTipo = nombreTipo;
        this.annio = annio;
        this.marca = marca;
        this.modelo = modelo;
        this.cantAsientos = cantAsientos;
        this.avionCollection = avionCollection;
    }
    

}
