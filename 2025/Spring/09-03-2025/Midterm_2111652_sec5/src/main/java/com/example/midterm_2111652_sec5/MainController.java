package com.example.midterm_2111652_sec5;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;


public class MainController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TextField authourTextField;
    @javafx.fxml.FXML
    private TextField numberOfAuthoursTextFiend;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private DatePicker publicationDatePicker;
    @javafx.fxml.FXML
    private CheckBox citationStatusCheckBox;
    @javafx.fxml.FXML
    private Label outputLable;
    @javafx.fxml.FXML
    private TableView<Article> articleTable;
    @javafx.fxml.FXML
    private TableColumn<Article, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> titleCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String > authourCol;
    @javafx.fxml.FXML
    private TableColumn<Article, LocalDate> publicationDateCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> citationStatusCol;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> numberOfAuthoursCol;
    @javafx.fxml.FXML
    private TextField fromYearTextField;
    @javafx.fxml.FXML
    private ComboBox filterTypeComboBox;
    @javafx.fxml.FXML
    private TextField toYearTextField;
    @javafx.fxml.FXML
    private CheckBox citationStatusFIlterTextField;


    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Review", "Book", "Case");
        filterTypeComboBox.getItems().addAll("Review", "Book", "Case");

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authourCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        publicationDateCol.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        citationStatusCol.setCellValueFactory(new PropertyValueFactory<>("citationStatus"));
        numberOfAuthoursCol.setCellValueFactory(new PropertyValueFactory<>("numberOfAuthors"));
    }

    ArrayList<Article> articles = new ArrayList<>();
    ArrayList<Article> filteredArticles = new ArrayList<>();

    @javafx.fxml.FXML
    public void addArticleOnAction(ActionEvent actionEvent) {
        // Check if title is unique
        for (Article article : articles) {
            if (article.getTitle().equals(titleTextField.getText())) {
                outputLable.setText("Title must be unique");
                return;
            }
        }

        // Check if number of authors has any text or not
        int numberOfUsers = 0;
        try {
            numberOfUsers = Integer.parseInt(numberOfAuthoursTextFiend.getText());
        }   catch (Exception e) {
            outputLable.setText("Number of Authors must be a int");
        }

        // Citation
        String citation = "No";
        if (citationStatusCheckBox.isSelected()) {
            citation = "Yes";
        }

        // Create obj add to the arrayList
        Article newArticle = new Article(
                titleTextField.getText(),
                authourTextField.getText(),
                typeComboBox.getValue(),
                publicationDatePicker.getValue(),
                citation,
                numberOfUsers
        );

        System.out.println(newArticle.toString());

        articles.add(newArticle);

        articleTable.getItems().clear();
        articleTable.getItems().addAll(articles);
    }

    @javafx.fxml.FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
        Article article = articles.getFirst();
        for (Article a : articles) {
            if (a.getNumberOfAuthors() > article.getNumberOfAuthors()) {
                article = a;
            }
        }

        outputLable.setText(article.toString());
    }

    @javafx.fxml.FXML
    public void serachArticleOnClick(ActionEvent actionEvent) {
        filteredArticles.clear();

        String citation = "No";
        if (citationStatusFIlterTextField.isSelected()) {
            citation = "Yes";
        }

        for (Article article : articles) {
            if (article.getType().equals(filterTypeComboBox.getValue()) & article.getCitationStatus().equals(citation)) {
                filteredArticles.add(article);
            }
        }

        articleTable.getItems().clear();
        articleTable.getItems().addAll(filteredArticles);
    }

    @javafx.fxml.FXML
    public void yearFilterOnClick(ActionEvent actionEvent) {
        filteredArticles.clear();

        int fromYear = Integer.parseInt(fromYearTextField.getText());
        int toYear = Integer.parseInt(toYearTextField.getText());

        for (Article article : articles) {
            if (fromYear < article.getPublicationDate().getYear() & article.getPublicationDate().getYear() < toYear) {
                filteredArticles.add(article);
            }
        }

        articleTable.getItems().clear();
        articleTable.getItems().addAll(filteredArticles);
    }
}