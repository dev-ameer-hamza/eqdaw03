package Vistas.Administrador;

import BD.UML.LigaDAO;
import Modelo.Equipo;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.SQLException;


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
    private JMenu jmInicio;


    public JPanel getPruebaPanel() {
        return pruebaPanel;
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
        if (Main.comprobarEstadoLiga().equals("ABIERT0")){
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
                    for (int i=0;i < listaEquipos.size();i++){
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
        jmiModificarJornada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrarPaneles();
                modificarJornada.setVisible(true);
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
                    validarLosCamposDeTexto(tfNombreCrearJugador.getText(),"Nombre");

                    validarLosCamposDeTexto(tfApellidoCrearJugador.getText(),"Apellido");

                    validarLosCamposDeTexto(tfApodoCrearJugador.getText(),"Apodo");

                    validarLosCamposDeTexto(tfRolCrearJugador.getText(),"Rol");

                    Pattern patternSueldo = Pattern.compile("^[0-9]+$");
                    Matcher matcherSueldo = patternSueldo.matcher(tfSueldoCrearJugador.getText().trim());

                    if(!matcherSueldo.matches()){
                        throw new Exception("El sueldo tiene que ser en numeros");
                    }
                    if (Float.parseFloat(tfSueldoCrearJugador.getText()) < SALARIOMINIMO){
                         throw new Exception("El salario tiene que ser mayor que el salario minimo interprofesional que es de " + SALARIOMINIMO + " euros");
                    }
                    Main.crearJugador(
                            tfNombreCrearJugador.getText()
                            ,tfApellidoCrearJugador.getText()
                            ,tfApodoCrearJugador.getText()
                            ,tfRolCrearJugador.getText()
                            ,Float.parseFloat(tfSueldoCrearJugador.getText())
                            ,cbEquipoCrearJugador.getSelectedItem().toString()
                    );
                }
                catch (Exception ex){
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
        /**
         * boton de inicio
         */
        btInicio.addActionListener(new ActionListener() {
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
    public void validarLosCamposDeTexto(String textField,String nombreCampo) throws Exception {
        Pattern patternTexto = Pattern.compile("^[A-Za-z]+$");
        Matcher matcherTexto = patternTexto.matcher(textField);

        if(!matcherTexto.matches()) {
            throw new Exception(nombreCampo + " Invalido!, solo puede tener letras");
        }
    }
}
