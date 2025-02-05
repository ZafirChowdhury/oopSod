module com.example.sp23c {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sp23c to javafx.fxml;
    exports com.example.sp23c;
}