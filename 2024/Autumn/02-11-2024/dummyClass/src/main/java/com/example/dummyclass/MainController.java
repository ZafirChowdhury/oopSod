package com.example.dummyclass;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TableColumn<DummyStudent, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<DummyStudent, String> creditCol;
    @javafx.fxml.FXML
    private TableColumn<DummyStudent, String> stuCol;
    @javafx.fxml.FXML
    private TableView<DummyStudent> table;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("cId"));
        creditCol.setCellValueFactory(new PropertyValueFactory<>("cc"));
        stuCol.setCellValueFactory(new PropertyValueFactory<>("stuId"));
    }

    @javafx.fxml.FXML
    public void showData(ActionEvent actionEvent) {
        ArrayList<Student> stuList = new ArrayList<>();
        Student stu1 = new Student("211", "CSE101");
        Student stu2 = new Student("222", "CSE101");
        stuList.add(stu1);
        stuList.add(stu2);


        ArrayList<Course> courseList = new ArrayList<>();
        Course c1 = new Course("CSE101", "3");
        courseList.add(c1);

        ArrayList<DummyStudent> dummyList = new ArrayList<>();
        for (Student s : stuList) {
            String creditCout = "";
            for (Course c : courseList) {
                if (s.getCourseId().equals(c.getCourseId())){
                    creditCout = c.getCreditCount();
                }
            }
            DummyStudent ds = new DummyStudent(s.getId(), creditCout, s.getCourseId());
            dummyList.add(ds);
            System.out.println(ds.toString());
        }

        table.getItems().addAll(dummyList);
    }
}