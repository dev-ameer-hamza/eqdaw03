package BD.UML;

import Modelo.Equipo;
import Modelo.Jornada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    public PartidoDAO(Connection conn)
    {
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
        crearCadaEnfrentamiento(listaEquipos,listaJornadas);
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

        /**
         * otro for loop para crear enfrentamientos de cada jornada
         * por ejemplo una jornada con 8 equipos en liga tendra 4 partidos
         */
        for (int jor = 1;jor <= jornadas; jor++)
        {
            for (int par = 0;par < medio;par++)
            {
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
}










