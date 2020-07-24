package inglesfacil;
import java.sql.*;

/**
 * Establishes connection to database
 * @author Daniel Suzumura
 * @author Mateus Zanetti Camargo Penteado
 */
public class ConnectionDB {
    public static java.sql.Connection conector() {
        java.sql.Connection connection = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10355412?autoReconnect=true&useSSL=false";
        String user = "sql10355412";
        String password = "SxVnnnZTWt";
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
