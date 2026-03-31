package com.example.books;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;

public class AddBookController
{
    @javafx.fxml.FXML
    private TextField idTextFiend;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TableColumn<Book, Integer> idCol;
    @javafx.fxml.FXML
    private TableColumn<Book, String> nameCol;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableView<Book> bookTable;

    @javafx.fxml.FXML
    public void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @javafx.fxml.FXML
    public void addBookOnClick(ActionEvent actionEvent) {
        int id = Integer.parseInt(idTextFiend.getText());
        String name = nameTextField.getText();
        Book book = new Book(id, name);

        File file = new File("book.bin");
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            if (file.exists()) {
                // Header exist
                fos = new FileOutputStream(file, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                // Header does not exist
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(book);
            oos.close();

        } catch (Exception ex) {
            System.out.println("There was a error while reading from bin file!");
        }

        outputLable.setText("New book " + book.toString() + "Added");
    }


    @javafx.fxml.FXML
    public void laodDataFromBinFIle(ActionEvent actionEvent) throws IOException {
        bookTable.getItems().clear();

        try {
            File file = new File("book.bin");

            if (!file.exists()) {
                return;
            }

            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {

                while (true) {
                    Book book = (Book) ois.readObject();
                    bookTable.getItems().add(book);
                }

            } catch (EOFException efo) {
                ois.close();
                System.out.println("End of file reached!");
            }

        } catch (Exception e) {
            System.out.println("There was a problem reading from bin file!");
        }
    }
}