package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label nameOutputLable;
    @javafx.fxml.FXML
    private Label idOutputLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showUserData(ActionEvent actionEvent) {
        String id;
        String name;

        id = idTextField.getText();
        name = nameTextField.getText();

        nameOutputLable.setText("Hello " + name + "!");
        idOutputLable.setText("Your id is: " + id);

    }
}