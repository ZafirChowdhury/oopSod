module com.example.sayhello {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sayhello to javafx.fxml;
    exports com.example.sayhello;
}