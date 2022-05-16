package Vistas.Administrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipalAdmin {
    private JMenuItem jmCrear;
    private JMenuItem menuBorrar;
    private JPanel pruebaPanel;
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
    private JMenu jmModificar;
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

    public JPanel getPruebaPanel() {
        return pruebaPanel;
    }

    public void cerrarPaneles() {
        crearDueño.setVisible(false);
        crearEntrenador.setVisible(false);
        crearEquipo.setVisible(false);
        crearAsistente.setVisible(false);
        foto.setVisible(false);
        crearJugador.setVisible(false);
        crearUsuario.setVisible(false);
        crearEmparejamiento.setVisible(false);
    }

    public VentanaPrincipalAdmin() {
        cerrarPaneles();
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
                cerrarPaneles();
                crearEmparejamiento.setVisible(true);
            }
        });
        /**
         * botones siguiente en crear
         */
        btSiguienteCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearDueño.setVisible(true);
            }
        });

        btSiguienteCrearDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearEntrenador.setVisible(true);
            }
        });
        /**
         * boton Si y No en la ventana de crear entrenador
         */
        btSiCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearAsistente.setVisible(true);
            }
        });
        btNoCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });

        /**
         * botones para cancelar en crear
         */
        btCancelarCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarCrearDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarCrearAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarCrearJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
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
                foto.setVisible(true);
            }
        });
        btGuardarCrearJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btGuardarCrearUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
    }
}
