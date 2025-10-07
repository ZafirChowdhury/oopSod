package com.example.studentobj;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class mainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label outputlable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonOnClick(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String name = nameTextField.getText();

        Student student = new Student();
        student.setId(id);
        student.name = name;

        student.setId("123");

        outputlable.setText("ID: " + student.getId() + " Name: " + student.name);
    }
}