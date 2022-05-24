package Modelo;

public class Asistente extends Persona {



    /**
     * Creamos el constructor de Asistente que extiende de Persona
     * @param id_personas d_personas
     * @param nombre nombre
     * @param apellido apellido
     */
    public Asistente(int id_personas, String nombre, String apellido) {
        super(id_personas, nombre, apellido);
    }

    /**
     * asistente
     * @param nombre nombre
     * @param apellido apellido
     */
    public Asistente( String nombre, String apellido) {
        super(nombre, apellido);
    }

    /**
     * constructor vacio asistente
     */
    public Asistente() {

    }

    /**
     * Creamos el metodo para dar de alta los asistentes
     * @param asistente asistente
     */
    public void crearAsistente(Asistente asistente){}

    /**
     * Creamos el metodo para sacar los datos del equipo al que pertenece
     * @param id_equipo id_equipo
     */
    public void getEquipo(int id_equipo){ }

}
