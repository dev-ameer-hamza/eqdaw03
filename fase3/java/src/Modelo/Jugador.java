package Modelo;

import java.util.ArrayList;

public class Jugador extends Persona{

    private String apodo;
    private String rol;
    private int sueldo;




    /**
     * Crteamos el constructor
     * @param id_personas
     * @param nombre
     * @param apellido
     * @param apodo
     * @param rol
     * @param sueldo
     */

    public Jugador(int id_personas, String nombre, String apellido, String apodo, String rol, int sueldo) {
        super(id_personas, nombre, apellido);
        this.apodo = apodo;
        this.rol = rol;
        this.sueldo = sueldo;
    }

    /**
     * Creamos el getter de apodo
     * @return apodo
     */

    public String getApodo() {
        return apodo;
    }

    /**
     * Creamos el setter de apodo
     * @param apodo
     */

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    /**
     * Creamos el getter de rol
     * @return rol
     */

    public String getRol() {
        return rol;
    }

    /**
     * Creamos el setter de rol
     * @param rol
     */

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Creamos el getter de Sueldo
     * @return sueldo
     */

    public int getSueldo() {
        return sueldo;
    }

    /**
     * Creamos el setter de sueldo
     * @param sueldo
     */

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * Creamos el metodo para dar del alta un Jugador
     * @param jugador
     */
    public void crearJugador(Jugador jugador){}

    /**
     * Creamos el metodo para borrar un jugador
     * @param id_jugador
     */
    public void borrarJugador(int id_jugador){}

    /**
     * Creamos el metodo para actualizar los datos del Jugador
     * @param jugador
     */
    public void modificarJugador(Jugador jugador){}

    /**
     * Creamos el metodo para sacar los datos del equipo al que pertenece
     * @param id_equipo
     * "return Equipo
     */
    //public Equipo getEquipo(int id_equipo){}
}
