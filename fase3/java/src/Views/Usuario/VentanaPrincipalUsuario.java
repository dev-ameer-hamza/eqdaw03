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
    private int posClasificacion;
    private int posPartido;

    public JPanel getPanelUsuario() {
        return Panel;
    }

    /**
     * funcion para cerrar los paneles de usuario
     */
    public void cerrarPanelesUsuario() {
        consultarClasificacion.setVisible(false);
        consultarUltimaJornada.setVisible(false);
        inicio.setVisible(false);
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

    /**
     * metodo para conseguir siguiente y anterior clasificacion
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



    public VentanaPrincipalUsuario() throws SQLException {
        deshabilitarBotonesUsuario();
        cerrarPanelesUsuario();
        inicio.setVisible(true);
        /**
         * botones panel usuario
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
         * botones del menu
         */
        btInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPanelesUsuario();
                inicio.setVisible(true);
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
         * botones siguiente y anterior de consultar clasificacion
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
