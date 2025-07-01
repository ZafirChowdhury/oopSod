package com.example.demo;

public class Student {
    private String id;
    private String name;
    private String major;
    private String gender;
    private boolean hasScolarship;

    public Student(String id, String name, String major, String gender, boolean hasScolarship) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.gender = gender;
        this.hasScolarship = hasScolarship;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHasScolarship() {
        return hasScolarship;
    }

    public void setHasScolarship(boolean hasScolarship) {
        this.hasScolarship = hasScolarship;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", hasScolarship=" + hasScolarship +
                '}';
    }
}
