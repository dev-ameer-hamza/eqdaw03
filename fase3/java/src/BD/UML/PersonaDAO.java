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
    public Persona crearPersona(Persona p) throws SQLException {
        Persona persona = null;
        PreparedStatement pst = conn.prepareStatement("insert into persona values(?,?)");
        pst.setString(1,p.getNombre());
        pst.setString(2,p.getApellido());

        ResultSet datosPersona = pst.executeQuery();
        while(datosPersona.next())
        {
            persona = new Persona();
            persona.setId_personas(datosPersona.getInt("id_persona"));
            persona.setNombre(datosPersona.getString("nombre"));
            persona.setApellido(datosPersona.getString("apellido"));
        }
        return persona;
    }

    /**
     * Creamos el metodo para borrar una persona
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

    // para consultar personas debemos crear una vista
}
