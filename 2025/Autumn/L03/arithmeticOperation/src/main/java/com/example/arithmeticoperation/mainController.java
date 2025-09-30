package com.example.arithmeticoperation;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mainController
{
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TextField xTextField;
    @javafx.fxml.FXML
    private TextField yTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void divButtonOnClick(ActionEvent actionEvent) {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        int result = x / y;

        outputLable.setText("Div: " + result);
    }

    @javafx.fxml.FXML
    public void subButtonOnClick(ActionEvent actionEvent) {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        int result = x - y;

        outputLable.setText("Sub: " + result);
    }

    @javafx.fxml.FXML
    public void sumButtonOnClick(ActionEvent actionEvent) {
        // Integer.parseInt("2");

        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        int result = x + y;

        outputLable.setText("Sum: " + result);
    }

    @javafx.fxml.FXML
    public void multiButtonOnlick(ActionEvent actionEvent) {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        int result = x * y;

        outputLable.setText("Multi: " + result);
    }
}