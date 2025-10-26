module com.example.arraylist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.arraylist to javafx.fxml;
    exports com.example.arraylist;
}