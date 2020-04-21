package JavaFX;

import connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;


public class ControllerRdv {

    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextArea reason;
    @FXML
    DatePicker date;
    Date rdv;
    @FXML
    Button send;

    public void button() throws SQLException {
        rdv = java.sql.Date.valueOf(date.getValue());
        ConnectionClass.insertAppointment(name.getText(), surname.getText(), reason.getText(),rdv);
    }


}
