module com.example.repo7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repo7 to javafx.fxml;
    exports com.example.repo7;
}