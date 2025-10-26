module com.example.forloop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.forloop to javafx.fxml;
    exports com.example.forloop;
}