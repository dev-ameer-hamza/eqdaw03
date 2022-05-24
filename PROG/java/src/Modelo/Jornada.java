package Modelo;

import com.sun.jdi.FloatValue;

import java.time.LocalDate;
import java.util.ArrayList;

public class Jornada {

    private int id_jornada;
    private LocalDate fecha;

    ArrayList<Partido> listaPartidos = new ArrayList<>();

    /**
     * Creamos el contructor para Jornada
     * @param id_jornada id_jornada
     * @param fecha fecha
     */

    public Jornada(int id_jornada, LocalDate fecha) {
        this.id_jornada = id_jornada;
        this.fecha = fecha;
    }

    /**
     * Creamos el getter de Id_jornada
     * @return getId_jornada
     */

    public int getId_jornada() {
        return id_jornada;
    }

    /**
     * Creamos el setter para id_jornada
     * @param id_jornada id jornada
     */

    public void setId_jornada(int id_jornada) {
        this.id_jornada = id_jornada;
    }


    /**
     * Creamos el getter Fecha
     * @return getFecha
     */

    public LocalDate getFecha() {
        return fecha;
    }


    /**
     * Creamos el setFecha
     * @param fecha fecha
     */

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Creamos el metodo para crear las jornadas
     * @param jornada jornada
     */
    public void crearJornadas(Jornada jornada){}

    /**
     * Creamos el metodo para crear los enfrentamientos
     */
    public void crearEnfrentamientos(){}
}
