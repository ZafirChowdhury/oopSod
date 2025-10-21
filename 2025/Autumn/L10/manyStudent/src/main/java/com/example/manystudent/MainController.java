package com.example.manystudent;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField filterIdTextField;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TextField nameTextFIeld;

    @javafx.fxml.FXML
    public void initialize() {
    }

    ArrayList<Student> studentList = new ArrayList<>();

    @javafx.fxml.FXML
    public void addButtonOnClick(ActionEvent actionEvent) {
        // idTextField -> String
        // nameTextField -> String

        //String c = idTextField.getText();
        // int id = Integer.parseInt(idString);

        // Take user input
        int id = Integer.parseInt(idTextField.getText());
        String name = nameTextFIeld.getText();

        // Make new object
        Student student = new Student(id, name);


        // Add it to the arrayList
        studentList.add(student);

        // Clear user input fields
        idTextField.clear();
        nameTextFIeld.clear();

        //studentList.add(new Student(
        //        Integer.parseInt(idTextField.getText()),
        //        nameTextFIeld.getText()
        //));
    }

    @javafx.fxml.FXML
    public void findButtonOnCllick(ActionEvent actionEvent) {
        int id = Integer.parseInt(filterIdTextField.getText());

        for (Student student: studentList) {
            if (id == student.getId()) {
                outputLable.setText(student.toString());
                return;
            }
        }

        outputLable.setText("ID not Found");
    }

    @javafx.fxml.FXML
    public void showAllButtonOnClick(ActionEvent actionEvent) {
        String output = "";

        for (Student student: studentList) {
            output = output + student.toString() + "\n";
        }

        outputLable.setText(output);
    }
}