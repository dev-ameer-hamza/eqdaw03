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


    /**
     * Metodo con la sentencia para crear los jugadores
     * @param jugador
     * @param nombreEquipo
     * @return boolean
     * @throws SQLException
     */

    public boolean crearJugador(Jugador jugador,String nombreEquipo) throws SQLException {
        Equipo equipo = equipoDAO.buscarEquipoPorNombre(nombreEquipo);
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

    /**
     * Metodo para sacar los datos de todos los jugadores
     * @return ArrayList<Jugador>
     * @throws SQLException
     */

    public ArrayList<Jugador> todoslosJugador() throws SQLException {

        ArrayList<Jugador>listaJugadores= new ArrayList<>();

        PreparedStatement pst = conn.prepareStatement("select p.nombre, p.apellido, j.apodo, j.sueldo, j.rol,j.id_persona, e.nombre_equipo from jugador j, persona p, equipo e where j.id_persona = p.id_persona and j.id_equipo = e.id_equipo");
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
            jugador.setNombreEquipo(resultSet.getString("nombre_equipo"));
            listaJugadores.add(jugador);
        }

        return listaJugadores;
    }

    /**
     * Metodo con la sentencia para borrar todas los jugadores
     * @param nombreJugador
     * @return boolean
     * @throws Exception
     */

    public boolean borrarJugador(String nombreJugador) throws Exception {
        String[] jug = nombreJugador.split("-");
        Jugador jugador = buscarJugador(Integer.parseInt(jug[0]));
        PreparedStatement pst = conn.prepareStatement("Delete from jugador where id_persona= ?");
        pst.setInt(1, jugador.getId_personas());
        int res = pst.executeUpdate();
        Main.borrarPersona(Integer.parseInt(jug[0]));
        return res == 1;
    }

    /**
     * Metodo con la sentencia para buscar un jugador
     * @param id
     * @return jugador
     * @throws Exception
     * @throws SQLException
     */
    public Jugador buscarJugador(int id) throws Exception,SQLException {

        PreparedStatement pst = conn.prepareStatement("select * from jugador where id_persona= ?");
        pst.setInt(1, id);

        ResultSet resultado = pst.executeQuery();

        Jugador jugador=new Jugador();
        while (resultado.next()){
            jugador.setId_personas(resultado.getInt("id_persona"));
            jugador.setApodo(resultado.getString("apodo"));
            jugador.setRol(resultado.getString("rol"));
            jugador.setSueldo(resultado.getInt("sueldo"));
        }

        return jugador;

    }

    /**
     * Metodo para buscar un jugador por atraves del nombre
     * @param juga
     * @return jugador
     * @throws Exception
     * @throws SQLException
     */
    public Jugador buscarJugadorPorNombre(String juga) throws Exception,SQLException {
        String[] jug = juga.split("-");
        Jugador j = buscarJugador(Integer.parseInt(jug[0]));
        PreparedStatement pst = conn.prepareStatement("select p.nombre,p.apellido,j.apodo,j.rol,j.sueldo from jugador j,persona p where j.id_persona= ? and j.id_persona=p.id_persona");
        pst.setInt(1, j.getId_personas());

        ResultSet resultado = pst.executeQuery();

        Jugador jugador=new Jugador();
        while (resultado.next()){
            jugador.setNombre(resultado.getString("nombre"));
            jugador.setApellido(resultado.getString("apellido"));
            jugador.setApodo(resultado.getString("apodo"));
            jugador.setRol(resultado.getString("rol"));
            jugador.setSueldo(resultado.getInt("sueldo"));
        }
        return jugador;

    }

    /**
     * Metodo para buscar los jugadores por el Id
     * @param id
     * @return Jugador
     * @throws Exception
     * @throws SQLException
     */
    public Jugador buscarJugadorPorId(int id) throws Exception,SQLException {

        PreparedStatement pst = conn.prepareStatement("select j.id_persona,p.nombre,p.apellido,j.apodo,j.rol,j.sueldo from jugador j,persona p where j.id_persona= ? and j.id_persona=p.id_persona");
        pst.setInt(1, id);

        ResultSet resultado = pst.executeQuery();

        Jugador jugador=new Jugador();
        while (resultado.next()){
            jugador.setId_personas(resultado.getInt("id_persona"));
            jugador.setNombre(resultado.getString("nombre"));
            jugador.setApellido(resultado.getString("apellido"));
            jugador.setApodo(resultado.getString("apodo"));
            jugador.setRol(resultado.getString("rol"));
            jugador.setSueldo(resultado.getInt("sueldo"));
        }
        return jugador;

    }

    /**
     * Metodo con la sentencia para poder modificar los jugadores
     * @param j
     * @param ju
     * @return boolean
     * @throws Exception
     */
    public boolean modificarJugador(String j,Jugador ju) throws Exception {
        String[] jug = j.split("-");
        Jugador jugador = buscarJugadorPorId(Integer.parseInt(jug[0]));
        return actualizarDatosJugador(jugador.getId_personas(),ju);
    }

    /**
     * Metodo para poder actualizar los datos de los jugadores
     * @param id
     * @param jugador
     * @return boolean
     * @throws SQLException
     */

    public boolean actualizarDatosJugador(int id,Jugador jugador) throws SQLException {
        Main.actualizarPersona(jugador.getNombre(),jugador.getApellido(), id);
        PreparedStatement pst = conn.prepareStatement("update jugador set apodo=?,rol=?,sueldo=? where id_persona=?" );
        pst.setString(1,jugador.getApodo());
        pst.setString(2,jugador.getRol());
        System.out.println((int) jugador.getSueldo());
        pst.setFloat(3, (jugador.getSueldo()));
        pst.setInt(4,id);
        return pst.executeUpdate() == 1;
    }
}
