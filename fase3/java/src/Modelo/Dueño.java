package Modelo;

import java.util.ArrayList;

public class Dueño extends Persona{

    /**
     * Creamos el constructor de Duenyo que extiende de Persona
     * @param id_personas
     * @param nombre
     * @param apellido
     */
    public Dueño(int id_personas, String nombre, String apellido) {
        super(id_personas, nombre, apellido);
    }
    public Dueño( String nombre, String apellido) {
        super(nombre, apellido);
    }


    public Dueño() {

    }


    /**
     * Creamos el metodo par dar de alta el Duenyo
     * @param equipo
     */
    public void crearDuenyo(Equipo equipo){}

    /**
     * Creamos el metodo para sacar los datos del equipo al que pertenece
     * @param id_equipo
     * @return Equipo
     */
    //public Equipo getEquipo(int id_equipo){return new Dueño();}
}
