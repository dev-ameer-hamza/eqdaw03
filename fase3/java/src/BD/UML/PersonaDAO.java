package BD.UML;

import Modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {
    private Connection conn;

    /**
     * Creamos el constructor para clase PersonaDAO
     * @param conn
     */
    public PersonaDAO(Connection conn)
    {
        this.conn = conn;
    }

    /**
     * Creamos el metodo para insertar los datos de la persona a la base de datos
     * @param p objeto persona
     * @return ResultSet
     * @throws SQLException
     */
    public int crearPersona(Persona p) throws SQLException {
        int persona=0;
        PreparedStatement pst = conn.prepareStatement("insert into persona(nombre,apellido) values(?,?)");
        pst.setString(1,p.getNombre());
        pst.setString(2,p.getApellido());
        int datosPersona = pst.executeUpdate();
        if (datosPersona == 1){
            persona = ultimaPersona();
        }
        return persona;
    }

    /**l
     * @param id
     * @return boolean
     * @throws SQLException
     */
    public boolean borrarPersona(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from persona where id_persona=?");
        pst.setInt(1,id);
        int resultado = pst.executeUpdate();
        return resultado == 1;
    }

    /**
     * Creamos el metodo para modificar los datos de la persona
     * @param p
     * @param id
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet modificarPersona(Persona p,int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("update persona set nombre=?,apellido=? where id_persona=?");
        pst.setString(1,p.getNombre());
        pst.setString(2,p.getApellido());
        pst.setInt(2,id);
        return pst.executeQuery();
    }

    public int ultimaPersona() throws SQLException {
        int pid=0;
        PreparedStatement pst = conn.prepareStatement("select max(id_persona) as maxi from persona");
        ResultSet set = pst.executeQuery();
        while(set.next()){
            pid = buscarUltimaPersona(set.getInt("maxi"));
        }
        return pid;
    }

    public int buscarUltimaPersona(int id) throws SQLException {
        int pid =0;
        PreparedStatement pst = conn.prepareStatement("select * from persona where id_persona=?");
        pst.setInt(1,id);
        ResultSet set = pst.executeQuery();
        while(set.next()){
            pid = set.getInt("id_persona");
        }
        return pid;
    }

    // para consultar personas debemos crear una vista
}
