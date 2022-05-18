package com.company;

import BD.BaseDatos;
import BD.UML.*;
import Modelo.*;
import Vistas.Administrador.VentanaPrincipalAdmin;
import Vistas.Login.VentanaLogin;

import javax.swing.*;
import java.sql.Connection;
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
    private static JFrame panelLogin;

    /**
     * metodo main y punto de incio de nuestra aplicacion
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
	// write your code here
        //mostrarVentanaLogin();
        mostrarVentanaAdmin();
        /**
         * Conexion a la base de datos
         */

        try{
            bd = new BaseDatos();
            incializarObjetosDAOS();
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
        panelAdmin.setVisible(true);
        panelLogin.setVisible(false);
    }
    public static void mostrarVentanaUsuario() {}

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
     * @return
     * @throws SQLException
     */
    public static ArrayList<Equipo> consultarEquipos() throws SQLException {
        return equipoDAO.consultarEquipos();
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


    public static boolean  crearJugador(String nombre,String apellido,String apodo,String rol,Float sueldo,String equipo) throws SQLException {
        jugador = new Jugador(nombre,apellido,apodo,rol,sueldo);
        return jugadorDAO.crearJugador(jugador,equipo);
    }

    public static boolean crearEquipoSinAsistente(){
        return equipoDAO.crearEquipoSinAsistente();
    }
    public static boolean crearEquipoConAsistente(){
        return equipoDAO.crearEquipoConAsistente();
    }

    // ****************************************//
    //     OPERACIONES DE BORRAR LOS DATOS     //
    // ****************************************//















    // ****************************************//
    //     OPERACIONES DE BUSCAR LOS DATOS     //
    // ****************************************//

    public static Equipo buscarEquipoPorNombre(String nombreEquipo) throws SQLException {
        return equipoDAO.buscarEquipoPorNombre(nombreEquipo);
    }

}
