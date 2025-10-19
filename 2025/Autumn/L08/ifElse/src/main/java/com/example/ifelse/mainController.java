package com.example.ifelse;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mainController
{
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TextField numberTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonOnClick(ActionEvent actionEvent) {
       int number = Integer.parseInt(numberTextField.getText());

        // number divisible by 2 -> Even
        // not divisible by 2 -> odd
        // %

        if (number == 0) {
            outputLable.setText(number + " is a Even Number");
        } else if ((number % 2) == 0) {
            outputLable.setText(number + " is a Even Number");
        } else {
            outputLable.setText(number + " is Odd Number");
        }
    }
}