package Views.Administrador;


import Modelo.Equipo;
import Modelo.Jornada;
import Modelo.Jugador;
import Modelo.Login;

import Modelo.*;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.SQLException;


public class VentanaPrincipalAdmin {
    private JMenuItem jmCrear;
    private JMenuItem menuBorrar;
    private JPanel PanelAdmin;
    private JPanel PanelPrincipal;
    private JPanel PanelMenu;
    private JPanel crearDueño;
    private JPanel crearEquipo;
    private JPanel crearEntrenador;
    private JMenuItem jmiCrearEquipo;
    private JMenuItem jmiCrearJugador;
    private JComboBox cbEquipoCrearDueño;
    private JButton btGuardarCrearUsuario;
    private JTextField tfNombreCrearAsistente;
    private JTextField tfApellidoCrearAsistente;
    private JTextField tfNombreCrearEntrenador;
    private JTextField tfApellidoCrearEntrenador;
    private JButton btSiCrearEntrenador;
    private JButton btNoCrearEntrenador;
    private JTextField tfNombreCrearDueño;
    private JTextField tfApellidoCrearDueño;
    private JTextField tfNombreCrearEquipo;
    private JButton btSiguienteCrearEquipo;
    private JButton btSiguienteCrearDueño;
    private JButton btGuardarCrearAsistente;
    private JPanel crearAsistente;
    private JPanel foto;
    private JMenuItem jmiCrearEmparejamiento;
    private JMenuItem jmiCrearUsuario;
    private JMenu jmBorrar;
    private JMenu jmConsultar;
    private JMenuItem jmiBorrarEquipo;
    private JMenuItem jmiBorrarJugador;
    private JMenuItem jmiBorrarUsuario;
    private JPanel crearJugador;
    private JTextField tfNombreCrearJugador;
    private JTextField tfApellidoCrearJugador;
    private JTextField tfApodoCrearJugador;
    private JTextField tfRolCrearJugador;
    private JTextField tfSueldoCrearJugador;
    private JComboBox cbEquipoCrearJugador;
    private JPanel crearUsuario;
    private JPanel crearEmparejamiento;
    private JTextField tfUsuarioCrearUsuario;
    private JPasswordField pfContraseñaCrearUsuario;
    private JPasswordField pfConfirmacionCrearUsuario;
    private JButton btGuardarCrearJugador;
    private JButton btCancelarCrearEquipo;
    private JButton btCancelarCrearDueño;
    private JButton btAtrasCrearDueño;
    private JButton btAtrasCrearEntrenador;
    private JButton btAtrasCrearAsistente;
    private JButton btCancelarCrearEntrenador;
    private JButton btCancelarCrearAsistente;
    private JButton btCancelarCrearJugador;
    private JButton btCancelarCrearUsuario;
    private JMenuItem jmiModificarEquipo;
    private JMenuItem jmiModificarJugador;
    private JMenuItem jmiConsultarEquipo;
    private JMenuItem jmiConsultarJugador;
    private JMenuItem jmiConsultarJornadas;
    private JMenuItem jmiConsultarClasificacion;
    private JPanel borrarEquipo;
    private JPanel borrarJugador;
    private JPanel borrarUsuario;
    private JComboBox cbNombreBorrarEquipo;
    private JButton btBorrarBorrarEquipo;
    private JButton btCancelarBorrarEquipo;
    private JComboBox cbNombreBorrarJugador;
    private JButton btBorrarBorrarJugador;
    private JButton btCancelarBorrarJugador;
    private JComboBox cbNombreBorrarUsuario;
    private JButton btBorrarBorrarUsuario;
    private JButton btCancelarBorrarUsuario;
    private JPanel modificarEquipo;
    private JPanel modificarJugador;
    private JPanel modificarDueño;
    private JPanel modificarEntrenador;
    private JPanel modificarAsistente;
    private JPanel modificarUsuario;
    private JComboBox cbNombreModificarJugador;
    private JTextField tfNuevoNombreModificarJugador;
    private JButton btModificarModificarJugador;
    private JButton btCancelarModificarJugador;
    private JComboBox cbNombreModificarDueño;
    private JTextField tfNuevoNombreModificarDueño;
    private JPasswordField tfnuevaContraseñaModificarUsuario;
    private JComboBox cbNombreModificarEquipo;
    private JTextField tfNuevoNombreModificarEquipo;
    private JButton btCancelarModificarEquipo;
    private JButton btCancelarModificarDueño;
    private JButton btCancelarModificarEntrenador;
    private JButton btCancelarModificarAsistente;
    private JButton btCancelarModificarUsuario;
    private JButton btModificarModificarEquipo;
    private JButton btModificarModificarDueño;
    private JButton btModificarModificarEntrenador;
    private JButton btModificarModificarAsistente;
    private JButton btModificarModificarUsuario;
    private JComboBox cbNombreModificarEntrenador;
    private JComboBox cbNombreModificarAsistente;
    private JComboBox cbNombreModificarUsuario;
    private JTextField tfNuevoNombreModificarEntrenador;
    private JTextField tfNuevoNombreModificarAsistente;
    private JTextField tfNuevoUsuarioModificarUsuario;
    private JTextField tfNuevoApellidoModificarJugador;
    private JTextField tfNuevoApellidoModificarDueño;
    private JTextField tfNuevoApellidoModificarEntrenador;
    private JTextField tfNuevoApellidoModificarAsistente;
    private JTextField tfNuevoApodoModificarJugador;
    private JTextField tfNuevoRolModificarJugador;
    private JTextField tfNuevoSueldoModificarJugador;
    private JPasswordField tfConfirmacionModificarUsuario;
    private JMenuItem jmiModificarDueño;
    private JMenuItem jmiModificarEntrenador;
    private JMenuItem jmiModificarAsistente;
    private JMenuItem jmiModificarUsuario;
    private JPanel consultarEquipo;
    private JButton btSiguienteConsultarEquipo;
    private JButton btAtrasConsultarEquipo;
    private JLabel lbNombreConsultarEquipo;
    private JLabel lbDueñoConsultarDueño;
    private JLabel lbEntrenadorConsultarDueño;
    private JLabel lbAsistenteConsultarDueño;
    private JPanel consultarJugador;
    private JLabel lbNombreConsultarJugador;
    private JLabel lbApellidoConsultarJugador;
    private JLabel lbApodoConsultarJugador;
    private JLabel lbRolConsultarJugador;
    private JLabel lbSueldoConsultarJugador;
    private JLabel lbEquipoConsultarJugador;
    private JPanel consultarPartido;
    private JPanel consultarClasificacion;
    private JButton btAtrasConsultarJugador;
    private JButton btAtrasConsultarJornadas;
    private JButton btSiguienteConsultarJornadas;
    private JButton btSiguienteConsultarJugador;
    private JLabel lbEquipoLocalConsultarJornada;
    private JLabel lbEquipoVisitanteConsultarJornada;
    private JLabel lbEquipoGanadorConsultarJornada;

