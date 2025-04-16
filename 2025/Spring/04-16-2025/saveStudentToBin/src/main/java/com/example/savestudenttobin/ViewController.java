package com.example.savestudenttobin;

import javafx.scene.control.Label;

public class ViewController
{
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void dataPassing(Student s) {
        outputLable.setText(s.toString());
    }
}