package com.example.sec6_2111652_finalexam;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.print.Book;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class DataProcessingView2111652Controller
{
    @javafx.fxml.FXML
    private TextField areaTextField;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> locationTypeCol;
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
    private TableColumn<Pharmacy, Double> areSqFtCol;

    @javafx.fxml.FXML
    public void initialize() {
        zipCodeComboBox.getItems().addAll("1229", "2009", "2111", "2902");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        areSqFtCol.setCellValueFactory(new PropertyValueFactory<>("areaInSqFt"));
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        openingDateCol.setCellValueFactory(new PropertyValueFactory<>("openingDate"));
        isChainCol.setCellValueFactory(new PropertyValueFactory<>("isChainPharmacy"));
        locationTypeCol.setCellValueFactory(new PropertyValueFactory<>("locationType"));
        tradeLicenseNoCol.setCellValueFactory(new PropertyValueFactory<>("tradeLicenseNo"));
    }

    @javafx.fxml.FXML
    public void loadTableWithFilteredDataOnClick(ActionEvent actionEvent) {
        ArrayList<Pharmacy> pharmacies = new ArrayList<>();
        tableView.getItems().clear();

        try {
            File file = new File("Chair.bin");

            if (!file.exists()) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {

                while (true) {
                    Pharmacy pharmacy = (Pharmacy) ois.readObject();
                    pharmacies.add(pharmacy);
                }

            } catch (EOFException efo) {
                ois.close();
                System.out.println("End of file reached!");
            }

        } catch (Exception e) {
            System.out.println("There was a problem reading from bin file!");
        }

        String zipCode = zipCodeComboBox.getValue();
        double area = Double.parseDouble(areaTextField.getText());

        for (Pharmacy pharmacy : pharmacies) {
            if (pharmacy.getZipCode().equals(zipCode) && pharmacy.getAreaInSqFt() <= area) {
                tableView.getItems().add(pharmacy);
            }
        }
    }

}