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

        Student newStudent = new Student(name, id);

        newStudent.setName("Adhora");

        outputlable.setText("Hello, " + newStudent.getName() + "Your id is: " + newStudent.getId());
    }
}