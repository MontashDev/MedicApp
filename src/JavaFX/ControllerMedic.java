package JavaFX;


import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class ControllerMedic {

    @FXML
    TextField carteID;
    @FXML
    TextField secuNum;
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField adresse;
    @FXML
    TextField telNum;
    @FXML
    TextField prescriptionNum;
    @FXML
    TextField examNum;
    @FXML
    TextField profession;
    @FXML
    TextField validite;
    @FXML
    TextField bilanRadio;
    @FXML
    TextField bilanBio;
    @FXML
    DatePicker age;
    Date date;
    @FXML
    Button maj;
    @FXML
    Button ordoButton;

    public void button() throws SQLException {
        date = java.sql.Date.valueOf(age.getValue());
        ConnectionClass.insertMedical(carteID.getText(), secuNum.getText(), nom.getText(), prenom.getText(), date, adresse.getText(),
                telNum.getText(), prescriptionNum.getText(), examNum.getText(), profession.getText(), validite.getText(), bilanRadio.getText(), bilanBio.getText());
    }

    public void ordoButton(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/ordo.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void certifMedical(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/certifMedic.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void certifDispense(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/certifDispense.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void certifApptitude(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/certifApptitude.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
