package BD.UML;

import Modelo.Login;

import java.sql.*;
import java.util.ArrayList;

public class LoginDAO {
    private Connection conn;

    /**
     * Creamos el constructor para la class LoginDAO
     * @param conn
     */
    public LoginDAO(Connection conn){
        this.conn = conn;
    }

    /**
     * Creamos un metodo para iniciar la sesion de usuario o admin
     * @param usuario
     * @param pass
     * @return Login
     * @throws SQLException
     */
    public Login inciarSesion(String usuario, String pass)  {
        Login login = new Login();
        try{
            PreparedStatement pst = conn.prepareStatement("select * from login where usuario=? and contrasenya=?");
        pst.setString(1,usuario.trim());
        pst.setString(2,pass);
            ResultSet loginDAO = pst.executeQuery();

            if(loginDAO.next()){
                login.setId_login(loginDAO.getInt("id_login"));
                login.setUsuario(loginDAO.getString("usuario"));
                login.setTipo_persona(loginDAO.getString("tipo"));
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        //loginDAO.close();
        return login;
    }

    /**
     * Creamos el metodo para registrarse una persona (admin o usuario).
     * Solo admiin tiene permisos de crear un usuario o otro admin
     * @param login
     * @return boolean
     */
    public boolean registrarse(Login login) throws SQLException {
        System.out.println(login.getTipo_persona());
        PreparedStatement pst = conn.prepareStatement("insert into login(usuario,contrasenya,tipo) values(?,?,'USER')");
        pst.setString(1,login.getUsuario().trim());
        pst.setString(2,login.getContrasenya().trim());
        //pst.setString(3, login.getTipo_persona());
        int resultado = pst.executeUpdate();
        return resultado == 1;
    }

    /**
     * Creamos un metodo para buscar un usuario con su nombre y nos devuelve un objeto tipo Login
     * @param usuario
     * @return Login
     * @throws SQLException
     */
    public Login buscarUsuario(String usuario) throws SQLException {
        Login login = new Login();
        PreparedStatement pst = conn.prepareStatement("select * from login where usuario=?");
        pst.setString(1,usuario.toLowerCase());
        ResultSet loginDAO = pst.executeQuery();

        while(loginDAO.next()){
            login.setId_login(loginDAO.getInt("id_login"));
            login.setUsuario(loginDAO.getString("usuario"));
            login.setTipo_persona(loginDAO.getString("tipo"));
        }
        return login;
    }

    /**
     * Creamos el metodo para borrar usuarios si existen
     * @param usuario
     * @return boolean
     * @throws Exception
     */
    public boolean borrarUsuario(String usuario) throws Exception {
        Login user = buscarUsuario(usuario);
        if (user.getUsuario().isEmpty()){
            throw new Exception("No puedes borrar el usuario " + usuario + " por que no existe");
        }
        else
        {
            PreparedStatement pstb = conn.prepareStatement("delete from login where id_login=?");
            pstb.setInt(1,user.getId_login());
            int resultado = pstb.executeUpdate();
            return resultado == 1;
        }
    }

    /**
     * Creamos el metodo para modificar los datos del usuario
     * @param login
     * @param usuarioAntiguo
     * @return boolean
     * @throws Exception
     */
    public boolean modificarUsuario(Login login,String usuarioAntiguo) throws Exception {
        Login usuarioExistente = buscarUsuario(usuarioAntiguo);
        if (usuarioExistente.getUsuario().isEmpty()){
            throw new Exception("No puedes modificar el usuario " + usuarioAntiguo + " por que no existe");
        }
        else
        {
            PreparedStatement pstm = conn.prepareStatement("update login set usuario=?,contrasenya=?,tipo=? where id_login=?");
            pstm.setString(1,login.getUsuario());
            pstm.setString(2,login.getContrasenya());
            pstm.setString(3,login.getTipo_persona());
            pstm.setInt(4,login.getId_login());
            int resultado = pstm.executeUpdate();
            return resultado==1;
        }
    }

    public ArrayList<Login> listaUsuarios() throws SQLException {
        ArrayList<Login> usuarios = new ArrayList<>();
        PreparedStatement pst = conn.prepareStatement("select * from login where tipo<>?");
        pst.setString(1,"ADMIN");
        ResultSet set = pst.executeQuery();
        while(set.next())
        {
            Login login = new Login();
            login.setUsuario(set.getString("usuario"));
            usuarios.add(login);
        }
        return usuarios;
    }
}
