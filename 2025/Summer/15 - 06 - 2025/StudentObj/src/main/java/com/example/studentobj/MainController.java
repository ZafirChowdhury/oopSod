package com.example.studentobj;

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
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createObjectShowDataButton(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String name = nameTextField.getText();

        Student s = new Student(id);

        s.setName(name);

        s.setName("Adhora");

        outputLable.setText("Hello " + s.getName() + " your id is: " + s.getId());
    }
}