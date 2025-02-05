module com.example.au23 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.au23 to javafx.fxml;
    exports com.example.au23;
}