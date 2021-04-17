/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aerolinea.logica;

import java.io.Serializable;

/**
 *
 * @author Josue
 */
public class Usuario implements Serializable {

    
    
    private String nombreUsuario;
    private String apellidos;
    private String correo;
    private String fechaNacimiento;
    private String direccion;
    private String telefonoTrabajo;
    private String celular;
    private String idUsuario;
    private String contrasena;
    private boolean usuarioAdmin;
    
    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", apellidos=" + apellidos + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", telefonoTrabajo=" + telefonoTrabajo + ", celular=" + celular + ", idUsuario=" + idUsuario + ", contrasena=" + contrasena + ", usuarioAdmin=" + usuarioAdmin + '}';
    }

    public Usuario() {
    }
   

    public Usuario(String nombreUsuario, String apellidos, String correo, String fechaNacimiento, String direccion, String telefonoTrabajo, String celular, String idUsuario, String contrasena, boolean usuarioAdmin) {
        this.nombreUsuario = nombreUsuario;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefonoTrabajo = telefonoTrabajo;
        this.celular = celular;
        this.idUsuario = idUsuario;
        this.contrasena = contrasena;
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoTrabajo() {
        return telefonoTrabajo;
    }

    public void setTelefonoTrabajo(String telefonoTrabajo) {
        this.telefonoTrabajo = telefonoTrabajo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(boolean usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    

}
