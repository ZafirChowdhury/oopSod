module com.example.courseoutlinemid {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.courseoutlinemid to javafx.fxml;
    exports com.example.courseoutlinemid;
}