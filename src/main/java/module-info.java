module com.example.devisverse {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.devisverse to javafx.fxml;
    exports com.example.devisverse;
}