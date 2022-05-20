package BD.UML;

import Modelo.Entrenador;
import Modelo.Persona;
import com.company.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
