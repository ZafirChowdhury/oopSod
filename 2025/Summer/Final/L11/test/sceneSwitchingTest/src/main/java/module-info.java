module com.example.sceneswitchingtest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sceneswitchingtest to javafx.fxml;
    exports com.example.sceneswitchingtest;
}