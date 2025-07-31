package com.example.sceneswitchingtest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class FirstController
{
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void loadFxmlInDiffrentStage(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        SecondController secondController = fxmlLoader.getController();
        secondController.reciveData(new Student(nameTextField.getText()));



        Stage stage = new Stage();

        stage.setScene(scene);
        stage.setTitle("Scene 2");
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadSceneinSameStageOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("second.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        SecondController secondController = fxmlLoader.getController();
        secondController.reciveData(new Student(nameTextField.getText()));



        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}