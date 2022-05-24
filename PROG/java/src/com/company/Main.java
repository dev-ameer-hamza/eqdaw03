package com.company;

import BD.BaseDatos;
import BD.UML.*;
import Modelo.*;
import Views.Administrador.VentanaPrincipalAdmin;
import Views.Login.VentanaLogin;
import Views.Usuario.VentanaPrincipalUsuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static BaseDatos bd;
    public static DueñoDAO dueñoDAO;
    public static EquipoDAO equipoDAO;
    public static JornadasDAO jornadasDAO;
    public static JugadorDAO jugadorDAO;
    public static LigaDAO ligaDAO;
    public static LoginDAO loginDAO;
    public static PartidoDAO partidoDAO;
    public static PersonaDAO personaDAO;
    public static AsistenteDAO asistenteDAO;
    public static EntrenadorDAO entrenadorDAO;
    private static VentanaPrincipalAdmin vpa ;
    public static Dueño dueño;
    public static Equipo equipo;
    public static Jornada jornada;
    public static Jugador jugador;
    public static Liga liga;
    public static Login login;
    public static Partido partido;
    public static Persona persona;
    public static Connection conn;

    private static ArrayList<Partido> partidosModificar = new ArrayList<>();
    private static ArrayList<Partido> partidosConsultar = new ArrayList<>();
    private static ArrayList<Dueño>Duenyos = new ArrayList<>();
    private static JFrame panelAdminCrear;
    private static JFrame panelAdmin;
    private static JFrame panelUsuario;
    private static JFrame panelLogin;

    private static int posMod;
    private static int posCon;
    /**
     *
     * @author Ameer Hamza, Aritz Sainz, Gorka Uriarte y Iñaki Arregui
     *

    /**
     * metodo main y punto de incio de nuestra aplicacion
     * @param args args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// write your code here
        mostrarVentanaLogin();
        /**
         * Conexion a la base de datos
         */

        try{
            bd = new BaseDatos();
            incializarObjetosDAOS();
            //vpa = new VentanaPrincipalAdmin();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public static void incializarObjetosDAOS() throws SQLException {
        dueñoDAO = new DueñoDAO(bd.getConnection());
        equipoDAO = new EquipoDAO(bd.getConnection());
        jornadasDAO = new JornadasDAO(bd.getConnection());
        jugadorDAO = new JugadorDAO(bd.getConnection());
        ligaDAO = new LigaDAO(bd.getConnection());
        loginDAO = new LoginDAO(bd.getConnection());
        partidoDAO = new PartidoDAO(bd.getConnection());
        personaDAO = new PersonaDAO(bd.getConnection());
        entrenadorDAO = new EntrenadorDAO(bd.getConnection());
        asistenteDAO = new AsistenteDAO(bd.getConnection());
    }

    // ****************************************//
    //          MOSTRAR LAS VENTANAS           //
    // ****************************************//

    /**
     * un metodo para mostrar la ventana login para inciar la sesion
     * sin inciar la sesion no te va a dejar entrar en la aplicacion
     */
    public static void mostrarVentanaLogin() {
        panelLogin = new JFrame("default");
        panelLogin.setContentPane(new VentanaLogin().getPanelLogin());
        panelLogin.setSize(300, 300);
        panelLogin.setLocationRelativeTo(null);
        panelLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelLogin.setVisible(true);
    }

    /**
     * un metodo para mostrar la ventana principal del admin
     * @throws SQLException sqlexception
     */
    public static void mostrarVentanaAdmin() throws SQLException {
        panelAdmin = new JFrame("default");
        panelAdmin.setContentPane(new VentanaPrincipalAdmin().getPruebaPanel());
        panelAdmin.setSize(635,675);
        panelAdmin.setLocationRelativeTo(null);
        panelAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelAdmin.setVisible(true);
        panelLogin.setVisible(false);
    }
    public static void mostrarVentanaUsuario() throws SQLException {
        panelUsuario = new JFrame("default");
        panelUsuario.setContentPane(new VentanaPrincipalUsuario().getPanelUsuario());
        panelUsuario.setSize(635,675);
        panelUsuario.setLocationRelativeTo(null);
        panelUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelUsuario.setVisible(true);
        panelLogin.setVisible(false);
    }

    /**
     * cerrar sesion
     */
    public static void cerrarSesionUsuario() throws SQLException {
        if (panelUsuario.isVisible()) {
            panelUsuario.setVisible(false);
        }
    }
    public static void cerrarSesionAdmin() throws SQLException {
        if (panelAdmin.isVisible()) {
            panelAdmin.setVisible(false);
        }
    }

    // ****************************************//
    //   CONSULTAS Y COMPRABACION DE DATOS     //
    // ****************************************//


    /**
     * un metodo para comprobar el estado de liga si esta abierto o cerrado
     * @return String cadena
     * @throws SQLException sqlexception
     */
    public static String comprobarEstadoLiga() throws SQLException {
        return ligaDAO.consultarEstado();
    }

    /**
     * un metodo para consultar todos equipos que existen en base de datos
     * @return ArrayList
     * @throws SQLException sqlexception
     */
    public static ArrayList<Equipo> consultarEquipos() throws SQLException {
        return equipoDAO.consultarEquipos();
    }
    /**
     * un metodo para buscar el usuarios en base de datos
     * @return ArrayList
     * @throws SQLException sqlexception
     */
    public static ArrayList<Login> listaUsuario() throws SQLException {
        return loginDAO.listaUsuarios();
    }

    /**
     * un metodo para sacar los datos de la jornada
     * @return ArrayList
     * @throws SQLException sqlexception
     */

    public static ArrayList<Jornada> listaJornadas() throws SQLException {
        return jornadasDAO.listaJornadas();
    }

    /**
     * el metodo para consultar partidos de una jornada
     * @param jornada jornada
     * @return Partido
     * @throws SQLException sqlexception
     */
    public static Partido listaPartidosMod(int jornada) throws SQLException {
        partidosModificar = partidoDAO.listaPartidos(jornada);
        posMod = 0;
        Partido p = new Partido();
        p.setId_partido(partidosModificar.get(posMod).getId_partido());
        p.setEquipo1(partidosModificar.get(posMod).getEquipo1());
        p.setEquipo2(partidosModificar.get(posMod).getEquipo2());
        p.setEquipo_ganador(partidosModificar.get(posMod).getEquipo_ganador());
        return p;
    }

    /**
     * el metodo para consultar partidos una jornada
     * @param jornada jornada
     * @return Partido
     * @throws SQLException
     */

    public static Partido listaPartidosCon(int jornada) throws SQLException {
        partidosConsultar = partidoDAO.listaPartidos(jornada);
        posCon = 0;
        Partido p = new Partido();
        p.setId_partido(partidosConsultar.get(posCon).getId_partido());
        p.setEquipo1(partidosConsultar.get(posCon).getEquipo1());
        p.setEquipo2(partidosConsultar.get(posCon).getEquipo2());
        p.setEquipo_ganador(partidosConsultar.get(posCon).getEquipo_ganador());

        return p;
    }

    /**
     * el metodo para ver el siguiente partido
     * @return Partido
     * @throws Exception sqlexception
     */
    public static Partido getSiguienteParMod() throws Exception {
        if (posMod != partidosModificar.size() - 1){
            posMod++;
            Partido p = new Partido();
            p.setId_partido(partidosModificar.get(posMod).getId_partido());
            p.setEquipo1(partidosModificar.get(posMod).getEquipo1());
            p.setEquipo2(partidosModificar.get(posMod).getEquipo2());
            p.setEquipo_ganador(partidosModificar.get(posMod).getEquipo_ganador());
            return p;
        }
        else
        {
            throw new Exception("No hay mas partidos");
        }
    }
    /**
     * el metodo para ver el partido anterior
     * @return Partido
     * @throws Exception sqlexception
     */

    public static Partido getSiguienteParCon() throws Exception {
        if (posCon != partidosConsultar.size() - 1){
            posCon++;
            Partido p = new Partido();
            p.setId_partido(partidosConsultar.get(posCon).getId_partido());
            p.setEquipo1(partidosConsultar.get(posCon).getEquipo1());
            p.setEquipo2(partidosConsultar.get(posCon).getEquipo2());
            p.setEquipo_ganador(partidosConsultar.get(posCon).getEquipo_ganador());
            return p;
        }
        else
        {
            throw new Exception("No hay mas partidos");
        }
    }
    /**
     * el metodo para ver el siguiente partido
     * @return Partido
     * @throws Exception sqlexception
     */
    public static Partido getPrevParMod() throws Exception {
        if (posMod != 0)
        {
            posMod--;
            Partido p = new Partido();
            p.setId_partido(partidosModificar.get(posMod).getId_partido());
            p.setEquipo1(partidosModificar.get(posMod).getEquipo1());
            p.setEquipo2(partidosModificar.get(posMod).getEquipo2());
            p.setEquipo_ganador(partidosModificar.get(posMod).getEquipo_ganador());
            //vpa.setDatosModificarJornada(p);
            return p;
        }
        else
        {
            throw new Exception("No hay mas partidos");
        }
    }
    /**
     * el metodo para ver el partido anterior
     * @return Partido
     * @throws Exception sqlexception
     */
    public static Partido getPrevParCon() throws Exception {
        if (posCon != 0)
        {
            posCon--;
            Partido p = new Partido();
            p.setId_partido(partidosConsultar.get(posCon).getId_partido());
            p.setEquipo1(partidosConsultar.get(posCon).getEquipo1());
            p.setEquipo2(partidosConsultar.get(posCon).getEquipo2());
            p.setEquipo_ganador(partidosConsultar.get(posCon).getEquipo_ganador());
            return p;
        }
        else
        {
            throw new Exception("No hay mas partidos");
        }
    }

    /**
     * un metodo para sacar todos los jufadores que existen en base de datos
     * @return ArrayList
     * @throws SQLException sqlexception
     */

    public static ArrayList<Jugador> todosJugadores() throws SQLException {
        return jugadorDAO.todoslosJugador();
    }

    /**
     * un metodo para consultar todos equipos que existen en base de datos
     * @return ArrayList
     * @throws SQLException sqlexception
     */

    public static ArrayList<Partido> consultarPartido() throws SQLException {
        return partidoDAO.consultarPartidos();
    }

    /**
     * un metodo para consultar todos los dueños que existen en base de datos
     * @return ArrayList array de due
     * @throws SQLException sqlexception
     */
    public static ArrayList<Dueño> todosDueños() throws SQLException {
        return dueñoDAO.todosDueños();
    }
    /**
     * un metodo para consultar todos los entrenadores que existen en base de datos
     * @return ArrayList<Entrenador>
     */
    public static ArrayList<Entrenador> todosEntrenadores() throws SQLException {
        return entrenadorDAO.todosEntrenadores();
    }
    /**
     * un metodo para consultar todos los asistentes que existen en base de datos
     * @return ArrayList<Asistente>
     */
    public static ArrayList<Asistente> todosAsistentes() throws SQLException {
        return asistenteDAO.todosAsistentes();

    }

    /**
     * un metodo para inciar le sesion de usuario
     * @param usuario usuario
     * @param contraseña contra
     * @return Login nos devuelve un objeto de clase Login
     * @throws Exception sqlexception
     */
    public static Login inciarSesion(String usuario, String contraseña) throws Exception {
        return loginDAO.inciarSesion(usuario,contraseña);
    }

    // ****************************************//
    //     OPERACIONES DE CREAR LOS DATOS      //
    // ****************************************//


    /**
     * un metodo para crear el usuario (un usuario tipo "USER")
     * @param usuario usuario
     * @param contra contra
     * @return boolean
     * @throws SQLException sqlexception
     */
    public static boolean crearUsuario(String usuario,String contra) throws SQLException {
        login = new Login();
        login.setUsuario(usuario);
        login.setContrasenya(contra);
        login.setTipo_persona("USER");
        LoginDAO loginDAO = new LoginDAO(bd.getConnection());
        return loginDAO.registrarse(login);

    }

    /**
     * un metodo para crear las jornadas y enfrentaminetos de cada jornada
     * @throws Exception sqlexception
     */
    public static void crearEmparejamientos() throws Exception {
        partidoDAO.crearEnfrentamientos();
    }
    /**
     * un metodo para cambiar el estado de la liga
     * */
    public static void cambiarEstadoLiga() throws Exception {
        ligaDAO.cambiarEstado();
    }

    /**
     * Metodo para crear jugador
     * @param nombre nombre
     * @param apellido apellido
     * @param apodo apodo
     * @param rol rol
     * @param sueldo sueldo
     * @param equipo equipo
     * @return boolean
     * @throws SQLException sqlexception
     */

    public static boolean  crearJugador(String nombre,String apellido,String apodo,String rol,Float sueldo,String equipo) throws SQLException {
        jugador = new Jugador(nombre,apellido,apodo,rol,sueldo);
        return jugadorDAO.crearJugador(jugador,equipo);
    }

    /**
     *  Metodo para crear Equipo sin asistente
     * @param nombreEquipo equipo
     * @param nombreDueno dueno
     * @param apellidoDueno apellido dueno
     * @param nombreEntrenador entrenador
     * @param apellidoEntrenador apellido
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearEquipoSinAsistente(String nombreEquipo,String nombreDueno,String apellidoDueno,String nombreEntrenador,String apellidoEntrenador) throws SQLException {
        Entrenador entrenedor = new Entrenador(nombreEntrenador,apellidoEntrenador);
        Dueño dueno = new Dueño(nombreDueno,apellidoDueno);
        Equipo equipo = new Equipo();
        equipo.setNombreEquipo(nombreEquipo);
        return equipoDAO.crearEquipoSinAsistente(equipo,dueno,entrenedor);
    }

    /**
     *  Metodo para crear Equipo con asistente
     * @param nombreEquipo nombre
     * @param nombreDueno dueño
     * @param apellidoDueno apellido
     * @param nombreEntrenador entrenador
     * @param apellidoEntrenador apellido
     * @param nombreAsistente asistente
     * @param apellidoAsistente apellido
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearEquipoConAsistente(String nombreEquipo,String nombreDueno,String apellidoDueno,String nombreEntrenador,String apellidoEntrenador,String nombreAsistente,String apellidoAsistente) throws SQLException {
        Entrenador entrenedor = new Entrenador(nombreEntrenador,apellidoEntrenador);
        Dueño dueno = new Dueño(nombreDueno,apellidoDueno);
        Asistente asistente = new Asistente(nombreAsistente,apellidoAsistente);
        Equipo equipo = new Equipo();
        equipo.setNombreEquipo(nombreEquipo);;
        return equipoDAO.crearEquipoConAsistente(equipo,dueno,entrenedor,asistente);
    }

    /**
     * Metodo para crear Dueño
     * @param d d
     * @param idEquipo equipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearDueno(Dueño d, int idEquipo) throws SQLException {
        return dueñoDAO.registrarDueño(d,idEquipo);
    }

    /**
     * Metodo para crear Entrenador
     * @param e e
     * @param idEquipo equipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearEntrenador(Entrenador e, int idEquipo) throws SQLException {
        return  entrenadorDAO.registrarEntrenador(e,idEquipo);
    }

    /**
     * Metodo para crear Asistente
     * @param a a
     * @param idEquipo equipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearAsistente(Asistente a,int idEquipo) throws SQLException {
        return  asistenteDAO.registrarAsistente(a,idEquipo);
    }

    /**
     * Metod para crear Personas
     * @param p p
     * @return
     * @throws SQLException
     */
    public static int crearPersona(Persona p) throws SQLException {
        return personaDAO.crearPersona(p);
    }

    // ****************************************//
    //     OPERACIONES DE BORRAR LOS DATOS     //
    // ****************************************//

    /**
     * Metodo para borrar usuarios
     * @param usuario usu
     * @throws Exception
     */

    public static void borrarUsuario(String usuario) throws Exception {
        loginDAO.borrarUsuario(usuario);
    }

    /**
     * Metodo para borrar jugadores con su persona correspondiente
     * @param jugador jugador
     * @return boolean
     * @throws Exception
     */
    public static boolean borrarJugador(String jugador) throws Exception {
        return jugadorDAO.borrarJugador(jugador);
    }

    /**
     * Metodo para borrar la persona referente al usuario, jugador,asistente,
     * @param id id
     */
    public static void borrarPersona(int id) throws SQLException {
        personaDAO.borrarPersona(id);
    }

    /**
     * Metodo para borrar el equipo con sus jugadores correspondientes
     * @param equipo equipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean borrarEquipo(String equipo) throws SQLException {
        return equipoDAO.borrarEquipo(equipo);
    }

    /**
     * Metodo para borrar el asistente  con su persona correspondientes
     * @param id id
     * @throws SQLException
     */
    public static void borrarAsistenteDeEquipo(int id) throws SQLException {
        asistenteDAO.borrarAsistente(id);
    }

    /**
     * Metodo para borrar el dueño con su persona referente
     * @param id id
     * @throws SQLException
     */
    public static void borrarDuenyoDeEquipo(int id) throws SQLException {
        dueñoDAO.borrarDuenyo(id);
    }

    /**
     * Metodo para borrar el entrenador con su persona referente
     * @param id id
     * @throws SQLException
     */

    public static void borrarEntrenadorDeEquipo(int id) throws SQLException {
        entrenadorDAO.borrarEntrenador(id);
    }




    // ****************************************//
    //     OPERACIONES DE BUSCAR LOS DATOS     //
    // ****************************************//

    /**
     * el metodo para buscar equipo por nombre
     * @param nombreEquipo equipo
     * @return Equipo
     * @throws SQLException
     */
    public static Equipo buscarEquipoPorNombre(String nombreEquipo) throws SQLException {
        return equipoDAO.buscarEquipoPorNombre(nombreEquipo);
    }

    /**
     * el metodo para buscar jugador por nombre
     * @param ju ju
     * @return Jugador
     * @throws Exception
     */
    public static Jugador buscarJugadorPorNombre(String ju) throws Exception {
        return jugadorDAO.buscarJugadorPorNombre(ju);
    }

    /**
     * el metodo para buscar el dueño por nombre
     * @param str str
     * @return Dueño
     * @throws SQLException
     */
    public static Dueño buscarDueñoConString(String str) throws SQLException {
        return dueñoDAO.buscarDueñoConString(str);
    }

    /**
     * elmetodo para buscar entrenador por nombre
     * @param str str
     * @return Entrenador
     * @throws SQLException
     */
    public static Entrenador buscarEntrenadorConString(String str) throws SQLException {
        return entrenadorDAO.buscarEntrenadorConString(str);
    }
    /**
     * elmetodo para buscar Asistente por nombre
     * @param str str
     * @return Asistente
     * @throws SQLException
     */
    public static Asistente buscarAsistenteConString(String str) throws SQLException {
        return asistenteDAO.buscarAsistenteConString(str);
    }
    /**
     * elmetodo para buscar usuario por nombre
     * @return Login
     * @throws SQLException
     */
    public static Login buscarUsuario(String u) throws SQLException {
        return loginDAO.buscarUsuario(u);
    }



    // ****************************************//
    //    OPERACIONES DE MODIFICAR LOS DATOS   //
    // ****************************************//

    /**
     * el metodo para modificar equipo
     * @param nombreAnti noombre
     * @param nombreNue nombre
     * @return boolean
     * @throws SQLException
     */
    public static boolean modificarEquipo(String nombreAnti,String nombreNue) throws SQLException {
        return equipoDAO.modificarEquipo(nombreAnti,nombreNue);
    }

    /**
     * el metodo para modificar jugador
     * @param jugador jugador
     * @param nNombre nombre
     * @param nApellido apellido
     * @param nApodo apodo
     * @param nRol rol
     * @param sueldo sueldo
     * @return boolean
     * @throws Exception
     */
    public static boolean modificarJugador(String jugador,String nNombre,String nApellido,String nApodo,String nRol,Float sueldo) throws Exception {
        System.out.println(nNombre + nApellido + nApodo + nRol + sueldo);

        Jugador j = new Jugador(nNombre,nApellido,nApodo,nRol,sueldo);
        return jugadorDAO.modificarJugador(jugador,j);
    }

    /**
     * el metodo para modificar persona
     * @param nom nom
     * @param ape ape
     * @param id id
     * @throws SQLException
     */
    public static void actualizarPersona(String nom,String ape,int id) throws SQLException {
        personaDAO.actualizaPersona(nom,ape,id);
    }

    /**
     * el metodo para modificar dueño
     * @param str str
     * @param nNombre nombre
     * @param nApel apel
     * @throws SQLException
     */
    public static void modificarDueño(String str,String nNombre,String nApel) throws SQLException {
        Dueño d = new Dueño(nNombre,nApel);
         dueñoDAO.modificarDueño(str,d);
    }

    /**
     * el metodo para modificar entrenador
     * @param str str
     * @param nNombre nombre
     * @param nApel apel
     * @throws SQLException
     */
    public static void modificarEntrenador(String str,String nNombre,String nApel) throws SQLException {
        Entrenador e = new Entrenador(nNombre,nApel);
        entrenadorDAO.modificarEntrenador(str,e);
    }

    /**
     * el metodo para modificar asistente
     * @param str str
     * @param nom nom
     * @param apel apel
     * @throws SQLException
     */
    public static void modificarAsistente(String str,String nom,String apel) throws SQLException {
        Asistente a = new Asistente(nom,apel);
         asistenteDAO.modificarAsistente(str,a);
    }

    /**
     * el metodo para modificar usuario
     * @param oldNom nom
     * @param nNom nombre nuevo
     * @param nCont contra
     * @return boolean
     * @throws Exception
     */
    public  static boolean modificarUsuario(String oldNom,String nNom,String nCont) throws Exception {
        Login l = new Login(nNom,nCont);
        return loginDAO.modificarUsuario(l,oldNom);
    }

    /**
     * el metodo para modificar partidos de cada jornada
     * @param equipo equipo
     * @param idPartido partido
     * @throws SQLException
     */
    public static void actualizaPartidoDeJornada(String equipo,int idPartido) throws SQLException {
        System.out.println("datos pdjfj " + equipo+idPartido);
        partidoDAO.actualizarPartido(equipo,idPartido);
    }

}
