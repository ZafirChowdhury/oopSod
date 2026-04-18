package com.example.final_9_2111652;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataCreationViewController2111652
{
    @javafx.fxml.FXML
    private TextField furnitureDescriptionTextFIeld;
    @javafx.fxml.FXML
    private TextField furniturePriceTextFIeld;
    @javafx.fxml.FXML
    private TextField furnitureIdTextField;
    @javafx.fxml.FXML
    private CheckBox isImportedCheckBox;
    @javafx.fxml.FXML
    private TextField dicoutAmmoutTextField;
    @javafx.fxml.FXML
    private TextField vatAmmoutTextFIeld;
    @javafx.fxml.FXML
    private ComboBox<String> furnitureTypeTextComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        furnitureTypeTextComboBox.getItems().addAll("Chair", "Table", "Bed", "Cabinet");
    }

    @javafx.fxml.FXML
    public void goToDataProcessingOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DataProcessingView2111652.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void validateAndAddNewFurnitureOnClick(ActionEvent actionEvent) {
        int vat = Integer.parseInt(vatAmmoutTextFIeld.getText());

        if (vat < 10) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vat must be 10% or higher!");
            alert.showAndWait();
            return;
        }

        if (vat % 5 != 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Vat must be multiple of 5!");
            alert.showAndWait();
            return;
        }

        if (isImportedCheckBox.isSelected()) {
            if (vat < 20) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Vat on imported furniture must be 20% or higher!");
                alert.showAndWait();
                return;
            }
        }

        String id = furnitureIdTextField.getText();
        String description = furnitureDescriptionTextFIeld.getText();
        String type = furnitureTypeTextComboBox.getValue();
        double price = Double.parseDouble(furniturePriceTextFIeld.getText());
        int discount = Integer.parseInt(dicoutAmmoutTextField.getText());

        Furniture furniture = new Furniture(id,
                isImportedCheckBox.isSelected(),
                vat,
                discount,
                price,
                type,
                description);

        File file = new File("Furniture.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (file.exists()) {
                // Header exist
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                // Header does not exist
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(furniture);
            oos.close();

        } catch (Exception ex) {
            System.out.println("There was a error while writing to bin file");
        }

        System.out.println("Furniture saved!!");

    }
}