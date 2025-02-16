module com.example.studentobject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.studentobject to javafx.fxml;
    exports com.example.studentobject;
}