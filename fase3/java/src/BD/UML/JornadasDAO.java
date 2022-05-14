package BD.UML;

import Modelo.Equipo;
import Modelo.Jornada;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JornadasDAO {
    private Connection conn;

    /**
     * Creamos el constructor para JornadaDAO
     * @param conn
     */
    public JornadasDAO(Connection conn){
        this.conn = conn;
    }

    /**
     * Creamos el metodo para crear jornadas segun la cantidad de equipos
     * @throws Exception
     * @throws SQLException
     */
    public void crearJornadas() throws Exception,SQLException {
        EquipoDAO equipoDAO = new EquipoDAO(this.conn);
        ArrayList<Equipo> listEquipos = equipoDAO.consultarEquipos();
        if (listEquipos.size() < 1)
        {
            throw new Exception("No hay equipos para crear jornadas");
        }

        for(int i = 0; i < listEquipos.size() - 1; i++)
        {
            boolean resultadoJornada = crearCadaJornada(i);
            if (!resultadoJornada){ throw new Exception("Error, creando las jornadas");}
        }
    }

    public boolean crearCadaJornada(int dia) throws SQLException {
        PreparedStatement pstj = conn.prepareStatement("insert into jornada values(?)");
        pstj.setDate(1, Date.valueOf(LocalDate.now().plusDays(dia)));
        int resultado = pstj.executeUpdate();
        return resultado == 1;
    }

    public ArrayList<Jornada> listaJornadas() throws SQLException {
        ArrayList<Jornada> listaJornada = new ArrayList<>();
        PreparedStatement pstjl = conn.prepareStatement("select * from jornadas");
        ResultSet datosJornadas = pstjl.executeQuery();
        while(datosJornadas.next())
        {
            Jornada jornada = new Jornada(datosJornadas.getInt("id_jornada"),datosJornadas.getDate("fecha").toLocalDate());
            listaJornada.add(jornada);
        }
        return listaJornada;
    }
}
