package com.example.sumsubmutidiv;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController
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

        if (y == 0) {
            outputLable.setText("Cannot be devided by zero");

        } else {
            outputLable.setText("Div: " + (x / y));
        }
    }

    @javafx.fxml.FXML
    public void subButtonOnClick(ActionEvent actionEvent) {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        outputLable.setText("Sub: " + (x - y));
    }

    @javafx.fxml.FXML
    public void multiButtonOnClick(ActionEvent actionEvent) {
        outputLable.setText("Multi: " + (Integer.parseInt(xTextField.getText())) * (Integer.parseInt(yTextField.getText())));
    }

    @javafx.fxml.FXML
    public void sumButtonOnClick(ActionEvent actionEvent) {
        int x;
        int y;
        int result;

        x = Integer.parseInt(xTextField.getText());
        y = Integer.parseInt(yTextField.getText());

        result = x + y;

        outputLable.setText("Sum: "+ result);
    }
}