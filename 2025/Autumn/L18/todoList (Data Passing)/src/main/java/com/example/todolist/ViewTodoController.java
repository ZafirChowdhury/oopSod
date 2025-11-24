package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewTodoController
{
    @javafx.fxml.FXML
    private Label titleLable;
    @javafx.fxml.FXML
    private Label descriptionLable;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void backButtonOnClick(ActionEvent actionEvent) throws IOException {
        // Load fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addTodo.fxml"));

        // Create Scene
        Scene scene = new Scene(fxmlLoader.load());

        // Get Stage
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Set scene to stage
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    Todo ricivedTodo;
    public void passData(Todo todo) {
        ricivedTodo = todo;

        titleLable.setText(ricivedTodo.getTitle());
        descriptionLable.setText(ricivedTodo.getDescription());
    }
}