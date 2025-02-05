package com.example.au23;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MidController
{
    @javafx.fxml.FXML
    private TableColumn<Product, Integer> qunCol;
    @javafx.fxml.FXML
    private TableColumn<Product, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Product, String> nameCol;
    @javafx.fxml.FXML
    private TableView<Product> productTable;
    @javafx.fxml.FXML
    private TableColumn<Product, String> matCol;
    @javafx.fxml.FXML
    private TextField producntNameTextField;
    @javafx.fxml.FXML
    private TextField productIdTextField;
    @javafx.fxml.FXML
    private ComboBox<String> materialComboBox;
    @javafx.fxml.FXML
    private ComboBox<Integer> quntityComboBox;
    @javafx.fxml.FXML
    private DatePicker deliveryDatePicker;
    @javafx.fxml.FXML
    private Label errorMassageLable;

    @javafx.fxml.FXML
    public void initialize() {
        // ComboBox
        materialComboBox.getItems().addAll("Wood", "Metal", "Board", "Cloth", "Other");
        quntityComboBox.getItems().addAll(1, 2, 3, 4, 5);

        // TableView
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        matCol.setCellValueFactory(new PropertyValueFactory<>("material"));
        qunCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
    }

    ArrayList<Product> itemList = new ArrayList<>();

    @javafx.fxml.FXML
    public void addProduct(ActionEvent actionEvent) {
        // Validation
        errorMassageLable.setText("");

        // Name
        if (producntNameTextField.getText().isEmpty()) {
            errorMassageLable.setText("Product name cannot be empty");
            return;
        }

        // ID
        if (productIdTextField.getText().isEmpty()) {
            errorMassageLable.setText("Product ID cannot be empty");
            return;
        }

        for (Product item : itemList) {
            if (item.getId().equals(productIdTextField.getText()))
            {
                errorMassageLable.setText("Prodect ID cannot be duplicate");
                return;
            }
        }

        // Material
        if (materialComboBox.getSelectionModel().getSelectedItem() == null) {
            errorMassageLable.setText("Please select a meterial");
            return;
        }

        // Quentity
        if (quntityComboBox.getSelectionModel().getSelectedItem() == null) {
            errorMassageLable.setText("Please select quentity");
            return;
        }

        // DatePicker
        if (deliveryDatePicker.getValue() == null) {
            errorMassageLable.setText("Please Select a date");
            return;
        }

        if (deliveryDatePicker.getValue().isBefore(LocalDate.now())) {
            errorMassageLable.setText("Date cannnot be set in past");
            return;
        }



        String productName = producntNameTextField.getText();
        String productId = productIdTextField.getText();
        String productMaterial = materialComboBox.getValue();
        int productQuqntity = quntityComboBox.getValue();
        LocalDate producntDeliveryDate = deliveryDatePicker.getValue();

        Product item = new Product(productName, producntDeliveryDate, productQuqntity, productMaterial, productId);
        itemList.add(item);

        // Showing Data On Table
        productTable.getItems().clear();
        productTable.getItems().addAll(itemList);
    }
}