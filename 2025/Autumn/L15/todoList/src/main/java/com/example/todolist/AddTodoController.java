package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class AddTodoController
{
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TextField descriptionTextField;
    @javafx.fxml.FXML
    private TableColumn<Todo, String> titleCol;
    @javafx.fxml.FXML
    private TableView<Todo> todoTableView;
    @javafx.fxml.FXML
    private TableColumn<Todo, Boolean> isFInishedCol;
    @javafx.fxml.FXML
    private TableColumn<Todo, String> descriptionCol;

    @javafx.fxml.FXML
    public void initialize() {
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        isFInishedCol.setCellValueFactory(new PropertyValueFactory<>("isFinished"));
    }

    ArrayList<Todo> todoList = new ArrayList<>();

    @javafx.fxml.FXML
    public void addTodoOnClick(ActionEvent actionEvent) {
        if (titleTextField.getText().isBlank()) {
            outputLable.setText("Title cant be empty!");
            return;
        }

        if (descriptionTextField.getText().isBlank()) {
            Todo todo = new Todo(titleTextField.getText());
        }

        Todo todo = new Todo(titleTextField.getText(), descriptionTextField.getText());

        todoList.add(todo);
        outputLable.setText(todo.toString());

        todoTableView.getItems().clear();
        todoTableView.getItems().addAll(todoList);
    }

    @javafx.fxml.FXML
    public void removeButtonCllick(ActionEvent actionEvent) {
        Todo todo = todoTableView.getSelectionModel().getSelectedItem();

        todoList.remove(todo);

        todoTableView.getItems().clear();
        todoTableView.getItems().addAll(todoList);
    }

    @javafx.fxml.FXML
    public void checkUndoButtonOnClick(ActionEvent actionEvent) {
        // not fully working
        if (todoTableView.getSelectionModel().isEmpty()) {
            outputLable.setText("Please select an todo.");
            return;
        }

        Todo todo = todoTableView.getSelectionModel().getSelectedItem();

        for (Todo td: todoList) {
            if (todo.equals(td)) {

                if (td.isFinished()) {
                    td.setFinished(false);
                }

                else {
                    td.setFinished(true);
                }
            }
        }

        todoTableView.getItems().clear();
        todoTableView.getItems().addAll(todoList);
    }
}
