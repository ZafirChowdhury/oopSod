package com.example.buttonpresstoiable;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController
{
    @javafx.fxml.FXML
    private TextField nameTextFiled;
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void helloButtonOnClick(ActionEvent actionEvent) {
        // Take user input
        String userName = nameTextFiled.getText();

        // Show output
        outputLable.setText("Hello " + userName);
        return;
    }
}