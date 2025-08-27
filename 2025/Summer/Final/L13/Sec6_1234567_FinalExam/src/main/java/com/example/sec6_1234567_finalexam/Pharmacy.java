package com.example.sec6_1234567_finalexam;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Pharmacy extends Shop implements Serializable {
    private String owner;
    private LocalDate openingDate;
    private String locationType;
    private String tradeLicenseNo;
    private boolean isChainPharmacy;

    public Pharmacy(String name, String zipCode, float areaInSqFt, String owner, LocalDate openingDate, String locationType, String tradeLicenseNo, boolean isChainPharmacy) {
        super(name, zipCode, areaInSqFt);
        this.owner = owner;
        this.openingDate = openingDate;
        this.locationType = locationType;
        this.tradeLicenseNo = tradeLicenseNo;
        this.isChainPharmacy = isChainPharmacy;
    }

    public void printLicenseFee () {
        if (this.getAreaInSqFt() >= 500) {
            System.out.println("1000 TK/SqFt");
        } else {
            System.out.println("500 TK/SqFt");
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean isChainPharmacy() {
        return isChainPharmacy;
    }

    public void setChainPharmacy(boolean chainPharmacy) {
        isChainPharmacy = chainPharmacy;
    }

    public String getTradeLicenseNo() {
        return tradeLicenseNo;
    }

    public void setTradeLicenseNo(String tradeLicenseNo) {
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
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
                "area=" + this.getAreaInSqFt() +
                "owner='" + owner + '\'' +
                ", openingDate=" + openingDate +
                ", locationType='" + locationType + '\'' +
                ", tradeLicenseNo='" + tradeLicenseNo + '\'' +
                ", isChainPharmacy=" + isChainPharmacy +
                '}';
    }
}
