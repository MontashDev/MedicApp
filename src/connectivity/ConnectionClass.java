package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {

    public static Connection conDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}