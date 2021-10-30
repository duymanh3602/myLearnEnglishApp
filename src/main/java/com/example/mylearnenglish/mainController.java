package com.example.mylearnenglish;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;

public class mainController {

    private String tempResText = "Hello everybody";
    @FXML
    private ToggleButton toggle;
    @FXML
    private TextArea resText;
    @FXML
    private TextArea ansText;

    public void initialize() {
        resText.setEditable(false);
    }

    public void showRes(MouseEvent event) {
        if (toggle.isSelected()) {
            toggle.setText("Hide");
            //tempResText = resText.getText();
            resText.setText(tempResText);
        } else {
            toggle.setText("Show");
            resText.setText("");
        }
    }

    public void checkSubmit(MouseEvent event) {
        String temp = ansText.getText();
        if (mainFuction.check(temp,tempResText)) {
            resText.setText(tempResText);
        } else {
            resText.setText("False");
        }
    }
}