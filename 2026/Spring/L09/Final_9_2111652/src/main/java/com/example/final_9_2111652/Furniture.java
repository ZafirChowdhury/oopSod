package com.example.final_9_2111652;

import java.io.Serializable;

public class Furniture implements Serializable {
    private String id;
    private String description;
    private String type;
    private double price;
    private int discountPercentage;
    private int vatPercentage;
    private Boolean isImported;

    public Furniture(String id, boolean isImported, int vatPercentage, int discountPercentage, double price, String type, String description) {
        this.id = id;
        this.isImported = isImported;
        this.vatPercentage = vatPercentage;
        this.discountPercentage = discountPercentage;
        this.price = price;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public int getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(int vatPercentage) {
        this.vatPercentage = vatPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discountPercentage=" + discountPercentage +
                ", vatPercentage=" + vatPercentage +
                ", isImported=" + isImported +
                '}';
    }

    public double getBillAmoint() {
      double discountPrice = this.price - (((double) this.discountPercentage / 100) * this.price);
      double vatPrice = discountPrice + (((double) this.vatPercentage / 100) * discountPrice);

      return vatPrice;
    };
}
