package connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteClass {

    public static void deleteFichePatient(String name, String surname) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
        String sql = "DELETE FROM fiche_medicale WHERE nom='" + name + "' AND prenom='" + surname + "'";
        PreparedStatement prestate = connection.prepareStatement(sql);
        try {
            prestate.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("Erreur");
            e.printStackTrace();
            throw e;
        }
    }
}
