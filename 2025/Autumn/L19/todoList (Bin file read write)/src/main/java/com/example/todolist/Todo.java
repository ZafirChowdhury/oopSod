package com.example.todolist;

import java.io.Serializable;

public class Todo implements Serializable {
    private String title;
    private String description;
    private boolean isFinished;

    public Todo(String title) {
        this.title = title;
        this.isFinished = false;
    }

    public Todo(String title, String description) {
        this.title = title;
        this.isFinished = false;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isFinished=" + isFinished +
                '}';
    }
}
