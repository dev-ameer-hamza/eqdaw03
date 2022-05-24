package Modelo;

import java.util.ArrayList;

public class Jugador extends Persona{

    private String apodo;
    private String rol;
    private float sueldo;
    private String nombreEquipo;


    /**
     * Crteamos el constructor
     * @param id_personas id personas
     * @param nombre nombre
     * @param apellido apellido
     * @param apodo apodo
     * @param rol rol
     * @param sueldo sueldo
     */

    public Jugador(int id_personas, String nombre, String apellido, String apodo, String rol, float sueldo, String nombreEquipo) {
        super(id_personas, nombre, apellido);
        this.apodo = apodo;
        this.rol = rol;
        this.sueldo = sueldo;
        this.nombreEquipo = nombreEquipo;
    }

    public Jugador(String nombre, String apellido,String apodo, String rol, float sueldo) {
        super(nombre, apellido);
        this.apodo = apodo;
        this.rol = rol;
        this.sueldo = sueldo;
    }

    public Jugador() {

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
     * @param apodo apodo
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
     * @param rol rol
     */

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Creamos el getter de Sueldo
     * @return sueldo
     */

    public float getSueldo() {
        return sueldo;
    }

    /**
     * Creamos el setter de sueldo
     * @param sueldo sueldo
     */

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * creamos el getter de id equipo
     */

    public String getNombreEquipo() { return nombreEquipo;}

    /**
     * creamos el setter de id_equipo
     */

    public void setNombreEquipo(String nombreEquipo) {this.nombreEquipo = nombreEquipo;}

    /**
     * Creamos el metodo para dar del alta un Jugador
     * @param jugador jgugador
     */
    public void crearJugador(Jugador jugador){}

    /**
     * Creamos el metodo para borrar un jugador
     * @param id_jugador id jugador
     */
    public void borrarJugador(int id_jugador){}

    /**
     * Creamos el metodo para actualizar los datos del Jugador
     * @param jugador jugador
     */
    public void modificarJugador(Jugador jugador){}

    /**
     * Creamos el metodo para sacar los datos del equipo al que pertenece
     * @param id_equipo id equipo
     * "return Equipo
     */
    //public Equipo getEquipo(int id_equipo){}
}
