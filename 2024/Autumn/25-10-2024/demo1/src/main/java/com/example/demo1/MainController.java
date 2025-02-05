package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    private RadioButton otherRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;
    @javafx.fxml.FXML
    private ToggleGroup genderRadioButtonToggle;
    @javafx.fxml.FXML
    private CheckBox scolarshipCheckBOx;
    @javafx.fxml.FXML
    private Label genderLable;
    @javafx.fxml.FXML
    private Label scolarsipLable;
    @javafx.fxml.FXML
    private Label majorLable;
    @javafx.fxml.FXML
    private ComboBox majorComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        majorComboBox.getItems().addAll("CSE", "CS", "BBA");
    }

    Student stu;

    @javafx.fxml.FXML
    public void saveStudentOnClick(ActionEvent actionEvent) {
        // Save Student
        String studentName = nameTextField.getText();
        int studentId = Integer.parseInt(idTextField.getText());

        // Gender
        String studentGender;
        if (maleRadioButton.isSelected()) {
            studentGender = "Male";
        } else if (femaleRadioButton.isSelected()) {
            studentGender = "Female";
        } else {
            studentGender = "Other";
        }

        // Scolarship
        boolean hasScolarship = false;
        if (scolarshipCheckBOx.isSelected()) {
           hasScolarship = true;
        }

        // Major
        String major = (String) majorComboBox.getValue();

        stu = new Student(studentName, studentId, studentGender, hasScolarship, major);



        // Clearing Fields TODO
    }

    @javafx.fxml.FXML
    public void showStudentOnClick(ActionEvent actionEvent) {
        // Show Student
        nameLabel.setText(stu.getName());
        idLabel.setText(Integer.toString(stu.getId()));

        genderLable.setText(stu.getGender());

        // Scholarsip Lable
        String hasSclarshipOutput = "No";
        if (stu.isHasScolarship()) {
            hasSclarshipOutput = "Yes";
        }

        // Major
        majorLable.setText(stu.getMajor());

        scolarsipLable.setText(hasSclarshipOutput);

    }
}
