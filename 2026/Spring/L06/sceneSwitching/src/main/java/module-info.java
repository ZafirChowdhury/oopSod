module com.example.sceneswitching {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.sceneswitching to javafx.fxml;
    exports com.example.sceneswitching;
}