package com.example.dummyclass;

public class Student {
    private String id;
    private String courseId;

    public Student(String id, String courseId) {
        this.id = id;
        this.courseId = courseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
