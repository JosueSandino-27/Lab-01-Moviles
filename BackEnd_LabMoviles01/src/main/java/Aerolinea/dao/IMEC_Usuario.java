
package Aerolinea.dao;


public enum IMEC_Usuario {
    
    LISTAR_PAISES("SELECT * FROM proyecto2.pais;"),
    CONSULTAR_USUARIO("SELECT * FROM proyecto2.usuario WHERE nombreusuario = ? AND contrasena = ?; ");
    
    IMEC_Usuario(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
