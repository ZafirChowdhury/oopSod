package com.example.newwindowstest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void openScene2inStage2COnClick(ActionEvent actionEvent) throws IOException {
        // Load FXML
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));

        // Create Scene from FXML
        Scene scene = new Scene(fxmlLoader.load());

        // Passing data
        Scene2Controller scene2Controller = fxmlLoader.getController();
        scene2Controller.passData(new Student("Zafir"));

        // Get the existing stage
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Node button = (Node) actionEvent.getSource();
        // Scene oldScene = button.getScene();
        // Stage stage = (Stage) oldScene.getWindow();

        // Set scene to stage
        stage.setScene(scene);

        // Show the Stage
        stage.show();
    }
}