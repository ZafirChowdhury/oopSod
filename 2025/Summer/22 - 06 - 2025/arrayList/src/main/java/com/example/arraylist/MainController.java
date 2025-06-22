package com.example.arraylist;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Objects;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField majorTextField;

    @javafx.fxml.FXML
    public void initialize() {

    }

    ArrayList<Student> listOfStudents = new ArrayList<>();
    ArrayList<Student> fillteredListOfStudents = new ArrayList<>();


    @javafx.fxml.FXML
    public void addStudentToArrayList(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String name = nameTextField.getText();
        String major = majorTextField.getText();

        Student newStudent = new Student(id, name, major);

        listOfStudents.add(newStudent);

        idTextField.clear();
        nameTextField.clear();
        majorTextField.clear();
    }

    @javafx.fxml.FXML
    public void printAllStudentsFromArrayList(ActionEvent actionEvent) {
        for (Student s : listOfStudents) {
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("Major: " + s.getMajor());
        }
    }

    @javafx.fxml.FXML
    public void showOnlyMajorStudentsOnClick(ActionEvent actionEvent) {
        for (Student s : listOfStudents) {
            if (Objects.equals(s.getMajor(), "CSE")) {
                fillteredListOfStudents.add(s);
            }
        }

        for (Student s : fillteredListOfStudents) {
            System.out.println("ID: " + s.getId());
            System.out.println("Name: " + s.getName());
            System.out.println("Major: " + s.getMajor());
        }

    }
}