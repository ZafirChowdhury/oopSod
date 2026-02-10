module com.example.aretmeticops {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aretmeticops to javafx.fxml;
    exports com.example.aretmeticops;
}