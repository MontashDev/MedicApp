package JavaFX;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class ControllerCertifMedic {

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
        ConnectionClass.insertCertifMedic(name.getText(),surname.getText(),date);
    }

}
