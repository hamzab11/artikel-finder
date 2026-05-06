package com.example.artikelfinder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.HashMap;

public class MainControler {
    @FXML
    public Button findartikel;
    @FXML
    public ComboBox <String> ArtikelSwitcher;
    @FXML
    public TextField toAddNoun;
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
        ArtikelSwitcher.getItems().addAll("der","die","das");

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
        String newNoun = nounInput.getText().trim();
        newNoun = newNoun.toLowerCase();
        String newArtikel = ArtikelSwitcher.getValue();
        if (newNoun.isEmpty()) {
            resultLabel.setText("Please enter a noun.");
        }



//
    }


    public void save() {
        String noun = toAddNoun.getText().trim();
        noun = noun.toLowerCase();
        String artikel = ArtikelSwitcher.getValue();
        artikel = artikel.toLowerCase();
        if (artikel.isEmpty()) {
            resultLabel.setText("Please enter a noun.");
        }else  {
            CsvWriter.csvEditor(noun,artikel);
        }

    }
}
