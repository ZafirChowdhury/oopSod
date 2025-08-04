package com.example.sceneswitchingdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentDashbordController
{
    @javafx.fxml.FXML
    private Label studentInfoLable;

    Student student;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showTranscriptOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("transcriptView.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        // actionEvent = buttonClick
        // actionEvent.getSource() = button
        // (Node) actionEvent.getSource() = Node
        // (Node) actionEvent.getSource().getScene() = Scene
        // ((Node) actionEvent.getSource()).getScene().getWindow() = Window
        // (Stage) ((Node) actionEvent.getSource()).getScene().getWindow() = Stage

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);

        stage.show();
    }

    @javafx.fxml.FXML
    public void registarationButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registarationView.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        // actionEvent = buttonClick
        // actionEvent.getSource() = button
        // (Node) actionEvent.getSource() = Node
        // (Node) actionEvent.getSource().getScene() = Scene
        // ((Node) actionEvent.getSource()).getScene().getWindow() = Window
        // (Stage) ((Node) actionEvent.getSource()).getScene().getWindow() = Stage

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);

        stage.show();
    }

    public void dataTransfer(Student student) {
        this.student = student;
        studentInfoLable.setText(student.toString());
    }

    public void test(){

    }
}