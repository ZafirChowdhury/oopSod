package com.example.demo1;

public class Student {
    private String name;
    private int id;
    private String gender;
    private boolean hasScolarship;
    private String major;


    public Student(String name, int id, String gender, boolean hasScolarship, String major) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.hasScolarship = hasScolarship;
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHasScolarship() {
        return hasScolarship;
    }

    public void setHasScolarship(boolean hasScolarship) {
        this.hasScolarship = hasScolarship;
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, int id, String gender, boolean hasScolarship) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.hasScolarship = hasScolarship;
    }
}
