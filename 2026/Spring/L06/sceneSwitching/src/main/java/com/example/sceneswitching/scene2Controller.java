package com.example.sceneswitching;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class scene2Controller
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        // load fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene1.fxml"));

        // load scene
        Scene scene = new Scene(fxmlLoader.load());

        // load current stage
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}