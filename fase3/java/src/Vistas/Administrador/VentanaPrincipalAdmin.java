package Vistas.Administrador;

import Modelo.Equipo;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class VentanaPrincipalAdmin {
    private JMenuItem menuCrear;
    private JMenuItem menuBorrar;
    private JPanel pruebaPanel;
    private JPanel PanelPrincipal;
    private JPanel PanelMenu;
    private JPanel crearDueño;
    private JPanel crearEquipo;
    private JPanel CrearJugador;
    private JPanel CrearEntrenador;
    private JPanel CrearAsistente;
    private JMenuItem itemDueño;
    private JMenuItem itemEquipo;
    private JMenuItem itemJugador;
    private JMenuItem itemEntrenador;
    private JLabel nombre;
    private JTextField tfNombreCrearDueño;
    private JTextField tfApellidoCrearDueño;
    private JComboBox cbEquipoCrearDueño;
    private JButton guardarButton;

    public JPanel getPruebaPanel() {
        return pruebaPanel;
    }

    public void cerrarPaneles() {
        crearDueño.setVisible(false);
        crearEquipo.setVisible(false);
    }

    public VentanaPrincipalAdmin() {

        itemDueño.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearDueño.setVisible(true);
               try {
                   ArrayList<Equipo> todosEquipos = Main.consultarEquipos();
                   for (int i=0;i< todosEquipos.size();i++){
                       cbEquipoCrearDueño.addItem(todosEquipos.get(i));
                   }
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
           }
        });

        itemEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                crearEquipo.setVisible(true);
            }
        });


//        guardarButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Main.guardarDueño(tfNombreCrearDueño.getText(), tfApellidoCrearDueño.getText());
//            }
//        });
    }
}
