package com.example.studentobject;

public class Student {
    private int id;
    private String name;

    public String getName() {
        return this.name;
        // this.name = name
    }

    public void setName(String name) {
        this.name = name;
        // studentWithOnlyId.name = name
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
