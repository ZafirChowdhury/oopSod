package com.example.mid;

import java.time.LocalDate;

public class Dummy {
    private String packageName;
    private float dataAmount;
    private String validity;
    private float price;
    private String availability;
    private LocalDate offerEnds;

    public Dummy(String packageName, float dataAmount, String validity, float price, String availability, LocalDate offerEnds) {
        this.packageName = packageName;
        this.dataAmount = dataAmount;
        this.validity = validity;
        this.price = price;
        this.availability = availability;
        this.offerEnds = offerEnds;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public float getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(float dataAmount) {
        this.dataAmount = dataAmount;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
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
        return "Dummy{" +
                "packageName='" + packageName + '\'' +
                ", dataAmount=" + dataAmount +
                ", validity='" + validity + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", offerEnds=" + offerEnds +
                '}';
    }
}
