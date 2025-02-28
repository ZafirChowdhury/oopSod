package com.example.datetime;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainController
{
    @javafx.fxml.FXML
    private DatePicker datePicker;

    @javafx.fxml.FXML
    private TextField hourTextField;
    @javafx.fxml.FXML
    private TextField minTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showDate(ActionEvent actionEvent) {
        String date = datePicker.getValue().toString();

        String time = "T" + hourTextField.getText() + ":" + minTextField.getText() + ":00";

        LocalDateTime dt = LocalDateTime.parse(date + time);

        System.out.println(dt);
        System.out.println(dt.getDayOfWeek());
    }
}