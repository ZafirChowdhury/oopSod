package com.example.mid;

import java.time.LocalDate;

public class DataPackage {
    private String packageName;
    private float dataAmount;
    private int validity; // 0 = Unlimited
    private float price;
    private String availability;
    private LocalDate offerEnds;

    public DataPackage(String packageName, LocalDate offerEnds, float dataAmount, int validity, float price, String availability) {
        this.packageName = packageName;
        this.offerEnds = offerEnds;
        this.dataAmount = dataAmount;
        this.validity = validity;
        this.price = price;
        this.availability = availability;
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

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
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
        return "DataPackage{" +
                "packageName='" + packageName + '\'' +
                ", dataAmount=" + dataAmount +
                ", validity=" + validity +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", offerEnds=" + offerEnds +
                '}';
    }
}
