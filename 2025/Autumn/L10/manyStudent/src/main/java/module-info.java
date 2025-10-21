module com.example.manystudent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.manystudent to javafx.fxml;
    exports com.example.manystudent;
}