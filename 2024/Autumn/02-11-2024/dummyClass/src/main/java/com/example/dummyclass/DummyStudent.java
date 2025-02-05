package com.example.dummyclass;

public class DummyStudent {
    private String stuId;
    private String cId;
    private String cc;

    public DummyStudent(String stuId, String cc, String cId) {
        this.stuId = stuId;
        this.cc = cc;
        this.cId = cId;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "DummyStudent{" +
                "stuId='" + stuId + '\'' +
                ", cId='" + cId + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }
}
