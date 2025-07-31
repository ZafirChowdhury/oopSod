package com.example.sceneswitchingtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SecondController
{

    Student student;
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
        outputLable.setText(student.toString());
    }

    @javafx.fxml.FXML
    public void backuttonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("first.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

    public void reciveData(Student student) {
        student = student;
    }
}