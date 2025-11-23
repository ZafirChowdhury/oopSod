package com.example.newwindowstest;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
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

        // Create Stage
        Stage stage = new Stage();

        stage.setTitle("Stage 2");

        // Set scene to stage
        stage.setScene(scene);

        // Show the Stage
        stage.show();
    }
}