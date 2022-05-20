package BD.UML;

import Modelo.Asistente;
import Modelo.Dueño;
import Modelo.Entrenador;
import Modelo.Equipo;
import com.company.Main;

import java.sql.*;
import java.util.ArrayList;

public class EquipoDAO {
    private Connection conn;

    public EquipoDAO(Connection conn){
        this.conn = conn;
    }

    /**
     * Creamos el metodo para crear los equipos
     * @param equipo objeto de la clase Equipo
     * @return boolean
     * @throws SQLException
     */
    public boolean registrarEquipo(Equipo equipo) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("insert into equipo(nombre_equipo) values(?) ");
        pst.setString(1,equipo.getNombreEquipo());
        int resultado = pst.executeUpdate();
        return resultado == 1;
    }

    /**
     * Creamos el metodo que nos devuelve todos los equipo que hay en base de datos
     * @return ArrayList<Equipo>
     * @throws SQLException
     */
    public ArrayList<Equipo> consultarEquipos() throws SQLException {
        ArrayList<Equipo> listaEquipos = new ArrayList<>();
        Statement consulta = this.conn.createStatement();
        ResultSet set = consulta.executeQuery("select distinct e.*,pa.nombre asistente,pd.nombre dueño,pe.nombre entrenador from  equipo e,duenyo d,entrenador en,asistente a,persona pa,persona pe,persona pd where (e.id_equipo = d.id_equipo and + e.id_equipo = en.id_equipo and e.id_equipo = a.id_equipo(+)) and (en.id_persona = pe.id_persona and a.id_persona = pa.id_persona(+) and d.id_persona = pd.id_persona) order by e.id_equipo");
        while(set.next()){
            Equipo eq = new Equipo();
            eq.setIdEquipo(set.getInt("id_equipo"));
            eq.setNombreEquipo(set.getString("nombre_equipo"));
            eq.setPartidosJugados(set.getInt("partidos_jugados"));
            eq.setPartidosGanados(set.getInt("partidos_ganados"));
            eq.setPartidosPerdidos(set.getInt("partidos_perdidos"));
            eq.setPuntos(set.getInt("puntos"));
            eq.setNombreAsistente(set.getString("asistente"));
            eq.setNombreDuenyo(set.getString("dueño"));
            eq.setNombreEntrenador(set.getString("entrenador"));
            listaEquipos.add(eq);
        }
        return listaEquipos;
    }




    /**
     * Creamos el metodo para actualizar los datos en un equipo
     */
    public boolean actualizarEquipo(Equipo equipo) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("update equipo set nombre_equipo=?,puntos=?,patidos_jugados=?,partidos_ganados=?,partidos_perdidos=?,estado=? where id_equipo=?");

        pst.setString(1,equipo.getNombreEquipo());
        int resultado = pst.executeUpdate();
        return resultado == 1;
    }

    public Equipo buscarEquipo(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("select * from equipo where id_equipo= ?");
        pst.setInt(1,id);
       return datosConsultaEquipo(pst);
    }

    public Equipo buscarEquipoPorNombre(String nombreEquipo) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("select * from equipo where nombre_equipo= ?");
        pst.setString(1,nombreEquipo);
        return datosConsultaEquipo(pst);
    }

    public Equipo datosConsultaEquipo(PreparedStatement pst) throws SQLException {
        Equipo eq = new Equipo();
        ResultSet datoEquipo = pst.executeQuery();
        while(datoEquipo.next()){
            eq.setIdEquipo(datoEquipo.getInt("id_equipo"));
            eq.setNombreEquipo(datoEquipo.getString("nombre_equipo"));
            eq.setPuntos(datoEquipo.getInt("puntos"));
            eq.setPartidosJugados(datoEquipo.getInt("partidos_jugados"));
            eq.setPartidosGanados(datoEquipo.getInt("partidos_ganados"));
            eq.setPartidosPerdidos(datoEquipo.getInt("partidos_perdidos"));
        }
        return eq;
    }

    public int crearEquipo(Equipo eq) throws SQLException {
        int latestEquipo=0;
        if (registrarEquipo(eq)){
            latestEquipo = ultimoEquipo();
        }
        return latestEquipo;
    }

    public int ultimoEquipo() throws SQLException {
        int idEquipo=0;
        PreparedStatement pst = conn.prepareStatement("select max(id_equipo) as maxid from equipo");
        ResultSet set = pst.executeQuery();
        while(set.next()){
            idEquipo = set.getInt("maxid");
        }
        return idEquipo;
    }

    public boolean crearEquipoSinAsistente(Equipo equipo, Dueño dueno, Entrenador entrenador) throws SQLException {
        int idEquipo = crearEquipo(equipo);
        boolean duenoCreado = Main.crearDueno(dueno,idEquipo);
        boolean entrenadorCreado = Main.crearEntrenador(entrenador,idEquipo);
        return duenoCreado && entrenadorCreado;
    }

    public boolean crearEquipoConAsistente(Equipo equipo, Dueño dueno, Entrenador entrenador, Asistente asistente) throws SQLException {
        int idEquipo = crearEquipo(equipo);
        boolean duenoCreado = Main.crearDueno(dueno, idEquipo);
        boolean entrenadorCreado = Main.crearEntrenador(entrenador, idEquipo);
        boolean asistenteCreado = Main.crearAsistente(asistente, idEquipo);
        return duenoCreado && entrenadorCreado && asistenteCreado;
    }

    public boolean borrarEquipo(String equipo) throws SQLException {
        Equipo eq = buscarEquipoPorNombre(equipo);
        borrarJugadoresDeEquipo(eq.getIdEquipo());
        borrarEntrenadoreDeEquipo(eq.getIdEquipo());
        borrarAsistenteDeEquipo(eq.getIdEquipo());
        borrarDuenyoDeEquipo(eq.getIdEquipo());
        PreparedStatement pst = conn.prepareStatement("delete from equipo where id_equipo=?");
        pst.setInt(1,eq.getIdEquipo());
        return pst.executeUpdate() == 1;
    }

    public void borrarJugadoresDeEquipo(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from jugador where id_equipo=?");
        pst.setInt(1,id);
        pst.executeUpdate();
    }
    public void borrarAsistenteDeEquipo(int id) throws SQLException {
        Main.borrarAsistenteDeEquipo(id);
    }
    public void borrarEntrenadoreDeEquipo(int id) throws SQLException {
        Main.borrarEntrenadorDeEquipo(id);
    }
    public void borrarDuenyoDeEquipo(int id) throws SQLException {
        Main.borrarDuenyoDeEquipo(id);
    }


}
