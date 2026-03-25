package com.example.sceneswitching;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class dataPassingDemoScene2Controller
{
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        // load fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dataPasssingDemoScene1.fxml"));

        // load scene
        Scene scene = new Scene(fxmlLoader.load());

        // load current stage
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    Student student;
    public void reciveData(Student incomingStudent) {
        student = incomingStudent;
    }


    @javafx.fxml.FXML
    public void showDataOnClick(ActionEvent actionEvent) {
        outputLable.setText("Hello, " + student.getName());
    }
}
