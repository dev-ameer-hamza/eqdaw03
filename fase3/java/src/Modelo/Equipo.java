package Modelo;

import java.util.ArrayList;

public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private int puntos;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosPerdidos;
    private String estado; //A C

    private ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
    private ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    private Entrenador entrenador;
    private Dueño duenyo;
    private Asistente asistente;

    private String nombreEntrenador;
    private String nombreDuenyo;
    private String nombreAsistente;

    /**
     * Creamos el constructor
     * @param idEquipo
     * @param nombreEquipo
     * @param puntos
     * @param partidosJugados
     * @param partidosGanados
     * @param partidosPerdidos
     * @param estado
     * @param listaPartidos
     * @param listaJugadores
     */

    public Equipo(int idEquipo, String nombreEquipo, int puntos, int partidosJugados, int partidosGanados, int partidosPerdidos, String estado, ArrayList<Partido> listaPartidos, ArrayList<Jugador> listaJugadores, String nombreEntrenador, String nombreAsistente, String nombreDuenyo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.puntos = puntos;
        this.partidosJugados = partidosJugados;
        this.partidosGanados = partidosGanados;
        this.partidosPerdidos = partidosPerdidos;
        this.estado = estado;
        this.listaPartidos = listaPartidos;
        this.listaJugadores = listaJugadores;
        this.nombreEntrenador = nombreEntrenador;
        this.nombreAsistente = nombreAsistente;
        this.nombreDuenyo = nombreDuenyo;
    }

    /**
     * Constructor de equipo para añadir los jugaores al equipo
     * @param idEquipo
     * @param nombreEquipo
     */
    public Equipo(int idEquipo, String nombreEquipo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Constructor de la clase Equipo vacio
     */
    public Equipo() {
    }

    /**
     * Creamos el getter de  Id_jornada
     * @return Id_jornada
     */
    public int getIdEquipo() {
        return idEquipo;
    }

    /**
     * Creamos el setter de id_jornada
     * @return id_jornada
     */
    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Creamos el getter getNombre
     * @return nombre
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /**
     * Getter para dueño
     * @return
     */
    public Dueño getDueñoEquipo() {return duenyo;}

    /**
     * Getter para entrenador
     * @return
     */
    public Entrenador getEntrenadorEquipo() {return entrenador;}

    /**
     * Getter para asistente
     * @return
     */
    public Asistente getasistenteEquipo() {return asistente;}

    /**
     * Creamos el setter de nombre
     * @param nombreEquipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /**
     * Creamos el getter de Puntos
     * @return puntos
     */
    public int getPuntos() {
        return puntos;
    }

    /**
     * Creamos el setter de puntos
     * @param puntos
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    /**
     * Creamos el getter gPartidos_jugandos
     * @return partidos_jugados
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }

    /**
     * Creamos el setter de  partidos_jugados
     * @param partidosJugados
     */
    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    /**
     * el getter para el atributo partidos_ganados
     * @return partidos_ganados
     */
    public int getPartidosGanados() {
        return partidosGanados;
    }

    /**
     * el setter para el atributo partidos_ganados
     * @param partidosGanados
     */
    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    /**
     * el getter para el atributo partidos_perdidos
     * @return return partidos_perdidos;
     */
    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    /**
     * el setter para el atributo partidos_perdidos
     * @param partidosPerdidos
     */
    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getNombreDuenyo() {
        return nombreDuenyo;
    }

    public void setNombreDuenyo(String nombreDuenyo) {
        this.nombreDuenyo = nombreDuenyo;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    /**
     * Creamos una funcion para añadir un entrenador al equipo
     * @param entrenador
     */
    public void addEntrenador( Entrenador entrenador){
       this.entrenador = entrenador;
    }


    /**
     * Creamos una funcion para añadir un asistente al equipo
     * @param asistente
     */
    public void addAsistente (Asistente asistente) {this.asistente = asistente;}

    /**
     * Creamos una funcion para añadir el dueño al equipo
     * @param duenyo
     */
    public void addDuenyo (Dueño duenyo) {this.duenyo = duenyo;}

    /**
     * Creamos el metodo para sacar todos los jugadores de un equipo
     * @return ArrayList<Jugador>
     */
    public ArrayList<Jugador> datosJugadores() {
        return listaJugadores;
    }

    /**
     * Creamos el metodo para sacar todos los enfrentamientos de equipo
     * @return ArrayList<Partido>
     */
    public ArrayList<Partido> todosPartidos() {
        return listaPartidos;
    }

    /**
     * Creamos el metodo para buscar un equipo
     * @param id_equipo
     * @return Equipo
     */
//    public Equipo buscarEquipo(int id_equipo){
//
//    }

    /**
     * Creamos el metodo para dar de alta un equipo
     * @param equipo
     */
    public void crearEquipo(Equipo equipo){}

    /**
     * Creamos el metodo para borrar un equipo
     * @param id_equipo
     * @return boolean
     */
    public boolean borrarEquipo(int id_equipo){return false;}

    /**
     * Creamos el metodo para actualizar los datos de un equipo
     * @param equipo
     */
    public void modificarEquipo(Equipo equipo){}

    /**
     * Creamos el metodo para saber si un equipo tiene los enfrentemiento creados
     * @param id_equipo
     * @return boolean
     */
    public boolean tieneEnfrentamientos(int id_equipo){return false;}

    /**
     * Creamos el metodo para obtener las clasificacion de un equipo
     * @return Equipo
     */


}
