package com.example.demo;

public class Student {
    private int id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if ((""+id).length() != 7) {
            System.out.println("Student id must be length of 7");
            return;
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
