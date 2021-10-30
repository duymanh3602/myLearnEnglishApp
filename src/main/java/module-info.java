module com.example.mylearnenglish {
    requires javafx.controls;
    requires javafx.fxml;
    requires voicerss.tts;
    requires java.desktop;


    opens com.example.mylearnenglish to javafx.fxml;
    exports com.example.mylearnenglish;
}