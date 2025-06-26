module com.example.codelab1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.codelab1 to javafx.fxml;
    exports com.example.codelab1;
}