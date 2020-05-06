package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import JavaFX.Main;
import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ControllerLogin<connection> implements Initializable {

    @FXML
    private ImageView btnClose;
    @FXML
    private ImageView btnClose2;
    @FXML
    private Button btnIn;
    @FXML
    private Button btnSign;
    @FXML
    private ImageView btnReturn;
    @FXML
    private Pane pnlConnect;
    @FXML
    private Pane pnlCreate;
    @FXML
    private Button btnCreate;
    @FXML
    public TextField textField;
    @FXML
    public TextField textField2;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField passwordField2;
    @FXML
    public Label lblErrors;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
    }

    @FXML
   public void MouseCloseOrReturn(MouseEvent event){
        if(event.getSource() == btnClose || event.getSource()==btnClose2){
            System.exit(0);
        }
        if(event.getSource().equals(btnReturn)){
            pnlConnect.toFront();
        }
    }

    @FXML
    public void buttonCreateAccount(ActionEvent event){
        if(event.getSource().equals(btnCreate)){
            pnlCreate.toFront();
        }
    }

    public void buttonIn(ActionEvent event) throws SQLException {
        if(event.getSource().equals(btnIn)) {
            String user = textField2.getText();
            String pass = passwordField2.getText();
            ConnectionClass.createAccount(user, pass);
            pnlConnect.toFront();
        }
    }
    Connection connection = ConnectionClass.conDB();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public void buttonSign(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        if(event.getSource().equals(btnSign)){
            String user = textField.getText();
            String pass = passwordField.getText();
            String sql = " SELECT * FROM utilisateur WHERE pseudo = ? AND password = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setObject(1,user);
                preparedStatement.setObject(2,pass);
                resultSet = preparedStatement.executeQuery();
                if(!resultSet.next()){
                    lblErrors.setTextFill(Color.RED);
                    lblErrors.setText("Enter correct Username/Password please");
                }
                else{
                    lblErrors.setTextFill(Color.GREEN);
                    lblErrors.setText("Login Successful");
                    alertDisplay("Well Done !", "Login Successful");
                    try{
                        Node node = (Node) event.getSource();
                        Stage stage = (Stage) node.getScene().getWindow();
                        stage.close();

                        Main app = new Main();
                        app.newStage(new Stage(), "home");
                    }catch(IOException e){
                        System.err.println(e.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    private void alertDisplay(String info, String header){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(info);
        alert.setHeaderText(header);
        alert.showAndWait();;
    }
}
