package com.example.savestudenttobin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class MainController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<Student, Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Student, String> nameCol;
    @javafx.fxml.FXML
    private TableView<Student> studentTable;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        File file;
        FileInputStream fis;
        ObjectInputStream ois;

        try {
            file = new File("student.bin");
            if (!file.exists()) return;

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    Student s = (Student) ois.readObject();
                    students.add(s);
                }
            } catch (EOFException eofException) {
                System.out.println("End of file reached");

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {

        }

        studentTable.getItems().addAll(students);
    }

    ArrayList<Student> students = new ArrayList<>();

    @javafx.fxml.FXML
    public void saveButtonOnClick(ActionEvent actionEvent) {
        Student newStudent = new Student(nameTextField.getText(),
                Integer.parseInt(idTextField.getText()));

        students.add(newStudent);

        File file = new File("student.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (file.exists()) {
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(file, true);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(newStudent);
            oos.close();

        } catch (Exception ex) {
            System.out.println("There was a error writing to bin file");
        }

        studentTable.getItems().clear();
        studentTable.getItems().addAll(students);
    }

    @javafx.fxml.FXML
    public void viewInDetailOnClick(ActionEvent actionEvent) throws IOException {
        Student selectedStudet = studentTable.getSelectionModel().getSelectedItem();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = fxmlLoader.load();

        ViewController vc = fxmlLoader.getController();
        vc.dataPassing(selectedStudet);

        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }
}