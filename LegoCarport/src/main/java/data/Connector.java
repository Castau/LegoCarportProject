package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Camilla
 */
public class Connector {
    
    // The connector is made as singletons, so that only one instance can exist
    // at a time, since the state of the object never change.
    
    // make sure to run one of the createscripts found in the SQL_files folder
    private static final String IP = "localhost";
    private static final String PORT = "3306";
    public static final String DATABASE = "lego";
    private static final String USERNAME = "root"; // change to match your workbench username
    private static final String PASSWORD = "1234"; // change to match your workbench password
    
    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if (singleton == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            singleton = DriverManager.getConnection(url, props);
            System.out.println("Connection correctly established to the database: " + DATABASE);
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
                throw new SQLException(ex.getMessage());
            }
        }
        return singleton;
    }

}
