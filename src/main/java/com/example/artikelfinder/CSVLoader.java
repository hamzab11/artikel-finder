package com.example.artikelfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CSVLoader {

    private static final String FILE_PATH =
            "src/main/resources/wordArticle.csv";

    public static HashMap<String, String> loadDictionary() {

        HashMap<String, String> map = new HashMap<>();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length >= 2) {

                    String word = parts[0].trim();
                    String artikel = parts[1].trim();

                    map.put(word, artikel);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}