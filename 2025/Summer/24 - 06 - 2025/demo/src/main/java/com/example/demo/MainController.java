package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private ToggleGroup genderToggleGroup;
    @javafx.fxml.FXML
    private CheckBox hasSchorshipCheckbox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML
    private RadioButton otherRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;

    @javafx.fxml.FXML
    public void initialize() {
        // ComboBox
        majorComboBox.getItems().addAll("CS", "CSE", "BBA", "MIS");
    }

    @javafx.fxml.FXML
    public void showDataButtonOnClick(ActionEvent actionEvent) {
        if (idTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter proper ID, ID cant be empty");
            return;
        }

        if (nameTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter proper name, Name cant be empty");
            return;
        }

        String id = idTextField.getText();
        String name = nameTextField.getText();

        if (majorComboBox.getSelectionModel().getSelectedItem() == null) {
            outputLable.setText("Please select a major");
            return;
        }

        String major = majorComboBox.getValue();

        String gender;
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (otherRadioButton.isSelected()) {
            gender = "Other";
        } else {
            outputLable.setText("Please select an gender!");
            return;
        }

        boolean hasScolarship;
        if (hasSchorshipCheckbox.isSelected()) {
            hasScolarship = true;
        } else {
            hasScolarship = false;
        }

        Student s = new Student(id, name, major, gender, hasScolarship);
        outputLable.setText(s.toString());

    }
}