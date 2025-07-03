package com.example.midterm_section1_1111111;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MidController
{
    @FXML
    private TableColumn<DataPackage, String> validityCol;
    @FXML
    private Label outputLable;
    @FXML
    private TableColumn<DataPackage, String> availabilityCol;
    @FXML
    private TableColumn<DataPackage, LocalDate> offerEndsCol;
    @FXML
    private TableColumn<DataPackage, Double> dataAmountCol;
    @FXML
    private TableColumn<DataPackage, Double> priceCol;
    @FXML
    private ComboBox<String> avvailabilityComboBox;
    @FXML
    private TableView<DataPackage> dataPakageTable;
    @FXML
    private TextField dataAmountTextField;
    @FXML
    private ComboBox<String> validityComboBox;
    @FXML
    private TextField pakageNameTextField;
    @FXML
    private TableColumn<DataPackage, String> pakageNameCol;
    @FXML
    private TextField priceTextField;
    @FXML
    private DatePicker offerEndsDatePicker;
    @FXML
    private ComboBox<String> validityFilterComboBox;
    @FXML
    private TextField maxPriceFilterTextFiled;

    @FXML
    public void initialize() {
        // ComboBox
        validityComboBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");
        avvailabilityComboBox.getItems().addAll("App only", "Recharge only", "App and recharge");

        validityFilterComboBox.getItems().addAll("3 days", "7 days", "15 days", "30 days", "Unlimited");

        pakageNameCol.setCellValueFactory(new PropertyValueFactory<>("packageName"));
        dataAmountCol.setCellValueFactory(new PropertyValueFactory<>("dataAmount"));
        validityCol.setCellValueFactory(new PropertyValueFactory<>("validity"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<>("availability"));
        offerEndsCol.setCellValueFactory(new PropertyValueFactory<>("offerEnds"));
    }

    ArrayList<DataPackage> dataPakageList = new ArrayList<>();

    @FXML
    public void createPakageOnClick(ActionEvent actionEvent) {
        if (pakageNameTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter a pakage name");
            return;
        }

        if (dataAmountTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter data Ammount");
            return;
        }

        if (priceTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter a price");
            return;
        }

        if (validityComboBox.getValue() == null) {
            outputLable.setText("Please select a Validity");
            return;
        }

        if (avvailabilityComboBox.getValue() == null) {
            outputLable.setText("Please select an avalibility");
            return;
        }

        if (offerEndsDatePicker.getValue() == null) {
            outputLable.setText("Please select an offer ends date");
            return;
        }

        for (DataPackage dp : dataPakageList) {
            if (dp.getPackageName().equals(pakageNameTextField.getText())) {
                outputLable.setText("A data pakage with the same name allready exists please change the pakage name");
                return;
            }
        }

        String pakageName = pakageNameTextField.getText();
        double dataAmount = Double.parseDouble(dataAmountTextField.getText());
        String validity = validityComboBox.getValue();
        double price = Double.parseDouble(priceTextField.getText());
        String availability = avvailabilityComboBox.getValue();
        LocalDate offerEnds = offerEndsDatePicker.getValue();

        DataPackage dp = new DataPackage(pakageName, dataAmount, validity, price, availability, offerEnds);

        dataPakageList.add(dp);

        outputLable.setText("Data Pakage Saved");

        // Show Data Pakge on Table
        dataPakageTable.getItems().clear();
        dataPakageTable.getItems().addAll(dataPakageList);
    }


    @FXML
    public void restFilterOnClick(ActionEvent actionEvent) {
        dataPakageTable.getItems().clear();
        dataPakageTable.getItems().addAll(dataPakageList);
    }

    @FXML
    public void filterButtonOnClick(ActionEvent actionEvent) {
        ArrayList<DataPackage> filteredDataPakgeList = new ArrayList<>();

        String filterValidity = validityFilterComboBox.getValue();
        double maxPrice = Double.parseDouble(maxPriceFilterTextFiled.getText());

        for (DataPackage dp : dataPakageList) {
            if (filterValidity.equals(dp.getValidity()) && (dp.getPrice() <= maxPrice)) {
                filteredDataPakgeList.add(dp);
            }
        }

        dataPakageTable.getItems().clear();
        dataPakageTable.getItems().addAll(filteredDataPakgeList);
    }

    @FXML
    public void findBestValuePakageOnClick(ActionEvent actionEvent) {
        if (dataPakageList.isEmpty()) {
            outputLable.setText("No data pakages exist");
            return;
        }

        double bestPricePerGb = dataPakageList.getFirst().getPrice() / dataPakageList.getFirst().getDataAmount();
        DataPackage bestPakage = dataPakageList.getFirst();

        double pricePerGb;
        for (DataPackage dp : dataPakageList) {
            pricePerGb =  dp.getPrice() / dp.getDataAmount();

            if (pricePerGb < bestPricePerGb) {
                bestPricePerGb = pricePerGb;
                bestPakage = dp;
            }
        }

        outputLable.setText(bestPakage.toString());
    }
/*
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
    }*/
}
