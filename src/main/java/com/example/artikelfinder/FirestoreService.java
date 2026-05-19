package com.example.artikelfinder;

import com.google.cloud.firestore.Firestore;

import java.util.HashMap;
import java.util.Map;


    public class FirestoreService {

        public static void saveWord(String noun, String artikel) {

            try {
                Firestore db = FirebaseManager.getFirestore();

                Map<String, Object> wordData = new HashMap<>();
                wordData.put("noun", noun);
                wordData.put("artikel", artikel);

                db.collection("words")
                        .document(noun)
                        .set(wordData);

                System.out.println("Word saved to Firestore: " + artikel + " " + noun);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static String getArtikel(String noun) {

            try {

                Firestore db = FirebaseManager.getFirestore();

                var document = db.collection("words")
                        .document(noun)
                        .get()
                        .get();

                if (document.exists()) {

                    return document.getString("artikel");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
