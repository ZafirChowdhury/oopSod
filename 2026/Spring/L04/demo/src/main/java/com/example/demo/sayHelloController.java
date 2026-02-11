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
    private TextField idTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void buttonOnClick(ActionEvent actionEvent) {
       Student student1 = new Student(nameTextField.getText());

       student1.setId(Integer.parseInt(idTextField.getText()));

       outputTextField.setText("Hello, " + student1.getName());
    }
}