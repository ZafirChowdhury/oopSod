package com.example.sec1_2111652_finalexam;

import java.io.Serializable;

public class Shop implements Serializable {
    private String name;
    private String zipCode;
    private int areaInSqFt;

    public Shop(String name, int areaInSqFt, String zipCode) {
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

    public int getAreaInSqFt() {
        return areaInSqFt;
    }

    public void setAreaInSqFt(int areaInSqFt) {
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
}
