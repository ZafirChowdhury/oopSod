package com.example.sec1_2111652_finalexam;

import java.io.Serializable;
import java.time.LocalDate;

public class Pharmacy extends Shop implements Serializable {
    private String owner;
    private LocalDate openingDate;
    private Boolean isChainPharmacy;
    private String locationType;
    private String licenceNo;

    public Pharmacy(String name, int areaInSqFt, String zipCode, String owner, LocalDate openingDate, Boolean isChainPharmacy, String locationType, String licenceNo) {
        super(name, areaInSqFt, zipCode);
        this.owner = owner;
        this.openingDate = openingDate;
        this.isChainPharmacy = isChainPharmacy;
        this.locationType = locationType;
        this.licenceNo = licenceNo;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Boolean getChainPharmacy() {
        return isChainPharmacy;
    }

    public void setChainPharmacy(Boolean chainPharmacy) {
        isChainPharmacy = chainPharmacy;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "owner='" + owner + '\'' +
                ", openingDate=" + openingDate +
                ", isChainPharmacy=" + isChainPharmacy +
                ", locationType='" + locationType + '\'' +
                ", licenceNo='" + licenceNo + '\'' +
                '}';
    }

    public void showLicenseFee() {
        if (this.getAreaInSqFt() >= 500) {
            System.out.println("1000 Tk /SqFt");
        } else {
            System.out.println("500 Tk /SqFt");
        }
    }
}
