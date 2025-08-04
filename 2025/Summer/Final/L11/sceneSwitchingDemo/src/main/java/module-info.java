module com.example.sceneswitchingdemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sceneswitchingdemo to javafx.fxml;
    exports com.example.sceneswitchingdemo;
}