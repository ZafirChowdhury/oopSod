package com.example.sec1_2111652_finalexam;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.function.BinaryOperator;

public class DataProcessingView2111652Controller
{
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> locationTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, Integer> areaCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> zipCodeCol;
    @javafx.fxml.FXML
    private TableView<Pharmacy> pharmacyTable;
    @javafx.fxml.FXML
    private ComboBox<String> zipCodeComboBox;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> tradeLicenceNoCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, String> ownerCol;
    @javafx.fxml.FXML
    private TextField areaToTextFiled;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, Boolean> isChainCol;
    @javafx.fxml.FXML
    private TableColumn<Pharmacy, LocalDate> openingDateCol;
    @javafx.fxml.FXML
    private TextField arearFromTextField;

    @javafx.fxml.FXML
    public void initialize() {

        // SS

        zipCodeComboBox.getItems().setAll("1229", "1222", "1129", "1245");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        areaCol.setCellValueFactory(new PropertyValueFactory<>("areaInSqFt"));
        zipCodeCol.setCellValueFactory(new PropertyValueFactory<>("zipCode"));
        ownerCol.setCellValueFactory(new PropertyValueFactory<>("owner"));
        openingDateCol.setCellValueFactory(new PropertyValueFactory<>("openingDate"));
        isChainCol.setCellValueFactory(new PropertyValueFactory<>("isChainPharmacy"));
        locationTypeCol.setCellValueFactory(new PropertyValueFactory<>("locationType"));
        tradeLicenceNoCol.setCellValueFactory(new PropertyValueFactory<>("licenceNo"));
    }

    @javafx.fxml.FXML
    public void loadTableOnClick(ActionEvent actionEvent) {
        ArrayList<Pharmacy> pharmacies = new ArrayList<>();

        try {
            File file = new File("Chair.bin");

            if (!file.exists()) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {

                while (true) {
                    pharmacies.add((Pharmacy) ois.readObject());
                }

            } catch (EOFException eof) {
                System.out.println("Bin file read successfully!");
            }

        } catch (Exception e) {
            System.out.println("There was error while reading from bin!");
        }

        ArrayList<Pharmacy> filtteredPharmecy = new ArrayList<>();

        String zipCode = zipCodeComboBox.getValue();
        int fromArea = Integer.parseInt(arearFromTextField.getText());
        int toArea = Integer.parseInt(areaToTextFiled.getText());

        for (Pharmacy pharmacy : pharmacies) {
            if (zipCode.equals(pharmacy.getZipCode())) {
                if ((pharmacy.getAreaInSqFt() >= fromArea) && pharmacy.getAreaInSqFt() <= toArea) {
                    filtteredPharmecy.add(pharmacy);
                }
            }
        }

        pharmacyTable.getItems().clear();
        pharmacyTable.getItems().addAll(filtteredPharmecy);
    }
}