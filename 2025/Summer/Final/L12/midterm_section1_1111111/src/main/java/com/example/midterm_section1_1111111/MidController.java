package com.example.midterm_section1_1111111;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
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
    public void initialize() throws IOException {
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

        // Read from bin file
        File file = new File("dataPackage.bin");

        if (!file.exists()) {
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                DataPackage dataPackage = (DataPackage) ois.readObject();
                dataPakageList.add(dataPackage);
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Class not found!");
        }

        dataPakageTable.getItems().addAll(dataPakageList);
    }

    ArrayList<DataPackage> dataPakageList = new ArrayList<>();

    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();


    @FXML
    public void createPakageOnClick(ActionEvent actionEvent) throws IOException {
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

        DataPackage dp = new DataPackage(offerEnds, availability, price, validity, dataAmount, pakageName);

        File file = new File("dataPackage.bin");
        FileOutputStream fis;
        ObjectOutputStream oos;

        if (file.exists()) {
            fis = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStream(fis);
        } else {
            fis = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fis);
        }

        oos.writeObject(dp);
        oos.close();

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

    @FXML
    public void showDataInDetail(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dataView.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        DataViewController dataViewController = fxmlLoader.getController();
        dataViewController.dataView(dataPakageTable.getSelectionModel().getSelectedItem());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Data View");

        stage.show();
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


    // Text Field
    // Lable Output
    // Combox
    // Radio Button
    // Check Box

    // Create Model Class

    // Table View
    // Date Picker



}
