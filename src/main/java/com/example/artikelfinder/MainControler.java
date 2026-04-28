package com.example.artikelfinder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainControler {
    @FXML
    private TextField nounInput;

    @FXML
    private Label resultLabel;

    private final Rules rules = new Rules();

    @FXML
    private void handleCheck() {
        String germanNoun = nounInput.getText().trim();

        if (germanNoun.isEmpty()) {
            resultLabel.setText("Please enter a noun.");
            return;
        }

        String artikel = rules.findArticle(germanNoun);

        resultLabel.setText("Artikel: " + artikel + " " + germanNoun);
    }


}