    private final float SALARIOMINIMO = 950.0f;

    private JLabel lbPartidosGanadosConsultarClasificacion;
    private JLabel lbPartidosPerdidosConsultarClasificacion;
    private JLabel lbPuntosConsultarClasificacion;
    private JButton btSiguienteConsultarClasificacion;
    private JButton btAtrasConsultarClasificacion;
    private JMenu jmModificar;
    private JButton btInicio;
    private JPanel consultarJornada;
    private JLabel lbPartidoConsultarJornada;
    private JComboBox cbJornadaConsultarJornada;
    private JPanel modificarJornada;
    private JComboBox cbJornadaModificarJornada;
    private JButton btAtrasModificarJornada;
    private JButton btSiguienteModificarJornada;
    private JLabel lbEquipoLocalModificarJornada;
    private JLabel lbEquipoVisitanteModificarJornada;
    private JLabel lbPartidoModificarJornada;
    private JComboBox cbEquipoGanadorModificarJornada;
    private JMenuItem jmiModificarJornada;
    private JPanel modificarPartido;
    private JButton btCerrarSesion;
    private JButton button1;
    private JLabel lbPosicionConsultarClasificacion;
    private JLabel lbNombreConsultarClasificacion;
    private JLabel lbPartidosJugadosConsultarClasificacion;
    private JMenu jmInicio;
    private int posJugador;
    private int posClasificacion;
    private int posEquipo;

    public JPanel getPruebaPanel() {
        return PanelAdmin;
    }

    /**
     * metodo para cerrar paneles
     */
    public void cerrarPaneles() {
        crearDueño.setVisible(false);
        crearEntrenador.setVisible(false);
        crearEquipo.setVisible(false);
        crearAsistente.setVisible(false);
        foto.setVisible(false);
        crearJugador.setVisible(false);
        crearUsuario.setVisible(false);
        crearEmparejamiento.setVisible(false);
        borrarEquipo.setVisible(false);
        borrarJugador.setVisible(false);
        borrarUsuario.setVisible(false);
        modificarEquipo.setVisible(false);
        modificarJugador.setVisible(false);
        modificarDueño.setVisible(false);
        modificarEntrenador.setVisible(false);
        modificarAsistente.setVisible(false);
        modificarUsuario.setVisible(false);
        modificarJornada.setVisible(false);
        consultarEquipo.setVisible(false);
        consultarJugador.setVisible(false);
        consultarJornada.setVisible(false);
        consultarClasificacion.setVisible(false);

    }

