package com.example.artikelfinder;

import java.io.*;
import java.util.HashMap;

public class CSVLoader {

    public static HashMap<String, String> loadDictionary() {

        HashMap<String, String> map = new HashMap<>();

        InputStream is = CSVLoader.class.getResourceAsStream("/wordArticle.csv");

        if (is == null) {
            throw new RuntimeException("CSV file not found: /wordArticle.csv");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;

            br.readLine(); // skip header

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