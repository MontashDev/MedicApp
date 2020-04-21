package JavaFX;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class ControllerPrescription {
    @FXML
    TextArea medic;
    @FXML
    TextField dose;
    @FXML
    DatePicker period;
    Date date;
    @FXML
    Button send;

    public void button() throws SQLException {
        date = java.sql.Date.valueOf(period.getValue());
        ConnectionClass.insertPrescription(medic.getText(),dose.getText(),date);
    }
}
