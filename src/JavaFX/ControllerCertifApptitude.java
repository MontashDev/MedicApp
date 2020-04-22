package JavaFX;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;

public class ControllerCertifApptitude {

    @FXML
    TextField idCard;

    @FXML
    TextField name;

    @FXML
    TextField surname;

    @FXML
    DatePicker period;
    Date date;

    @FXML
    TextField confirmation;

    @FXML
    Button button;

    public void button() throws SQLException {
        date = java.sql.Date.valueOf(period.getValue());
        ConnectionClass.insertCertifApptitude(idCard.getText(),name.getText(),surname.getText(),date,confirmation.getText());
    }
}
