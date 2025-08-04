package com.example.sceneswitchingdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController
{
    @javafx.fxml.FXML
    private PasswordField passwordField;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private Label outputLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    Student student = new Student("Zafir", "0191");

    @javafx.fxml.FXML
    public void loginButtonOnCick(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (username.equals(student.getUsername()) && password.equals(student.getPassword())) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("studentDashbord.fxml"));

            Scene scene = new Scene(fxmlLoader.load());

            // fxmlLoader.load("studentDashbord.fxml") -> studentDashbord.fxml
            // fxmlLoader.load("studentDashbord.fxml").getController() -> StudentDashbordController

            StudentDashbordController studentDashbordController = fxmlLoader.getController();
            studentDashbordController.dataTransfer(student);

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);

            stage.show();
        } else {
            outputLable.setText("Username and passowrd dose not match");
        }
    }
}