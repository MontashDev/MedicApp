package connectivity;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.sql.*;

public class ConnectionClass {
    public static void insertUser(String pseudo, String password, Byte role){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/cabinet_medical", "root", "");
            String sql = "INSERT INTO utilisateur (pseudo,password,role) VALUES(?,?,?)";
            PreparedStatement prestate = connection.prepareStatement(sql);
            prestate.setObject(1,pseudo,Types.VARCHAR);
            prestate.setObject(2,password,Types.VARCHAR);
            prestate.setObject(3,role,Types.TINYINT);
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
            prestate.setObject(1,carteID,Types.INTEGER);
            prestate.setObject(2,secuNum,Types.INTEGER);
            prestate.setObject(3,nom,Types.VARCHAR);
            prestate.setObject(4,prenom,Types.VARCHAR);
            prestate.setObject(5,age,Types.DATE);
            prestate.setObject(6,adresse,Types.VARCHAR);
            prestate.setObject(7,telNum,Types.INTEGER);
            prestate.setObject(8,prescriptionNum,Types.INTEGER);
            prestate.setObject(9,examNum,Types.INTEGER);
            prestate.setObject(10,profession,Types.VARCHAR);
            prestate.setObject(11,validite,Types.BOOLEAN);
            prestate.setObject(12,bilanRadio,Types.TINYINT);
            prestate.setObject(13,bilanBio,Types.TINYINT);
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
            prestate.setObject(1,name,Types.VARCHAR);
            prestate.setObject(2,surname,Types.VARCHAR);
            prestate.setObject(3,reason,Types.VARCHAR);
            prestate.setObject(4,date,Types.DATE);
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
            prestate.setObject(1,medicName,Types.VARCHAR);
            prestate.setObject(2,dose,Types.INTEGER);
            prestate.setObject(3,period,Types.DATE);
            prestate.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}