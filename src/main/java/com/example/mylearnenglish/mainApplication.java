package com.example.mylearnenglish;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainApplication.class.getResource("mainGraphics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Learn English!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        loadFile.loadDataFile();
        launch();
    }
}