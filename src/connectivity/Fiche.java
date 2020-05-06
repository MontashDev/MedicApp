package connectivity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fiche {
    private final StringProperty patientName = new SimpleStringProperty();
    private final StringProperty patientSurname = new SimpleStringProperty();
    private final StringProperty patientBirth = new SimpleStringProperty();
    private final IntegerProperty patientGender = new SimpleIntegerProperty();
    private final StringProperty patientAddress = new SimpleStringProperty();
    private final IntegerProperty patientSecu = new SimpleIntegerProperty();
    private final IntegerProperty patientTel = new SimpleIntegerProperty();
    private final IntegerProperty patientValidity = new SimpleIntegerProperty();

    public String getPatientName() {
        return patientName.get();
    }

    public StringProperty patientNameProperty() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName.set(patientName);
    }

    public String getPatientSurname() {
        return patientSurname.get();
    }

    public StringProperty patientSurnameProperty() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname.set(patientSurname);
    }

    public String getPatientBirth() {
        return patientBirth.get();
    }

    public StringProperty patientBirthProperty() {
        return patientBirth;
    }

    public void setPatientBirth(String patientBirth) {
        this.patientBirth.set(patientBirth);
    }

    public int getPatientGender() {
        return patientGender.get();
    }

    public IntegerProperty patientGenderProperty() {
        return patientGender;
    }

    public void setPatientGender(int patientGender) {
        this.patientGender.set(patientGender);
    }

    public String getPatientAddress() {
        return patientAddress.get();
    }

    public StringProperty patientAddressProperty() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress.set(patientAddress);
    }

    public int getPatientSecu() {
        return patientSecu.get();
    }

    public IntegerProperty patientSecuProperty() {
        return patientSecu;
    }

    public void setPatientSecu(int patientSecu) {
        this.patientSecu.set(patientSecu);
    }

    public int getPatientTel() {
        return patientTel.get();
    }

    public IntegerProperty patientTelProperty() {
        return patientTel;
    }

    public void setPatientTel(int patientTel) {
        this.patientTel.set(patientTel);
    }

    public int getPatientValidity() {
        return patientValidity.get();
    }

    public IntegerProperty patientValidityProperty() {
        return patientValidity;
    }

    public void setPatientValidity(int patientValidity) {
        this.patientValidity.set(patientValidity);
    }
}
