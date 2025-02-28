module com.example.evenoddlist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.evenoddlist to javafx.fxml;
    exports com.example.evenoddlist;
}