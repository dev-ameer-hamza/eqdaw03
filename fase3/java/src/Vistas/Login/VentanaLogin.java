package Vistas.Login;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogin {
    private JPanel panelLogin;
    private JTextField tfUsuarioLogin;
    private JPasswordField tfContraseñaLogin;
    private JButton siguienteButton;

    public VentanaLogin() {
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaAdmin();
            }
        });
    }

    public JPanel getPanelLogin() {return panelLogin;}
}
