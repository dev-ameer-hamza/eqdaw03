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
     * @param conn conn
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
     * @param id id
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
     * @param p p
     * @param id id
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

    /**
     * Metodo con la sentencia para poder sacar la ultima persona
     * @return int
     * @throws SQLException
     */
    public int ultimaPersona() throws SQLException {
        int pid=0;
        PreparedStatement pst = conn.prepareStatement("select max(id_persona) as maxi from persona");
        ResultSet set = pst.executeQuery();
        while(set.next()){
            pid = buscarUltimaPersona(set.getInt("maxi"));
        }
        return pid;
    }

    /**
     *  Metodo con la sentencia para buscar la ultima persona
     * @param id id
     * @return int
     * @throws SQLException
     */
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

    /**
     * Metodo con la consulta para poder actualizar los datos de persona
     * @param nom nom
     * @param apell apel
     * @param id id
     * @throws SQLException
     */

    public void actualizaPersona(String nom,String apell,int id) throws SQLException {
        System.out.println(id + nom + apell);
        PreparedStatement pst = conn.prepareStatement("update persona set nombre=?,apellido=? where id_persona=?");
        pst.setString(1,nom);
        pst.setString(2,apell);
        pst.setInt(3,id);
        if(pst.executeUpdate() == 1){
            System.out.println("persona actualizada");
        }
        else
        {
            System.out.println("error con persona");
        }
    }

    // para consultar personas debemos crear una vista
}
