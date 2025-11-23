module com.example.newwindowstest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.newwindowstest to javafx.fxml;
    exports com.example.newwindowstest;
}