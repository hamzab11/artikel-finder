package com.example.artikelfinder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class MainControler {
    public Button findartikel;
    @FXML
    private TextField nounInput;

    @FXML
    private Label resultLabel;
    @FXML
    private Button saveButton;
    @FXML




    public void initialize(){
        AnimationManager.nodeHover(saveButton);
        AnimationManager.nodeHover(findartikel);

    }

    //private final Rules rules = new Rules();

    @FXML
    private void handleCheck() {
        String germanNoun = nounInput.getText().trim();
        germanNoun = germanNoun.toLowerCase();


        if (germanNoun.isEmpty()) {
            resultLabel.setText("Please enter a noun.");
            return;
        }
        String formatted = germanNoun.substring(0, 1).toUpperCase() + germanNoun.substring(1).toLowerCase();

        try {

            HashMap<String, String> dictionary = CSVLoader.loadDictionary();

            String artikel = dictionary.get(formatted);

            resultLabel.setText("Artikel: " + artikel + " " + formatted);

        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
//
    }


}
