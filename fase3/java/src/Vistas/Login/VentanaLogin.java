package Vistas.Login;

import Modelo.Login;
import Vistas.Administrador.VentanaPrincipalAdmin;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Objects;
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
//                try {
//                    if(verificarDatos(tfUsuarioLogin.getText(), tfContrasenyaLogin.getText())){
//                        Login login = Main.inciarSesion(tfUsuarioLogin.getText(), tfContrasenyaLogin.getText());
//                        System.out.println(" error " + login.getUsuario() + login.getId_login() + login.getTipo_persona());
//                        if (login.getUsuario() == null){
//                            throw new Exception("el usuario o contraseña esta mal");
//                        }
//                        if ("admin".equalsIgnoreCase(login.getTipo_persona())){
//                            /* TODO hay que ocultar la ventana login primero*/
//                            Main.mostrarVentanaAdmin();
//                        }
//                        else
//                        {
//                            Main.mostrarVentanaUsuario();
//                        }
//                    }
//                } catch (Exception ex) {
//                    Main.mostrarVentanaLogin();
//                    mostrarError(ex.getMessage());
//                }
                try {
                    Main.mostrarVentanaAdmin();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanelLogin() {return panelLogin;}

//    public boolean verificarDatos(String usuario, String contrasenya) throws Exception {
//
//        if (usuario.isEmpty() || contrasenya.toString().isEmpty()) {
//
//            throw new Exception("Usuario o contraseña estan vacios");
//
//        }
//
//        Pattern pattern = Pattern.compile("^[A-Z]*[a-z]+$");
//        Matcher matcher = pattern.matcher(usuario);
//
//        if(!matcher.matches()){
//            throw  new Exception("El formato de usuario no es valido");
//        }
//        return true;
//
//    }

    public void mostrarError(String mensaje){

        JOptionPane.showMessageDialog(null,mensaje);

    }


}
