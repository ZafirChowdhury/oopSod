    package com.example.midterm_section1_1111111;

    import java.io.Serializable;
    import java.time.LocalDate;

    public class DataPackage implements Serializable {
        private String packageName;
        private double dataAmount;  // In GB
        private String validity;
        private double price;
        private String availability;
        private LocalDate offerEnds;

        public DataPackage(LocalDate offerEnds, String availability, double price, String validity, double dataAmount, String packageName) {
            this.offerEnds = offerEnds;
            this.availability = availability;
            this.price = price;
            this.validity = validity;
            this.dataAmount = dataAmount;
            this.packageName = packageName;
        }

        public LocalDate getOfferEnds() {
            return offerEnds;
        }

        public void setOfferEnds(LocalDate offerEnds) {
            this.offerEnds = offerEnds;
        }

        public String getAvailability() {
            return availability;
        }

        public void setAvailability(String availability) {
            this.availability = availability;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
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

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
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
