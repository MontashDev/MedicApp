package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import JavaFX.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerHome implements Initializable {

    @FXML
    private ImageView btnClose;
    @FXML
    private Button btnAcc;
    @FXML
    private Button btnApp;
    @FXML
    private Button btnPF;
    @FXML
    private Button btnMR;
    private Node node;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

    public void buttonClose(MouseEvent event) {
        if (event.getSource() == btnClose) {
            System.exit(0);
        }
    }

    Main app = new Main();

    public void buttonApp(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/rdv.fxml"));
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

    public void buttonAcc(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/compta.fxml"));
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

    public void buttonMR(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/medic.fxml"));
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

    public void buttonPF(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXML/fiche.fxml"));
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
