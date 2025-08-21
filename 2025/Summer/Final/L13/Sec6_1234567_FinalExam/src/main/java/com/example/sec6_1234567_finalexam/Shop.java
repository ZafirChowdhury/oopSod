package com.example.sec6_1234567_finalexam;

import java.io.Serializable;

public class Shop implements Serializable {
    private String name;
    private String zipCode;
    private float areaInSqFt;

    public Shop(String name, String zipCode, float areaInSqFt) {
        this.name = name;
        this.zipCode = zipCode;
        this.areaInSqFt = areaInSqFt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAreaInSqFt() {
        return areaInSqFt;
    }

    public void setAreaInSqFt(float areaInSqFt) {
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
