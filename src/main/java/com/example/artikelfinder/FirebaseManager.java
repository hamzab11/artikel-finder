package com.example.artikelfinder;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;

public class FirebaseManager {

    private static Firestore firestore;

    public static  void initializeFirebase(){
       try {
           FileInputStream  serviceAccount = new FileInputStream("src/main/resources/firebase/serviceAccountKey.json");
           FirebaseOptions  options = FirebaseOptions.builder().setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();
           if (FirebaseApp.getApps().isEmpty()) {
               FirebaseApp.initializeApp(options);
           }
           firestore = FirestoreClient.getFirestore();
           System.out.println("Firestore initialized successfully");

       }catch (Exception e){
           System.out.println("Firestore initialization failed");
       }

    }
    public static Firestore getFirestore(){
        if (firestore == null) {
            initializeFirebase();
        }
        return firestore;
    }
}
