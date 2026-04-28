module com.example.artikelfinder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.artikelfinder to javafx.fxml;
    exports com.example.artikelfinder;
}