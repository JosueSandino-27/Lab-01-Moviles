
package Aerolinea.dao;


public enum IMEC_Usuario {
    
    LISTAR_PAISES("SELECT * FROM proyecto2.pais;"),
    CONSULTAR_USUARIO("SELECT nombreUsuario, contrasena FROM proyecto2.usuario where nombreUsuario = ? AND contrasena = ?; ");
    
    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
