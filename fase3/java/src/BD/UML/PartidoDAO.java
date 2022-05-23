package BD.UML;

import Modelo.Equipo;
import Modelo.Jornada;
import Modelo.Partido;
import com.company.Main;

import java.sql.*;
import java.util.ArrayList;

public class PartidoDAO {
    private Connection conn;
    private JornadasDAO jornadasDAO;
    private EquipoDAO equipoDAO;
    private ArrayList<Equipo> listaEquipos;
    private ArrayList<Jornada> listaJornadas;

    /**
     * Creamos el constructor para JornadaDAO
     * @param conn
     */
    public PartidoDAO(Connection conn) throws SQLException {
        this.conn = conn;
        this.equipoDAO = new EquipoDAO(this.conn);
        this.jornadasDAO = new JornadasDAO(this.conn);
    }

    /**
     * Creamos el metodo  para crear los enfrentamientos
     * @throws Exception
     */
    public void crearEnfrentamientos() throws Exception {
        this.jornadasDAO.crearJornadas();
        listaEquipos = equipoDAO.consultarEquipos();
        listaJornadas = jornadasDAO.listaJornadas();
        System.out.println("lista jornadas " + listaJornadas.size());
        crearCadaEnfrentamiento(listaEquipos,listaJornadas);
        Main.cambiarEstadoLiga();
    }

    /**
     * Creamos el metodo para crear partidos de cada jornada
     * pasandole dos listas de equipos y jornadas que ya existen en base de datos
     * @param listaEquipos
     * @param listaJornadas
     * @throws Exception
     */
    public void crearCadaEnfrentamiento(ArrayList<Equipo> listaEquipos,ArrayList<Jornada> listaJornadas) throws Exception {
        if (listaEquipos.size() <= 0){throw new Exception("No hay equipos para crear enfrentamientos");}
        int equipos = listaEquipos.size();
        int jornadas = listaJornadas.size();
        int medio = equipos / 2;

        int[] ciclo = new int[equipos];

        /**
         * un for loop para crear una lista con los ids de los equipo
         * por ejemplo una lista de 8 equipos sera asi
         * [1,2,3,4,8,7,6,5]
         */
        for (int i = 0; i < medio; i++)
        {
            ciclo[i] = listaEquipos.get(i).getIdEquipo();
            ciclo[equipos - i - 1] = ciclo[i] + medio;
        }
        System.out.println("ids equipos -: " + ciclo.length);
        /**
         * otro for loop para crear enfrentamientos de cada jornada
         * por ejemplo una jornada con 8 equipos en liga tendra 4 partidos
         */
        for (int jor = 0;jor < jornadas; jor++)
        {
            for (int par = 0;par < medio;par++)
            {
                System.out.println("Jornada -: " + listaJornadas.get(jor).getId_jornada() + " Equipo Local -: " + ciclo[par] + " Equipo Visitante -: " +ciclo[equipos - par - 1] );
                crearPartido(listaJornadas.get(jor).getId_jornada(),ciclo[par],ciclo[equipos - par - 1]);
            }
            int temp = ciclo[1]; // esta variable tiene id_equipo que esta en la posicion 2

            /**
             * un loop para actualizar la posicion de los equipos dentro de la lista ciclo
             */
            for (int mod = 1; mod < jornadas; mod++)
            {
                int equipo = ciclo[mod + 1];
                ciclo[mod + 1] = temp;
                temp = equipo;
            }
            ciclo[1] = temp;
        }
    }

    /**
     * Creamos el metodo para crear y guardar un partido en base de datos segun su jornada
     * @param idJornada
     * @param equipoLocal
     * @param equipoVisitante
     * @throws Exception
     * @throws SQLException
     */
    public void crearPartido(int idJornada,int equipoLocal,int equipoVisitante) throws Exception,SQLException {
        System.out.println("equipo local - " + equipoLocal + " equipo visitante - " + equipoVisitante + " jornada - " + idJornada);
        PreparedStatement pst = conn.prepareStatement("insert into partido(id_jornada,id_equipo1,id_equipo2) values(?,?,?)");
        pst.setInt(1,idJornada);
        pst.setInt(2,equipoLocal);
        pst.setInt(3,equipoVisitante);
        int resultado = pst.executeUpdate();
        if (resultado != 1){ throw new Exception("Error, no se puede crear el partido");}
    }


    /**
     * Metodo con la sentencia para poder consultar los partidos
     * @return
     * @throws SQLException
     */


    public ArrayList<Partido> consultarPartidos() throws SQLException {
        ArrayList<Partido> listaPartidos = new ArrayList<>();
        Statement consulta = this.conn.createStatement();
        ResultSet set = consulta.executeQuery("select p.id_partido, e1.nombre_equipo equipo1, e2.nombre_equipo equipo2, eg.nombre_equipo equipoGanador from partido p, equipo e1, equipo e2, equipo eg where ( p.id_equipo1 = e1.id_equipo and p.id_equipo2 = e2.id_equipo and p.equipo_ganador = eg.id_equipo(+) ) and (id_jornada = (select max(id_jornada) from jornada))");
        while(set.next()){
            Partido eq = new Partido();
            eq.setId_partido(set.getInt("id_partido"));
            eq.setEquipo1(set.getString("equipo1"));
            eq.setEquipo2(set.getString("equipo2"));
            eq.setEquipo_ganador(set.getString("equipoGanador"));

            listaPartidos.add(eq);
        }
        return listaPartidos;
    }

    public ArrayList<Partido> listaPartidos(int jornada) throws SQLException {
        ArrayList<Partido> partidoArrayList = new ArrayList<>();
        CallableStatement cst = conn.prepareCall("{call todospartidos(?,?)}");
        cst.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
        cst.setInt(2,jornada);
        ResultSet set = cst.executeQuery();

        while(set.next()){
            Partido p = new Partido();
            p.setId_partido(set.getInt("id_partido"));
            p.setEquipo1(set.getString("equipo_local"));
            p.setEquipo2(set.getString("equipo_visitante"));
            p.setEquipo_ganador(set.getString("equipo_ganador"));
            partidoArrayList.add(p);

        }
        return partidoArrayList;
    }

}










