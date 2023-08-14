module com.example.ponggame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ponggame to javafx.fxml;
    exports com.example.ponggame;
}