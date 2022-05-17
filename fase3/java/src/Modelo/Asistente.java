package Modelo;

public class Asistente extends Persona {



    /**
     * Creamos el constructor de Asistente que extiende de Persona
     * @param id_personas
     * @param nombre
     * @param apellido
     */
    public Asistente(int id_personas, String nombre, String apellido) {
        super(id_personas, nombre, apellido);
    }

    /**
     * Creamos el metodo para dar de alta los asistentes
     * @param asistente
     */
    public void crearAsistente(Asistente asistente){}

    /**
     * Creamos el metodo para sacar los datos del equipo al que pertenece
     * @param id_equipo
     */
    public void getEquipo(int id_equipo){ }

}
