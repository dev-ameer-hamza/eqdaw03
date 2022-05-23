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

    public static Dueño dueño;
    public static Equipo equipo;
    public static Jornada jornada;
    public static Jugador jugador;
    public static Liga liga;
    public static Login login;
    public static Partido partido;
    public static Persona persona;
    public static Connection conn;

    ArrayList<Entrenador>Entrenadores = new ArrayList<>();
    ArrayList<Dueño>Duenyos = new ArrayList<>();
    private static JFrame panelAdminCrear;
    private static JFrame panelAdmin;
    private static JFrame panelUsuario;
    private static JFrame panelLogin;

    /**
     * metodo main y punto de incio de nuestra aplicacion
     * @param args
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
            System.out.println(jornadasDAO.listaJornadas().size());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public static void incializarObjetosDAOS(){
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
     * @throws SQLException
     */
    public static void mostrarVentanaAdmin() throws SQLException {
        panelAdmin = new JFrame("default");
        panelAdmin.setContentPane(new VentanaPrincipalAdmin().getPruebaPanel());
        panelAdmin.setSize(600,600);
        panelAdmin.setLocationRelativeTo(null);
        panelAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelAdmin.setVisible(true);
        panelLogin.setVisible(false);
    }
    public static void mostrarVentanaUsuario() throws SQLException {
        panelUsuario = new JFrame("default");
        panelUsuario.setContentPane(new VentanaPrincipalUsuario().getPanelUsuario());
        panelUsuario.setSize(600,600);
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
     * @return String
     * @throws SQLException
     */
    public static String comprobarEstadoLiga() throws SQLException {
        return ligaDAO.consultarEstado();
    }

    /**
     * un metodo para consultar todos equipos que existen en base de datos
     * @return ArrayList<Equipo>
     * @throws SQLException
     */
    public static ArrayList<Equipo> consultarEquipos() throws SQLException {
        return equipoDAO.consultarEquipos();
    }
    /**
     * un metodo para buscar el usuarios en base de datos
     * @return ArrayList<Login>
     * @throws SQLException
     */
    public static ArrayList<Login> listaUsuario() throws SQLException {
        return loginDAO.listaUsuarios();
    }

    /**
     * un metodo para sacar los datos de la jornada
     * @return ArrayList<Equipo>
     * @throws SQLException
     */

    public static ArrayList<Jornada> listaJornadas() throws SQLException {
        return jornadasDAO.listaJornadas();
    }

    /**
     * un metodo para sacar todos los jufadores que existen en base de datos
     * @return ArrayList<Jugador>
     * @throws SQLException
     */

    public static ArrayList<Jugador> todosJugadores() throws SQLException {
        return jugadorDAO.todoslosJugador();
    }

    /**
     * un metodo para consultar todos equipos que existen en base de datos
     * @return ArrayList<Partido>
     * @throws SQLException
     */

    public static ArrayList<Partido> consultarPartido() throws SQLException {
        return partidoDAO.consultarPartidos();
    }

    /**
     * un metodo para consultar todos los dueños que existen en base de datos
     * @return ArrayList<Dueño>
     * @throws SQLException
     */
    public static ArrayList<Dueño> todosDueños() throws SQLException {
        return dueñoDAO.todosDueños();
    }
    /**
     * un metodo para consultar todos los entrenadores que existen en base de datos
     * @return ArrayList<Entrenador>
     * @throws SQLException
     */
    public static ArrayList<Entrenador> todosEntrenadores() throws SQLException {
        return entrenadorDAO.todosEntrenadores();
    }
    /**
     * un metodo para consultar todos los asistentes que existen en base de datos
     * @return ArrayList<Asistente>
     * @throws SQLException
     */
    public static ArrayList<Asistente> todosAsistentes() throws SQLException {
        return asistenteDAO.todosAsistentes();

    }

    /**
     * un metodo para inciar le sesion de usuario
     * @param usuario
     * @param contraseña
     * @return Login nos devuelve un objeto de clase Login
     * @throws Exception
     */
    public static Login inciarSesion(String usuario, String contraseña) throws Exception {
        return loginDAO.inciarSesion(usuario,contraseña);
    }

    // ****************************************//
    //     OPERACIONES DE CREAR LOS DATOS      //
    // ****************************************//


    /**
     * un metodo para crear el usuario (un usuario tipo "USER")
     * @param usuario
     * @param contra
     * @return boolean
     * @throws SQLException
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
     * @throws Exception
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
     * @param nombre
     * @param apellido
     * @param apodo
     * @param rol
     * @param sueldo
     * @param equipo
     * @return boolean
     * @throws SQLException
     */

    public static boolean  crearJugador(String nombre,String apellido,String apodo,String rol,Float sueldo,String equipo) throws SQLException {
        jugador = new Jugador(nombre,apellido,apodo,rol,sueldo);
        return jugadorDAO.crearJugador(jugador,equipo);
    }

    /**
     *  Metodo para crear Equipo sin asistente
     * @param nombreEquipo
     * @param nombreDueno
     * @param apellidoDueno
     * @param nombreEntrenador
     * @param apellidoEntrenador
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
     * @param nombreEquipo
     * @param nombreDueno
     * @param apellidoDueno
     * @param nombreEntrenador
     * @param apellidoEntrenador
     * @param nombreAsistente
     * @param apellidoAsistente
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
     * @param d
     * @param idEquipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearDueno(Dueño d, int idEquipo) throws SQLException {
        return dueñoDAO.registrarDueño(d,idEquipo);
    }

    /**
     * Metodo para crear Entrenador
     * @param e
     * @param idEquipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearEntrenador(Entrenador e, int idEquipo) throws SQLException {
        return  entrenadorDAO.registrarEntrenador(e,idEquipo);
    }

    /**
     * Metodo para crear Asistente
     * @param a
     * @param idEquipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean crearAsistente(Asistente a,int idEquipo) throws SQLException {
        return  asistenteDAO.registrarAsistente(a,idEquipo);
    }

    /**
     * Metod para crear Personas
     * @param p
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
     * @param usuario
     * @throws Exception
     */

    public static void borrarUsuario(String usuario) throws Exception {
        loginDAO.borrarUsuario(usuario);
    }

    /**
     * Metodo para borrar jugadores con su persona correspondiente
     * @param jugador
     * @return boolean
     * @throws Exception
     */
    public static boolean borrarJugador(String jugador) throws Exception {
        return jugadorDAO.borrarJugador(jugador);
    }

    /**
     * Metodo para borrar la persona referente al usuario, jugador,asistente,
     * @param id
     * @throws SQLException
     */
    public static void borrarPersona(int id) throws SQLException {
        personaDAO.borrarPersona(id);
    }

    /**
     * Metodo para borrar el equipo con sus jugadores correspondientes
     * @param equipo
     * @return boolean
     * @throws SQLException
     */
    public static boolean borrarEquipo(String equipo) throws SQLException {
        return equipoDAO.borrarEquipo(equipo);
    }

    /**
     * Metodo para borrar el asistente  con su persona correspondientes
     * @param id
     * @throws SQLException
     */
    public static void borrarAsistenteDeEquipo(int id) throws SQLException {
        asistenteDAO.borrarAsistente(id);
    }

    /**
     * Metodo para borrar el dueño con su persona referente
     * @param id
     * @throws SQLException
     */
    public static void borrarDuenyoDeEquipo(int id) throws SQLException {
        dueñoDAO.borrarDuenyo(id);
    }

    /**
     * Metodo para borrar el entrenador con su persona referente
     * @param id
     * @throws SQLException
     */

    public static void borrarEntrenadorDeEquipo(int id) throws SQLException {
        entrenadorDAO.borrarEntrenador(id);
    }













    // ****************************************//
    //     OPERACIONES DE BUSCAR LOS DATOS     //
    // ****************************************//

    public static Equipo buscarEquipoPorNombre(String nombreEquipo) throws SQLException {
        return equipoDAO.buscarEquipoPorNombre(nombreEquipo);
    }

    public static Jugador buscarJugadorPorNombre(String ju) throws Exception {
        return jugadorDAO.buscarJugadorPorNombre(ju);
    }
    public static Dueño buscarDueñoConString(String str) throws SQLException {
        return dueñoDAO.buscarDueñoConString(str);
    }

    public static Entrenador buscarEntrenadorConString(String str) throws SQLException {
        return entrenadorDAO.buscarEntrenadorConString(str);
    }

    public static Asistente buscarAsistenteConString(String str) throws SQLException {
        return asistenteDAO.buscarAsistenteConString(str);
    }

    public static Login buscarUsuario(String u) throws SQLException {
        return loginDAO.buscarUsuario(u);
    }



    // ****************************************//
    //    OPERACIONES DE MODIFICAR LOS DATOS   //
    // ****************************************//

    public static boolean modificarEquipo(String nombreAnti,String nombreNue) throws SQLException {
        return equipoDAO.modificarEquipo(nombreAnti,nombreNue);
    }

    public static boolean modificarJugador(String jugador,String nNombre,String nApellido,String nApodo,String nRol,Float sueldo) throws Exception {
        System.out.println(nNombre + nApellido + nApodo + nRol + sueldo);

        Jugador j = new Jugador(nNombre,nApellido,nApodo,nRol,sueldo);
        return jugadorDAO.modificarJugador(jugador,j);
    }
    public static void actualizarPersona(String nom,String ape,int id) throws SQLException {
        personaDAO.actualizaPersona(nom,ape,id);
    }

    public static void modificarDueño(String str,String nNombre,String nApel) throws SQLException {
        Dueño d = new Dueño(nNombre,nApel);
         dueñoDAO.modificarDueño(str,d);
    }

    public static void modificarEntrenador(String str,String nNombre,String nApel) throws SQLException {
        Entrenador e = new Entrenador(nNombre,nApel);
        entrenadorDAO.modificarEntrenador(str,e);
    }

    public static void modificarAsistente(String str,String nom,String apel) throws SQLException {
        Asistente a = new Asistente(nom,apel);
         asistenteDAO.modificarAsistente(str,a);
    }

    public  static boolean modificarUsuario(String oldNom,String nNom,String nCont) throws Exception {
        Login l = new Login(nNom,nCont);
        return loginDAO.modificarUsuario(l,oldNom);
    }

}
