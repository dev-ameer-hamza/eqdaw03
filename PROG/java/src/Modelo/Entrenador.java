package Modelo;

import java.util.ArrayList;

public class Entrenador extends Persona{



    /**
     * Creamos el constructor de Entrenador que extiende de Persona
     * @param id_personas id_perosnas
     * @param nombre nombre
     * @param apellido apellido
     */
    public Entrenador(int id_personas, String nombre, String apellido) {
        super(id_personas, nombre, apellido);
    }
    public Entrenador( String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Entrenador() {

    }


    /**
     * Creamos el metodo para da de alta el entrenador
     * @param entrenador entrenador
     */
    public void crearEntrenador(Entrenador entrenador){}

    /**
     * Creamos el metodo para sacar los datos del equipo al que pertenece
     * @param id_equipo id_equipo
     * @return Equipo
     */
    public Equipo get_equipo(int id_equipo){return new Equipo();}


}
