package com.example.arraylist;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class CheckBoxController
{
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private CheckBox yesCheckBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonOnClick(ActionEvent actionEvent) {
        // yesCheckBox.isSelected();
        // True --> if the checkbox is selected
        // False --> if the checkbox is not selected

        if (yesCheckBox.isSelected()) {
            outputLable.setText("YES!");
        } else {
            outputLable.setText("NO!");
        }

    }
}