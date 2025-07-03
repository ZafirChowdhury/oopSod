package com.example.midterm_section1_1111111;

import java.time.LocalDate;

public class DataPackage {
    private String packageName;
    private double dataAmount;  // In GB
    private String validity;
    private double price;
    private String availability;
    private LocalDate offerEnds;

    public DataPackage(String packageName, double dataAmount, String validity, double price, String availability, LocalDate offerEnds) {
        this.packageName = packageName;
        this.dataAmount = dataAmount;
        this.validity = validity;
        this.price = price;
        this.availability = availability;
        this.offerEnds = offerEnds;
    }

    public DataPackage(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public double getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(double dataAmount) {
        this.dataAmount = dataAmount;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public LocalDate getOfferEnds() {
        return offerEnds;
    }

    public void setOfferEnds(LocalDate offerEnds) {
        this.offerEnds = offerEnds;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "packageName='" + packageName + '\'' +
                ", dataAmount=" + dataAmount +
                ", validity='" + validity + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", offerEnds=" + offerEnds +
                '}';
    }
}
