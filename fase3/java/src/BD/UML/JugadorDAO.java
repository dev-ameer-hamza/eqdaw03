package BD.UML;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Persona;
import com.company.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        int idPersona = personaDAO.crearPersona(p);
        PreparedStatement pst = conn.prepareStatement("insert into jugador(id_persona,apodo,rol,sueldo,id_equipo) values(?,?,?,?,?)");
        pst.setInt(1,idPersona);
        pst.setString(2,jugador.getApodo());
        pst.setString(3,jugador.getRol());
        pst.setFloat(4,jugador.getSueldo());
        pst.setInt(5,equipo.getIdEquipo());

        int resultado = pst.executeUpdate();
        return resultado == 1;
    }

    public ArrayList<Jugador> todoslosJugador() throws SQLException {

        ArrayList<Jugador>listaJugadores= new ArrayList<>();

        PreparedStatement pst = conn.prepareStatement("select p.nombre, p.apellido, j.apodo, j.sueldo, j.rol,j.id_persona from jugador j, persona p where j.id_persona = p.id_persona");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()){
            Jugador jugador=new Jugador();
            System.out.println("persfghj" + resultSet.getInt("id_persona"));
            jugador.setId_personas(resultSet.getInt("id_persona"));
            jugador.setNombre(resultSet.getString("nombre"));
            jugador.setApellido(resultSet.getString("apellido"));
            jugador.setApodo(resultSet.getString("apodo"));
            jugador.setRol(resultSet.getString("rol"));
            jugador.setSueldo(resultSet.getInt("sueldo"));
            listaJugadores.add(jugador);
        }

        return listaJugadores;
    }

    public boolean borrarJugador(String nombreJugador) throws Exception {
        String[] jug = nombreJugador.split("-");
        Jugador jugador = buscarJugador(Integer.parseInt(jug[0]));
        PreparedStatement pst = conn.prepareStatement("Delete from jugador where id_persona= ?");
        pst.setInt(1, jugador.getId_personas());
        int res = pst.executeUpdate();
        Main.borrarPersona(Integer.parseInt(jug[0]));
        return res == 1;
    }

    public Jugador buscarJugador(int id) throws Exception,SQLException {

        PreparedStatement pst = conn.prepareStatement("select * from jugador where id_persona= ?");
        pst.setInt(1, id);

        ResultSet resultado = pst.executeQuery();

        Jugador jugador=new Jugador();
        System.out.println(resultado.getFetchSize());
        while (resultado.next()){
            System.out.println("persona " + resultado.getInt("id_persona") );
            jugador.setId_personas(resultado.getInt("id_persona"));
            jugador.setApodo(resultado.getString("apodo"));
            jugador.setRol(resultado.getString("rol"));
            jugador.setSueldo(resultado.getInt("sueldo"));
        }

        System.out.println(jugador.getNombre() + jugador.getApodo());
        return jugador;

    }
}
