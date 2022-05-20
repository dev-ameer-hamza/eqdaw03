package BD.UML;

import Modelo.Dueño;
import Modelo.Persona;
import com.company.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
