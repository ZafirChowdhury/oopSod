module com.example.sstutorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sstutorial to javafx.fxml;
    exports com.example.sstutorial;
}