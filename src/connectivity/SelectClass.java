package connectivity;

import java.sql.*;

public class SelectClass {

    public static void selectFiche(String name, String surname) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
        String sql = "SELECT * FROM fiche_medicale WHERE nom='" + name + "' AND prenom='" + surname + "'";
        PreparedStatement prestate = connection.prepareStatement(sql);
        try {
            prestate.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Erreur");
            e.printStackTrace();
            throw e;
        }
    }

    public static void getInformation() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
        String sql = "SELECT * FROM fiche_medicale";
        PreparedStatement prestate = connection.prepareStatement(sql);
        try {
            ResultSet resultSet = prestate.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
