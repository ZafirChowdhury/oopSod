module com.example.filereadwritetest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.filereadwritetest to javafx.fxml;
    exports com.example.filereadwritetest;
}