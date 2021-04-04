/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.logica;

/**
 *
 * @author Josue
 */
public class Tiquete {

    private Integer numero;
    private Reserva reserva;
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Tiquete(Integer numero, Reserva reserva) {
        this.numero = numero;
        this.reserva = reserva;
    }

    public Tiquete() {
    }

    
    
}
