package com.example.sec6_1234567_finalexam;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataCreationProcessing1234567Controller
{
    @javafx.fxml.FXML
    private TextField areaTextField;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> locationCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, Float> areaCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> zipCodeCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> nameCol;
    @javafx.fxml.FXML
    private TableView<Pharmacy> tableView;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> tradeLicenseNoCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> ownerCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, Boolean> isChainCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, LocalDate> openingDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        zipCodeComboBox.getItems().addAll("1111", "1212", "1122", "1211");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        openingDateCol.setCellValueFactory(new PropertyValueFactory<>("openingDate"));
        locationCol.setCellValueFactory(new PropertyValueFactory<>("locationType"));
        tradeLicenseNoCol.setCellValueFactory(new PropertyValueFactory<>("tradeLicenseNo"));
        isChainCol.setCellValueFactory(new PropertyValueFactory<>("tradeLicenseNo"));
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        areaCol.setCellValueFactory(new PropertyValueFactory<>("areaInSqFt"));
    }

    ArrayList<Pharmacy> pharmacies = new ArrayList<>();
    ArrayList<Pharmacy> filteredPharmacies = new ArrayList<>();

    @javafx.fxml.FXML
    public void loadDataToTable(ActionEvent actionEvent) throws IOException {
        filteredPharmacies.clear();

        File file = new File("Chair.bin");
        if (!file.exists()) {
            return;
        }

        System.out.println("Bin File Exists");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                Pharmacy pharmacy = (Pharmacy) ois.readObject();
                System.out.println(pharmacy.toString());
                pharmacies.add(pharmacy);
            }
        } catch (EOFException efo) {
            System.out.println("End of file reached!");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Class not found");
        }

        String zipCode = zipCodeComboBox.getValue();
        float area = Float.parseFloat(areaTextField.getText());

        System.out.println("Filtering...");
        for (Pharmacy pharmacy : pharmacies) {
            System.out.println(pharmacy.getAreaInSqFt());
            if ((pharmacy.getZipCode().equals(zipCode))) {
                System.out.println(pharmacy.getAreaInSqFt());
                System.out.println(area);
                if (pharmacy.getAreaInSqFt() <= area) {
                    filteredPharmacies.add(pharmacy);
                }
            }
        }

        tableView.getItems().clear();
        tableView.getItems().addAll(filteredPharmacies);
    }
}