module com.example.sumsubmutidiv {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sumsubmutidiv to javafx.fxml;
    exports com.example.sumsubmutidiv;
}