package com.example.sceneswitching;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class    dataPassingDemoScene1Controller
{
    @javafx.fxml.FXML
    private TextField nameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void sayHelloInScene2OnClick(ActionEvent actionEvent) throws IOException {
        // load the fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dataPassingDemoScene2.fxml"));

        // load scene
        Scene scene = new Scene(fxmlLoader.load());

        // call the controller
        dataPassingDemoScene2Controller scene2Controller = fxmlLoader.getController();
        scene2Controller.reciveData(new Student(nameTextField.getText()));

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}