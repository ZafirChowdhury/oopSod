module com.example.newwindowstest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.newwindowstest to javafx.fxml;
    exports com.example.newwindowstest;
}