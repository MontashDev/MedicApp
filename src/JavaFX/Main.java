package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/login.fxml"));
        primaryStage.setTitle("MedicApp");
        primaryStage.setScene(new Scene(root, 650, 425));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    public void newStage(Stage secondStage,String fxlmName) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../FXML/"+fxlmName+".fxml"));
        secondStage.setTitle("MedicApp");
        secondStage.setScene(new Scene(root, 600, 425));
        secondStage.initStyle(StageStyle.DECORATED);
        secondStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
