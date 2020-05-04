package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {

    protected Connection connection;

    public Connection getConnection() throws SQLException {
        final String connectionString = "jdbc:mysql://localhost/cabinet_medical";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(InsertClass.class.getName()).log(Level.SEVERE, null, e);
        }
        connection = DriverManager.getConnection(connectionString, "root", "");
        return connection;
    }
}
