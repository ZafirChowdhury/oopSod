package com.example.dummyclass;

public class Course {
    private String courseId;
    private String creditCount;

    public Course(String courseId, String creditCount) {
        this.courseId = courseId;
        this.creditCount = creditCount;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCreditCount() {
        return creditCount;
    }

    public void setCreditCount(String creditCount) {
        this.creditCount = creditCount;
    }
}
