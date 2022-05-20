package BD.UML;

import Modelo.Asistente;
import Modelo.Persona;
import com.company.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
