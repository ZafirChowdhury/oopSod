module com.example.mid2025 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mid2025 to javafx.fxml;
    exports com.example.mid2025;
}