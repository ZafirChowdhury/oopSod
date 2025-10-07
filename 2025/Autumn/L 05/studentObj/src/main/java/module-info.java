module com.example.studentobj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentobj to javafx.fxml;
    exports com.example.studentobj;
}