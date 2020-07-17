package inglesfacil;
import java.sql.*;

public class ConnectionDB {
    public static java.sql.Connection conector() {
        java.sql.Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        //String url = "jdbc:mysql://localhost:3306/dbEasyEnglish?autoReconnect=true&useSSL=false";
        String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10355412?autoReconnect=true&useSSL=false";
        // String user = "root";
        //String password = "admin";
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
