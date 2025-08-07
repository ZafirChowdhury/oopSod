module com.example.midterm_section1_1111111 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.midterm_section1_1111111 to javafx.fxml;
    exports com.example.midterm_section1_1111111;
}