module com.example.mylearnenglish {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mylearnenglish to javafx.fxml;
    exports com.example.mylearnenglish;
}