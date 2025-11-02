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
    private CheckBox searchCitationStatusYes;
    @javafx.fxml.FXML
    private ComboBox<String> searchTypeComboBox;
    @javafx.fxml.FXML
    private TextField toYearTextFIeld;
    @javafx.fxml.FXML
    private TextField fromYearTextField;
    @javafx.fxml.FXML
    private Label highArticleTextField;

    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Review", "Book", "Case");
        searchTypeComboBox.getItems().addAll("Review", "Book", "Case");

        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
        publicationDateCol.setCellValueFactory(new PropertyValueFactory<>("publicationDate"));
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        noOfAuthorCol.setCellValueFactory(new PropertyValueFactory<>("noOfAuthors"));

        int wordCount = 100;
        int score = 200;

        if ((wordCount > 0) && ((score < 0) && (score < 100))) {

        }
    }

    private ArrayList<Article> articleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String citationType = typeComboBox.getValue();
        LocalDate publicationDate = publicationDatePicker.getValue();

        String citationStatus = "No";
        if (citationStatusYes.isSelected()) citationStatus = "Yes";

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

    @javafx.fxml.FXML
    public void searchArticleOnClick(ActionEvent actionEvent) {
        ArrayList<Article> filteredArticles = new ArrayList<>();

        String searchType = searchTypeComboBox.getValue();
        String searchCitationStatus = "No";
        if (searchCitationStatusYes.isSelected()) searchCitationStatus = "Yes";

        for (Article article: articleList) {
            if ((article.getType().equals(searchType)) && (article.getStatus().equals(searchCitationStatus))) {
                filteredArticles.add(article);
            }
        }

        articleTable.getItems().clear();
        articleTable.getItems().addAll(filteredArticles);
    }


    @javafx.fxml.FXML
    public void yearfilterButtonOnClick(ActionEvent actionEvent) {
        if (fromYearTextField.getText().isBlank()) {
            outputLable.setText("Please enter a starting year to search");
            return;
        }

        if (toYearTextFIeld.getText().isBlank()) {
            outputLable.setText("Please enter a ending year to search");
            return;
        }

        int fromYear = 0;
        int toYear = 0;
        try {
            fromYear = Integer.parseInt(fromYearTextField.getText());
            toYear =  Integer.parseInt(toYearTextFIeld.getText());
        } catch (Exception e) {
            outputLable.setText("Please enter a proper year in the year field");
            return;
        }

        ArrayList<Article> filteredArticles = new ArrayList<>();
        for (Article article: articleList) {
            if ((fromYear <= article.getPubliationYer()) && (toYear >= article.getPubliationYer()))  {
                filteredArticles.add(article);
            }
        }

        articleTable.getItems().clear();
        articleTable.getItems().addAll(filteredArticles);
    }

    @javafx.fxml.FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent actionEvent) {
        if (articleList.isEmpty()) return;

        // max = -inf
        Article highestArticle = articleList.getFirst();

        // for loop
        for (Article article: articleList) {
            // if i > max
            if (article.getNoOfAuthors() > highestArticle.getNoOfAuthors()) {
                // max = i
                highestArticle = article;
            }
        }

        highArticleTextField.setText(highestArticle.toString());
    }
}