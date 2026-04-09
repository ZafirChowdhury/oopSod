module com.example.sec6_2111652_finalexam {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.sec6_2111652_finalexam to javafx.fxml;
    exports com.example.sec6_2111652_finalexam;
}