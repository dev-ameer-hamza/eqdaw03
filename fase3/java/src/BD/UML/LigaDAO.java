package BD.UML;

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
}
