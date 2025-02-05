module com.example.dummyclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dummyclass to javafx.fxml;
    exports com.example.dummyclass;
}