package Views.Login;

import Modelo.Login;
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
                try {
                    if(verificarDatos(tfUsuarioLogin.getText(), tfContrasenyaLogin.getText())){
                        Login login = Main.inciarSesion(tfUsuarioLogin.getText(), tfContrasenyaLogin.getText());
                        System.out.println(" usuario " + login.getUsuario() + " id " + login.getId_login() + " tipo: " + login.getTipo_persona());
                        if (login.getUsuario() == null){
                            throw new Exception("el usuario o contraseña esta mal");
                        }
                        if ("admin".equalsIgnoreCase(login.getTipo_persona())){
                            Main.mostrarVentanaAdmin();
                        }
                        else
                        {
                            Main.mostrarVentanaAdmin();
                        }
                    }
                } catch (Exception ex) {
                    //Main.mostrarVentanaLogin();
                    mostrarError(ex.getMessage());
                }
            }
        });
    }

    public JPanel getPanelLogin() {return panelLogin;}


    public boolean verificarDatos(String usuario, String contrasenya) throws Exception {

        if (usuario.isEmpty() || contrasenya.toString().isEmpty()) {

            throw new Exception("Usuario o contraseña estan vacios");

        }

        Pattern pattern = Pattern.compile("^[a-z]+$");
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
