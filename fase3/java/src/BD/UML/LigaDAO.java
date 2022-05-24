package BD.UML;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LigaDAO {
    private Connection conn;

    public LigaDAO(Connection conn){
        this.conn = conn;
    }

    /**
     * Metodo con la sentencia para consultar el estado de la liga
     * @return estado
     * @throws SQLException
     */

    public String consultarEstado() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet set = st.executeQuery("select * from liga");
        String estado = "";
        while(set.next()){
            estado = set.getString("estado");
        }
        return estado;
    }

    /**
     * Metodo con la consulta que te permite cambiar el estado de la liga
     * @throws SQLException
     */


    public void cambiarEstado() throws SQLException{
        Statement st = conn.createStatement();
        st.executeUpdate("update liga set estado = 'CERRADO'");

    }
}
