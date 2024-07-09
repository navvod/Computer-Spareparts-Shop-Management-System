// DBConnect.java

package computerSpare;

import java.sql.Connection; 
import java.sql.DriverManager;

/**
 * This class provides a connection to the database using JDBC.
 */
public class DBConnect { 
	
    private static String url = "jdbc:mysql://localhost:3306/computerspare";
    private static String userName = "root";
    private static String password = "Dilshara224#";
    private static Connection con;

    /**
     * Establishes a database connection and returns the Connection object.
     * 
     * @return Connection object for the established database connection.
     */
    public static Connection getConnection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish a connection to the database
            con = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            System.out.println("Database connection is not successful!!!");
        }
        return con;
    }
}
