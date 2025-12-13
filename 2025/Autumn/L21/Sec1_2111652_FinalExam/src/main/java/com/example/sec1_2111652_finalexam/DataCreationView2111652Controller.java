package com.example.sec1_2111652_finalexam;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class DataCreationView2111652Controller
{
    @javafx.fxml.FXML
    private TextField ownerTextField;
    @javafx.fxml.FXML
    private CheckBox isChainPharmacyCheckBox;
    @javafx.fxml.FXML
    private TextField areaTextField;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeComboBox;
    @javafx.fxml.FXML
    private TextField tradeLicenceNoTextField;
    @javafx.fxml.FXML
    private ComboBox<String> locationTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker openingDateDatePicker;
    @javafx.fxml.FXML
    private TextField pharmacyNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        zipCodeComboBox.getItems().setAll("1229", "1222", "1129", "1245");
        locationTypeComboBox.getItems().setAll("Mall", "Supershop", "Local");
    }

    @javafx.fxml.FXML
    public void goToDataProcessingViewOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingView2111652.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Data Processing View");
        stage.show();
    }

    @javafx.fxml.FXML
    public void validateAndAddToBinFIleOnClick(ActionEvent actionEvent) {
        String name = pharmacyNameTextField.getText();
        String owner = ownerTextField.getText();
        LocalDate openingDate = openingDateDatePicker.getValue();
        String zipCode = zipCodeComboBox.getValue();
        String locationType = locationTypeComboBox.getValue();
        String tradeLicenseNo = tradeLicenceNoTextField.getText();

        int area = Integer.parseInt(areaTextField.getText());
        boolean isChainPharmacy = isChainPharmacyCheckBox.isSelected();

        if (isChainPharmacy) {
            if (!(area >= 500)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Chain pharmacy must be greater then or equel to 500");
                alert.showAndWait();
                return;
            }
        } else {
            if (!((area >= 100) && (area <= 499))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Non chain pharmacy must be greater then or equle to 100 and smaller then or equle to 499!");
                alert.showAndWait();
                return;
            }
        }

        Pharmacy pharmacy = new Pharmacy(name, area, zipCode, owner, openingDate, isChainPharmacy, locationType, tradeLicenseNo);

        File file = new File("Chair.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            // Testing custom method
            pharmacy.showLicenseFee();

            oos.writeObject(pharmacy);
            oos.close();

        } catch (Exception e) {
            System.out.println("There was a error saving to bin file!");
            //e.printStackTrace();
        }
    }
}