package com.example.mylearnenglish;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class mainController {

    private int numOfHeart = 3;
    private int level = 1;
    private String ResultText;

    @FXML
    private ToggleButton toggle;
    @FXML
    private TextArea resText;
    @FXML
    private TextArea ansText;
    @FXML
    private ImageView heart1, heart2, heart3;
    @FXML
    private ImageView copy;


    public void initialize() throws Exception {
        resText.setEditable(false);
        resText.setText("Level: " + level);
        ResultText = loadFile.randomWord();
        copy.setVisible(false);
        textToSpeech.ttsOnline(ResultText);
        InputStream stream = new FileInputStream("src\\main\\resources\\com\\example\\image\\like.png");
        Image image = new Image(stream,40,40,false,true);
        heart1.setImage(image);
        heart2.setImage(image);
        heart3.setImage(image);
    }

    public void showRes(MouseEvent event) {
        if (toggle.isSelected()) {
            toggle.setText("Hide");
            //tempResText = resText.getText();
            resText.setText(ResultText);
            copy.setVisible(true);
        } else {
            toggle.setText("Show");
            resText.setText("");
            copy.setVisible(false);
        }
    }

    public void checkSubmit(MouseEvent event) throws Exception {
        String temp = ansText.getText();
        if (mainFuction.check(temp, ResultText)) {
            resText.setText(ResultText);
            numOfHeart = 3;
            level ++;
            resText.setText("Level: " + level);
            ResultText = loadFile.randomWord();
            textToSpeech.ttsOnline(ResultText);
        } else {
            resText.setText("False");
            numOfHeart --;
            if (numOfHeart == 2) {
                heart3.setImage(null);
            } else if (numOfHeart == 1) {
                heart2.setImage(null);
            } else if (numOfHeart == 0) {
                heart1.setImage(null);
                Alert outOfHeart = new Alert(AlertType.ERROR);
                outOfHeart.setTitle("You loose!");
                outOfHeart.setHeaderText("You ran out of Heart!");
                outOfHeart.show();
                //System.out.println("exit code here");
                outOfHeart.showAndWait();
                System.exit(0);
            }
        }
    }

    public void speaking(MouseEvent event) throws Exception {
        //textToSpeech.ttsOnline(ResultText);
        textToSpeech.playAudio("eng_voice.wav");
    }

    public void getNewAns(MouseEvent event) throws Exception {
        ResultText = loadFile.randomWord();
        textToSpeech.ttsOnline(ResultText);
    }

    public void copyToClipboard(MouseEvent event) {
        String myString = ansText.getText();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void copyToClipboard2(MouseEvent event) {
        String myString = resText.getText();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void clearAns(MouseEvent event) {
        ansText.clear();
    }
}