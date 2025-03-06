module com.example.mid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mid to javafx.fxml;
    exports com.example.mid;
}