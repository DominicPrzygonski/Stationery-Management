package za.ac.cput.dominicPrzygonski.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dominic Przygonski
 */
public class DBConnection {
    
    //Provides a connection to the database
    public static Connection derbyConnection() throws SQLException{
        String url = "jdbc:derby://localhost:1527/Stationery Database";
        String user = "Administrator";
        String password = "Password";
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }
    
}
