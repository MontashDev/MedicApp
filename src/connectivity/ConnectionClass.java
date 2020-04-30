package connectivity;

import Controllers.ControllerFiche;
import com.mysql.cj.protocol.Resultset;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionClass {
    protected Connection connection;

    public Connection getConnection() throws SQLException {
        final String connectionString = "jdbc:mysql://localhost/cabinet_medical";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, e);
        }
        connection = DriverManager.getConnection(connectionString, "root", "");
        return connection;
    }

    public static void insertUser(String pseudo, String password, Byte role) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO utilisateur (pseudo,password,role) VALUES(?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, pseudo, Types.VARCHAR);
            prestate.setObject(2, password, Types.VARCHAR);
            prestate.setObject(3, role, Types.TINYINT);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertMedical(String carteID, String secuNum, String nom, String prenom, Date age, String adresse, String telNum, String prescriptionNum, String examNum, String profession, String validite, String bilanRadio, String bilanBio) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO dossier_medical (idCarte,secuNum,nom,prenom,age,adresse,telNum,prescriptionNum,examNum,profession,validite,bilanRadio,bilanBio) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, carteID, Types.INTEGER);
            prestate.setObject(2, secuNum, Types.INTEGER);
            prestate.setObject(3, nom, Types.VARCHAR);
            prestate.setObject(4, prenom, Types.VARCHAR);
            prestate.setObject(5, age, Types.DATE);
            prestate.setObject(6, adresse, Types.VARCHAR);
            prestate.setObject(7, telNum, Types.INTEGER);
            prestate.setObject(8, prescriptionNum, Types.INTEGER);
            prestate.setObject(9, examNum, Types.INTEGER);
            prestate.setObject(10, profession, Types.VARCHAR);
            prestate.setObject(11, validite, Types.BOOLEAN);
            prestate.setObject(12, bilanRadio, Types.TINYINT);
            prestate.setObject(13, bilanBio, Types.TINYINT);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertAppointment(String name, String surname, String reason, Date date) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO rendez_vous (nomPatient, prenomPatient, raison, date) VALUES(?,?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, name, Types.VARCHAR);
            prestate.setObject(2, surname, Types.VARCHAR);
            prestate.setObject(3, reason, Types.VARCHAR);
            prestate.setObject(4, date, Types.DATE);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertPrescription(String medicName, String dose, Date period) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO ordonnance (medicNom, dose, periode) VALUES(?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, medicName, Types.VARCHAR);
            prestate.setObject(2, dose, Types.INTEGER);
            prestate.setObject(3, period, Types.DATE);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertCertifMedic(String name, String surname, Date period) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO certif_medical (nom, prenom, reposPeriode) VALUES(?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, name, Types.VARCHAR);
            prestate.setObject(2, surname, Types.VARCHAR);
            prestate.setObject(3, period, Types.DATE);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertCertifDispense(String name, String surname, Date period) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO certif_dispense (nom, prenom, dispensePeriode) VALUES(?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, name, Types.VARCHAR);
            prestate.setObject(2, surname, Types.VARCHAR);
            prestate.setObject(3, period, Types.DATE);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertCertifApptitude(String idCard, String name, String surname, Date birthDate, String confirmation) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO certif_apptitude (idCarte, nom, prenom, dateNaissance, confirmation) VALUES(?,?,?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, idCard, Types.INTEGER);
            prestate.setObject(2, name, Types.VARCHAR);
            prestate.setObject(3, surname, Types.VARCHAR);
            prestate.setObject(4, birthDate, Types.DATE);
            prestate.setObject(5, confirmation, Types.TINYINT);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public static void insertFiche(String name, String surname, Date birthDate, String secuNumber, String adress, String telNumber, String validity, String gender) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO fiche_medicale (secuNum ,nom, prenom, dateNaissance, adresse, telNum, validite, sexe) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1, secuNumber, Types.INTEGER);
            prestate.setObject(2, name, Types.VARCHAR);
            prestate.setObject(3, surname, Types.VARCHAR);
            prestate.setObject(4, birthDate, Types.DATE);
            prestate.setObject(5, adress, Types.VARCHAR);
            prestate.setObject(6, telNumber, Types.INTEGER);
            prestate.setObject(7, validity, Types.TINYINT);
            prestate.setObject(8, gender, Types.TINYINT);

            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
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
    public static void searchFiche(String name, String surname) throws ClassNotFoundException, SQLException {
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