package com.example.courseoutlinemid;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseoutlineController
{
    @javafx.fxml.FXML
    private ComboBox<String> semesterComboBox;
    @javafx.fxml.FXML
    private TextField filterByNoOfCreditsTextField;
    @javafx.fxml.FXML
    private TextField yearTextField;
    @javafx.fxml.FXML
    private ComboBox<String> preR2ComboBox;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline,String> courseTitleTableColumn;
    @javafx.fxml.FXML
    private TableView<CourseOutline> courseOutlineTableView;
    @javafx.fxml.FXML
    private TextField courseIdTextFiled;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline,String> semesterTableColumn;
    @javafx.fxml.FXML
    private Label showSemesterWiseCourseCountLabel;
    @javafx.fxml.FXML
    private TextField noOfCreditsTextField;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline,Integer> yearTableColumn;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline,String> courseIdTableColumn;
    @javafx.fxml.FXML
    private TextField courseTitleTextField;
    @javafx.fxml.FXML
    private ComboBox<String> preR1ComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> preRComboBox;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline,Integer> noOfCreditsTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> filterBySEmesterComboBox;

    @javafx.fxml.FXML
    public void initialize() {
        semesterComboBox.getItems().addAll("Spring","Autumn","Summer");
        filterBySEmesterComboBox.getItems().addAll("Spring","Autumn","Summer");
        preR1ComboBox.getItems().addAll("None","CSC101","CSE203","CSE211","CSE213");
        preR2ComboBox.getItems().addAll("None","CSC101","CSE203","CSE211","CSE213");
        preRComboBox.getItems().addAll("None","CSC101","CSE203","CSE211","CSE213");

        courseIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        courseTitleTableColumn.setCellValueFactory(new PropertyValueFactory<>("courseTitle"));
        noOfCreditsTableColumn.setCellValueFactory(new PropertyValueFactory<>("noOfCredits"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        semesterTableColumn.setCellValueFactory(new PropertyValueFactory<>("semester"));

    }

    ArrayList<CourseOutline> outlineList = new ArrayList<CourseOutline>();
    /*
    @javafx.fxml.FXML
    public void filterandLoadTableButton(ActionEvent actionEvent) {
        for (CourseOutline i : outlineList) {
            if (filterBySEmesterComboBox.getValue().equals(i.getSemester())&&
                    Integer.parseInt(noOfCreditsTextField.getText()==i.getNoOfCredits()){
                courseOutlineTableView.getItems().addAll(i);
                        
            }
        }



    }

     */

    @javafx.fxml.FXML
    public void showSemesterWiseCourseOutlineButton(ActionEvent actionEvent) {
        // "Spring","Autumn","Summer"
        int summerCount = 0;
        int autumnCount = 0;
        int springCount = 0;

        for (CourseOutline co: courseOutlineTableView.getItems()) {
            if (co.getSemester().equals("Summer")) summerCount++;
            if (co.getSemester().equals("Autumn")) autumnCount++;
            if (co.getSemester().equals("Spring")) springCount++;
        }

        showSemesterWiseCourseCountLabel.setText("Summer: " + summerCount + "\n" + "Autmn: " + autumnCount + "\n" + "Spring: " + springCount);
    }

    @javafx.fxml.FXML
    public void validateAndAddNewCourseOutlineButton(ActionEvent actionEvent) {
        if (!preRComboBox.getValue().equals("None") &&
                preR2ComboBox.getValue().equals("None") && preR2ComboBox.getValue().equals("None")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("If preR3 isn't None, preR1 and preR2 cant be None");
        }

        if (preR1ComboBox.getValue().equals("None")&&
                !preR2ComboBox.getValue().equals("None")&& !preRComboBox.getValue().equals("None")){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("If preR1 is None, preR2 and preR3 cant be None");
        }

        if (Integer.parseInt(yearTextField.getText())> LocalDate.now().getYear()){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Year cant be future");
        }

        CourseOutline co = new CourseOutline(

                courseIdTextFiled.getText(),
                courseTitleTextField.getText(),
                preR1ComboBox.getValue(),
                preR2ComboBox.getValue(),
                preRComboBox.getValue(),
                Integer.parseInt(noOfCreditsTextField.getText()),
                Integer.parseInt(yearTextField.getText()),
                semesterComboBox.getValue(),
                descriptionTextArea.getText()

        );
        outlineList.add(co);
    }

    @javafx.fxml.FXML
    public void filterandLoadTableButton(ActionEvent actionEvent) {
        courseOutlineTableView.getItems().clear();
        courseOutlineTableView.getItems().addAll(outlineList);
    }
}