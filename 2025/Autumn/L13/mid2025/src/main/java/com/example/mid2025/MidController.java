package com.example.mid2025;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MidController
{
    @javafx.fxml.FXML
    private ComboBox<String> combox;
    @javafx.fxml.FXML
    private Button buttonOnClick;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> c1Col;
    @javafx.fxml.FXML
    private TableColumn<CourseOutline, String> c2Col;
    @javafx.fxml.FXML
    private TableView<CourseOutline> table;

    @javafx.fxml.FXML
    public void initialize() {
        combox.getItems().setAll("");

        //
    }

    // objList;

    @javafx.fxml.FXML
    public void add(ActionEvent actionEvent) {
        // non validated inputs

        // val
        // return;

        // make obj
        // add to arrayList
        // show to table
    }
}