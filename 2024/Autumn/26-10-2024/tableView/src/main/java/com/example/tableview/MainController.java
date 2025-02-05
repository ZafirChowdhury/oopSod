package com.example.tableview;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TableColumn<Student, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> majorCol;
    @javafx.fxml.FXML
    private TableView<Student> studentTable;
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> majorFilterComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        majorComboBox.getItems().addAll("CSE", "CS", "BBA", "MIS", "EEE");
        majorFilterComboBox.getItems().addAll("CSE", "CS", "BBA", "MIS", "EEE");

        // Table
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
    }

    // Student List
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Student> filteredStudentList = new ArrayList<>();

    @javafx.fxml.FXML
    public void showStudentDataButtonOnClick(ActionEvent actionEvent) {
        studentTable.getItems().clear();
        studentTable.getItems().setAll(studentList);
    }

    @javafx.fxml.FXML
    public void saveStudentButtonOnClick(ActionEvent actionEvent) {
        String studentName = nameTextField.getText();
        String studentId = idTextField.getText();
        String studentMajor = majorComboBox.getValue();

        Student newStudent = new Student(studentId, studentName, studentMajor);
        studentList.add(newStudent);

        // Debug
        System.out.println(newStudent.toString());

        // Clear
        nameTextField.clear();
        idTextField.clear();
        majorComboBox.valueProperty().set(null);
    }

    @javafx.fxml.FXML
    public void filterBy(ActionEvent actionEvent) {
        String filterBy = majorFilterComboBox.getValue();

        filteredStudentList.clear();
        for (Student s : studentList) {
            
            if (s.getMajor().equals(filterBy)) {
                filteredStudentList.add(s);
            }

        }

        System.out.println(studentTable.toString());
        System.out.println(filteredStudentList.toString());

        studentTable.getItems().clear();
        studentTable.getItems().addAll(filteredStudentList);

    }
}