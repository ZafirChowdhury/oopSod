package com.example.sceneswitching;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class scene1Controller
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void showScene2OnClick(ActionEvent actionEvent) throws IOException {
        // load fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));

        // load scene
        Scene scene = new Scene(fxmlLoader.load());

        // set scene to stage
        Stage stage = new Stage();
        stage.setScene(scene);

        // show stage
        stage.show();
    }

    @javafx.fxml.FXML
    public void showScene2InThisStageOnAction(ActionEvent actionEvent) throws IOException {
        // load fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene2.fxml"));

        // load scene
        Scene scene = new Scene(fxmlLoader.load());

        // load current stage
        // actionEvent == button press
        // actionEvent.getSource() == button
        // (Node) actionEvent.getSource() == Node (Button)
        // ((Node) actionEvent.getSource()).getScene() == "scene1.fxml"
        // ((Node) actionEvent.getSource()).getScene().getWindow() == "Window"

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}