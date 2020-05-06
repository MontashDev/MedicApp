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

    public static String selectCertifDispense(String name, String surname) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "SELECT nom,prenom FROM dossier_medical WHERE nom=? AND prenom=?";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, name, Types.VARCHAR);
            prestate.setObject(2, surname, Types.VARCHAR);
            ResultSet rs = prestate.executeQuery(sql);
            String fullName = " ";
            while (rs.next()) {
                fullName = rs.getString(1) + " " + rs.getString(2);
            }
            System.out.println(fullName);
            return fullName;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
