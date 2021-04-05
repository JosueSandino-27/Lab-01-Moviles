
package Aerolinea.dao;


public enum IMEC_PAIS {
    
    LISTAR_PAISES("SELECT * FROM proyecto2.pais;"),
    DELETE("DELETE FROM proyecto2.pais WHERE nombrePais=?;  "),
    INSERTAR("INSERT INTO proyecto2.pais ( siglas, nombrePais) VALUES (?, ?); ");
    
    IMEC_PAIS(String comando) {
        this.comando = comando;
    }

    public String obtenerComando() {
        return comando;
    }

    private final String comando;
}
