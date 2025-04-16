module com.example.savestudenttobin {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.savestudenttobin to javafx.fxml;
    exports com.example.savestudenttobin;
}