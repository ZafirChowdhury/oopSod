module com.example.books {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.books to javafx.fxml;
    exports com.example.books;
}