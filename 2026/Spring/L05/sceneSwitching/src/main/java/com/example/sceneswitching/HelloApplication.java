package com.example.sceneswitching;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // load
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1.fxml"));

        // scene
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Hello!");

        // stage
        stage.setScene(scene);

        stage.show();
    }
}
