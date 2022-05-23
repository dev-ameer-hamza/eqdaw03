package Modelo;

public class Liga {

    private String estado;

    /**
     * constructor de liga
     * @param estado
     */
    public Liga(String estado){
        this.estado = estado;
    }

    /**
     * constructor de liga vacio
     */
    public Liga() {
    }

    /**
     * getter de estado para saber si la liga esta abierta o cerrada
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * setter de estado para cerrar o abrir la liga
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
