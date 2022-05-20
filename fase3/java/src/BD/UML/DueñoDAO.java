package BD.UML;

import Modelo.Dueño;
import Modelo.Jugador;
import Modelo.Persona;
import com.company.Main;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DueñoDAO {
    private Connection conn;

    public DueñoDAO(Connection conn){
        this.conn = conn;
    }

    public boolean registrarDueño(Dueño d, int idEquipo) throws SQLException {
        Persona p =d;
        int idPersona = Main.crearPersona(p);
        PreparedStatement pst = conn.prepareStatement("insert into duenyo(id_persona,id_equipo) values(?,?)");
        pst.setInt(1,idPersona);
        pst.setInt(2,idEquipo);
        return pst.executeUpdate() == 1;
    }

    public void borrarDuenyo(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from duenyo where id_equipo=?");
        pst.setInt(1,id);
        pst.executeUpdate();
    }

    public ArrayList<Dueño> todosDueños() throws SQLException {
        ArrayList<Dueño> dueños = new ArrayList<>();
        PreparedStatement pst = conn.prepareStatement("select d.id_persona,p.nombre,p.apellido from persona p,duenyo d where p.id_persona = d.id_persona");
        ResultSet set = pst.executeQuery();
        while(set.next())
        {
            Dueño d = new Dueño();
            d.setId_personas(set.getInt("id_persona"));
            d.setNombre(set.getString("nombre"));
            d.setApellido(set.getString("apellido"));
            dueños.add(d);
        }
        return dueños;
    }

    public Dueño buscarDueñoConString(String str) throws SQLException {
        String[] jug = str.split("-");
        return buscarDueñoPorId(Integer.parseInt(jug[0]));
    }
    public Dueño buscarDueñoPorId(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("select p.nombre,p.apellido,d.id_persona from persona p,duenyo d where d.id_persona = p.id_persona and d.id_persona=?");
        pst.setInt(1,id);
        ResultSet set = pst.executeQuery();
        Dueño dd = new Dueño();
        while (set.next())
        {
            dd.setId_personas(set.getInt("id_persona"));
            dd.setNombre(set.getString("nombre"));
            dd.setApellido(set.getString("apellido"));
        }
        return dd;
    }

    public  void modificarDueño(String str,Dueño newD) throws SQLException {
        Dueño old = buscarDueñoConString(str);
         actualizarDueño(old.getId_personas(),newD);
    }

    public void actualizarDueño(int id,Dueño d) throws SQLException {
        Main.actualizarPersona(d.getNombre(),d.getApellido(),id);
    }
}
