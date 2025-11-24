module com.example.todolist {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.todolist to javafx.fxml;
    exports com.example.todolist;
}