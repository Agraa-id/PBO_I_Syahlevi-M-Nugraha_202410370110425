module com.example.extra_task {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.extra_task to javafx.fxml;
    exports com.example.extra_task;
}