module com.example.puntodeventa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.puntodeventa to javafx.fxml;
    exports com.example.puntodeventa;
}