package Controllers;

import connectivity.ConnectionClass;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class Controller {
    public TextField textField;

   public void button() throws SQLException {
    String[] str=textField.getText().split(",");
    byte role = Byte.parseByte(str[2]);
    ConnectionClass.insertUser(str[0],str[1],role);
    }
}
