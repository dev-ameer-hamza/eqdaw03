package Vistas.Usuario;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaPrincipalUsuario {
    private JPanel PanelMenu;
    private JMenu jmConsultar;
    private JMenuItem jmiConsultarUltimaJornada;
    private JMenuItem jmiConsultarClasificacion;
    private JButton btInicio;
    private JPanel consultarClasificacion;
    private JButton btAtrasConsultarClasificacion;
    private JButton btSiguienteConsultarClasificacion;
    private JLabel lbPartidosGanadosConsultarClasificacion;
    private JLabel lbPartidosPerdidosConsultarClasificacion;
    private JLabel lbPuntosConsultarClasificacion;
    private JPanel PanelPrincipal;
    private JPanel Panel;
    private JPanel consultarUltimaJornada;
    private JPanel consultarPartido;
    private JButton btAtrasConsultarJornadas;
    private JButton btSiguienteConsultarJornadas;
    private JLabel lbEquipoLocalConsultarJornada;
    private JLabel lbEquipoVisitanteConsultarJornada;
    private JLabel lbEquipoGanadorConsultarJornada;
    private JLabel lbPartidoConsultarJornada;
    private JPanel panelInicio;
    private JButton btCerrarSesion;

    public JPanel getPanelUsuario() {
        return Panel;
    }

    /**
     * funcion para cerrar los paneles de usuario
     */
    public void cerrarPanelesUsuario() {
        consultarClasificacion.setVisible(false);
        consultarUltimaJornada.setVisible(false);
        panelInicio.setVisible(false);
    }

    public void deshabilitarBotonesUsuario() throws SQLException {
        if (Main.comprobarEstadoLiga().equals("ABIERTO")) {
            System.out.println(Main.comprobarEstadoLiga());
//            jmiConsultarUltimaJornada.setVisible(false);
//            jmiConsultarClasificacion.setVisible(false);
            jmConsultar.setVisible(false);
            btInicio.setVisible(false);
        }
    }

    public VentanaPrincipalUsuario() throws SQLException {
        deshabilitarBotonesUsuario();
        cerrarPanelesUsuario();
        panelInicio.setVisible(true);
        /**
         * botones panel usuario
         */
        jmiConsultarUltimaJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                consultarUltimaJornada.setVisible(true);
            }
        });

        jmiConsultarClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                consultarClasificacion.setVisible(true);
            }
        });

        /**
         * botones del menu
         */
        btInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                panelInicio.setVisible(true);
            }
        });

        btCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaLogin();
                try {
                    Main.cerrarSesionUsuario();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
