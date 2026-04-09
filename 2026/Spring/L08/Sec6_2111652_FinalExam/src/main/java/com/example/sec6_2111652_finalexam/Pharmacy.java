package com.example.sec6_2111652_finalexam;

import java.io.Serializable;
import java.time.LocalDate;

public class Pharmacy extends Shop implements Serializable {
    private String owner;
    private LocalDate openingDate;
    private boolean isChainPharmacy;
    private String locationType;
    private String tradeLicenseNo;

    public Pharmacy(String name, Double areaInSqFt, String zipCode, String owner, String tradeLicenseNo, String locationType, boolean isChainPharmacy, LocalDate openingDate) {
        super(name, areaInSqFt, zipCode);
        this.owner = owner;
        this.tradeLicenseNo = tradeLicenseNo;
        this.locationType = locationType;
        this.isChainPharmacy = isChainPharmacy;
        this.openingDate = openingDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getTradeLicenseNo() {
        return tradeLicenseNo;
    }

    public void setTradeLicenseNo(String tradeLicenseNo) {
        this.tradeLicenseNo = tradeLicenseNo;
    }

    public boolean isChainPharmacy() {
        return isChainPharmacy;
    }

    public void setChainPharmacy(boolean chainPharmacy) {
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
                ", tradeLicenseNo='" + tradeLicenseNo + '\'' +
                '}';
    }
}
