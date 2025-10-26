package com.example.midterm_2111652_1;

import java.time.LocalDate;

public class Article {
    private String title;
    private String author;
    private String type;
    private LocalDate publicationDate;
    private String status;
    private int noOfAuthors;

    public Article(String title, int noOfAuthors, String status, LocalDate publicationDate, String type, String author) {
        this.title = title;
        this.noOfAuthors = noOfAuthors;
        this.status = status;
        this.publicationDate = publicationDate;
        this.type = type;
        this.author = author;
    }

    public int getPubliationYer() {
        return publicationDate.getYear();
        // publicationDate.toString().substring(0, 3); // 2007-XX-XX
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoOfAuthors() {
        return noOfAuthors;
    }

    public void setNoOfAuthors(int noOfAuthors) {
        this.noOfAuthors = noOfAuthors;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", publicationDate=" + publicationDate +
                ", status='" + status + '\'' +
                ", noOfAuthors=" + noOfAuthors +
                '}';
    }
}
