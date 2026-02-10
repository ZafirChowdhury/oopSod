package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class sayHelloController
{
    @javafx.fxml.FXML
    private Label outputTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void buttonOnClick(ActionEvent actionEvent) {
        // outputTextField.setText("Hello, " + nameTextField.getText());

        // Take input from the user

        String username;
        username = nameTextField.getText();

        // String testUsername = nameTextField.getText();

        // Say hello to the user
        outputTextField.setText("Hello, " + username);
    }
}