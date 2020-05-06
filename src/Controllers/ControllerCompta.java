package Controllers;

import connectivity.InsertClass;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerCompta {

    @FXML
    private TextField nature;

    @FXML
    private TextField achat;

    @FXML
    private TextField loyer;

    @FXML
    private TextField facture;

    public void send() {
        InsertClass.insertRecette(nature.getText());
    }

    public void send2() {
        InsertClass.insertDepense(achat.getText(), loyer.getText(), facture.getText());
    }

}
