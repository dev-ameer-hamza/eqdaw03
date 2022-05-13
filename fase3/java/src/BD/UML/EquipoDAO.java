package BD.UML;

import Modelo.Equipo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EquipoDAO {
    private Connection conn;

    public EquipoDAO(Connection conn){
        this.conn = conn;
    }

    public void registrarEquipo(){}

    public ArrayList<Equipo> consultarEquipos() throws SQLException {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        Statement consulta = this.conn.createStatement();
        ResultSet set = consulta.executeQuery("select * from equipo");
        while(set.next()){
            Equipo eq = new Equipo();
            eq.setIdEquipo(set.getInt("id_equipo"));
            eq.setNombreEquipo(set.getString("nombre_equipo"));
            listaEquipos.add(eq);
        }
        return listaEquipos;
    }
}
