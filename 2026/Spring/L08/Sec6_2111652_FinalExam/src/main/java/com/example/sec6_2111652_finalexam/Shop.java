package com.example.sec6_2111652_finalexam;

import java.io.Serializable;

public class Shop implements Serializable {
    private String name;
    private String zipCode;
    private Double areaInSqFt;

    public Shop(String name, Double areaInSqFt, String zipCode) {
        this.name = name;
        this.areaInSqFt = areaInSqFt;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAreaInSqFt() {
        return areaInSqFt;
    }

    public void setAreaInSqFt(Double areaInSqFt) {
        this.areaInSqFt = areaInSqFt;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", areaInSqFt=" + areaInSqFt +
                '}';
    }

    public void showLicenseFeeiNConsole() {
        if (this.areaInSqFt >= 500) {
            System.out.println("License fee: 1000 Tk /SqFt");
        } else {
            System.out.println("License fee: 500 Tk /SqFt");
        }
    }
}
