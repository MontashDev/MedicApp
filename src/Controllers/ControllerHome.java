package Controllers;
import java.net.URL;
import java.util.ResourceBundle;

import JavaFX.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerHome implements Initializable{

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

    public void buttonClose(MouseEvent event){
        if(event.getSource() == btnClose) {
            System.exit(0);
        }
    }

    Main app = new Main();

    public void buttonApp(ActionEvent event) throws Exception {
        if(event.getSource().equals(btnApp)){
            System.out.println("appointments opened");
            /*Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();*/
           // app.newStage(new Stage(), "appointments");
        }
    }

    public void buttonAcc(ActionEvent event) throws Exception {
        if(event.getSource().equals(btnAcc)){
            System.out.println("accounting opened");
            /*Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();*/
           // app.newStage(new Stage(), "accounting");
        }
    }

    public void buttonMR(ActionEvent event) throws Exception{
        if(event.getSource().equals(btnMR)){
            System.out.println("medical records opened");
            /*Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();*/
            // app.newStage(new Stage(), "medcial-records");
        }
    }

    public void buttonPF(ActionEvent event) throws Exception{
        if(event.getSource().equals(btnPF)){
            System.out.println("patient folders opened");
            /*Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();*/
            // app.newStage(new Stage(), "patients-files");
        }
    }
}
