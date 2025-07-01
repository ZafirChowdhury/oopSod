package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private ToggleGroup genderToggleGroup;
    @javafx.fxml.FXML
    private CheckBox hasSchorshipCheckbox;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private ComboBox<String> majorComboBox;
    @javafx.fxml.FXML
    private RadioButton otherRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    private TableView<Student> studentTable;

    @javafx.fxml.FXML
    private TableColumn<Student, String> majorCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> genderCol;
    @javafx.fxml.FXML
    private TableColumn<Student, Boolean> scolarshipCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private ComboBox<String> majorFilterComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> filterMajorComboBox2;
    @javafx.fxml.FXML
    private ComboBox<String> filterGenderComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        // ComboBox
        majorComboBox.getItems().addAll("CS", "CSE", "BBA", "MIS");

        majorFilterComboBox.getItems().addAll("CS", "CSE", "BBA", "MIS");

        filterMajorComboBox2.getItems().addAll("CS", "CSE", "BBA", "MIS");
        filterGenderComboBox.getItems().addAll("Male", "Female", "Other");

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        majorCol.setCellValueFactory(new PropertyValueFactory<>("major"));
        genderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        scolarshipCol.setCellValueFactory(new PropertyValueFactory<>("hasScolarship"));
    }

    ArrayList<Student> studentList = new ArrayList();

    @javafx.fxml.FXML
    public void viewStudentDataOnTableViewOnClick(ActionEvent actionEvent) {
        studentTable.getItems().clear();
        studentTable.getItems().addAll(studentList);

    }

    @javafx.fxml.FXML
    public void saveStudentToArrayListOnClick(ActionEvent actionEvent) {
        if (idTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter proper ID, ID cant be empty");
            return;
        }

        if (nameTextField.getText().trim().isEmpty()) {
            outputLable.setText("Please enter proper name, Name cant be empty");
            return;
        }

        String id = idTextField.getText();
        String name = nameTextField.getText();

        if (majorComboBox.getSelectionModel().getSelectedItem() == null) {
            outputLable.setText("Please select a major");
            return;
        }

        String major = majorComboBox.getValue();

        String gender;
        if (maleRadioButton.isSelected()) {
            gender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            gender = "Female";
        } else if (otherRadioButton.isSelected()) {
            gender = "Other";
        } else {
            outputLable.setText("Please select an gender!");
            return;
        }

        boolean hasScholarship;
        if (hasSchorshipCheckbox.isSelected()) {
            hasScholarship = true;
        } else {
            hasScholarship = false;
        }

        Student s = new Student(id, name, major, gender, hasScholarship);

        studentList.add(s);
    }

    @javafx.fxml.FXML
    public void filterByMajorComboBox(ActionEvent actionEvent) {
        ArrayList<Student> filteredStudents = new ArrayList<>();

        String filterMajor = majorFilterComboBox.getValue();

        for (Student s : studentList) {
            if (s.getMajor().equals(filterMajor)) {
                filteredStudents.add(s);
            }
        }

        studentTable.getItems().clear();
        studentTable.getItems().addAll(filteredStudents);
    }

    @javafx.fxml.FXML
    public void filterByMajorAndGenderOnClick(ActionEvent actionEvent) {
        ArrayList<Student> filteredStudents = new ArrayList<>();

        String filterMajor = filterMajorComboBox2.getValue();
        String filterGender = filterGenderComboBox.getValue();

        for (Student s : studentList) {
            if ((s.getMajor().equals(filterMajor)) && (s.getGender().equals(filterGender))) {
                filteredStudents.add(s);
            }
        }

        studentTable.getItems().clear();
        studentTable.getItems().addAll(filteredStudents);
    }
}
