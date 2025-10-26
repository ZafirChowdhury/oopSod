package com.example.midterm_2111652_1;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class MidController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private CheckBox citationStatusNo;
    @javafx.fxml.FXML
    private TextField noOfOthersTexrtField;
    @javafx.fxml.FXML
    private DatePicker publicationDatePicker;
    @javafx.fxml.FXML
    private TextField authorTextField;
    @javafx.fxml.FXML
    private CheckBox citationStatusYes;
    @javafx.fxml.FXML
    private TableColumn<Article, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> titleCol;
    @javafx.fxml.FXML
    private TableView<Article> articleTable;
    @javafx.fxml.FXML
    private TableColumn<Article, String> authorCol;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> noOfAuthorCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> statusCol;
    @javafx.fxml.FXML
    private TableColumn<Article, LocalDate> publicationDateCol;

    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Review", "Book", "Case");

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        publicationDateCol.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        noOfAuthorCol.setCellValueFactory(new PropertyValueFactory<>("noOfAuthors"));
    }

    private ArrayList<Article> articleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String citationType = typeComboBox.getValue();
        LocalDate publicationDate = publicationDatePicker.getValue();

        if (citationStatusYes.isSelected() && citationStatusNo.isSelected()) {
            outputLable.setText("Please select one citation status");
            return;
        }

        String citationStatus = "";
        if (citationStatusYes.isSelected()) citationStatus = "Yes";
        if (citationStatusNo.isSelected()) citationStatus = "No";

        int noOfAuthors = 0;
        try {
            noOfAuthors = Integer.parseInt(noOfOthersTexrtField.getText());
        }
        catch (Exception e) {
            outputLable.setText("Please enter a proper author count.");
            return;
        }

        Article article = new Article(title, noOfAuthors, citationStatus, publicationDate, citationType, author);
        articleList.add(article);
        outputLable.setText("Article Added succesfully");

        System.out.println(article.toString());

        articleTable.getItems().clear();
        articleTable.getItems().addAll(articleList);
    }
}