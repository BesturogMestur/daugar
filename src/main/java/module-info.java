module com.example.draugar {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.draugar to javafx.fxml;
    exports com.example.draugar;
}