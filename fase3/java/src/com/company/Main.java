package com.company;

import BD.BaseDatos;
import BD.UML.DueñoDAO;
import BD.UML.EquipoDAO;
import BD.UML.LigaDAO;
import BD.UML.LoginDAO;
import Modelo.Dueño;
import Modelo.Entrenador;
import Modelo.Equipo;
import Modelo.Login;
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
    public static Connection conn;

    ArrayList<Entrenador>Entrenadores = new ArrayList<>();
    ArrayList<Dueño>Duenyos = new ArrayList<>();
    private static JFrame panelAdminCrear;
    private static JFrame panelAdmin;
    private static JFrame panelLogin;

    public static void main(String[] args) throws Exception {
	// write your code here
        mostrarVentanaLogin();
        /**
         * Conexion a la base de datos
         */

        try{
            bd = new BaseDatos();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }

    }

    public static void mostrarVentanaLogin() {
        panelLogin = new JFrame("default");
        panelLogin.setContentPane(new VentanaLogin().getPanelLogin());
        panelLogin.setSize(300, 300);
        panelLogin.setLocationRelativeTo(null);
        panelLogin.setVisible(true);
    }

    public static void mostrarVentanaAdmin() throws SQLException {
        panelAdmin = new JFrame("default");
        panelAdmin.setContentPane(new VentanaPrincipalAdmin().getPruebaPanel());
        panelAdmin.setSize(600,600);
        panelAdmin.setLocationRelativeTo(null);
        panelAdmin.setVisible(true);
        panelLogin.setVisible(false);
    }
    public static void mostrarVentanaUsuario() {}

    public static ArrayList<Equipo> consultarEquipos() throws SQLException {
        equipoDAO = new EquipoDAO(bd.getConnection());
        return equipoDAO.consultarEquipos();
    }

    public static void guardarDueño() {

    }

    public static String comprobarEstadoLiga() throws SQLException {
        LigaDAO ligaDAO = new LigaDAO(bd.getConnection());
        return ligaDAO.consultarEstado();
    }



    //////////////////////////////////////////////
    // ****************************************//
    //codigo para consultas a la base de datos /
    ////////////////////////////////////////////


    public static Login inciarSesion(String usuario, String contraseña) throws Exception {
        LoginDAO loginDAO = new LoginDAO(bd.getConnection());
        return loginDAO.inciarSesion(usuario,contraseña);
    }

    public static Connection conexionDesdeBD(){
        return bd.getConnection();
    }
}
