package com.example.studentobject;

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
    public void showOutputOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String idStr = idTextField.getText();

        int id = Integer.parseInt(idStr);

        // Class Handel // No splace taken in memory
        Student newStudent;

        // Class Instance
        // Named instance
        newStudent = new Student(id, name);

        // Class Instance
        // Student newStudent = new Student(id, name);

        outputLable.setText("Output: " + "Hello " + newStudent.getName() + " " + "your id is: " + newStudent.getId());

        // Anonymous instance
        System.out.println( new Student(2, "Anonymous ") );

    }
}