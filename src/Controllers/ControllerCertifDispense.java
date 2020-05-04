package Controllers;

import connectivity.InsertClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class ControllerCertifDispense extends ControllerMedic {

    @FXML
    TextField name;

    @FXML
    TextField surname;

    @FXML
    DatePicker period;
    Date date;

    @FXML
    Button button;

    public void button() throws SQLException {
        date = java.sql.Date.valueOf(period.getValue());
        InsertClass.insertCertifDispense(name.getText(),surname.getText(),date);
    }

    public void fill() throws SQLException {
        InsertClass.selectCertifDispense(nom.getText(),prenom.getText());
    }
}
