package com.example.mid2025;

import javafx.scene.control.Alert;

public class CourseOutline {
    private String courseId;
    private String courseTitle;
    private String preReq1;
    private String preReq2;
    private String preReq3;
    private int noOfCredit;
    private int year;
    private String semester;
    private String description;

    public CourseOutline(String courseId, String description, int year, String semester, String preReq3, int noOfCredit, String preReq2, String preReq1, String courseTitle) {
        this.courseId = courseId;
        this.description = description;
        this.year = year;
        this.semester = semester;
        this.preReq3 = preReq3;
        this.noOfCredit = noOfCredit;
        this.preReq2 = preReq2;
        this.preReq1 = preReq1;
        this.courseTitle = courseTitle;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNoOfCredit() {
        return noOfCredit;
    }

    public void setNoOfCredit(int noOfCredit) {
        this.noOfCredit = noOfCredit;
    }

    public String getPreReq3() {
        return preReq3;
    }

    public void setPreReq3(String preReq3) {
        this.preReq3 = preReq3;
    }

    public String getPreReq2() {
        return preReq2;
    }

    public void setPreReq2(String preReq2) {
        this.preReq2 = preReq2;
    }

    public String getPreReq1() {
        return preReq1;
    }

    public void setPreReq1(String preReq1) {
        this.preReq1 = preReq1;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    @Override
    public String toString() {
        return "CourseOutline{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", preReq1='" + preReq1 + '\'' +
                ", preReq2='" + preReq2 + '\'' +
                ", preReq3='" + preReq3 + '\'' +
                ", noOfCredit=" + noOfCredit +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void showCourseType() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (courseId.endsWith("L")) {
            alert.setContentText("Lab");
            alert.showAndWait();
        } else {
            alert.setContentText("Teory");
            alert.showAndWait();
        }
    }
}
