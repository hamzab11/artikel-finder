package com.example.artikelfinder;

import java.io.FileWriter;

public class CsvWriter {

    public static void csvEditor(String noun , String artikel) {

        try {

            FileWriter fw = new FileWriter("/wordArticle.csv");
            fw.write(noun + "," +artikel+ "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }





}
