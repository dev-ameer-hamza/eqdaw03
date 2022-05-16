package Vistas.Login;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VentanaLogin {
    private JPanel panelLogin;
    private JTextField tfUsuarioLogin;
    private JPasswordField tfContrasenyaLogin;
    private JButton siguienteButton;

    public VentanaLogin() {
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mostrarVentanaAdmin();
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    verificarDatos(tfUsuarioLogin.getText(), tfContrasenyaLogin.getPassword());
                } catch (Exception ex) {
                    mostrarError(ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanelLogin() {return panelLogin;}

    public boolean verificarDatos(String usuario, char[] contrasenya) throws Exception {

        if (usuario.isEmpty() || contrasenya.toString().isEmpty()) {

            throw new Exception("Usuario o contraseña estan vacios");

        }

        Pattern pattern = Pattern.compile("^[A-Z][a-z]+$");
        Matcher matcher = pattern.matcher(usuario);

        if(!matcher.matches()){
            throw  new Exception("El formato de usuario no es valido");
        }



        return true;
    }

    public void mostrarError(String mensaje){

        JOptionPane.showMessageDialog(null,mensaje);

    }


}
