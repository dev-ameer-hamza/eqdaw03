package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Partido {

    private int id_partido;
    private LocalDateTime hora;

    private String equipo1;
    private String equipo2;
    private String equipo_ganador;


    /**
     * Creamos el constructor de partido
     * @param id_partido
     * @param hora
     * @param equipo1
     * @param equipo2
     * @param equipo_ganador
     */

    public Partido(int id_partido, LocalDateTime hora, String equipo1, String equipo2, String equipo_ganador) {
        this.id_partido = id_partido;
        this.hora = hora;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.equipo_ganador = equipo_ganador;
    }

    public Partido() {
    }

    public Partido(int id_partido, String equipo1, String equipo2, String equipo_ganador) {
    }

    /**
     * Creamos el getter de id_partido
     * @return id_partido
     */

    public int getId_partido() {
        return id_partido;
    }

    /**
     * Creamos el setter de id_partido
     * @param id_partido
     */

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    /**
     * Cremos el getter para la hora
     * @return hora
     */

    public LocalDateTime getHora() {
        return hora;
    }

    /**
     * Creamos el setter para la hora
     * @param hora
     */

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    /**
     * creamos el getter para el equipo1
     * @return equipo1
     */
    public String getEquipo1() {
        return equipo1;
    }

    /**
     * creamos el setter para el equipo1
     * @param equipo1
     */
    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * creamos el getter para el equipo2
     * @return equipo2
     */
    public String getEquipo2() {
        return equipo2;
    }

    /**
     * creamos el setter para el equipo2
     * @param equipo2
     */
    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * creamos el getter para el equipo_ganador
     * @return equipo_ganador
     */
    public String getEquipo_ganador() {
        return equipo_ganador;
    }

    /**
     * creamos el setter para el equipo_ganador
     * @param equipo_ganador
     */
    public void setEquipo_ganador(String equipo_ganador) {
        this.equipo_ganador = equipo_ganador;
    }
}


