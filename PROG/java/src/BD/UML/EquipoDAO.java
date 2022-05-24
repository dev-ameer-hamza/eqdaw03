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

    /**
     *  Metodo para sacar los datos de un equipo atraves de una sentecia
     * @param id id
     * @return Equipo
     * @throws SQLException
     */
    public Equipo buscarEquipo(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("select * from equipo where id_equipo= ?");
        pst.setInt(1,id);
       return datosConsultaEquipo(pst);
    }

    /**
     * Metodo con la sentencia para buscar los datos de un equipo
     * @param nombreEquipo equipo
     * @return Equipo
     * @throws SQLException
     */
    public Equipo buscarEquipoPorNombre(String nombreEquipo) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("select * from equipo where nombre_equipo= ?");
        pst.setString(1,nombreEquipo);
        return datosConsultaEquipo(pst);
    }

    /**
     * Metodo con la sentencia para consultar los datos del equipo
     * @param pst pst
     * @return Equipo
     * @throws SQLException
     */
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

    /**
     * Metodo con una sentencia para crear un equipo
     * @param eq eq
     * @return int
     * @throws SQLException
     */
    public int crearEquipo(Equipo eq) throws SQLException {
        int latestEquipo=0;
        if (registrarEquipo(eq)){
            latestEquipo = ultimoEquipo();
        }
        return latestEquipo;
    }

    /**
     * Metodo con una sentencia para sacar los datos del ultimo equipo
     * @return int
     * @throws SQLException
     */
    public int ultimoEquipo() throws SQLException {
        int idEquipo=0;
        PreparedStatement pst = conn.prepareStatement("select max(id_equipo) as maxid from equipo");
        ResultSet set = pst.executeQuery();
        while(set.next()){
            idEquipo = set.getInt("maxid");
        }
        return idEquipo;
    }

    /**
     * Metodo que llama a distintos metodos para crear un equipo sin asistente
     * @param equipo equipo
     * @param dueno dueño
     * @param entrenador entrenador
     * @return
     * @throws SQLException
     */
    public boolean crearEquipoSinAsistente(Equipo equipo, Dueño dueno, Entrenador entrenador) throws SQLException {
        int idEquipo = crearEquipo(equipo);
        boolean duenoCreado = Main.crearDueno(dueno,idEquipo);
        boolean entrenadorCreado = Main.crearEntrenador(entrenador,idEquipo);
        return duenoCreado && entrenadorCreado;
    }

    /**
     * Metodo que llama a distintos metodos para crear un equipo asistente
     * @param equipo eq
     * @param dueno dueño
     * @param entrenador entrenador
     * @param asistente asistente
     * @return boolean
     * @throws SQLException
     */
    public boolean crearEquipoConAsistente(Equipo equipo, Dueño dueno, Entrenador entrenador, Asistente asistente) throws SQLException {
        int idEquipo = crearEquipo(equipo);
        boolean duenoCreado = Main.crearDueno(dueno, idEquipo);
        boolean entrenadorCreado = Main.crearEntrenador(entrenador, idEquipo);
        boolean asistenteCreado = Main.crearAsistente(asistente, idEquipo);
        return duenoCreado && entrenadorCreado && asistenteCreado;
    }

    /**
     * Metodo con una sentencia para borrar los equipo al borrar el equipo
     * @param equipo eq
     * @return boolean
     * @throws SQLException
     */
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

    /**
     * Metodo con sentencia para borrar los jugadores de un equipo al borrar el equipo
     * @param id id
     * @throws SQLException
     */
    public void borrarJugadoresDeEquipo(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("delete from jugador where id_equipo=?");
        pst.setInt(1,id);
        pst.executeUpdate();
    }

    /**
     * Metodo con sentencia para borrar los asistentes de un equipo al borrar el equipo
     * @param id id
     * @throws SQLException
     */

    public void borrarAsistenteDeEquipo(int id) throws SQLException {
        Main.borrarAsistenteDeEquipo(id);
    }

    /**
     * Metodo con sentencia para borrar el entrenador de un equipo al borrar el equipo
     * @param id id
     * @throws SQLException
     */
    public void borrarEntrenadoreDeEquipo(int id) throws SQLException {
        Main.borrarEntrenadorDeEquipo(id);
    }

    /**
     * Metodo con sentencia para borrar el dueño del equipo al borrar el equipo
     * @param id id
     * @throws SQLException
     */


    public void borrarDuenyoDeEquipo(int id) throws SQLException {
        Main.borrarDuenyoDeEquipo(id);
    }

    /**
     * Metodo para sacar los datos del equipo
     * @return ResultSet
     * @throws SQLException
     */
    public ResultSet detalleEquipos() throws SQLException {
        PreparedStatement pst = conn.prepareStatement("select distinct e.nombre_equipo,pa.nombre \"nombre asistente\",pd.nombre \"nombre dueno\",pe.nombre \"nombre entrenador\" from \n" +
                "equipo e,duenyo d,entrenador en,asistente a,persona pa,persona pe,persona pd\n" +
                "where (\n" +
                "e.id_equipo = d.id_equipo\n" +
                "and\n" +
                "e.id_equipo = en.id_equipo\n" +
                "and \n" +
                "e.id_equipo = a.id_equipo(+)\n" +
                ")\n" +
                "and (\n" +
                "en.id_persona = pe.id_persona\n" +
                "and \n" +
                "a.id_persona = pa.id_persona(+)\n" +
                "and\n" +
                "d.id_persona = pd.id_persona\n" +
                ")");
        return pst.executeQuery();
    }

    /**
     * Metodo con sentencia para modificar los equipos
     * @param nA na
     * @param nN nn
     * @return
     * @throws SQLException
     */
    public boolean modificarEquipo(String nA,String nN) throws SQLException {
        Equipo eq = buscarEquipoPorNombre(nA);
        PreparedStatement pst = conn.prepareStatement("update equipo set nombre_equipo=? where id_equipo=?");
        pst.setString(1,nN);
        pst.setInt(2,eq.getIdEquipo());
        return pst.executeUpdate() == 1;
    }

    /**
     * el metodo para añadir clasificacion del equipo ganado
     * @param ide ide
     * @throws SQLException
     */
    public void addClasificacionEquipoGanado(int ide) throws SQLException {
        Equipo e = buscarEquipo(ide);
        System.out.println("equipo ganado");
        PreparedStatement pst = conn.prepareStatement("update equipo set puntos=?,partidos_jugados=?,partidos_ganados=? where id_equipo=?");
        pst.setInt(1,e.getPuntos() + 2);
        pst.setInt(2,e.getPartidosJugados() + 1);
        pst.setInt(3,e.getPartidosGanados() + 1);
        pst.setInt(4,ide);
        pst.executeUpdate();
    }

    /**
     * el metodo para añadir la clasificacion del equipo perdido
     * @param ide ide
     * @throws SQLException
     */
    public void addClasificacionEquipoPerdido(int ide) throws SQLException {
        Equipo e = buscarEquipo(ide);
        System.out.println("equipo perdido");

        PreparedStatement pst = conn.prepareStatement("update equipo set partidos_jugados=?,partidos_perdidos=? where id_equipo=?");
        pst.setInt(1,e.getPartidosJugados() + 1);
        pst.setInt(2,e.getPartidosPerdidos() + 1);
        pst.setInt(3,ide);
        pst.executeUpdate();
    }

}
