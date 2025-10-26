package com.example.forloop;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mainController
{
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TextField startTextField;
    @javafx.fxml.FXML
    private TextField endTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void evenOnClick(ActionEvent actionEvent) {
        int start = Integer.parseInt(startTextField.getText());
        int end = Integer.parseInt(endTextField.getText());

        String output = "";
        for (int i = start; i <= end; i++) {
            if ((i % 2) == 0) {
                output = output + i + " ";
            }
        }

        outputLable.setText(output);
    }

    @javafx.fxml.FXML
    public void oddOnClick(ActionEvent actionEvent) {
        int start = Integer.parseInt(startTextField.getText());
        int end = Integer.parseInt(endTextField.getText());

        String output = "";
        int i = start;
        while (i <= end) {

            if ((i % 2) != 0) {
                output = output + i + " ";
            }

            i++;
        }

        outputLable.setText(output);
    }
}
