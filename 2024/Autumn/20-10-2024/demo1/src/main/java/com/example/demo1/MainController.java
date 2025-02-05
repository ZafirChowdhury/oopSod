package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController
{
    @javafx.fxml.FXML
    private Label idLabel;
    @javafx.fxml.FXML
    private Label nameLabel;
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void buttonOnClick(ActionEvent actionEvent) {
        String studentName = nameTextField.getText();
        int studentId = Integer.parseInt(idTextField.getText());

        Student student1 = new Student(studentName, studentId);

        nameLabel.setText(student1.getName());
        idLabel.setText(Integer.toString(student1.getId()));

    }
}
