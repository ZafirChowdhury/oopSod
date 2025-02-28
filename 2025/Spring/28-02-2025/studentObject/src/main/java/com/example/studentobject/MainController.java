package com.example.studentobject;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML
    private ToggleGroup genderToggleGroup;
    @javafx.fxml.FXML
    private RadioButton otherRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private CheckBox scholarshipCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
        majorComboBox.getItems().addAll("CSE", "CS", "BBA", "MIS", "EEE");
    }

    @javafx.fxml.FXML
    public void showOutputOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();

        String idStr = idTextField.getText();
        int id = Integer.parseInt(idStr);

        String major = majorComboBox.getValue();

        String gender = "";
        if (maleRadioButton.isSelected()) {
            gender = maleRadioButton.getText();
        } else if (femaleRadioButton.isSelected()) {
            gender = femaleRadioButton.getText();
        } else if (otherRadioButton.isSelected()) {
            gender = otherRadioButton.getText();
        }

        Boolean hasScholarship = scholarshipCheckBox.isSelected();

        Student newStudent = new Student(id, hasScholarship, gender, major, name);
        outputLable.setText(newStudent.toString());

    }
}