package com.example.final_9_2111652;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DataProcessingViewController2111652
{
    @javafx.fxml.FXML
    private TableColumn<Furniture, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Furniture, Boolean> isImportedCol;
    @javafx.fxml.FXML
    private TableColumn<Furniture, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Furniture, Integer> descoutCol;
    @javafx.fxml.FXML
    private TextField minPriceTextField;
    @javafx.fxml.FXML
    private CheckBox isImportedCheckBox;
    @javafx.fxml.FXML
    private ComboBox<String> furnitureTypeTextField;
    @javafx.fxml.FXML
    private TableView<Furniture> tableView;
    @javafx.fxml.FXML
    private TableColumn<Furniture, String> descriptionCol;
    @javafx.fxml.FXML
    private TableColumn<Furniture, Integer> priceCol;
    @javafx.fxml.FXML
    private TableColumn<Furniture, Integer> vatCol;

    @javafx.fxml.FXML
    public void initialize() {
        furnitureTypeTextField.getItems().addAll("Chair", "Table", "Bed", "Cabinet");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        isImportedCol.setCellValueFactory(new PropertyValueFactory<>("isImported"));
        vatCol.setCellValueFactory(new PropertyValueFactory<>("vatPercentage"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        descoutCol.setCellValueFactory(new PropertyValueFactory<>("discountPercentage"));
    }

    @javafx.fxml.FXML
    public void loadDataToTableOnCllick(ActionEvent actionEvent) {
        ArrayList<Furniture> furnitures = new ArrayList<>();
        tableView.getItems().clear();

        try {
            File file = new File("Furniture.bin");

            if (!file.exists()) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {

                while (true) {
                    Furniture furniture = (Furniture) ois.readObject();
                    System.out.println(furniture);
                    furnitures.add(furniture);
                }

            } catch (EOFException efo) {
                ois.close();
                System.out.println("End of file reached!");
            }

        } catch (Exception e) {
            System.out.println("There was a problem reading from bin file!");
        }

        ArrayList<Furniture> filteredFurnitures = new ArrayList<>();

        for (Furniture furniture : furnitures) {
            if (furniture.getType().equals(furnitureTypeTextField.getValue())) {
                if (furniture.getPrice() >= Double.parseDouble(minPriceTextField.getText())) {
                    filteredFurnitures.add(furniture);
                }
            }
        }

        if (isImportedCheckBox.isSelected()) {
            ArrayList<Furniture> importedFurnitures = new ArrayList<>();

            for (Furniture furniture : filteredFurnitures) {
                if (furniture.getIsImported()) {
                    importedFurnitures.add(furniture);
                }
            }

            tableView.getItems().addAll(importedFurnitures);
            return;
        }

        tableView.getItems().addAll(filteredFurnitures);
    }
}