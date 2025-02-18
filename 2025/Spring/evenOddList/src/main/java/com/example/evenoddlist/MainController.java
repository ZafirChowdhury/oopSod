package com.example.evenoddlist;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TextField numberTextField;
    @javafx.fxml.FXML
    private TextArea outputTextArea;

    @javafx.fxml.FXML
    public void initialize() {
    }

    // Global
    ArrayList<Integer> numbers = new ArrayList<>();
    ArrayList<Integer> evenNumber = new ArrayList<>();
    ArrayList<Integer> oddNumber = new ArrayList<>();


    @javafx.fxml.FXML
    public void addNumberOnClick(ActionEvent actionEvent) {
        int number = Integer.parseInt(numberTextField.getText());

        numbers.add(number);

        numberTextField.clear();
    }

    @javafx.fxml.FXML
    public void filterOnClick(ActionEvent actionEvent) {
        // for number in numbers:
        // for each loop
        for (Integer number : numbers) {
            if ((number % 2) == 0) {
                evenNumber.add(number);
            } else {
                oddNumber.add(number);
            }
        }


        outputTextArea.setText("Number : " + numbers.toString() + "\n"
                + "Even : " + evenNumber.toString() + "\n"
                + "Odd : " + oddNumber.toString());
    }
}