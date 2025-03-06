package com.example.mid;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TextField packageNameTextField;
    @javafx.fxml.FXML
    private TextField dataAmountTextField;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private ComboBox<String> validityComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> availabilityComboBox;
    @javafx.fxml.FXML
    private DatePicker offerEndsDatePicker;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TableView<DataPackage> dataPakageTable;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Integer> validityCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> availabilityCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, LocalDate> offerEndsCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Float> dataAmmountCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, Float> priceCol;
    @javafx.fxml.FXML
    private TableColumn<DataPackage, String> nameCol;
    @javafx.fxml.FXML
    private TextField priceFilterTextField;
    @javafx.fxml.FXML
    private ComboBox<String> validityFilterComboBox;
    @javafx.fxml.FXML
    private Label bestValueOutputLable;


    @javafx.fxml.FXML
    public void initialize() {
        // ComboBox Setup
        validityComboBox.getItems().setAll("3 Days", "7 Days", "15 Days", "30 Days", "Unlimited");
        availabilityComboBox.getItems().setAll("App only", "Recharge only", "App and recharge");

        validityFilterComboBox.getItems().setAll("3 Days", "7 Days", "15 Days", "30 Days", "Unlimited");

        // Table
        nameCol.setCellValueFactory(new PropertyValueFactory<>("packageName"));
        dataAmmountCol.setCellValueFactory(new PropertyValueFactory<>("dataAmount"));
        validityCol.setCellValueFactory(new PropertyValueFactory<>("validity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        offerEndsCol.setCellValueFactory(new PropertyValueFactory<>("offerEnds"));
    }

    ArrayList<DataPackage> dataPackages = new ArrayList<>();
    ArrayList<DataPackage> filteredDataPackages = new ArrayList<>();

    @javafx.fxml.FXML
    public void createPakageButtonOnClick(ActionEvent actionEvent) {
        // Check if all input given
        if (packageNameTextField.getText().trim().isEmpty()){
            outputLable.setText("Please enter package name!");
            return;
        }

        if (dataAmountTextField.getText().trim().isEmpty()){
            outputLable.setText("Please enter data amount!");
            return;
        }

        if (priceTextField.getText().trim().isEmpty()){
            outputLable.setText("Please enter a price!");
            return;
        }

        if (availabilityComboBox.getValue() == null){
            outputLable.setText("Please select a avalibility!");
            return;
        }

        if (validityComboBox.getValue() == null){
            outputLable.setText("Please select a validity!");
            return;
        }

        if (offerEndsDatePicker.getValue() == null){
            outputLable.setText("Please select an end date!");
            return;
        }

        // Check if pakage name unique
        for (DataPackage dp : dataPackages) {
             if (dp.getPackageName().equals(packageNameTextField.getText())) {
                outputLable.setText("A pakage with the same name already exists. Please enter a new name.");
                return;
            }
        }


        int validity = 0;
        if (validityComboBox.getValue().equals("3 Days")) validity = 3;
        else if (validityComboBox.getValue().equals("7 Days")) validity = 7;
        else if (validityComboBox.getValue().equals("15 Days")) validity = 15;
        else if (validityComboBox.getValue().equals("30 Days")) validity = 30;

        DataPackage newDatapackage = new DataPackage(
                packageNameTextField.getText(),
                offerEndsDatePicker.getValue(),
                Float.parseFloat(dataAmountTextField.getText()),
                validity,
                Float.parseFloat(priceTextField.getText()),
                availabilityComboBox.getValue()
        );

        dataPackages.add(newDatapackage);

        System.out.println(newDatapackage.toString());
        outputLable.setText("New datapakage added!");

        dataPakageTable.getItems().clear();
        dataPakageTable.getItems().addAll(dataPackages);
    }

    @javafx.fxml.FXML
    public void clearFIlterButtonIOnClick(ActionEvent actionEvent) {
        dataPakageTable.getItems().clear();
        dataPakageTable.getItems().addAll(dataPackages);
    }

    @javafx.fxml.FXML
    public void filterButtonOnClick(ActionEvent actionEvent) {
        filteredDataPackages.clear();

        if (priceFilterTextField.getText() == null) {
            outputLable.setText("Please enter a price to filter");
            return;
        }

        if (validityFilterComboBox.getValue() == null) {
            outputLable.setText("Please select a validity to filter");
            return;
        }

        float price = Float.parseFloat(priceFilterTextField.getText());
        int validity = 0;
        if (validityFilterComboBox.getValue().equals("3 Days")) validity = 3;
        else if (validityFilterComboBox.getValue().equals("7 Days")) validity = 7;
        else if (validityFilterComboBox.getValue().equals("15 Days")) validity = 15;
        else if (validityFilterComboBox.getValue().equals("30 Days")) validity = 30;

        for (DataPackage dp : dataPackages) {
            if ((dp.getValidity() == validity) && (dp.getPrice() >= price)) {
                filteredDataPackages.add(dp);
            }
        }

        dataPakageTable.getItems().clear();
        dataPakageTable.getItems().addAll(filteredDataPackages);

    }

    @javafx.fxml.FXML
    public void findBestValueOnClick(ActionEvent actionEvent) {
        if (dataPackages.isEmpty()) {
            bestValueOutputLable.setText("No data Pakages exists");
            return;
        }

        float bestRatio = dataPackages.getFirst().getDataAmount() / dataPackages.getFirst().getPrice();
        DataPackage bestPakage =  dataPackages.getFirst();

        for (DataPackage dp : dataPackages) {
            if (dp.getDataAmount() / dp.getPrice() > bestRatio) {
                bestRatio = dp.getDataAmount() / dp.getPrice();
                bestPakage = dp;
            }
        }

        bestValueOutputLable.setText(bestPakage.toString());
    }
}