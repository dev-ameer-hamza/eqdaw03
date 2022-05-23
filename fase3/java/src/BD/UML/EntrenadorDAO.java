package BD.UML;

import Modelo.Dueño;
import Modelo.Entrenador;
import Modelo.Persona;
import com.company.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EntrenadorDAO {
    private Connection conn;

    public EntrenadorDAO(Connection conn){
        this.conn = conn;
    }

    public boolean registrarEntrenador(Entrenador e, int idEquipo) throws SQLException {
        Persona p =e;
        int idPersona = Main.crearPersona(p);
        PreparedStatement pst = conn.prepareStatement("insert into entrenador(id_persona,id_equipo) values(?,?)");
        pst.setInt(1,idPersona);
        pst.setInt(2,idEquipo);
        return pst.executeUpdate() == 1;
    }
    public void borrarEntrenador(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from entrenador where id_equipo=?");
        pst.setInt(1,id);
        pst.executeUpdate();
    }

    public ArrayList<Entrenador> todosEntrenadores() throws SQLException {
        ArrayList<Entrenador> entrenadors = new ArrayList<>();
        PreparedStatement pst = conn.prepareStatement("select p.nombre,p.apellido,d.id_persona from persona p,entrenador d where d.id_persona = p.id_persona");
        ResultSet set = pst.executeQuery();
        while(set.next())
        {
            Entrenador e = new Entrenador();
            e.setId_personas(set.getInt("id_persona"));
            e.setNombre(set.getString("nombre"));
            e.setApellido(set.getString("apellido"));
            entrenadors.add(e);
        }
        return entrenadors;
    }

    public Entrenador buscarEntrenadorConString(String str) throws SQLException {
        String[] jug = str.split("-");
        System.out.println(Integer.parseInt(jug[0]));
        return buscarEntPorId(Integer.parseInt(jug[0]));
    }

    public Entrenador buscarEntPorId(int id) throws SQLException {
        System.out.println("djkhjkljdlñ" + id);
        PreparedStatement pst = conn.prepareStatement("select p.nombre,p.apellido,d.id_persona from persona p,entrenador d where d.id_persona = p.id_persona and d.id_persona=?");
        pst.setInt(1,id);
        ResultSet set = pst.executeQuery();
        Entrenador en = new Entrenador();
        while (set.next())
        {
            en.setId_personas(set.getInt("id_persona"));
            en.setNombre(set.getString("nombre"));
            en.setApellido(set.getString("apellido"));
        }
        return en;
    }

    public void modificarEntrenador(String str,Entrenador en) throws SQLException {
        Entrenador old = buscarEntrenadorConString(str);
        actualizarEntrenador(old.getId_personas(),en);
    }

    public void actualizarEntrenador(int id,Entrenador d) throws SQLException {
        Main.actualizarPersona(d.getNombre(),d.getApellido(),id);
    }
}
