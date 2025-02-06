package com.example.basiccalculation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class MyController
{
    @javafx.fxml.FXML
    private TextField xTextField;
    @javafx.fxml.FXML
    private TextField yTextField;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addButtonOnMouseClick(MouseEvent event) {

        String xStr = xTextField.getText();
       String yStr = yTextField.getText();

       int xVal = Integer.parseInt(xStr);
       int yVal = Integer.parseInt(yStr);

       int sum = xVal + yVal;

       String sumStr = Integer.toString(sum);

       resultLabel.setText(sumStr);


    }
}