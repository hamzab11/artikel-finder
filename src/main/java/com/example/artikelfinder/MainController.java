package com.example.artikelfinder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController extends UiHelper {

    @FXML
    public Button findartikel;

    @FXML
    public ComboBox<String> ArtikelSwitcher;

    @FXML
    public TextField toAddNoun;

    @FXML
    private TextField nounInput;

    @FXML
    private Label resultLabel;

    @FXML
    private Button saveButton;



    @FXML
    public void initialize() {

        // Hover animations
        AnimationManager.nodeHover(saveButton);
        AnimationManager.nodeHover(findartikel);
        AnimationManager.nodeHover(toAddNoun);
        AnimationManager.nodeHover(ArtikelSwitcher);

        // ComboBox items
        ArtikelSwitcher.getItems().addAll("der", "die", "das");


        // 🎨 Color each item inside dropdown
        ArtikelSwitcher.setCellFactory(listView -> new javafx.scene.control.ListCell<>() {

            @Override
            protected void updateItem(String artikel, boolean empty) {

                super.updateItem(artikel, empty);

                if (empty || artikel == null) {
                    setText(null);
                    setStyle("");
                    return;
                }

                setText(artikel);

                switch (artikel) {

                    case "der":
                        setStyle(
                                "-fx-background-color: #DBEAFE;" +
                                        "-fx-text-fill: #1D4ED8;"
                        );
                        break;

                    case "die":
                        setStyle(
                                "-fx-background-color: #FCE7F3;" +
                                        "-fx-text-fill: #BE185D;"
                        );
                        break;

                    case "das":
                        setStyle(
                                "-fx-background-color: #FEF3C7;" +
                                        "-fx-text-fill: #92400E;"
                        );
                        break;
                }
            }
        });


        // 🎨 Color selected item inside ComboBox
        ArtikelSwitcher.setButtonCell(new javafx.scene.control.ListCell<>() {

            @Override
            protected void updateItem(String artikel, boolean empty) {

                super.updateItem(artikel, empty);

                if (empty || artikel == null) {
                    setText(null);
                    setStyle("");
                    return;
                }

                setText(artikel);

                switch (artikel) {

                    case "der":
                        setStyle(
                                "-fx-background-color: #DBEAFE;" +
                                        "-fx-text-fill: #1D4ED8;"
                        );
                        break;

                    case "die":
                        setStyle(
                                "-fx-background-color: #FCE7F3;" +
                                        "-fx-text-fill: #BE185D;"
                        );
                        break;

                    case "das":
                        setStyle(
                                "-fx-background-color: #FEF3C7;" +
                                        "-fx-text-fill: #92400E;"
                        );
                        break;
                }
            }
        });


        // 🎨 Change ComboBox border color dynamically
        ArtikelSwitcher.setOnAction(e -> {

            String artikel = ArtikelSwitcher.getValue();

            switch (artikel) {

                case "der":
                    ArtikelSwitcher.setStyle(
                            "-fx-border-color: #2563EB;" +
                                    "-fx-border-width: 2;" +
                                    "-fx-background-color: #DBEAFE;" +
                                    "-fx-background-radius: 10;" +
                                    "-fx-border-radius: 10;"
                    );
                    break;

                case "die":
                    ArtikelSwitcher.setStyle(
                            "-fx-border-color: #EC4899;" +
                                    "-fx-border-width: 2;" +
                                    "-fx-background-color: #FCE7F3;" +
                                    "-fx-background-radius: 10;" +
                                    "-fx-border-radius: 10;"
                    );
                    break;

                case "das":
                    ArtikelSwitcher.setStyle(
                            "-fx-border-color: #EAB308;" +
                                    "-fx-border-width: 2;" +
                                    "-fx-background-color: #FEF3C7;" +
                                    "-fx-background-radius: 10;" +
                                    "-fx-border-radius: 10;"
                    );
                    break;
            }
        });
    }

    @FXML
    private void handleCheck() {

        //String germanNoun = nounInput.getText().trim();
        String germanNoun = extractText(nounInput).trim();

        if (germanNoun.isEmpty()) {
            //resultLabel.setText("Please enter a noun.");
            displayText(resultLabel,"Please enter a noun.");
            return;
        }

        String formatted =
                germanNoun.substring(0, 1).toUpperCase()
                        + germanNoun.substring(1).toLowerCase();

       // String artikel = DictionaryManager.getArtikel(formatted);
        String artikel = FirestoreService.getArtikel(formatted);

        if (artikel != null) {
           // resultLabel.setText("Artikel: " + artikel + " " + formatted);
            displayText(resultLabel,"Artikel: " + artikel + " " + formatted);
        } else {
            //resultLabel.setText("Word not found: " + formatted);
            displayText(resultLabel,"Word not found: " + formatted);
        }
        nounInput.clear();
    }


    @FXML
    public void save() {


        //String noun = toAddNoun.getText().trim();
        String noun =extractText(toAddNoun).trim();
        String artikel = ArtikelSwitcher.getValue();

        if (noun.isEmpty() || artikel == null) {
            //resultLabel.setText("Please enter noun and choose artikel.");
            displayText(resultLabel,"Please enter noun and choose artikel.");
            return;
        }

        noun =
                noun.substring(0, 1).toUpperCase()
                        + noun.substring(1).toLowerCase();

        CsvWriter.csvEditor(noun, artikel.toLowerCase());

        // 🔥 reload dictionary after adding new word
        DictionaryManager.reloadDictionary();
        FirestoreService.saveWord(noun, artikel);

        //resultLabel.setText("Word saved: " + artikel + " " + noun);
        displayText(resultLabel,"Word saved: " + noun + " " + artikel);
        toAddNoun.clear();
    }

}