package com.example.arraylist;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RadioButtonController
{
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private RadioButton radiobuttonOptionB;
    @javafx.fxml.FXML
    private RadioButton radioButtonOptionC;
    @javafx.fxml.FXML
    private RadioButton radioButtonOptionA;
    @javafx.fxml.FXML
    private ToggleGroup groupA;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonOnCick(ActionEvent actionEvent) {
        if (radioButtonOptionA.isSelected()) {
            outputLable.setText("User has selected option A");
        } else if (radiobuttonOptionB.isSelected()) {
            outputLable.setText("User has selected option B");
        } else if (radioButtonOptionC.isSelected()) {
            outputLable.setText("User has selected option C");
        } else {
            outputLable.setText("Please select and option");
        }
    }
}