package com.example.midterm_2111652_sec5;

import java.time.LocalDate;

public class Article {
    private String title;
    private String author;
    private String type;
    private LocalDate publicationDate;
    private String citationStatus;
    private int numberOfAuthors;

    public Article(String title, String author, String type, LocalDate publicationDate, String citationStatus, int numberOfAuthors) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.publicationDate = publicationDate;
        this.citationStatus = citationStatus;
        this.numberOfAuthors = numberOfAuthors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getCitationStatus() {
        return citationStatus;
    }

    public void setCitationStatus(String citationStatus) {
        this.citationStatus = citationStatus;
    }

    public int getNumberOfAuthors() {
        return numberOfAuthors;
    }

    public void setNumberOfAuthors(int numberOfAuthors) {
        this.numberOfAuthors = numberOfAuthors;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", publicationDate=" + publicationDate +
                ", citationStatus='" + citationStatus + '\'' +
                ", numberOfAuthors=" + numberOfAuthors +
                '}';
    }
}
