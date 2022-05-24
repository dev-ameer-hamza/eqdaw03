package BD.UML;

import Modelo.Asistente;
import Modelo.Entrenador;
import Modelo.Persona;
import com.company.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsistenteDAO {
    private Connection conn;

    public AsistenteDAO(Connection conn){
        this.conn = conn;
    }

    /**
     * Metodo con la sentencia para crear un asistente
     * @param a a
     * @param idEquipo eq
     * @return boolean
     * @throws SQLException sql
     */
    public boolean registrarAsistente(Asistente a,int idEquipo) throws SQLException {
        Persona p =a;
        int idPersona = Main.crearPersona(p);
        PreparedStatement pst = conn.prepareStatement("insert into asistente(id_persona,id_equipo) values(?,?)");
        pst.setInt(1,idPersona);
        pst.setInt(2,idEquipo);
        return pst.executeUpdate() == 1;
    }

    /**
     * Metodo con la sentencia para borrar el asistente
     * @param id id
     * @throws SQLException sql
     */
    public void borrarAsistente(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from asistente where id_equipo=?");
        pst.setInt(1,id);
        pst.executeUpdate();
    }

    /**
     * Te muestra todos los datos del Asistente
     * @return ArrayList
     * @throws SQLException sql
     */
    public ArrayList<Asistente> todosAsistentes() throws SQLException {
        ArrayList<Asistente> entrenadors = new ArrayList<>();
        PreparedStatement pst = conn.prepareStatement("select p.nombre,p.apellido,d.id_persona from persona p,asistente d where d.id_persona = p.id_persona");
        ResultSet set = pst.executeQuery();
        while(set.next())
        {
            Asistente e = new Asistente();
            e.setId_personas(set.getInt("id_persona"));
            e.setNombre(set.getString("nombre"));
            e.setApellido(set.getString("apellido"));
            entrenadors.add(e);
        }
        return entrenadors;
    }

    /**
     * Metodo para sacar los datos del
     * @param str str
     * @return Asistente
     * @throws SQLException sql
     */

    public Asistente buscarAsistenteConString(String str) throws SQLException {
        String[] jug = str.split("-");
        System.out.println(Integer.parseInt(jug[0]));
        return buscarAsisPorId(Integer.parseInt(jug[0]));
    }

    /**
     * Metodo para sacar los datos del asistente atraves del Id
     * @param id id
     * @return Asistente
     * @throws SQLException sql
     */
    public Asistente buscarAsisPorId(int id) throws SQLException {
        System.out.println("djkhjkljdlñ" + id);
        PreparedStatement pst = conn.prepareStatement("select p.nombre,p.apellido,d.id_persona from persona p,asistente d where d.id_persona = p.id_persona and d.id_persona=?");
        pst.setInt(1,id);
        ResultSet set = pst.executeQuery();
        Asistente en = new Asistente();
        while (set.next())
        {
            en.setId_personas(set.getInt("id_persona"));
            en.setNombre(set.getString("nombre"));
            en.setApellido(set.getString("apellido"));
        }
        return en;
    }

    /**
     * Metodo para modificar el asistente
     * @param str str
     * @param en en
     * @throws SQLException sql
     */
    public void modificarAsistente(String str,Asistente en) throws SQLException {
        Asistente old = buscarAsistenteConString(str);
        actualizarAsistente(old.getId_personas(),en);
    }

    /**
     * Metodo para actualizar el asistente
     * @param id id
     * @param d d
     * @throws SQLException sql
     */

    public void actualizarAsistente(int id,Asistente d) throws SQLException {
        Main.actualizarPersona(d.getNombre(),d.getApellido(),id);
    }
}