    /**
     * metodo para deshabilitar botones una vez la clasificacion este hecha
     */
    public void deshabilitarBotones() throws SQLException {
        if (Main.comprobarEstadoLiga().equals("ABIERTO")) {
            System.out.println(Main.comprobarEstadoLiga());
            jmiConsultarJornadas.setVisible(false);
            jmiConsultarClasificacion.setVisible(false);
            jmiModificarJornada.setVisible(false);
        } else {
            //dentro de crear
            jmiCrearEquipo.setVisible(false);
            jmiCrearJugador.setVisible(false);
            jmiCrearEmparejamiento.setVisible(false);
            //dentro de borrar
            jmiBorrarEquipo.setVisible(false);
            jmiBorrarJugador.setVisible(false);
            //dentro de modificar
            jmiModificarAsistente.setVisible(false);
            jmiModificarDueño.setVisible(false);
            jmiModificarEquipo.setVisible(false);
            jmiModificarJugador.setVisible(false);
            jmiModificarEntrenador.setVisible(false);
        }
    }

    /**
     * metodo para conseguir siguiente y anterior equipp
     */
    public void getSiguienteEquipo() throws Exception {
        try {
            if (posEquipo != Main.consultarEquipos().size() - 1) {
                posEquipo++;
                Equipo equipo = Main.consultarEquipos().get(posEquipo);
                lbNombreConsultarEquipo.setText(equipo.getNombreEquipo());
                lbDueñoConsultarDueño.setText(equipo.getNombreDuenyo());
                lbEntrenadorConsultarDueño.setText(equipo.getNombreEntrenador());
                lbAsistenteConsultarDueño.setText(equipo.getNombreAsistente());
            } else {
                // hay que avisar al usuario
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay más equipos");
        }

    }

    public void getAnteriorEquipo() throws Exception {
        if (posEquipo != 0) {
            posEquipo--;
            Equipo equipo = Main.consultarEquipos().get(posEquipo);
            lbNombreConsultarEquipo.setText(equipo.getNombreEquipo());
            lbDueñoConsultarDueño.setText(equipo.getNombreDuenyo());
            lbEntrenadorConsultarDueño.setText(equipo.getNombreEntrenador());
            lbAsistenteConsultarDueño.setText(equipo.getNombreAsistente());

        } else
            throw new Exception("No hay anterior");
    }

    /**
     * metodo para conseguir siguiente y anterior jugador
     */
    public void getSiguienteJugador() throws Exception {
        try {
            if (posJugador != Main.todosJugadores().size() - 1) {
                posJugador++;
                Jugador jugador = Main.todosJugadores().get(posJugador);
                lbNombreConsultarJugador.setText(jugador.getNombre());
                lbApellidoConsultarJugador.setText(jugador.getApellido());
                lbApodoConsultarJugador.setText(jugador.getApodo());
                lbRolConsultarJugador.setText(jugador.getRol());
                float sueldo = jugador.getSueldo();
                String s = String.valueOf(sueldo);
                lbSueldoConsultarJugador.setText(s);
                lbEquipoConsultarJugador.setText(jugador.getNombreEquipo());
            } else {
                // hay que avisar al usuario
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No hay más jugadores");
        }

    }

    public void getAnteriorJugador() throws Exception {
        if (posJugador != 0) {
            posJugador--;
            Jugador jugador = Main.todosJugadores().get(posJugador);
            lbNombreConsultarJugador.setText(jugador.getNombre());
            lbApellidoConsultarJugador.setText(jugador.getApellido());
            lbApodoConsultarJugador.setText(jugador.getApodo());
            lbRolConsultarJugador.setText(jugador.getRol());
            float sueldo = jugador.getSueldo();
            String sueldoS = String.valueOf(sueldo);
            lbSueldoConsultarJugador.setText(sueldoS);
            lbEquipoConsultarJugador.setText(jugador.getNombreEquipo());
        } else
            throw new Exception("No hay anterior");
    }

    /**
     * metodo para conseguir siguiente y anterior clasificacion
     */
    public void getSiguienteClasificacion() throws Exception {
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
        } else {
            // hay que avisar al usuario
            throw new Exception("No hay siguiente");
        }
    }

    public void getAnteriorClasificacion() throws Exception {
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
        } else
            throw new Exception("No hay anterior");
    }

    /**
     * ventana admin
     */

