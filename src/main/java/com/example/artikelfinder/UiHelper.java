package com.example.artikelfinder;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public abstract class UiHelper {
    protected  void displayText(Label screen,String text){

        screen.setText(text);
    }
    protected  String extractText(TextField textField){

        return textField.getText();
    }
}
