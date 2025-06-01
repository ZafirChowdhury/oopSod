module com.example.buttonpresstoiable {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttonpresstoiable to javafx.fxml;
    exports com.example.buttonpresstoiable;
}