    public VentanaPrincipalAdmin() throws SQLException {
        cerrarPaneles();
        deshabilitarBotones();
        foto.setVisible(true);
        /**
         * Botones del menu crear
         */
        jmiCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearEquipo.setVisible(true);
            }
        });
        jmiCrearJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearJugador.setVisible(true);
                try {
                    ArrayList<Equipo> listaEquipos = Main.consultarEquipos();
                    for (int i = 0; i < listaEquipos.size(); i++) {
                        cbEquipoCrearJugador.addItem(listaEquipos.get(i).getNombreEquipo());
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jmiCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearUsuario.setVisible(true);
            }
        });
        jmiCrearEmparejamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.crearEmparejamientos();
                    Main.cambiarEstadoLiga();
                    mostrarMensaje("Jornadas y enfrentaminetos ya estan creadas");
                    cerrarPaneles();
                    crearEmparejamiento.setVisible(true);
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                    cerrarPaneles();
                    foto.setVisible(true);
                }
            }
        });

        /**
         * botones del menu borrar
         */
        jmiBorrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                borrarEquipo.setVisible(true);
                try {
                    ArrayList<Equipo> equipos = Main.consultarEquipos();
                    for (int i = 0; i < equipos.size(); i++) {
                        cbNombreBorrarEquipo.addItem(equipos.get(i).getNombreEquipo());
                    }
                } catch (Exception ex) {
                }
            }
        });
        jmiBorrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                borrarJugador.setVisible(true);
                try {
                    ArrayList<Jugador> jugadores = Main.todosJugadores();
                    for (int i = 0; i < jugadores.size(); i++) {
                        cbNombreBorrarJugador.addItem(jugadores.get(i).getId_personas() + "-" + jugadores.get(i).getNombre());
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        jmiBorrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                borrarUsuario.setVisible(true);
                try {
                    ArrayList<Login> usuarios = Main.listaUsuario();
                    for (int i = 0; i < usuarios.size(); i++) {
                        System.out.println(usuarios.get(i).getUsuario());
                        cbNombreBorrarUsuario.addItem(usuarios.get(i).getUsuario());
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        /**
         *  botones del menu modificar
         */
        jmiModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarEquipo.setVisible(true);

                try {
                    ArrayList<Equipo> equipos = Main.consultarEquipos();
                    for (int i = 0; i < equipos.size(); i++) {
                        cbNombreModificarEquipo.addItem(equipos.get(i).getNombreEquipo());
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        jmiModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarJugador.setVisible(true);
                try {
                    ArrayList<Jugador> jugadores = Main.todosJugadores();
                    for (int i = 0; i < jugadores.size(); i++) {
                        cbNombreModificarJugador.addItem(jugadores.get(i).getId_personas() + "-" + jugadores.get(i).getNombre());
                    }
                } catch (Exception ex) {
                }
            }
        });
        jmiModificarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarDueño.setVisible(true);
                try {
                    ArrayList<Dueño> duenos = Main.todosDueños();
                    for (int i = 0; i < duenos.size(); i++) {
                        cbNombreModificarDueño.addItem(duenos.get(i).getId_personas() + "-" + duenos.get(i).getNombre());
                    }
                } catch (Exception ex) {
                }
            }
        });
        jmiModificarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarEntrenador.setVisible(true);
                try {
                    ArrayList<Entrenador> entrenadores = Main.todosEntrenadores();
                    for (int i = 0; i < entrenadores.size(); i++) {
                        cbNombreModificarEntrenador.addItem(entrenadores.get(i).getId_personas() + "-" + entrenadores.get(i).getNombre());
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        jmiModificarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarAsistente.setVisible(true);
                try {
                    ArrayList<Asistente> asistentes = Main.todosAsistentes();
                    for (int i = 0; i < asistentes.size(); i++) {
                        cbNombreModificarAsistente.addItem(asistentes.get(i).getId_personas() + "-" + asistentes.get(i).getNombre());
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }

            }
        });
        jmiModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarUsuario.setVisible(true);
                try {
                    ArrayList<Login> usuarios = Main.listaUsuario();
                    for (int i = 0; i < usuarios.size(); i++) {
                        cbNombreModificarUsuario.addItem(usuarios.get(i).getUsuario());
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        jmiModificarJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarJornada.setVisible(true);
                try{
                    ArrayList<Jornada> jornadas = Main.listaJornadas();
                    if(jornadas.isEmpty()){
                        cbJornadaModificarJornada.addItem("No hay jornadas ");
                    }
                    for(int i=0;i<jornadas.size();i++)
                    {
                        cbJornadaModificarJornada.addItem("Jornada " + jornadas.get(i).getId_jornada());
                    }
                }
                catch(Exception ex){
                    mostrarError(ex.getMessage());
                }
            }
        });
        /**
         * Botones del moenu consultar
         */
        jmiConsultarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                consultarEquipo.setVisible(true);
                try {
                    Equipo equipo = Main.consultarEquipos().get(0);
                    lbNombreConsultarEquipo.setText(equipo.getNombreEquipo());
                    lbDueñoConsultarDueño.setText(equipo.getNombreDuenyo());
                    lbEntrenadorConsultarDueño.setText(equipo.getNombreEntrenador());
                    lbAsistenteConsultarDueño.setText(equipo.getNombreAsistente());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        jmiConsultarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                consultarJugador.setVisible(true);
                try {
                    Jugador jugador = Main.todosJugadores().get(0);
                    lbNombreConsultarJugador.setText(jugador.getNombre());
                    lbApellidoConsultarJugador.setText(jugador.getApellido());
                    lbApodoConsultarJugador.setText(jugador.getApodo());
                    lbRolConsultarJugador.setText(jugador.getRol());
                    float sueldo = jugador.getSueldo();
                    String s = String.valueOf(sueldo);
                    lbSueldoConsultarJugador.setText(s);
                    //no se como sacar el jugador del equipo
                    lbEquipoConsultarJugador.setText(jugador.getNombreEquipo());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jmiConsultarJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                consultarJornada.setVisible(true);
                try{
                    ArrayList<Jornada> jornadas = Main.listaJornadas();
                    if(jornadas.isEmpty()){
                        cbJornadaConsultarJornada.addItem("No hay jornadas ");
                    }
                    for(int i=0;i<jornadas.size();i++)
                    {
                        cbJornadaConsultarJornada.addItem("Jornada " + jornadas.get(i).getId_jornada());
                    }
                }
                catch(Exception ex){
                    mostrarError(ex.getMessage());
                }
            }
        });
        jmiConsultarClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
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
         * botones siguiente en crear
         */
        btSiguienteCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();

                try {
                    validarLosCamposDeTexto(tfNombreCrearEquipo.getText(), "Nombre Equipo");
                    crearDueño.setVisible(true);
                } catch (Exception ex) {
                    crearEquipo.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });

        btSiguienteCrearDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                try {
                    validarLosCamposDeTexto(tfNombreCrearDueño.getText(), "Nombre Dueno");
                    validarLosCamposDeTexto(tfApellidoCrearDueño.getText(), "Apellido Dueno");
                    crearEntrenador.setVisible(true);
                } catch (Exception ex) {
                    crearDueño.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });
        /**
         * boton Si y No en la ventana de crear entrenador
         */
        btSiCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();

                try {
                    validarLosCamposDeTexto(tfNombreCrearEntrenador.getText(), "Nombre Asistente");
                    validarLosCamposDeTexto(tfNombreCrearEntrenador.getText(), "Apellido Asistente");
                    crearAsistente.setVisible(true);
                } catch (Exception ex) {
                    crearEntrenador.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });
        btNoCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();

                try {
                    validarLosCamposDeTexto(tfNombreCrearEntrenador.getText(), "Nombre Entrenador");
                    validarLosCamposDeTexto(tfApellidoCrearEntrenador.getText(), "Apellido Entrenador");
                    foto.setVisible(true);
                    if (
                            Main.crearEquipoSinAsistente(
                                    tfNombreCrearEquipo.getText()
                                    , tfNombreCrearDueño.getText()
                                    , tfApellidoCrearDueño.getText()
                                    , tfNombreCrearEntrenador.getText()
                                    , tfApellidoCrearEntrenador.getText()
                            )) {
                        mostrarMensaje("Equipo creado sin asistente");
                    }
                } catch (Exception ex) {
                    crearEntrenador.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });

        /**
         * botones para ir atras en crear
         */
        btAtrasCrearDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearEquipo.setVisible(true);
            }
        });
        btAtrasCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearDueño.setVisible(true);
            }
        });
        btAtrasCrearAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearEntrenador.setVisible(true);
            }
        });
        /**
         * boton guardar en crear
         */
        btGuardarCrearAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                try {
                    validarLosCamposDeTexto(tfNombreCrearAsistente.getText(), "Nombre Asistente");
                    validarLosCamposDeTexto(tfApellidoCrearAsistente.getText(), "Apellido Asistente");
                    foto.setVisible(true);
                    if (Main.crearEquipoConAsistente(
                            tfNombreCrearEquipo.getText()
                            , tfNombreCrearDueño.getText()
                            , tfApellidoCrearDueño.getText()
                            , tfNombreCrearEntrenador.getText()
                            , tfApellidoCrearEntrenador.getText()
                            , tfNombreCrearAsistente.getText()
                            , tfApellidoCrearAsistente.getText()
                    )) {
                        mostrarMensaje("Equipo creado con exito");
                    }
                } catch (Exception ex) {
                    crearAsistente.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });
        btGuardarCrearJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    validarLosCamposDeTexto(tfNombreCrearJugador.getText(), "Nombre");

                    validarLosCamposDeTexto(tfApellidoCrearJugador.getText(), "Apellido");

                    validarLosCamposDeTexto(tfApodoCrearJugador.getText(), "Apodo");

                    validarLosCamposDeTexto(tfRolCrearJugador.getText(), "Rol");

                    Pattern patternSueldo = Pattern.compile("^[0-9]+$");
                    Matcher matcherSueldo = patternSueldo.matcher(tfSueldoCrearJugador.getText().trim());

                    if (!matcherSueldo.matches()) {
                        throw new Exception("El sueldo tiene que ser en numeros");
                    }
                    if (Float.parseFloat(tfSueldoCrearJugador.getText()) < SALARIOMINIMO) {
                        throw new Exception("El salario tiene que ser mayor que el salario minimo interprofesional que es de " + SALARIOMINIMO + " euros");
                    }
                    if (Main.crearJugador(
                            tfNombreCrearJugador.getText()
                            , tfApellidoCrearJugador.getText()
                            , tfApodoCrearJugador.getText()
                            , tfRolCrearJugador.getText()
                            , Float.parseFloat(tfSueldoCrearJugador.getText())
                            , cbEquipoCrearJugador.getSelectedItem().toString()
                    )) {
                        mostrarMensaje("Jugador creado");
                    } else {
                        mostrarError("error jugador no fue creado");
                    }
                } catch (Exception ex) {
                    cerrarPaneles();
                    tfNombreCrearJugador.setText("");
                    tfApellidoCrearJugador.setText("");
                    tfApodoCrearJugador.setText("");
                    tfRolCrearJugador.setText("");
                    tfSueldoCrearJugador.setText("");
                    crearJugador.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });
        btGuardarCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    if (validarCrearUsuario(tfUsuarioCrearUsuario.getText(), pfContraseñaCrearUsuario.getText(), pfConfirmacionCrearUsuario.getText())) {
                        if (Main.crearUsuario(tfUsuarioCrearUsuario.getText(), pfContraseñaCrearUsuario.getText())) {
                            tfUsuarioCrearUsuario.setText("");
                            pfConfirmacionCrearUsuario.setText("");
                            pfContraseñaCrearUsuario.setText("");
                            JOptionPane.showMessageDialog(null, "Usuario " + tfUsuarioCrearUsuario.getText() + " se ha creado correctamente");
                        }
                    }
                } catch (Exception ex) {
                    cerrarPaneles();
                    pfConfirmacionCrearUsuario.setText("");
                    pfContraseñaCrearUsuario.setText("");
                    crearUsuario.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });

        /**
         * boton borrar en borrar
         */
        btBorrarBorrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    if (JOptionPane.showConfirmDialog(null, "Quieres borrar el equipo " + cbNombreBorrarEquipo.getSelectedItem() + " y sus jugadores?") == 0) {
                        if (Main.borrarEquipo(cbNombreBorrarEquipo.getSelectedItem().toString())) {
                            mostrarMensaje("Equipo " + cbNombreBorrarEquipo.getSelectedItem().toString() + " y sus jugadores se han eliminado");
                        }
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        btBorrarBorrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    if (JOptionPane.showConfirmDialog(null, "Quieres borrar el jugador " + cbNombreBorrarJugador.getSelectedItem().toString() + "?") == 0) {
                        if (Main.borrarJugador(cbNombreBorrarJugador.getSelectedItem().toString())) {
                            mostrarMensaje(cbNombreBorrarJugador.getSelectedItem().toString() + " se ha borrado");
                        }
                    }
                } catch (Exception ex) {
                }
            }
        });
        btBorrarBorrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    int confirm = JOptionPane.showConfirmDialog(null, "Quieres borrar el usuario " + cbNombreBorrarUsuario.getSelectedItem().toString() + "?");
                    if (confirm == 0) {
                        Main.borrarUsuario(cbNombreBorrarUsuario.getSelectedItem().toString());
                        cbNombreBorrarUsuario.removeAllItems();
                    } else {
                        System.out.println("saliendo");
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });

        /**
         * boton modificar en modificar
         */
        btModificarModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    validarLosCamposDeTexto(tfNuevoNombreModificarEquipo.getText().toString(), "Nombre Equipo");
                    if (Main.modificarEquipo(cbNombreModificarEquipo.getSelectedItem().toString(), tfNuevoNombreModificarEquipo.getText().toString())) {
                        mostrarMensaje(cbNombreModificarEquipo.getSelectedItem() + " actualizado con nuevo nombre " + tfNuevoNombreModificarEquipo.getText());
                        cbNombreModificarEquipo.removeAllItems();
                        tfNuevoNombreModificarEquipo.setText("");
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        btModificarModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    validarLosCamposDeTexto(tfNuevoNombreModificarJugador.getText(), "Nombre Jugador");
                    validarLosCamposDeTexto(tfNuevoApellidoModificarJugador.getText(), "Apellido Jugador");
                    validarLosCamposDeTexto(tfNuevoApodoModificarJugador.getText(), "Apodo Jugador");
                    validarLosCamposDeTexto(tfNuevoRolModificarJugador.getText(), "Rol Jugador");
//                    Pattern patternSueldo = Pattern.compile("^[0-9]+$");
//                    Matcher matcherSueldo = patternSueldo.matcher(tfSueldoCrearJugador.getText().trim());
//
//                    if(!matcherSueldo.matches()){
//                        throw new Exception("El sueldo tiene que ser en numeros");
//                    }
//                    if (Float.parseFloat(tfSueldoCrearJugador.getText()) < SALARIOMINIMO){
//                        throw new Exception("El salario tiene que ser mayor que el salario minimo interprofesional que es de " + SALARIOMINIMO + " euros");
//                    };
                    if (Main.modificarJugador(
                            (String) cbNombreModificarJugador.getSelectedItem()
                            , tfNuevoNombreModificarJugador.getText()
                            , tfNuevoApellidoModificarJugador.getText()
                            , tfNuevoApodoModificarJugador.getText()
                            , tfNuevoRolModificarJugador.getText()
                            , Float.parseFloat(tfNuevoSueldoModificarJugador.getText())
                    )) {
                        mostrarMensaje("Jugador actualizado");

                        cbNombreModificarJugador.removeAllItems();
                    }
                } catch (Exception ex) {
                    cerrarPaneles();
                    modificarJugador.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });
        btModificarModificarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    validarLosCamposDeTexto(tfNuevoNombreModificarDueño.getText(), "Nombre Dueño");
                    validarLosCamposDeTexto(tfNuevoApellidoModificarDueño.getText(), "Apellido Dueño");
                    if (JOptionPane.showConfirmDialog(null, "Quieres actualizar dueño " + (String) cbNombreModificarDueño.getSelectedItem() + "?") == 0) {
                        Main.modificarDueño((String) cbNombreModificarDueño.getSelectedItem(), tfNuevoNombreModificarDueño.getText(), tfNuevoApellidoModificarDueño.getText());
                        JOptionPane.showMessageDialog(null, (String) cbNombreModificarDueño.getSelectedItem() + " actualizada");
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }

            }
        });
        btModificarModificarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    validarLosCamposDeTexto(tfNuevoNombreModificarEntrenador.getText(), "Nombre Entrenador");
                    validarLosCamposDeTexto(tfNuevoApellidoModificarEntrenador.getText(), "Apellido Entrenador");
                    if (JOptionPane.showConfirmDialog(null, "Quieres actualizar " + (String) cbNombreModificarEntrenador.getSelectedItem() + "?") == 0) {
                        Main.modificarEntrenador((String) cbNombreModificarEntrenador.getSelectedItem(), tfNuevoNombreModificarEntrenador.getText(), tfNuevoApellidoModificarEntrenador.getText());
                        JOptionPane.showMessageDialog(null, (String) cbNombreModificarEntrenador.getSelectedItem() + " actualizada");

                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        btModificarModificarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);

                try {
                    validarLosCamposDeTexto(tfNuevoNombreModificarAsistente.getText(), "Nombre Asistente");
                    validarLosCamposDeTexto(tfNuevoApellidoModificarAsistente.getText(), "Apellido Asistente");
                    if (JOptionPane.showConfirmDialog(null, "Quieres actualizar " + (String) cbNombreModificarAsistente.getSelectedItem() + "?") == 0) {
                        Main.modificarAsistente((String) cbNombreModificarAsistente.getSelectedItem(), tfNuevoNombreModificarAsistente.getText(), tfNuevoApellidoModificarAsistente.getText());
                        JOptionPane.showMessageDialog(null, (String) cbNombreModificarAsistente.getSelectedItem() + " actualizada");
                        cbNombreModificarAsistente.removeAllItems();
                    }
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
        btModificarModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
                try {
                    validarLosCamposDeTexto(tfNuevoUsuarioModificarUsuario.getText(), "Usuario");
//                    if (tfnuevaContraseñaModificarUsuario.getText().isEmpty() || tfConfirmacionModificarUsuario.getText().isEmpty()){
//                        throw new Exception("la contrasñao contraseña confirmacion no pueden estar vacios");
//                    }
                    if (!tfnuevaContraseñaModificarUsuario.getText().equals(tfConfirmacionModificarUsuario.getText())) {
                        throw new Exception("la contrasña no coincide con contraseña confirmacion");
                    }
                    if (JOptionPane.showConfirmDialog(null, "Quieres actualizar usuario " + (String) cbNombreModificarUsuario.getSelectedItem()) == 0) {
                        if (Main.modificarUsuario((String) cbNombreModificarUsuario.getSelectedItem(), tfNuevoUsuarioModificarUsuario.getText(), tfnuevaContraseñaModificarUsuario.getText())) {
                            cbNombreModificarUsuario.removeAllItems();
                            mostrarMensaje((String) cbNombreModificarUsuario.getSelectedItem() + " actualizada");
                        }
                    }
                } catch (Exception ex) {
                    cerrarPaneles();
                    modificarUsuario.setVisible(true);
                    mostrarError(ex.getMessage());
                }
            }
        });
        /**
         * botones del menu
         */
        btInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaLogin();
                try {
                    Main.cerrarSesionAdmin();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        /**
         * botones siguiente y anterior de consultar jugador
         */
        btSiguienteConsultarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getSiguienteJugador();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btAtrasConsultarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getAnteriorJugador();
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
        cbNombreModificarJugador.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Jugador jugador = Main.buscarJugadorPorNombre(cbNombreModificarJugador.getSelectedItem().toString());
                    System.out.println("jugador mine " + jugador.getNombre());
                    tfNuevoNombreModificarJugador.setText(jugador.getNombre());
                    tfNuevoApellidoModificarJugador.setText(jugador.getApellido());
                    tfNuevoApodoModificarJugador.setText(jugador.getApodo());
                    tfNuevoRolModificarJugador.setText(jugador.getRol());
                    tfNuevoSueldoModificarJugador.setText(Float.toString(jugador.getSueldo()));
                } catch (Exception ex) {
                }
            }
        });
        cbNombreModificarDueño.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Dueño d = Main.buscarDueñoConString((String) cbNombreModificarDueño.getSelectedItem());
                    tfNuevoApellidoModificarDueño.setText(d.getNombre());
                    tfNuevoNombreModificarDueño.setText(d.getApellido());
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());

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

        /**
         * botones siguiente y atras de consultar equipo
         */
        btSiguienteConsultarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getSiguienteEquipo();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btAtrasConsultarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getAnteriorEquipo();
                } catch (Exception ex) {
                    ex.printStackTrace();

                    cbNombreModificarEntrenador.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            try {
                                Entrenador en = Main.buscarEntrenadorConString((String) cbNombreModificarEntrenador.getSelectedItem());
                                tfNuevoNombreModificarEntrenador.setText(en.getNombre());
                                tfNuevoApellidoModificarEntrenador.setText(en.getApellido());
                            } catch (Exception ex) {
                                mostrarError(ex.getMessage());
                            }
                        }
                    });
                    cbNombreModificarAsistente.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            try {
                                Asistente en = Main.buscarAsistenteConString((String) cbNombreModificarAsistente.getSelectedItem());
                                tfNuevoNombreModificarAsistente.setText(en.getNombre());
                                tfNuevoApellidoModificarAsistente.setText(en.getApellido());
                            } catch (Exception ex) {
                                mostrarError(ex.getMessage());
                            }
                        }
                    });
                    cbNombreModificarUsuario.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            try {
                                Login u = Main.buscarUsuario((String) cbNombreModificarUsuario.getSelectedItem());
                                tfNuevoUsuarioModificarUsuario.setText(u.getUsuario());
                            } catch (Exception ex) {
                                mostrarError(ex.getMessage());

                            }
                        }
                    });
                }
            }

        });
    }
    public boolean validarCrearUsuario (String usuario, String contra, String contraConfirm) throws Exception {
        if (usuario.isEmpty() || contra.isEmpty() || contraConfirm.isEmpty()) {
            throw new Exception("Ningun campo puede estar vacio");
        }

        if (!contra.equals(contraConfirm)) {
            throw new Exception("La contraseña no coincide con contraseña de confirmacion");
        }
        if (contra.length() < 6) {
            throw new Exception("La contraseña no puede tener menos de 6 caracteres");
        }

        Pattern patternUsuario = Pattern.compile("^[a-z]+$");
        Matcher matcher = patternUsuario.matcher(usuario);

        if (!matcher.matches()) {
            throw new Exception("El formato del campo usuario no es valido");
        }


        return true;
    }
    public void mostrarError (String msj)
    {
        JOptionPane.showMessageDialog(null, msj);
    }
    public void mostrarMensaje (String msj){
        JOptionPane.showMessageDialog(null, msj);
    }
    public void validarLosCamposDeTexto (String textField, String nombreCampo) throws Exception
    {
        if (textField.isEmpty()) {
            throw new Exception(nombreCampo + " no puede ser vacio");
        }
        Pattern patternTexto = Pattern.compile("^[A-Za-z]+$");
        Matcher matcherTexto = patternTexto.matcher(textField);

        if (!matcherTexto.matches()) {
            throw new Exception(nombreCampo + " Invalido, solo puede tener letras");
        }
    }
}
