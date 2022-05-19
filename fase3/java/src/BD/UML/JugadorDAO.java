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
        System.out.println("Equipo buscado " + equipo.getNombreEquipo());
        Persona p = new Persona(jugador.getNombre(), jugador.getApellido());
        Persona persona = personaDAO.crearPersona(p);
        System.out.println("Persona creada " + p.getNombre());
        PreparedStatement pst = conn.prepareStatement("insert into jugador(id_persona,apodo,rol,sueldo,id_equipo) values(?,?,?,?,?)");
        pst.setInt(1,jugador.getId_personas());
        pst.setString(2,jugador.getApodo());
        pst.setString(3,jugador.getRol());
        pst.setFloat(4,jugador.getSueldo());
        pst.setInt(5,equipo.getIdEquipo());

        int resultado = pst.executeUpdate();
        return resultado == 1;
    }
}
