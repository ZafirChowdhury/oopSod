package com.example.aretmeticops;

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
    private Label lable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addOnClick(ActionEvent actionEvent) {
        int x;
        int y;

        x = Integer.parseInt(xTextField.getText());
        y = Integer.parseInt(yTextField.getText());

        // Integer.parseInt("3");
        // Float.parseFloat("3.3");

        // 3 + "" = "3"
        // 3.3 + "" = "3.3"

        //5 + 6 + ""  = "56"

        int output = x + y;

        lable.setText("+");
        outputLable.setText("= " + output);
    }

    @javafx.fxml.FXML
    public void subOnClick(ActionEvent actionEvent) {
        lable.setText("-");
        outputLable.setText("=" + (Integer.parseInt(xTextField.getText()) - Integer.parseInt(yTextField.getText())));
    }

    @javafx.fxml.FXML
    public void multiOnClick(ActionEvent actionEvent) {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        int output = x * y;
        lable.setText("X");
        outputLable.setText("= " + output);
    }

    @javafx.fxml.FXML
    public void divOnClick(ActionEvent actionEvent) {
        int x = Integer.parseInt(xTextField.getText());
        int y = Integer.parseInt(yTextField.getText());

        if (y == 0) {
            outputLable.setText("Cant devide by zero!");
        }

        int output = x / y;
        lable.setText("/");
        outputLable.setText("= " + output);
    }
}