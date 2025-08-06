package com.example.filereadwritetest;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextFied;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TableColumn<Student, String> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private TableView<Student> table;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    ArrayList<Student> students = new ArrayList<>();

    @javafx.fxml.FXML
    public void sameButtonOnClick(ActionEvent actionEvent) throws IOException {
        Student student = new Student(idTextFied.getText(), nameTextField.getText());

        File file = new File("s.bin");

        FileOutputStream fos = new FileOutputStream(file, true);
        ObjectOutputStream oos;

        if (file.exists()) {
            oos = new ObjectOutputStream(fos);
        } else {
            oos = new AppendableObjectOutputStream(fos);
        }

        oos.writeObject(student);
        oos.close();
    }

    @javafx.fxml.FXML
    public void showButtonOnCllick(ActionEvent actionEvent) throws IOException {
        File file = new File("s.bin");

        if (!file.exists()) {
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            while (true) {
                students.add((Student) ois.readObject());
            }
        } catch (EOFException eofException) {
            System.out.println("End of file reached");
        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Program cant find the Student Class");
        }

        table.getItems().addAll(students);
    }
}