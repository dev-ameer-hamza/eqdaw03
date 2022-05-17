package Vistas.Administrador;

import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private JPanel consultarJornada;
    private JPanel consultarClasificacion;
    private JButton btAtrasConsultarJugador;
    private JButton btAtrasConsultarJornadas;
    private JButton btSiguienteConsultarJornadas;
    private JButton btSiguienteConsultarJugador;
    private JLabel lbJornadaConsultarJornada;
    private JLabel lbEquipoLocalConsultarJornada;
    private JLabel lbEquipoVisitanteConsultarJornada;
    private JLabel lbEquipoGanadorConsultarJornada;
    private final float SALARIOMINIMO = 950.0f;

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
        borrarEquipo.setVisible(false);
        borrarJugador.setVisible(false);
        borrarUsuario.setVisible(false);
        modificarEquipo.setVisible(false);
        modificarJugador.setVisible(false);
        modificarDueño.setVisible(false);
        modificarEntrenador.setVisible(false);
        modificarAsistente.setVisible(false);
        modificarUsuario.setVisible(false);
        consultarEquipo.setVisible(false);
        consultarJugador.setVisible(false);
        consultarJornada.setVisible(false);
        consultarClasificacion.setVisible(false);
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
         * botones del menu borrar
         */
        jmiBorrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                borrarEquipo.setVisible(true);
            }
        });
        jmiBorrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                borrarJugador.setVisible(true);
            }
        });
        jmiBorrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                borrarUsuario.setVisible(true);
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
            }
        });
        jmiModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarJugador.setVisible(true);
            }
        });
        jmiModificarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarDueño.setVisible(true);
            }
        });
        jmiModificarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarEntrenador.setVisible(true);
            }
        });
        jmiModificarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarAsistente.setVisible(true);
            }
        });
        jmiModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarUsuario.setVisible(true);
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
            }
        });
        jmiConsultarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                consultarJugador.setVisible(true);
            }
        });
        jmiConsultarJornadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                consultarJornada.setVisible(true);
            }
        });
        jmiConsultarClasificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                consultarClasificacion.setVisible(true);
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

                try {
                    Pattern patternNombre = Pattern.compile("^[A-Za-z]+$");
                    Matcher matcherNombre = patternNombre.matcher(tfNombreCrearJugador.getText().trim());

                    if (!matcherNombre.matches()){
                        throw new Exception("Nombre no valido");
                    }

                    Pattern patternApellido = Pattern.compile("^[A-Za-z]+$");
                    Matcher matcherApellido = patternApellido.matcher(tfApellidoCrearJugador.getText().trim());

                    if(!matcherApellido.matches()) {
                        throw new Exception("Apellido no valido");
                    }

                    Pattern patternApodo = Pattern.compile("^[A-Za-z]+$");
                    Matcher matcherApodo = patternApodo.matcher(tfApodoCrearJugador.getText().trim());

                    if (!matcherApodo.matches()){
                        throw new Exception("Apodo no valido");
                    }

                    Pattern patternRol = Pattern.compile("^[A-Za-z]+$");
                    Matcher matcherRol = patternRol.matcher(tfRolCrearJugador.getText().trim());

                    if (!matcherRol.matches()){
                        throw new Exception("Rol no valido");
                    }


                    Pattern patternSueldo = Pattern.compile("^[0-9]+$");
                    Matcher matcherSueldo = patternSueldo.matcher(tfSueldoCrearJugador.getText().trim());

                    if(!matcherSueldo.matches()){
                        throw new Exception("El sueldo tiene que ser en numeros");
                    }else{
                        if (Integer.parseInt(tfSueldoCrearJugador.getText()) < SALARIOMINIMO){
                            throw new Exception("El salario tiene que ser mayor que el salario minimo interprofesional que es de " + SALARIOMINIMO + " euros");
                        }
                    }


                }catch (Exception ex){
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
                    if(validarCrearUsuario(tfUsuarioCrearUsuario.getText(),pfContraseñaCrearUsuario.getText(),pfConfirmacionCrearUsuario.getText()))
                    {
                        if(Main.crearUsuario(tfUsuarioCrearUsuario.getText(),pfContraseñaCrearUsuario.getText()))
                        {
                            tfUsuarioCrearUsuario.setText("");
                            pfConfirmacionCrearUsuario.setText("");
                            pfContraseñaCrearUsuario.setText("");
                            JOptionPane.showMessageDialog(null,"Usuario " + tfUsuarioCrearUsuario.getText() +" se ha creado correctamente");
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
         * boton cancelar en borrar
         */
        btCancelarBorrarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarBorrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarBorrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
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
            }
        });
        btBorrarBorrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btBorrarBorrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });

        /**
         * boton cancelar en modificar
         */
        btCancelarModificarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarModificarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarModificarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarModificarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btCancelarModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
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
            }
        });
        btModificarModificarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btModificarModificarDueño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btModificarModificarEntrenador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btModificarModificarAsistente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
        btModificarModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                foto.setVisible(true);
            }
        });
    }


    public boolean validarCrearUsuario(String usuario,String contra,String contraConfirm) throws Exception {
        if (usuario.isEmpty() || contra.isEmpty() || contraConfirm.isEmpty())
        {
            throw new Exception("Ningun campo puede estar vacio");
        }

        if (!contra.equals(contraConfirm))
        {
            throw new Exception("La contraseña no coincide con contraseña de confirmacion");
        }
        if (contra.length() < 6){
            throw new Exception("La contraseña no puede tener menos de 6 caracteres");
        }

        Pattern patternUsuario = Pattern.compile("^[a-z]+$");
        Matcher matcher = patternUsuario.matcher(usuario);

        if (!matcher.matches())
        {
            throw new Exception("El formato del campo usuario no es valido");
        }


        return true;
    }
    public void mostrarError(String msj)
    {
        JOptionPane.showMessageDialog(null,msj);
    }
}
