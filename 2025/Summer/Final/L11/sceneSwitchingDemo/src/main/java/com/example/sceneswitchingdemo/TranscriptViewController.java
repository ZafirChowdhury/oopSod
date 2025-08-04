package com.example.sceneswitchingdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TranscriptViewController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("studentDashbord.fxml"));

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
}