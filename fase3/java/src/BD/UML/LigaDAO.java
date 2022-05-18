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

    public String consultarEstado() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet set = st.executeQuery("select * from liga");
        String estado = "";
        while(set.next()){
            estado = set.getString("estado");
        }
        return estado;
    }
    public void cambiarEstado() throws SQLException{
        Statement st = conn.createStatement();
        if (consultarEstado().equals("ABIERTO")){
            st.executeUpdate("update liga set estado = 'CERRADO'");
        } else{
            st.executeUpdate("update liga set estado = 'ABIERTO'");
        }
    }
}
