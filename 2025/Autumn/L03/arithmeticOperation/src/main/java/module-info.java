module com.example.arithmeticoperation {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.arithmeticoperation to javafx.fxml;
    exports com.example.arithmeticoperation;
}