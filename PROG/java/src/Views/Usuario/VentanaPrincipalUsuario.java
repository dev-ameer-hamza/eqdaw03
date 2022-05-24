package Views.Usuario;

import Modelo.Equipo;
import Modelo.Partido;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class VentanaPrincipalUsuario {


    private JPanel Panel;
    private JPanel PanelMenu;
    private JButton btInicio;
    private JMenu jmConsultar;
    private JMenuItem jmiConsultarUltimaJornada;
    private JMenuItem jmiConsultarClasificacion;
    private JButton btCerrarSesion;
    private JPanel PanelPrincipal;
    private JPanel inicio;
    private JPanel consultarClasificacion;
    private JButton btAtrasConsultarClasificacion;
    private JButton btSiguienteConsultarClasificacion;
    private JLabel lbPartidosGanadosConsultarClasificacion;
    private JLabel lbPartidosPerdidosConsultarClasificacion;
    private JLabel lbPuntosConsultarClasificacion;
    private JPanel consultarUltimaJornada;
    private JPanel consultarPartido;
    private JButton btAtrasConsultarJornadas;
    private JButton btSiguienteConsultarJornadas;
    private JLabel lbEquipoLocalConsultarJornada;
    private JLabel lbEquipoVisitanteConsultarJornada;
    private JLabel lbEquipoGanadorConsultarJornada;
    private JLabel lbPartidoConsultarJornada;
    private JLabel lbPosicionConsultarClasificacion;
    private JLabel lbNombreConsultarClasificacion;
    private JLabel lbPartidosJugadosConsultarClasificacion;
    private JButton btInicioUsuario;
    private int posClasificacion;
    private int posPartido;

    /**
     * metodo para que aparezca la ventana de usuario
     * @return Panel
     */
    public JPanel getPanelUsuario() {
        return Panel;
    }

    /**
     * metodo para cerrar todos los paneles de la ventana usuario
     */
    public void cerrarPanelesUsuario() {
        consultarClasificacion.setVisible(false);
        consultarUltimaJornada.setVisible(false);
        inicio.setVisible(false);
    }
    /**
     * metodo para deshabilitar botones cuando los emparejamientos esten creados
     */
    public void deshabilitarBotonesUsuario() throws SQLException {
        System.out.println(Main.comprobarEstadoLiga());
        if (Main.comprobarEstadoLiga().equals("ABIERTO")) {
            jmiConsultarUltimaJornada.setVisible(false);
            jmiConsultarClasificacion.setVisible(false);
            jmConsultar.setVisible(false);
            btInicio.setVisible(false);
        }
    }

    /**
     * metodo para ir al siguiente en consultar jornada
     */
    public void getSiguientePartido() throws Exception{
        if (posPartido != Main.consultarPartido().size() - 1) {
            posPartido++;
            Partido partido = Main.consultarPartido().get(posPartido);
            int idPartido = partido.getId_partido();
            String idPartidoS = String.valueOf(idPartido);
            lbPartidoConsultarJornada.setText(idPartidoS);
            lbEquipoLocalConsultarJornada.setText(partido.getEquipo1());
            lbEquipoVisitanteConsultarJornada.setText(partido.getEquipo2());
            lbEquipoGanadorConsultarJornada.setText(partido.getEquipo_ganador());
        }
        else {
            // hay que avisar al usuario
            throw new Exception("No hay siguiente");
        }
    }
    /**
     * metodo para ir al anterior en consultar jornada
     */
    public void getAnteriorPartido() throws Exception{
        if (posPartido != 0) {
            posPartido--;
            Partido partido = Main.consultarPartido().get(posPartido);
            int idPartido = partido.getId_partido();
            String idPartidoS = String.valueOf(idPartido);
            lbPartidoConsultarJornada.setText(idPartidoS);
            lbEquipoLocalConsultarJornada.setText(partido.getEquipo1());
            lbEquipoVisitanteConsultarJornada.setText(partido.getEquipo2());
            lbEquipoGanadorConsultarJornada.setText(partido.getEquipo_ganador());
        }
        else {
            // hay que avisar al usuario
            throw new Exception("No");
        }
    }
    /**
     * metodo para ir al siguiente en consultar clasificacion
     */
    public void getSiguienteClasificacion() throws Exception
    {
        if (posClasificacion != Main.consultarEquipos().size() - 1) {
            //lbPosicionConsultarClasificacion.setText();
            posClasificacion++;
            Equipo equipo = Main.consultarEquipos().get(posClasificacion);
            lbNombreConsultarClasificacion.setText(equipo.getNombreEquipo());
            int partidosJugados = equipo.getPartidosJugados();
            String partidosJugadosS = String.valueOf(partidosJugados);
            lbPartidosJugadosConsultarClasificacion.setText(partidosJugadosS);
            int partidosGanados = equipo.getPartidosGanados();
            String partidosGanadosS = String.valueOf(partidosGanados);
            lbPartidosGanadosConsultarClasificacion.setText(partidosGanadosS);
            int partidosPerdidos = equipo.getPartidosPerdidos();
            String partidosPerdidosS = String.valueOf(partidosPerdidos);
            lbPartidosPerdidosConsultarClasificacion.setText(partidosPerdidosS);
            int puntos = equipo.getPuntos();
            String puntosS = String.valueOf(puntos);
            lbPuntosConsultarClasificacion.setText(puntosS);
        }
        else {
            // hay que avisar al usuario
            throw new Exception("No hay siguiente");
        }
    }
    /**
     * metodo para ir al anterior en consultar clasificacion
     */
    public void getAnteriorClasificacion() throws Exception
    {
        if (posClasificacion != 0) {
            //lbPosicionConsultarClasificacion.setText();
            posClasificacion--;
            Equipo equipo = Main.consultarEquipos().get(posClasificacion);
            lbNombreConsultarClasificacion.setText(equipo.getNombreEquipo());
            int partidosJugados = equipo.getPartidosJugados();
            String partidosJugadosS = String.valueOf(partidosJugados);
            lbPartidosJugadosConsultarClasificacion.setText(partidosJugadosS);
            int partidosGanados = equipo.getPartidosGanados();
            String partidosGanadosS = String.valueOf(partidosGanados);
            lbPartidosGanadosConsultarClasificacion.setText(partidosGanadosS);
            int partidosPerdidos = equipo.getPartidosPerdidos();
            String partidosPerdidosS = String.valueOf(partidosPerdidos);
            lbPartidosPerdidosConsultarClasificacion.setText(partidosPerdidosS);
            int puntos = equipo.getPuntos();
            String puntosS = String.valueOf(puntos);
            lbPuntosConsultarClasificacion.setText(puntosS);
        }
        else
            throw new Exception("No hay anterior");
    }


    /**
     * ventana del usuario
     */
    public VentanaPrincipalUsuario() throws SQLException {
        deshabilitarBotonesUsuario();
        cerrarPanelesUsuario();
        inicio.setVisible(true);
        /**
         * Listener para el boton del menu consultar ultima jornada
         */
        jmiConsultarUltimaJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                consultarUltimaJornada.setVisible(true);
                try {
                    Partido partido = Main.consultarPartido().get(0);
                    int idPartido = partido.getId_partido();
                    String idPartidoS = String.valueOf(idPartido);
                    lbPartidoConsultarJornada.setText(idPartidoS);
                    lbEquipoLocalConsultarJornada.setText(partido.getEquipo1());
                    lbEquipoVisitanteConsultarJornada.setText(partido.getEquipo2());
                    lbEquipoGanadorConsultarJornada.setText(partido.getEquipo_ganador());

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        /**
         * Listener para el boton del menu consultar clasificacion
         */
        jmiConsultarClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                consultarClasificacion.setVisible(true);

                Equipo equipo = null;
                try {
                    equipo = Main.consultarEquipos().get(0);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                lbNombreConsultarClasificacion.setText(equipo.getNombreEquipo());
                int partidosJugados = equipo.getPartidosJugados();
                String partidosJugadosS = String.valueOf(partidosJugados);
                lbPartidosJugadosConsultarClasificacion.setText(partidosJugadosS);
                int partidosGanados = equipo.getPartidosGanados();
                String partidosGanadosS = String.valueOf(partidosGanados);
                lbPartidosGanadosConsultarClasificacion.setText(partidosGanadosS);
                int partidosPerdidos = equipo.getPartidosPerdidos();
                String partidosPerdidosS = String.valueOf(partidosPerdidos);
                lbPartidosPerdidosConsultarClasificacion.setText(partidosPerdidosS);
                int puntos = equipo.getPuntos();
                String puntosS = String.valueOf(puntos);
                lbPuntosConsultarClasificacion.setText(puntosS);
            }
        });

        /**
         * listener del boton inicio en el menu
         */
        btInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                inicio.setVisible(true);
            }
        });
        /**
         * listener del boton cerrar sesion en el menu
         */
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

        /**
         * listener del boton para ir al siguiente en consultar jornadas
         */
        btSiguienteConsultarJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getSiguientePartido();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        /**
         * listener del boton para ir al anterior en consultar jornadas
         */
        btAtrasConsultarJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getAnteriorPartido();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        /**
         * listener del boton para ir al siguiente en consultar clasificacion
         */
        btSiguienteConsultarClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getSiguienteClasificacion();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        /**
         * listener del boton para ir al anterior en consultar clasificacion
         */
        btAtrasConsultarClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getAnteriorClasificacion();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
