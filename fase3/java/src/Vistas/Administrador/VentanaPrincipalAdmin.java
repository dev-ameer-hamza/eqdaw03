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
    private JButton guardarButton;
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

    public JPanel getPruebaPanel() {
        return pruebaPanel;
    }

    public void cerrarPaneles() {
        crearDueño.setVisible(false);
        crearEquipo.setVisible(false);
        crearAsistente.setVisible(false);
        crearEntrenador.setVisible(false);
        foto.setVisible(false);
    }

    public VentanaPrincipalAdmin() {
        cerrarPaneles();
        foto.setVisible(true);

        // crear -> equipo
        jmiCrearEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearEquipo.setVisible(true);
            }
        });

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

        btSiCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearAsistente.setVisible(true);
            }
        });

        btGuardarCrearAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });

        btNoCrearEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true );
            }
        });
    }
}
