package com.example.sec6_1234567_finalexam;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class DataCreationView1234567Controller
{
    @javafx.fxml.FXML
    private CheckBox isChainPharmacyCheckBox;
    @javafx.fxml.FXML
    private TextField areaTextField;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeComboBox;
    @javafx.fxml.FXML
    private TextField tradeLicenseNoTextField;
    @javafx.fxml.FXML
    private TextField ownerTextFIeld;
    @javafx.fxml.FXML
    private ComboBox<String> locationTypeConboBox;
    @javafx.fxml.FXML
    private DatePicker openingDateDatePicker;
    @javafx.fxml.FXML
    private TextField pharmacyNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        zipCodeComboBox.getItems().addAll("1111", "1212", "1122", "1211");
        locationTypeConboBox.getItems().addAll("Local", "Supershop");
    }

    @javafx.fxml.FXML
    public void goToDataProcessingViewButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingView1234567.fxml"));

        Scene scene =  new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Data Processing View");

        stage.show();
    }

    @javafx.fxml.FXML
    public void validateAndSaveToBin(ActionEvent actionEvent) throws IOException {
        String pharmecyName = pharmacyNameTextField.getText();
        String owner = ownerTextFIeld.getText();
        LocalDate openingDate = openingDateDatePicker.getValue();
        boolean isChainPharmacy = isChainPharmacyCheckBox.isSelected();
        String zipCode = zipCodeComboBox.getValue();
        String locationType = locationTypeConboBox.getValue();
        String tradeLicneNo = tradeLicenseNoTextField.getText();
        float area = Float.parseFloat(areaTextField.getText());

        if (isChainPharmacy) {
            if (area < 500) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Validation Error");
                alert.setHeaderText("Chain Pharmacy Must be 500 Squre Feet or more");
                alert.showAndWait();
                return;
            }
        } else {
            if (!(area >= 100 && area <= 499)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Validation Error");
                alert.setHeaderText("Non Chain Pharmacy Must be between 100 to 499 Squre Feet or more");
                alert.showAndWait();
                return;
            }
        }

        Pharmacy pharmacy = new Pharmacy(pharmecyName, zipCode, area, owner, openingDate, locationType, tradeLicneNo, isChainPharmacy);

        File file = new File("Chair.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        if (file.exists()) {
            fos = new FileOutputStream(file);
            oos = new AppendableObjectOutputStream(fos);
        } else {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
        }

        oos.writeObject(pharmacy);
        oos.close();
        pharmacy.printLicenseFee();
        System.out.println("Object saved to bin");
    }
}