package Controllers;

import connectivity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerFiche implements Initializable {

    @FXML
    private TextField name;

    @FXML
    private TextField surname;


    @FXML
    private DatePicker birth;
    private Date date;

    @FXML
    private TextField gender;

    @FXML
    private TextField adress;

    @FXML
    private TextField secuNumber;

    @FXML
    private TextField tel;

    @FXML
    private TextField validity;

    @FXML
    private Button Send;

    @FXML
    private TableView<Fiche> tableFiche;

    @FXML
    private TableColumn<Fiche, String> tableName;

    @FXML
    private TableColumn<Fiche, String> tableSurname;

    @FXML
    private TableColumn<Fiche, String> tableBirth;

    @FXML
    private TableColumn<Fiche, Integer> tableGender;

    @FXML
    private TableColumn<Fiche, String> tableAddress;

    @FXML
    private TableColumn<Fiche, Integer> tableSecu;

    @FXML
    private TableColumn<Fiche, Integer> tableValidity;

    @FXML
    private TableColumn<Fiche, Integer> tableTel;

    @FXML
    private TextArea resultConsole;

    @FXML
    private TextField searchName;

    @FXML
    private TextField searchSurname;

    @FXML
    private Button Delete;

    private Connection connection;
    private ObservableList<Fiche> list;
    private ConnectionClass dbHandler;


    public void send() {
        date = java.sql.Date.valueOf(birth.getValue());
        InsertClass.insertFiche(name.getText(), surname.getText(), date, secuNumber.getText(), adress.getText(), tel.getText(), validity.getText(), gender.getText());
        resultConsole.setText("Patient ajouté avec succès !");
    }

    public void delete() throws ClassNotFoundException, SQLException {
        try {
            DeleteClass.deleteFichePatient(searchName.getText(), searchSurname.getText());
            resultConsole.setText("Suppression réussie !");
        } catch (SQLException e) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            throw e;
        }
    }

    public void search() throws SQLException, ClassNotFoundException {
        try {
            SelectClass.selectFiche(searchName.getText(), searchSurname.getText());
                populateTableView();
                resultConsole.setText(searchName.getText() + " " + searchSurname.getText() + " trouvé !");
        } catch (SQLException e) {
            System.out.println("Une erreur est survenue");
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbHandler = new ConnectionClass();
        try {
            populateTableView();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void populateTableView() throws SQLException, ClassNotFoundException {
        list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM fiche_medicale";
        connection = ConnectionClass.conDB();
        ResultSet resultSet = connection.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            Fiche fiche = new Fiche();
            fiche.setPatientName(resultSet.getString("nom"));
            fiche.setPatientSurname(resultSet.getString("prenom"));
            fiche.setPatientGender(resultSet.getByte("sexe"));
            fiche.setPatientBirth(resultSet.getString("dateNaissance"));
            fiche.setPatientAddress(resultSet.getString("adresse"));
            fiche.setPatientSecu(resultSet.getInt("secuNum"));
            fiche.setPatientTel(resultSet.getInt("telNum"));
            fiche.setPatientValidity(resultSet.getByte("validite"));
            SelectClass.getInformation();
            list.add(fiche);
        }
        tableName.setCellValueFactory(new PropertyValueFactory<>("patientName"));
        tableSurname.setCellValueFactory(new PropertyValueFactory<>("patientSurname"));
        tableGender.setCellValueFactory(new PropertyValueFactory<>("patientGender"));
        tableBirth.setCellValueFactory(new PropertyValueFactory<>("patientBirth"));
        tableAddress.setCellValueFactory(new PropertyValueFactory<>("patientAddress"));
        tableSecu.setCellValueFactory(new PropertyValueFactory<>("patientSecu"));
        tableTel.setCellValueFactory(new PropertyValueFactory<>("patientTel"));
        tableValidity.setCellValueFactory(new PropertyValueFactory<>("patientValidity"));
        tableFiche.setItems(list);
    }
}
