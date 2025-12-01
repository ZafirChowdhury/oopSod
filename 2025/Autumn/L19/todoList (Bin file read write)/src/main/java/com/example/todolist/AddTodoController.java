package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
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

        todoTableView.getItems().remove(todo);

        File oldFile = new File("todo.bin");
        if (oldFile.exists()) {
            oldFile.delete();
        }

        for (Todo td: todoTableView.getItems()) {
            try {
                File file = new File("todo.bin");

                FileOutputStream fos;
                ObjectOutputStream oos;

                if (file.exists()) {
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                }

                oos.writeObject(td);
                oos.close();

            } catch (Exception e) {
                System.out.println("There was a error while reading to file!");
            }
        }


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

    @javafx.fxml.FXML
    public void viewTodoOnCllick(ActionEvent actionEvent) throws IOException {
        // Load fxml
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewTodo.fxml"));

        // Create Scene
        Scene scene = new Scene(fxmlLoader.load());

        // Data passing
        ViewTodoController viewTodoController = fxmlLoader.getController();
        viewTodoController.passData(todoTableView.getSelectionModel().getSelectedItem());

        // Get Stage
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        // Set scene to stage
        stage.setScene(scene);

        // Show the stage
        stage.show();
    }

    @javafx.fxml.FXML
    public void loadFromBinFileOnClick(ActionEvent actionEvent) throws IOException {
        File file = new File("todo.bin");

        if (!file.exists()) {
            System.out.println("Bin file dose not exist");
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        todoTableView.getItems().clear();
        try {
            while (true) {
                Todo todo = (Todo) ois.readObject();
                todoTableView.getItems().add(todo);
            }
        } catch (EOFException eof) {
            System.out.println("End of file reached");
        } catch (ClassNotFoundException | IOException cnf) {
            System.out.println("Class not found!");
        }
    }

    @javafx.fxml.FXML
    public void addTodoToBinOnCllick(ActionEvent actionEvent) {
        if (titleTextField.getText().isBlank()) {
            outputLable.setText("Title cant be empty!");
            return;
        }

        if (descriptionTextField.getText().isBlank()) {
            Todo todo = new Todo(titleTextField.getText());
        }

        Todo todo = new Todo(titleTextField.getText(), descriptionTextField.getText());

        try {
            File file = new File("todo.bin");

            FileOutputStream fos;
            ObjectOutputStream oos;

            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(todo);
            oos.close();

        } catch (Exception e) {
            System.out.println("There was a error while writing to file!");
        }
    }
}
