package com.example.studentobject;

public class Student {
    private int id;
    private String name;

    private String major;
    private String gender;
    private boolean hasScholarship;

    public Student(int id, boolean hasScholarship, String gender, String major, String name) {
        this.id = id;
        this.hasScholarship = hasScholarship;
        this.gender = gender;
        this.major = major;
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

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
                ", major='" + major + '\'' +
                ", gender='" + gender + '\'' +
                ", hasScholarship=" + hasScholarship +
                '}';
    }
}
