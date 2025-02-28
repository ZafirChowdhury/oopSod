module com.example.datetime {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datetime to javafx.fxml;
    exports com.example.datetime;
}