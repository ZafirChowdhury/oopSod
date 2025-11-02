package com.example.courseoutlinemid;

import javafx.scene.control.Alert;

public class CourseOutline {
    private String courseId;
    private String courseTitle;
    private String preReq1;
    private String preReq2;
    private String preReq3;
    private int noOfCredits;
    private int year;
    private String semester;
    private String description;

    public CourseOutline() {
    }

    public CourseOutline(String courseId, String courseTitle, String preReq1, String preReq2, String preReq3, int noOfCredits, int year, String semester, String description) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.preReq1 = preReq1;
        this.preReq2 = preReq2;
        this.preReq3 = preReq3;
        this.noOfCredits = noOfCredits;
        this.year = year;
        this.semester = semester;
        this.description = description;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getPreReq1() {
        return preReq1;
    }

    public String getPreReq2() {
        return preReq2;
    }

    public String getPreReq3() {
        return preReq3;
    }

    public int getNoOfCredits() {
        return noOfCredits;
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getDescription() {
        return description;
    }

    public void setPreReq3(String preReq3) {
        this.preReq3 = preReq3;
    }


    public void setPreReq1(String preReq1) {
        this.preReq1 = preReq1;
    }

    public void setPreReq2(String preReq2) {
        this.preReq2 = preReq2;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CourseOutline{" +
                "courseId='" + courseId + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", preReq1='" + preReq1 + '\'' +
                ", preReq2='" + preReq2 + '\'' +
                ", preReq3='" + preReq3 + '\'' +
                ", noOfCredits=" + noOfCredits +
                ", year=" + year +
                ", semester='" + semester + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void showCourseType(){
        if(courseId.charAt(6)=='L'){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Lab Course");
            a.showAndWait();

        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Theory Course");
            a.showAndWait();
        }
    }
}
