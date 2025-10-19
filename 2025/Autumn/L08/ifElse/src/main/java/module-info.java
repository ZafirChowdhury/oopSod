module com.example.ifelse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ifelse to javafx.fxml;
    exports com.example.ifelse;
}