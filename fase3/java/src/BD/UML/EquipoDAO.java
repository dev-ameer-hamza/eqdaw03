package BD.UML;

import Modelo.Equipo;

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
        ResultSet set = consulta.executeQuery("select * from equipo");
        while(set.next()){
            Equipo eq = new Equipo();
            eq.setIdEquipo(set.getInt("id_equipo"));
            eq.setNombreEquipo(set.getString("nombre_equipo"));
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

    public boolean crearEquipoSinAsistente(){return false;}

    public boolean crearEquipoConAsistente(){return false;}

}
