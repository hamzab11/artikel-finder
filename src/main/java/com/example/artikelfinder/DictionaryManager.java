package com.example.artikelfinder;

import java.util.HashMap;

public class DictionaryManager {

    private static HashMap<String, String> dictionary =
            CSVLoader.loadDictionary();

    public static String getArtikel(String word) {
        return dictionary.get(word);
    }

    public static void reloadDictionary() {
        dictionary = CSVLoader.loadDictionary();
    }
}