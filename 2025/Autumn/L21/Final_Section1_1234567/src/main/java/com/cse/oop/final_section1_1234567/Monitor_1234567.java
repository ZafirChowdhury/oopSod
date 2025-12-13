package com.cse.oop.final_section1_1234567;

import java.io.Serializable;

public class Monitor_1234567 implements Serializable {
    private String modle;
    private String resolution;
    private String diagonal;
    private float price;

    public Monitor_1234567(String modle, float price, String diagonal, String resolution) {
        this.modle = modle;
        this.price = price;
        this.diagonal = diagonal;
        this.resolution = resolution;
    }

    public String getModle() {
        return modle;
    }

    public void setModle(String modle) {
        this.modle = modle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "Monitor_1234567{" +
                "modle='" + modle + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", price=" + price +
                '}';
    }

    public String getPPI() {
        if (resolution.equals("HD")) {
            if (diagonal.equals("17")) return "86";
            if (diagonal.equals("19")) return "77";
            if (diagonal.equals("22")) return "67";
            if (diagonal.equals("24")) return "61";
        }

        if (resolution.equals("HD+")) {
            if (diagonal.equals("17")) return "108";
            if (diagonal.equals("19")) return "97";
            if (diagonal.equals("22")) return "83";
            if (diagonal.equals("24")) return "76";
        }

        if (resolution.equals("Full-HD")) {
            if (diagonal.equals("17")) return "130";
            if (diagonal.equals("19")) return "116";
            if (diagonal.equals("22")) return "100";
            if (diagonal.equals("24")) return "92";
        }

        if (resolution.equals("QHD")) {
            if (diagonal.equals("17")) return "173";
            if (diagonal.equals("19")) return "155";
            if (diagonal.equals("22")) return "134";
            if (diagonal.equals("24")) return "122";
        }

        return "";
    }
}
