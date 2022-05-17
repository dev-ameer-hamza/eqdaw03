package BD.UML;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JugadorDAO {
    private final Connection conn;
    private  EquipoDAO equipoDAO;
    private  PersonaDAO personaDAO;

    public JugadorDAO(Connection conn) {
        this.conn = conn;
        this.equipoDAO = new EquipoDAO(conn);
        this.personaDAO = new PersonaDAO(conn);
    }

    public boolean crearJugador(Jugador jugador,String nombreEquipo) throws SQLException {
        Equipo equipo = equipoDAO.buscarEquipoPorNombre(nombreEquipo);
        Persona p = new Persona(jugador.getNombre(), jugador.getApellido());
        Persona persona = personaDAO.crearPersona(p);

        PreparedStatement pst = conn.prepareStatement("insert into jugador(apodo,rol,sueldo,id_persona,id_equipo) values(?,?,?,?,?)");
        pst.setString(1,jugador.getApodo());
        pst.setString(2,jugador.getRol());
        pst.setFloat(3,jugador.getSueldo());
        pst.setInt(4,persona.getId_personas());
        pst.setInt(5,equipo.getIdEquipo());

        int resultado = pst.executeUpdate();
        return resultado == 1;
    }
}
