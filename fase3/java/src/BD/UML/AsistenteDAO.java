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

    public boolean registrarAsistente(Asistente a,int idEquipo) throws SQLException {
        Persona p =a;
        int idPersona = Main.crearPersona(p);
        PreparedStatement pst = conn.prepareStatement("insert into asistente(id_persona,id_equipo) values(?,?)");
        pst.setInt(1,idPersona);
        pst.setInt(2,idEquipo);
        return pst.executeUpdate() == 1;
    }

    public void borrarAsistente(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from asistente where id_equipo=?");
        pst.setInt(1,id);
        pst.executeUpdate();
    }

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

    public Asistente buscarAsistenteConString(String str) throws SQLException {
        String[] jug = str.split("-");
        System.out.println(Integer.parseInt(jug[0]));
        return buscarAsisPorId(Integer.parseInt(jug[0]));
    }

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

    public void modificarAsistente(String str,Asistente en) throws SQLException {
        Asistente old = buscarAsistenteConString(str);
        actualizarAsistente(old.getId_personas(),en);
    }

    public void actualizarAsistente(int id,Asistente d) throws SQLException {
        Main.actualizarPersona(d.getNombre(),d.getApellido(),id);
    }
}
