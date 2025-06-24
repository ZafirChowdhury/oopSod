package com.example.arraylist;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxContoller
{
    @javafx.fxml.FXML
    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
        majorComboBox.getItems().addAll("CS", "CSE", "BBA", "MIS", "ENV", "EEE");
    }

    @javafx.fxml.FXML
    public void showMajorOnClick(ActionEvent actionEvent) {
        // Checking if user has selected an item or not
        if (majorComboBox.getSelectionModel().getSelectedItem() == null) {
            outputLable.setText("Please select a major");
            return;
        }

        String major = majorComboBox.getValue();
        outputLable.setText(major);
    }

    @javafx.fxml.FXML
    public void majorComboBoxSelected(ActionEvent actionEvent) {
        outputLable.setText(majorComboBox.getValue());
    }
}