package com.example.sec6_2111652_finalexam;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataCreationView2111652Controller
{
    @javafx.fxml.FXML
    private TextField ownerTextField;
    @javafx.fxml.FXML
    private CheckBox isChainPharmacyCheckBox;
    @javafx.fxml.FXML
    private TextField areaInSquareFeetTextField;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeComboBox;
    @javafx.fxml.FXML
    private TextField tradeLicenseNoTextField;
    @javafx.fxml.FXML
    private ComboBox<String> locationTypeComboBox;
    @javafx.fxml.FXML
    private DatePicker openingDateDatePicker;
    @javafx.fxml.FXML
    private TextField pharmacyNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        locationTypeComboBox.getItems().addAll("Mall", "Supershop", "Local", "Uni");
        zipCodeComboBox.getItems().addAll("1229", "2009", "2111", "2902");
    }

    @javafx.fxml.FXML
    public void goToDataProcessingViewOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingView2111652.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void validateAndSaveToBinFileOnClick(ActionEvent actionEvent) {
        boolean isChain = isChainPharmacyCheckBox.isSelected();
        double areaSqFt = Double.parseDouble(areaInSquareFeetTextField.getText());

        if (isChain) {
            if (areaSqFt < 500) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid data");
                alert.setContentText("Chain pharmacy must have area greater then or equal to 500 SqFt");
                alert.showAndWait();
            }
        } else {
            if (areaSqFt < 100 || areaSqFt > 499) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Invalid data");
                alert.setContentText("Non chain pharmacy must have area of greater then 100 and less then 499 SqFt");
                alert.showAndWait();
            }
        }

        Pharmacy pharmacy = new Pharmacy(
                pharmacyNameTextField.getText(),
                areaSqFt,
                zipCodeComboBox.getValue(),
                ownerTextField.getText(),
                tradeLicenseNoTextField.getText(),
                locationTypeComboBox.getValue(),
                isChain,
                openingDateDatePicker.getValue()
        );

        File file = new File("Chair.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (file.exists()) {
                // Header exist
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream2111652(fos);
            } else {
                // Header does not exist
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(pharmacy);
            oos.close();

        } catch (Exception ex) {
            System.out.println("There was a error while writing to bin file");
        }

        System.out.println("Pharmacy saved!!");
    }
}