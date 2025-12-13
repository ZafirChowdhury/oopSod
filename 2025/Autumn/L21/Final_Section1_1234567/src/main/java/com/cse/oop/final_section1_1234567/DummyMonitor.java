package com.cse.oop.final_section1_1234567;

public class DummyMonitor {
    private String modle;
    private String resolution;
    private String diagonal;
    private float price;
    private String ppi;

    public DummyMonitor(String modle, String ppi, float price, String diagonal, String resolution) {
        this.modle = modle;
        this.ppi = ppi;
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

    public String getPpi() {
        return ppi;
    }

    public void setPpi(String ppi) {
        this.ppi = ppi;
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
        return "DummyMonitor{" +
                "modle='" + modle + '\'' +
                ", resolution='" + resolution + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", price=" + price +
                ", ppi='" + ppi + '\'' +
                '}';
    }
}
