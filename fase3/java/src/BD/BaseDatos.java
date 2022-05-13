package BD;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDatos {
    //Parametros de conexion
    private String user = "daw04";
    private String password = "daw04";
    private String url = "jdbc:oracle:thin:@172.20.225.114:1521:orcl";

    private Connection connection;

    public BaseDatos() throws Exception{
        //obtenemos el driver para mysql
        Class.forName("oracle.jdbc.OracleDriver");

        //obtenemos la conexión
        connection = DriverManager.getConnection(url,user,password);

        if (connection==null){
            throw new Exception("Problemas con la conexión");
        }
    }


    public Connection getConnection(){
        return connection;
    }

    public void desconectar() throws Exception{
        connection.close();
    }
}
