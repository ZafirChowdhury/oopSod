module com.example.basiccalculation {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jfr;


    opens com.example.basiccalculation to javafx.fxml;
    exports com.example.basiccalculation;
}